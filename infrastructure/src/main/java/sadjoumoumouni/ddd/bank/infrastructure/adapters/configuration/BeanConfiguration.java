package sadjoumoumouni.ddd.bank.infrastructure.adapters.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sadjoumoumouni.ddd.bank.domain.services.BankAccountDomainService;
import sadjoumoumouni.ddd.bank.infrastructure.adapters.outgoing.jpa.JpaBankAccountRepository;

@Configuration
public class BeanConfiguration {

    @Bean
    BankAccountDomainService bankAccountService(JpaBankAccountRepository repository) {
        return new BankAccountDomainService(repository);
    }
}
