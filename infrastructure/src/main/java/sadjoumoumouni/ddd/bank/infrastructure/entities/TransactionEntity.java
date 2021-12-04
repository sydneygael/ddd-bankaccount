package sadjoumoumouni.ddd.bank.infrastructure.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import sadjoumoumouni.ddd.bank.domain.entities.DepositTransaction;
import sadjoumoumouni.ddd.bank.domain.entities.Transaction;
import sadjoumoumouni.ddd.bank.domain.entities.WithDrawTransaction;
import sadjoumoumouni.ddd.bank.domain.valueobject.Money;

@Entity
@Table(name = "transaction")
@Builder
@Data
public class TransactionEntity {

    enum Type {
        WITHDRAW, DEPOSIT;
    }

    @Id
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "date")
    private Date date;

    @Column(name = "amount")
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne
    @JoinColumn (name = "id")
    private OperationEntity operation;

    @OneToOne(mappedBy = "transactionEntity")
    private OperationEntity user;

    public static TransactionEntity from(Transaction transaction) {

        TransactionEntity toReturn = TransactionEntity.builder()
                .uuid(transaction.getUuid().toString())
                .amount(transaction.getAmount().getAmount())
                .date(new java.sql.Date(transaction.getDate().getTime()))
                .build();

        if(transaction instanceof DepositTransaction) {
            toReturn.setType(Type.DEPOSIT);
        } else {
            toReturn.setType(Type.WITHDRAW);
        }

        return toReturn;
    }

    public Transaction toDomain() {
        if (Type.WITHDRAW.equals(type)) {
            return WithDrawTransaction.builder()
                    .uuid(UUID.fromString(uuid))
                    .amount(Money.moneyOf(amount))
                    .date(new java.util.Date(date.getTime()))
                    .build();
        } else {
            return DepositTransaction.builder()
                    .uuid(UUID.fromString(uuid))
                    .amount(Money.moneyOf(amount))
                    .date(new java.util.Date(date.getTime()))
                    .build();
        }
    }
}
