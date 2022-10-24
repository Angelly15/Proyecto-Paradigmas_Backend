package una.ac.cr.paradigmas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import una.ac.cr.paradigmas.modelo.Mocion;
import una.ac.cr.paradigmas.modelo.Persona;
import una.ac.cr.paradigmas.modelo.PersonaMocion;
import una.ac.cr.paradigmas.modelo.TipoMocion;
import una.ac.cr.paradigmas.service.MocionService;
import una.ac.cr.paradigmas.service.PersonaMocionService;
import una.ac.cr.paradigmas.service.PersonaService;
import una.ac.cr.paradigmas.service.TipoMocionService;

import java.text.SimpleDateFormat;

@SpringBootApplication
public class ParadigmasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParadigmasApplication.class, args);
	}
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD");
	@Bean
	CommandLineRunner run (MocionService ms, PersonaService ps, PersonaMocionService pms, TipoMocionService ts ){
		return args -> {
			ts.guardar(new TipoMocion(null, "tipo1"));
			ts.guardar(new TipoMocion(null, "tipo2"));
			ts.guardar(new TipoMocion(null, "tipo3"));

			ms.guardar(new Mocion(null, "hola", null, simpleDateFormat.parse("2022-10-22")),Long.parseLong("1"));
			ms.guardar(new Mocion(null, "mundo", null, simpleDateFormat.parse("2022-11-10")), Long.parseLong("2"));
			ms.guardar(new Mocion(null, "adios", null, simpleDateFormat.parse("2022-01-12")), Long.parseLong("3"));

			ps.guardar(new Persona(1, "118280201", "jack"));
			ps.guardar(new Persona(2, "202020202", "juan"));
			ps.guardar(new Persona(3, "101010101", "pancho"));





		};
	}

}
