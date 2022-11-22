package br.com.rafaelnicolei.education.account.application.impl;


import br.com.rafaelnicolei.education.account.application.AccountApplication;
import br.com.rafaelnicolei.education.account.application.adapter.AccountAdapter;
import br.com.rafaelnicolei.education.account.application.dto.request.DebitAccountRequest;
import br.com.rafaelnicolei.education.account.application.dto.response.AccountBalanceResponse;
import br.com.rafaelnicolei.education.account.application.dto.response.DebitAccountResponse;
import br.com.rafaelnicolei.education.account.domain.model.Account;
import br.com.rafaelnicolei.education.account.domain.service.AccountService;
import lombok.RequiredArgsConstructor;
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
