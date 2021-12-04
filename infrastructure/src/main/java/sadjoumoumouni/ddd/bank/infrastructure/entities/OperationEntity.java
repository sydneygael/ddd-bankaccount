package sadjoumoumouni.ddd.bank.infrastructure.entities;

import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import sadjoumoumouni.ddd.bank.domain.entities.Operation;
import sadjoumoumouni.ddd.bank.domain.valueobject.Money;

@Entity
@Table(name = "operation")
@Builder
@Data
public class OperationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "operation_id")
    @NonNull
    private String OperationId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transaction", referencedColumnName = "uuid")
    private TransactionEntity transactionEntity ;

    @Column (name = "current_balance")
    private BigDecimal currentBalance;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private BankAccountEntity account;

    public Operation toDomain() {
        return Operation.builder()
                .transaction(transactionEntity.toDomain())
                .currentBalance(Money.moneyOf(currentBalance))
                .build();
    }
}
