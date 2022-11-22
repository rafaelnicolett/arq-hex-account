package br.com.rafaelnicolei.education.account.application;

import br.com.rafaelnicolei.education.account.application.dto.request.DebitAccountRequest;
import br.com.rafaelnicolei.education.account.application.dto.response.AccountBalanceResponse;
import br.com.rafaelnicolei.education.account.application.dto.response.DebitAccountResponse;

public interface AccountApplication {

    AccountBalanceResponse getBalance(Long accountId);

    DebitAccountResponse debit(Long accountId, DebitAccountRequest debitAccountRequest);
}
