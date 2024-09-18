package br.com.jtech.services.doctor.config.usecases;

import br.com.jtech.services.doctor.adapters.output.UpdateDoctorAdapter;
import br.com.jtech.services.doctor.application.core.usecases.UpdateDoctorUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateDoctorUseCaseConfig {

    @Bean
    public UpdateDoctorUseCase updateDoctorUseCase(UpdateDoctorAdapter adapter) {
        return new UpdateDoctorUseCase(adapter);
    }

}