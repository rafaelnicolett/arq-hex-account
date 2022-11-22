package br.com.lab.impacta.account.application.impl;


import br.com.lab.impacta.account.application.AccountApplication;
import br.com.lab.impacta.account.application.adapter.AccountAdapter;
import br.com.lab.impacta.account.application.dto.request.DebitAccountRequest;
import br.com.lab.impacta.account.application.dto.response.AccountBalanceResponse;
import br.com.lab.impacta.account.application.dto.response.DebitAccountResponse;
import br.com.lab.impacta.account.domain.model.Account;
import br.com.lab.impacta.account.domain.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountApplicationImpl implements AccountApplication {

    private final AccountService accountService;

    @Override
    public AccountBalanceResponse getBalance(Long accountId) {
        Account account = accountService.find(accountId);

        return AccountAdapter.toDtoBalance(account);
    }

    @Override
    public DebitAccountResponse debit(Long accountId, DebitAccountRequest debitAccountRequest) {
        accountService.debit(accountId, debitAccountRequest.getValueOfDebit());

        return new DebitAccountResponse(true);
    }
}
