package una.ac.cr.paradigmas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import una.ac.cr.paradigmas.modelo.Mocion;
import una.ac.cr.paradigmas.modelo.Persona;
import una.ac.cr.paradigmas.modelo.PersonaMocion;
import una.ac.cr.paradigmas.modelo.TipoMocion;
import una.ac.cr.paradigmas.repositorio.PersonaMocionRepository;

import java.text.SimpleDateFormat;
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
        if(personaMocion ==null){
            return null;
        }
        personaMocionRepository.delete(personaMocion);
        return personaMocion;
    }


    public PersonaMocion buscarporid(Long id){
        PersonaMocion personaMocion=personaMocionRepository.findById(id).orElse(null);
        if(personaMocion==null){
            return null;
        }
        return personaMocion;
    }

    public  PersonaMocion guardar(Long persona, Long mocion){
        Persona pp = personaService.buscarporid(persona);
        Mocion mn = mocionService.buscarporid(mocion);
        System.out.println(pp);
        System.out.println(mn);
        if(pp==null||mn==null){
            return null;
        }
        List<PersonaMocion> nombre = listarpersona(persona);
        List<PersonaMocion> nom = listarmocion(mocion);


        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        List<PersonaMocion> pm = new ArrayList<>();
        for (var personaMocion:nombre){
            String fecha1 = simpleDateFormat.format(personaMocion.getMocion().getFecha());
            String fecha2 = simpleDateFormat.format(mn.getFecha());
            if (fecha1.equals(fecha2)){
                pm.add(personaMocion);
            }

        }
        System.out.println(nom.size());
        System.out.println(pm.size());
            if(nom.size()>=3 || pm.size()>=5){
            return null;
        }



        return  personaMocionRepository.save(new PersonaMocion(null,pp, mn));


    }
    public List<PersonaMocion> listarpersona(Long idpersona){
        List<PersonaMocion> personas = new ArrayList<>();
        personaMocionRepository.findAll().forEach(personaMocion -> {
            if(idpersona.equals(personaMocion.getPersona().getId())){
                personas.add(personaMocion);
            }

        });
        return personas;
    }

    public List<PersonaMocion> listarmocion(Long idmocion){
        List <PersonaMocion> mociones = new ArrayList<>();
        personaMocionRepository.findAll().forEach(personaMocion -> {
            if(idmocion.equals(personaMocion.getMocion().getId())){
                mociones.add(personaMocion);
            }
        });
        return mociones;
    }
}
