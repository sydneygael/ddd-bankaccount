package sadjoumoumouni.ddd.bank.infrastructure.adapters.outgoing.inmemory;

import java.util.Optional;

import org.springframework.stereotype.Component;

import sadjoumoumouni.ddd.bank.domain.BankAccount;
import sadjoumoumouni.ddd.bank.domain.entities.Transaction;
import sadjoumoumouni.ddd.bank.domain.ports.outgoing.AccountPort;

@Component
public class InMemoryBankAccountRepository implements AccountPort {

    @Override
    public void save(BankAccount bankAccount) {

    }

    @Override
    public void saveTransaction(Transaction transaction) {

    }

    @Override
    public Optional<BankAccount> loadAccountById(Long id) {
        return Optional.empty();
    }
}
