package sadjoumoumouni.ddd.bank.domain.ports.incoming;

import java.math.BigDecimal;

public interface DepositUseCase {
    void deposit(Long id, BigDecimal amount);
}
