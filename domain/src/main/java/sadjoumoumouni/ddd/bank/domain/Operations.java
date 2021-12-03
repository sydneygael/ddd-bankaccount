package sadjoumoumouni.ddd.bank.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import sadjoumoumouni.ddd.bank.domain.entities.Operation;
import sadjoumoumouni.ddd.bank.domain.entities.Transaction;
import sadjoumoumouni.ddd.bank.domain.valueobject.Money;

@Data
public class Operations {

    private List<Operation> transactionList = new ArrayList<Operation>();

    public void addLineContaining(Transaction transaction, Money balanceAfterTransaction) {
        transactionList.add(new Operation(transaction,balanceAfterTransaction));
    }
}
