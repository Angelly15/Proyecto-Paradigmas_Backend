package una.ac.cr.paradigmas.repositorio;

import org.springframework.data.repository.CrudRepository;
import una.ac.cr.paradigmas.modelo.Persona;

public interface PersonaRepository extends CrudRepository<Persona,Long> {



}
