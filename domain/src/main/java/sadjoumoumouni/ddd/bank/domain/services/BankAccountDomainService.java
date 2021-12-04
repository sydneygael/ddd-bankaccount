package sadjoumoumouni.ddd.bank.domain.services;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

import sadjoumoumouni.ddd.bank.domain.BankAccount;
import sadjoumoumouni.ddd.bank.domain.ports.incoming.DepositUseCase;
import sadjoumoumouni.ddd.bank.domain.ports.incoming.ListOperationsUseCase;
import sadjoumoumouni.ddd.bank.domain.ports.incoming.WithdrawUseCase;
import sadjoumoumouni.ddd.bank.domain.ports.outgoing.AccountPort;

public class BankAccountDomainService implements DepositUseCase, WithdrawUseCase, ListOperationsUseCase {

    AccountPort accountPort;

    public BankAccountDomainService(AccountPort repository) {
        this.accountPort = repository;
    }

    @Override
    public void deposit(Long id, BigDecimal amount) {
        BankAccount account = accountPort.loadAccountById(id)
                .orElseThrow(NoSuchElementException::new);

        account.deposit(amount);

        accountPort.save(account);
    }

    @Override
    public void withdraw(Long id, BigDecimal amount) {
        BankAccount account = accountPort.loadAccountById(id)
                .orElseThrow(NoSuchElementException::new);

        account.withdraw(amount);

        accountPort.save(account);
    }

    @Override
    public String listOperations(Long accountId) {
        BankAccount account = accountPort.loadAccountById(accountId)
                .orElseThrow(NoSuchElementException::new);
        return account.listOperations();
    }
}
