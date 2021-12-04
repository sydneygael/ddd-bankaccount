package sadjoumoumouni.ddd.bank.infrastructure.adapters.outgoing.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import sadjoumoumouni.ddd.bank.infrastructure.entities.TransactionEntity;

public interface TransactionJpaRepository extends JpaRepository<TransactionEntity, String> {
}
