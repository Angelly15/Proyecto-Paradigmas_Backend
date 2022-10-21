package una.ac.cr.paradigmas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import una.ac.cr.paradigmas.modelo.Mocion;
import una.ac.cr.paradigmas.modelo.Persona;
import una.ac.cr.paradigmas.modelo.PersonaMocion;
import una.ac.cr.paradigmas.modelo.TipoMocion;
import una.ac.cr.paradigmas.repositorio.PersonaMocionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaMocionService {
@Autowired private PersonaMocionRepository personaMocionRepository;
@Autowired private PersonaService personaService;
@Autowired private MocionService mocionService;

    public List<PersonaMocion> listar(){
        List<PersonaMocion> lista=new ArrayList();
        personaMocionRepository.findAll().forEach(PersonaMocion->{
                    lista.add(PersonaMocion);
                }

        );
        return lista;
    }

    public PersonaMocion eliminar(Long id){
        PersonaMocion personaMocion=personaMocionRepository.findById(id).orElse(null);
        if(personaMocion.equals(null)){
            return null;
        }
        personaMocionRepository.delete(personaMocion);
        return personaMocion;
    }


    public PersonaMocion buscarporid(Long id){
        PersonaMocion personaMocion=personaMocionRepository.findById(id).orElse(null);
        if(personaMocion.equals(null)){
            return null;
        }
        return personaMocion;
    }

    public  PersonaMocion guardar(Long Persona, Long Mocion){

        Persona persona = personaService.buscarporid(Persona);
        Mocion mocion = mocionService.buscarporid(Mocion);
        if(persona.equals(null)&&mocion.equals(null)){
            return null;

        }
        return  personaMocionRepository.save(new PersonaMocion(null,persona, mocion));


    }


}
