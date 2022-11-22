package br.com.lab.impacta.account.api.handler;

import br.com.lab.impacta.account.application.dto.response.ErrorMessageResponse;
import br.com.lab.impacta.account.domain.exception.AccountNotFoundException;
import br.com.lab.impacta.account.domain.exception.AccountWithoutBalanceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ControllerExceptionHandler {

    private final String MESSAGE_ERROR_INTERNAL = "Erro interno!";
    private final String DESCRIPTION_ERROR_INTERNAL = "Serviço temporariamente indisponível, tente novamente mais tarde!";
    @Value("${lab.account.exceptions.account-without-balance-message}")
    private String messageExceptionWithoutBalance;

    @Value("${lab.account.exceptions.account-without-balance-description}")
    private String descriptionExceptionWithoutBalance;

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorMessageResponse> accountNotFoundException(AccountNotFoundException exception) {
        return getErrorResponse(exception.getMessage(), exception.getDescription(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AccountWithoutBalanceException.class)
    public ResponseEntity<ErrorMessageResponse> withoutBalanceException() {
        return getErrorResponse(messageExceptionWithoutBalance,
                descriptionExceptionWithoutBalance, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorMessageResponse> errorGeneral() {
        return getErrorResponse(MESSAGE_ERROR_INTERNAL,
                DESCRIPTION_ERROR_INTERNAL,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ErrorMessageResponse> getErrorResponse(String message,
                                                                  String description,
                                                                  HttpStatus httpStatus) {
        ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse(
                new Date(),
                message,
                description
        );

        return new ResponseEntity<>(errorMessageResponse, httpStatus);
    }
}
