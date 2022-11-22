package br.com.lab.impacta.account.application.adapter;

import br.com.lab.impacta.account.application.dto.response.AccountBalanceResponse;
import br.com.lab.impacta.account.domain.model.Account;

public class AccountAdapter {
    public static AccountBalanceResponse toDtoBalance(Account account) {
        return new AccountBalanceResponse(account.getId(), account.getBalance());
    }
}
