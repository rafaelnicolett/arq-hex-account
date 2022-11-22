package br.com.rafaelnicolei.education.account.domain.service;

import br.com.rafaelnicolei.education.account.domain.model.Account;

public interface AccountService {

    Account find(Long accountId);

    void debit(Long accountId, Double valueOfDebit);
}
