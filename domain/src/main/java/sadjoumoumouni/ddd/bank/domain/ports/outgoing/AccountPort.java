package sadjoumoumouni.ddd.bank.domain.ports.outgoing;

import sadjoumoumouni.ddd.bank.domain.BankAccount;
import sadjoumoumouni.ddd.bank.domain.entities.Transaction;

public interface AccountPort {
    void save(BankAccount bankAccount);
    void save(Transaction transaction);
}
