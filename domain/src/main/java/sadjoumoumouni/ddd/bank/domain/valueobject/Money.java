package sadjoumoumouni.ddd.bank.domain.valueobject;

import java.math.BigDecimal;
import lombok.NonNull;
import lombok.Value;

/*
    Value Object
 */
@Value
public class Money {

    @NonNull
    private BigDecimal amount;

    public Money add(Money otherMoney) {
        return new Money(this.amount.add(otherMoney.amount));
    }

    public Money remove(Money otherMoney) {
        return new Money(this.amount.add(otherMoney.amount.negate()));
    }

    public boolean canRemove(Money other) {
        return this.amount.compareTo(other.amount) > 0 ;
    }

    public static Money moneyOf(BigDecimal amount) {
        return new Money(amount);
    }
}
