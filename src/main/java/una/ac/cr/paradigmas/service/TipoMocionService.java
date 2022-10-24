package una.ac.cr.paradigmas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import una.ac.cr.paradigmas.modelo.Mocion;
import una.ac.cr.paradigmas.modelo.TipoMocion;
import una.ac.cr.paradigmas.repositorio.TipoMocionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoMocionService {

    @Autowired
    private TipoMocionRepository tipomocionrepository;
    public List<TipoMocion> listar(){
        List<TipoMocion> lista=new ArrayList();
        tipomocionrepository.findAll().forEach(TipoMocion->{
                    lista.add(TipoMocion);
                }

        );
        return lista;
    }

    public TipoMocion guardar(TipoMocion tipoMocion){
        return tipomocionrepository.save(tipoMocion);
    }
    public TipoMocion buscarporid(Long id){
        TipoMocion mocion=tipomocionrepository.findById(id).orElse(null);
        System.out.println(mocion);
        if(mocion ==null){
            return null;
        }
        return mocion;
    }

    public TipoMocion eliminar(Long id){
        TipoMocion mocion=tipomocionrepository.findById(id).orElse(null);
        if(mocion==null){
            return null;
        }
        tipomocionrepository.delete(mocion);
        return mocion;
    }

}
