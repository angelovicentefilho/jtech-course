package br.com.jtech.services.doctor.config.usecases;

import br.com.jtech.services.doctor.adapters.output.DeleteDoctorAdapter;
import br.com.jtech.services.doctor.application.core.usecases.DeleteDoctorUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteDoctorUseCaseConfig {

    @Bean
    public DeleteDoctorUseCase deleteDoctorUseCase(DeleteDoctorAdapter adapter) {
        return new DeleteDoctorUseCase(adapter);
    }
}