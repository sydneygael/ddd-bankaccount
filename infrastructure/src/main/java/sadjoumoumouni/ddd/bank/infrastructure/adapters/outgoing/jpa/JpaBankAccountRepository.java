package sadjoumoumouni.ddd.bank.infrastructure.adapters.outgoing.jpa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sadjoumoumouni.ddd.bank.domain.BankAccount;
import sadjoumoumouni.ddd.bank.domain.entities.Transaction;
import sadjoumoumouni.ddd.bank.domain.ports.outgoing.AccountPort;
import sadjoumoumouni.ddd.bank.infrastructure.entities.BankAccountEntity;
import sadjoumoumouni.ddd.bank.infrastructure.entities.TransactionEntity;

//@Component
public class JpaBankAccountRepository implements AccountPort {

    BankAccountJpaRepository bankAccountJpaRepository;
    TransactionJpaRepository transactionJpaRepository;

    @Autowired
    public JpaBankAccountRepository(BankAccountJpaRepository bankAccountJpaRepository, TransactionJpaRepository transactionJpaRepository) {
        this.bankAccountJpaRepository = bankAccountJpaRepository;
        this.transactionJpaRepository = transactionJpaRepository;
    }

    @Override
    public void save(BankAccount bankAccount) {
        bankAccountJpaRepository.save(BankAccountEntity.from(bankAccount));
    }

    @Override
    public void saveTransaction(Transaction transaction) {
        transactionJpaRepository.save(TransactionEntity.from(transaction));
    }

    @Override
    public Optional<BankAccount> loadAccountById(Long id) {
        return  bankAccountJpaRepository.findById(id)
                .map(BankAccountEntity::toDomain);
    }
}
