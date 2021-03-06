package sadjoumoumouni.ddd.bank.domain;

import static sadjoumoumouni.ddd.bank.domain.valueobject.Money.moneyOf;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sadjoumoumouni.ddd.bank.domain.entities.DepositTransaction;
import sadjoumoumouni.ddd.bank.domain.entities.Transaction;
import sadjoumoumouni.ddd.bank.domain.entities.WithDrawTransaction;
import sadjoumoumouni.ddd.bank.domain.valueobject.Money;

/*
    Aggregate Root
 */
@Getter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
public class BankAccount {

    private Long accountId;
    private Money balance;
    Operations operations = new Operations();


    public BankAccount(Long accountId, BigDecimal balance) {
        this.accountId = accountId;
        this.balance = moneyOf(balance);
    }

    public BankAccount(Long accountId, Money balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public BankAccount (Long accountId, Money balance, Operations operations) {
        this.accountId = accountId;
        this.balance = balance;
        this.operations = operations;
    }

    public void withdraw(BigDecimal withDraw) {
        Transaction transaction = WithDrawTransaction
                .builder()
                .amount(moneyOf(withDraw))
                .date(new Date())
                .uuid(UUID.randomUUID())
                .build();
        completeTransaction(transaction);
    }

    public void deposit(BigDecimal deposit) {
        Transaction transaction = DepositTransaction
                .builder()
                .amount(moneyOf(deposit))
                .date(new Date())
                .uuid(UUID.randomUUID())
                .build();
        completeTransaction(transaction);
    }

    public String listOperations() {
        final StringBuilder builder = new StringBuilder();
        operations.getTransactionList().stream()
                .sorted(Collections.reverseOrder())
                .forEach( op -> builder.append(op.toString()).append("\n"));
        return  builder.toString();
    }

    private void completeTransaction(Transaction transaction) {
        Money balanceAfterTransaction = transaction.balanceAfterTransaction(balance);
        balance = balanceAfterTransaction;
        operations.addLineContaining(transaction, balanceAfterTransaction);
    }

}
