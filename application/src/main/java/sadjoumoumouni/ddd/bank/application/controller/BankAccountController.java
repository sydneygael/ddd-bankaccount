package sadjoumoumouni.ddd.bank.application.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sadjoumoumouni.ddd.bank.domain.ports.incoming.DepositUseCase;
import sadjoumoumouni.ddd.bank.domain.ports.incoming.ListOperationsUseCase;
import sadjoumoumouni.ddd.bank.domain.ports.incoming.WithdrawUseCase;

@RestController
@RequestMapping("/account")
public class BankAccountController {

    private final DepositUseCase depositUseCase;
    private final WithdrawUseCase withdrawUseCase;
    private final ListOperationsUseCase listOperationsUseCase;

    @Autowired
    /**
     * BankAccountApplicationService is injected
     */
    public BankAccountController(DepositUseCase depositUseCase, WithdrawUseCase withdrawUseCase, ListOperationsUseCase listOperationsUseCase) {
        this.depositUseCase = depositUseCase;
        this.withdrawUseCase = withdrawUseCase;
        this.listOperationsUseCase = listOperationsUseCase;
    }

    @PostMapping(value = "/{id}/deposit/{amount}")
    void deposit(@PathVariable final Long id, @PathVariable final BigDecimal amount) {
        depositUseCase.deposit(id, amount);
    }

    @PostMapping(value = "/{id}/withdraw/{amount}")
    void withdraw(@PathVariable final Long id, @PathVariable final BigDecimal amount) {
        withdrawUseCase.withdraw(id, amount);
    }

    @PostMapping(value = "/{id}/listoperations")
    String listOperations(@PathVariable final Long id) {
        return listOperationsUseCase.listOperations(id);
    }
}
