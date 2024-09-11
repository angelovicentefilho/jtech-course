package br.com.jtech.services.doctor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.jtech.services.doctor.config.infra.redis.RedisConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(RedisConfiguration.class)
public class StartDoctor {

	public static void main(String[] args) {
		SpringApplication.run(StartDoctor.class, args);
	}

}
