package br.com.jtech.services.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.jtech.services.schedule.config.infra.redis.RedisConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(RedisConfiguration.class)
public class StartSchedule {

	public static void main(String[] args) {
		SpringApplication.run(StartSchedule.class, args);
	}

}
