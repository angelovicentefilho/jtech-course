package br.com.jtech.services.patient.config.usecases;

import br.com.jtech.services.patient.adapters.output.DeletePatientByNameAdapter;
import br.com.jtech.services.patient.adapters.output.FindPatientByNameAdapter;
import br.com.jtech.services.patient.application.core.usecases.DeletePatientByNameUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletePatientByNameUseCaseConfig {

    @Bean
    public DeletePatientByNameUseCase deletePatientByNameUseCase(
            DeletePatientByNameAdapter deletePatientByNameAdapter,
            FindPatientByNameAdapter findPatientByNameAdapter) {
        return new DeletePatientByNameUseCase(
                deletePatientByNameAdapter,
                findPatientByNameAdapter
        );
    }
}
