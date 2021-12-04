package sadjoumoumouni.ddd.bank.application.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sadjoumoumouni.ddd.bank.domain.ports.incoming.DepositUseCase;
import sadjoumoumouni.ddd.bank.domain.ports.incoming.ListOperationsUseCase;
import sadjoumoumouni.ddd.bank.domain.ports.incoming.WithdrawUseCase;
import sadjoumoumouni.ddd.bank.domain.services.BankAccountDomainService;

@Service
@Transactional
@Primary
/**
 * In this part we handle transactions
 */
public class BankAccountApplicationService implements WithdrawUseCase, DepositUseCase, ListOperationsUseCase {

    private final BankAccountDomainService bankAccountDomainService;

    @Autowired
    public BankAccountApplicationService(BankAccountDomainService bankAccountDomainService) {
        this.bankAccountDomainService = bankAccountDomainService;
    }

    public void deposit(Long id, BigDecimal amount) {
        bankAccountDomainService.deposit(id,amount);
    }

    public String listOperations(Long accountId) {
        return bankAccountDomainService.listOperations(accountId);
    }

    public void withdraw(Long id, BigDecimal amount) throws RuntimeException {
        bankAccountDomainService.withdraw(id,amount);
    }
}
