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
@Autowired private TipoMocionRepository tipoMocionRepository;
@Autowired private TipoMocionService tipoMocionService;
    public List<Mocion> listar(){
        List<Mocion> lista=new ArrayList();
        Mocionrepository.findAll().forEach(Mocion->{
                    lista.add(Mocion);
                }
        );
        return lista;
    }

    public Mocion guardar(Mocion mocion,Long id){
        TipoMocion tipo = tipoMocionRepository.findById(id).orElse(null);
        if (tipo == null) {
            return null;
        }
        mocion.setTipo(tipo);
        return Mocionrepository.save(mocion);
    }
    public Mocion buscarporid(Long id){
        Mocion mocion=Mocionrepository.findById(id).orElse(null);
        if(mocion == null){
            return null;
        }
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
        System.out.println(mocion);
        if (tipoMocion==null|| mocion==null) {
            return null;
        }
        mocion.setTipo(tipoMocion);
        return Mocionrepository.save(mocion) ;
    }
}



