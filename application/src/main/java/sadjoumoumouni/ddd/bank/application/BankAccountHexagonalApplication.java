package sadjoumoumouni.ddd.bank.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

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
}
