package br.com.lab.impacta.account.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DebitAccountResponse {
    private boolean debited;
}
