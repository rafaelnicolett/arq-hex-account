package br.com.lab.impacta.account.domain.model;

import br.com.lab.impacta.account.domain.exception.AccountWithoutBalanceException;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long number;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person customer;

    private Double balance;

    public void debit(Double valueOfDebit) {
        if (this.getBalance() < valueOfDebit) {
            throw new AccountWithoutBalanceException();
        }

        Double debitedAmount = this.getBalance() - valueOfDebit;

        this.setBalance(debitedAmount);
    }
}
