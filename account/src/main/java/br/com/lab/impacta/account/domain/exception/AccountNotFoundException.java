package br.com.lab.impacta.account.domain.exception;

public class AccountNotFoundException extends RuntimeException {

    private String description;

    public String getDescription() {
        return description;
    }

    public AccountNotFoundException(){super();}

    public AccountNotFoundException(String message, String description) {
        super(message);

        this.description = description;
    }
}
