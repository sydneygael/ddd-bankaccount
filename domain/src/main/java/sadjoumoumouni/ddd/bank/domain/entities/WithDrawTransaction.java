package sadjoumoumouni.ddd.bank.domain.entities;
import java.util.Date;
import java.util.UUID;

import lombok.EqualsAndHashCode;
import sadjoumoumouni.ddd.bank.domain.valueobject.Money;

@EqualsAndHashCode
public class WithDrawTransaction extends Transaction {

    WithDrawTransaction(UUID uuid, Date date, Money amount) {
        super(uuid, date, amount);
    }

    public Money balanceAfterTransaction(Money balance) {
        if(balance.canRemove(amount)) {
            return balance.remove(amount);
        }
        throw new RuntimeException("cannot add amount");
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("TRANSACTION_TYPE :  WithDraw ")
                .append("Id : ")
                .append(uuid)
                .append(" Date : ")
                .append(simpleDateFormat.format(date))
                .append("Amount : ")
                .append(amount)
                .toString();
    }
}
