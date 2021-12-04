package sadjoumoumouni.ddd.bank.infrastructure.adapters.outgoing.inmemory;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import sadjoumoumouni.ddd.bank.domain.BankAccount;
import sadjoumoumouni.ddd.bank.domain.entities.Transaction;
import sadjoumoumouni.ddd.bank.domain.ports.outgoing.AccountPort;

@Component
public class InMemoryBankAccountRepository implements AccountPort {

    private Map<String, BankAccount> inMemoryBankDb = new ConcurrentHashMap<>();

    @Override
    public void save(BankAccount bankAccount) {
        inMemoryBankDb.put(bankAccount.getAccountId().toString(),bankAccount);
    }

    @Override
    public void saveTransaction(Transaction transaction) {

    }

    @Override
    public Optional<BankAccount> loadAccountById(Long id) {
        return Optional.ofNullable(inMemoryBankDb.get(id.toString()));
    }
}
