package br.com.lab.impacta.account.domain.exception;

import org.springframework.beans.factory.annotation.Value;

public class AccountWithoutBalanceException extends RuntimeException {
    private String description;

    public String getDescription() {
        return description;
    }

    public AccountWithoutBalanceException(){super();}
}
