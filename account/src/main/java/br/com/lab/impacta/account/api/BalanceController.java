package br.com.lab.impacta.account.api;

import br.com.lab.impacta.account.application.AccountApplication;
import br.com.lab.impacta.account.application.dto.response.AccountBalanceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class BalanceController {

    private final AccountApplication accountApplication;

    @GetMapping("/{accountId}/balance")
    public ResponseEntity<AccountBalanceResponse> getBalance(@PathVariable long accountId) {
        AccountBalanceResponse accountBalanceResponse =
                accountApplication.getBalance(accountId);

        return ResponseEntity.ok(accountBalanceResponse);
    }
}
