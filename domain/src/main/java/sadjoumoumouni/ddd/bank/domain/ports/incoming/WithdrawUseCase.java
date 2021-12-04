package sadjoumoumouni.ddd.bank.domain.ports.incoming;

import java.math.BigDecimal;

public interface WithdrawUseCase {
    void withdraw(Long id, BigDecimal amount) throws RuntimeException;
}
