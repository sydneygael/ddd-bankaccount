package sadjoumoumouni.ddd.bank.infrastructure.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import sadjoumoumouni.ddd.bank.domain.BankAccount;
import sadjoumoumouni.ddd.bank.domain.Operations;
import sadjoumoumouni.ddd.bank.domain.valueobject.Money;

@Entity
@Table(name = "bank_account")
@Builder
@Data
public class BankAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "balance")
    private BigDecimal balance;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="account")
    private List<OperationEntity> operations;

    public BankAccountEntity() {

    }

    public static BankAccountEntity from(BankAccount bankAccount) {
        return BankAccountEntity.builder()
                .accountId(bankAccount.getAccountId())
                .balance(bankAccount.getBalance().getAmount())
                .build();
    }

    public BankAccount toDomain() {
        return BankAccount.builder()
                .accountId(accountId)
                .balance(Money.moneyOf(balance))
                .operations(buildOperations(operations))
                .build();
    }

    private Operations buildOperations(List<OperationEntity> operationsList) {
        Operations operations = new Operations();

        operationsList.forEach(op -> operations.addLineContaining(
                op.getTransactionEntity().toDomain(),
                Money.moneyOf(op.getCurrentBalance()))
        );

        return operations;
    }
}
