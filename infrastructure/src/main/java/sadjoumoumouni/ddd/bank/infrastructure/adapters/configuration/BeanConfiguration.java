package sadjoumoumouni.ddd.bank.infrastructure.adapters.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import sadjoumoumouni.ddd.bank.domain.services.BankAccountDomainService;
import sadjoumoumouni.ddd.bank.infrastructure.adapters.outgoing.inmemory.InMemoryBankAccountRepository;

@Configuration
@ComponentScan(basePackages = "sadjoumoumouni.ddd.bank.infrastructure.adapters")
public class BeanConfiguration {

    @Bean
    BankAccountDomainService bankAccountService(InMemoryBankAccountRepository repository) {
        return new BankAccountDomainService(repository);
    }
}
