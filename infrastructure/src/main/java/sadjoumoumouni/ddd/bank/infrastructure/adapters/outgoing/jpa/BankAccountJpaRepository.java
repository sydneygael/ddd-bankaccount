package sadjoumoumouni.ddd.bank.infrastructure.adapters.outgoing.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import sadjoumoumouni.ddd.bank.infrastructure.entities.BankAccountEntity;

public interface BankAccountJpaRepository extends JpaRepository<BankAccountEntity, Long> {
}
