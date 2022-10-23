package una.ac.cr.paradigmas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import una.ac.cr.paradigmas.modelo.Mocion;
import una.ac.cr.paradigmas.modelo.TipoMocion;
import una.ac.cr.paradigmas.service.MocionService;
import una.ac.cr.paradigmas.service.TipoMocionService;

import java.util.List;

@RestController
@RequestMapping("/TipoMocion")
public class ControladorTipoMocion {

    @Autowired private TipoMocionService tipoMocionService;


    @GetMapping()
    @CrossOrigin(origins = "*",maxAge=3600)
    public ResponseEntity <List<TipoMocion>>Listar(){
        return ResponseEntity.ok().body(tipoMocionService.listar());
    }

    @PostMapping()
    @CrossOrigin(origins = "*",maxAge=3600)

    public  ResponseEntity<TipoMocion> guardar(@RequestBody TipoMocion tipoMocion){
        TipoMocion tpm = tipoMocionService.guardar(tipoMocion);
        if (tpm==null) {
            return ResponseEntity.badRequest().build();

        }
        return ResponseEntity.ok(tpm);
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*",maxAge=3600)
    public  ResponseEntity<TipoMocion> buscarporid(@PathVariable("id") Long id){
        TipoMocion tipoMocion = tipoMocionService.buscarporid(id);
        if (tipoMocion==null) {
            return ResponseEntity.badRequest().build();

        }
        return ResponseEntity.ok(tipoMocion);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "*",maxAge=3600)
    public  ResponseEntity<TipoMocion> borrar(@PathVariable("id") Long id){
        TipoMocion tipoMocion = tipoMocionService.eliminar(id);
        if (tipoMocion==null) {
            return ResponseEntity.badRequest().build();

        }
        return ResponseEntity.ok().body(tipoMocion);
    }

    /*private final LogRepository LR;

    @GetMapping("/Log")
    @CrossOrigin(origins = "*",maxAge=3600)
    public  ResponseEntity<List<Log>> listarLog(){
        List<Log> lista = new ArrayList<Log>();
        LR.findAll().forEach(log -> lista.add(log));
        return ResponseEntity.ok(lista);
    }
    */


}
