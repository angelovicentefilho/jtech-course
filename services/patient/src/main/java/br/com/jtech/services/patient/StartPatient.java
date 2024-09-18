package br.com.jtech.services.patient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.jtech.services.patient.config.infra.redis.RedisConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@Import(RedisConfiguration.class)
public class StartPatient {

	public static void main(String[] args) {
		SpringApplication.run(StartPatient.class, args);
	}

}
