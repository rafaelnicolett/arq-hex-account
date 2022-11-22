package br.com.rafaelnicolei.education.account.application.adapter;

import br.com.rafaelnicolei.education.account.application.dto.response.AccountBalanceResponse;
import br.com.rafaelnicolei.education.account.domain.model.Account;

public class AccountAdapter {
    public static AccountBalanceResponse toDtoBalance(Account account) {
        return new AccountBalanceResponse(account.getId(), account.getBalance());
    }
}
