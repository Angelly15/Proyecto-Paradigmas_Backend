package una.ac.cr.paradigmas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import una.ac.cr.paradigmas.modelo.Mocion;
import una.ac.cr.paradigmas.modelo.Persona;
import una.ac.cr.paradigmas.modelo.TipoMocion;
import una.ac.cr.paradigmas.repositorio.MocionRepository;
import una.ac.cr.paradigmas.repositorio.TipoMocionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MocionService  {

@Autowired
    private MocionRepository Mocionrepository;
@Autowired private TipoMocionService tipoMocionService;
    public List<Mocion> listar(){
        List<Mocion> lista=new ArrayList();
        Mocionrepository.findAll().forEach(Mocion->{
                    lista.add(Mocion);
                }
        );
        return lista;
    }

    public Mocion guardar(Mocion mocion){
        return Mocionrepository.save(mocion);
    }
    public Mocion buscarporid(Long id){
        if(!Mocionrepository.findById(id).isPresent()){
            return null;
        }
        Mocion mocion=Mocionrepository.findById(id).orElse(null);
        return mocion;

    }

    public Mocion eliminar(Long id){
        Mocion mocion=Mocionrepository.findById(id).orElse(null);
        if(mocion==null){
            return null;
        }
        Mocionrepository.delete(mocion);
        return mocion;
    }
    public Mocion anadirTipo(Long iditpo, Mocion mocion){
        TipoMocion tipoMocion = tipoMocionService.buscarporid(iditpo);
        mocion = buscarporid(mocion.getId());
        if (tipoMocion==null|| mocion==null) {
            return null;
        }
        mocion.setTipo(tipoMocion);
        return guardar(mocion);
    }
}



