package sadjoumoumouni.ddd.bank.domain.entities;

import lombok.Data;
import sadjoumoumouni.ddd.bank.domain.valueobject.Money;

@Data
public class Operation {
    private Transaction transaction;
    private Money currentBalance;

    public Operation(Transaction transaction, Money currentBalance) {
        this.transaction = transaction;
        this.currentBalance = currentBalance;
    }
}
