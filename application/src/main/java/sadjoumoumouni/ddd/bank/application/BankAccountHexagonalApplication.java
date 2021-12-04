package sadjoumoumouni.ddd.bank.application;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;

import sadjoumoumouni.ddd.bank.domain.BankAccount;
import sadjoumoumouni.ddd.bank.infrastructure.adapters.outgoing.inmemory.InMemoryBankAccountRepository;

@SpringBootApplication (scanBasePackages = {"sadjoumoumouni.ddd.bank.infrastructure.adapters",
        "sadjoumoumouni.ddd.bank.application"},
        exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})
public class BankAccountHexagonalApplication {
    public static void main(final String[] args) {
        SpringApplication.run(BankAccountHexagonalApplication.class, args);
    }

    @Bean
    public CommandLineRunner bootstrapData(InMemoryBankAccountRepository repository) {
        return (args) -> {
            BigDecimal initialBalance = BigDecimal.valueOf(100);
            BankAccount bankAccount = new BankAccount(1L, initialBalance);
            repository.save(bankAccount);
        };
    }
}
