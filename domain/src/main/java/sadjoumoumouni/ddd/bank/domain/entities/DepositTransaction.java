package sadjoumoumouni.ddd.bank.domain.entities;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import sadjoumoumouni.ddd.bank.domain.valueobject.Money;

@Data
@SuperBuilder
public class DepositTransaction extends Transaction {

    public Money balanceAfterTransaction(Money balance) {
        return balance.add(amount);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("TRANSACTION_TYPE :  DEPOSIT ")
                .append("Id : ")
                .append(uuid)
                .append(" Date : ")
                .append(simpleDateFormat.format(date))
                .append("Amount : ")
                .append(amount)
                .toString();
    }
}
