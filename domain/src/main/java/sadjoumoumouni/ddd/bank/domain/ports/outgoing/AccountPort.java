package sadjoumoumouni.ddd.bank.domain.ports.outgoing;

import java.util.Optional;

import sadjoumoumouni.ddd.bank.domain.BankAccount;
import sadjoumoumouni.ddd.bank.domain.entities.Transaction;

public interface AccountPort {
    void save(BankAccount bankAccount);
    void save(Transaction transaction);

    Optional<BankAccount> loadAccountById(Long id);
}
