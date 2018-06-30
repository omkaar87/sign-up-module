package com.mcq.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.mcq.repository.UserRepository;

@SpringBootApplication(scanBasePackages={"com"},exclude = {JpaRepositoriesAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class McqLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(McqLoginApplication.class, args);
	}
}

