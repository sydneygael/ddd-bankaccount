package sadjoumoumouni.ddd.bank.domain.ports.incoming;

public interface ListOperationsUseCase {

    String listOperations(Long accountId);
}
