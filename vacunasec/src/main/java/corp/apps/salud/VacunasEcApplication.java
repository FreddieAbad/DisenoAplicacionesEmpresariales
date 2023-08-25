package corp.apps.salud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "VacunasEc API", version = "2.0", description = "Vacunas Information"))
public class VacunasEcApplication {

	public static void main(String[] args) {
		SpringApplication.run(VacunasEcApplication.class, args);
	}

}
