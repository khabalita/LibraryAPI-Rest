package com.khabalita.springboot.finalseminario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.khabalita.springboot.finalseminario.entities"})
public class FinalSeminarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalSeminarioApplication.class, args);
	}

}
