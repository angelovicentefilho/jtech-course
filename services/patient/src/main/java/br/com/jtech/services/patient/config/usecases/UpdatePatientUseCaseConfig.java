package br.com.jtech.services.patient.config.usecases;

import br.com.jtech.services.patient.adapters.output.FindPatientByIdAdapter;
import br.com.jtech.services.patient.adapters.output.UpdatePatientAdapter;
import br.com.jtech.services.patient.application.core.usecases.UpdatePatientUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdatePatientUseCaseConfig {

    @Bean
    public UpdatePatientUseCase updatePatientUseCase(
            final FindPatientByIdAdapter findPatientByIdAdapter,
            final UpdatePatientAdapter updatePatientAdapter
    ) {
        return new UpdatePatientUseCase(
                findPatientByIdAdapter,
                updatePatientAdapter
        );
    }
}
