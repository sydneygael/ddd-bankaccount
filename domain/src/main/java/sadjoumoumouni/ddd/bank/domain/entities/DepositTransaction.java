package sadjoumoumouni.ddd.bank.domain.entities;

import java.util.Date;
import java.util.UUID;

import lombok.EqualsAndHashCode;
import sadjoumoumouni.ddd.bank.domain.valueobject.Money;

@EqualsAndHashCode
public class DepositTransaction extends Transaction {

    DepositTransaction(UUID uuid, Date date, Money amount) {
        super(uuid, date, amount);
    }

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
