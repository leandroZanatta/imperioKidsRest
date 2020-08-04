package br.com.sysdesc.imperio.kids;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication(scanBasePackages = { "br.com.sysdesc.imperio.kids" })
public class ImperioKidsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImperioKidsApplication.class, args);
	}

}
