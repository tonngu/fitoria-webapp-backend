package se.lexicon.g1.fitoriabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class FitoriaBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FitoriaBackendApplication.class, args);
    }

}
