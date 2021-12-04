package sadjoumoumouni.ddd.bank.domain.entities;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import sadjoumoumouni.ddd.bank.domain.valueobject.Money;

@Data
@SuperBuilder
public class WithDrawTransaction extends Transaction {

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
