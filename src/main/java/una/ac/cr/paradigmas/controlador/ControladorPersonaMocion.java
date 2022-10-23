package una.ac.cr.paradigmas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import una.ac.cr.paradigmas.modelo.PersonaMocion;
import una.ac.cr.paradigmas.modelo.TipoMocion;
import una.ac.cr.paradigmas.service.PersonaMocionService;
import una.ac.cr.paradigmas.service.TipoMocionService;

import java.util.List;

@RestController
@RequestMapping("/PersonaMocion")
public class ControladorPersonaMocion {

    @Autowired private PersonaMocionService personaMocionService;


    @GetMapping()
    @CrossOrigin(origins = "*",maxAge=3600)
    public ResponseEntity <List<PersonaMocion>>Listar(){
        return ResponseEntity.ok().body(personaMocionService.listar());
    }

    @PutMapping("/{persona}/{mocion}" )
    @CrossOrigin(origins = "*",maxAge=3600)

    public  ResponseEntity<PersonaMocion> guardar(@PathVariable("persona") Long persona, @PathVariable ("mocion") Long mocion){
        PersonaMocion pm = personaMocionService.guardar(persona, mocion);
        if (pm==null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(pm);
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*",maxAge=3600)
    public  ResponseEntity<PersonaMocion> buscarporid(@PathVariable("id") Long id){
        PersonaMocion personaMocion = personaMocionService.buscarporid(id);
        if (personaMocion==null) {
            return ResponseEntity.badRequest().build();

        }
        return ResponseEntity.ok(personaMocion);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "*",maxAge=3600)
    public  ResponseEntity<PersonaMocion> borrar(@PathVariable("id") Long id){
        PersonaMocion personaMocion = personaMocionService.eliminar(id);
        if (personaMocion==null) {
            return ResponseEntity.badRequest().build();

        }
        return ResponseEntity.ok().body(personaMocion);
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
