package sadjoumoumouni.ddd.bank.domain.entities;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import sadjoumoumouni.ddd.bank.domain.valueobject.Money;

@SuperBuilder
@Getter
public abstract class Transaction {

    private static String datePattern = "dd MMMMM yyyy HH:mm:ss ";
    protected static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern, Locale.FRANCE);

    protected UUID uuid;
    protected Date  date;
    protected Money amount;

    public abstract Money balanceAfterTransaction(Money balance);
}
