package sadjoumoumouni.ddd.bank.domain.services;

import java.math.BigDecimal;

import sadjoumoumouni.ddd.bank.domain.ports.incoming.DepositUseCase;
import sadjoumoumouni.ddd.bank.domain.ports.incoming.WithdrawUseCase;

public class BankAccountService implements DepositUseCase, WithdrawUseCase {

    @Override
    public void deposit(Long id, BigDecimal amount) {

    }

    @Override
    public boolean withdraw(Long id, BigDecimal amount) {
        return false;
    }
}
