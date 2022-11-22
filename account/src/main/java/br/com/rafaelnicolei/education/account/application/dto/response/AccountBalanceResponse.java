package br.com.rafaelnicolei.education.account.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountBalanceResponse {
    private Long accountId;

    private Double balance;
}
