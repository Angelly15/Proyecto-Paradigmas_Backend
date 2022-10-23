package una.ac.cr.paradigmas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import una.ac.cr.paradigmas.modelo.Persona;
import una.ac.cr.paradigmas.service.PersonaService;

import java.util.List;

@RestController
@RequestMapping("/Persona")
public class ControladorPersona {

    @Autowired private PersonaService personaService;

    @GetMapping()
    @CrossOrigin(origins = "*",maxAge=3600)
    public ResponseEntity <List<Persona>>Listar(){
        return ResponseEntity.ok().body(personaService.listar());
    }

    @PostMapping()
    @CrossOrigin(origins = "*",maxAge=3600)

    public  ResponseEntity<Persona> guardar(@RequestBody Persona persona){
        Persona p = personaService.guardar(persona);
        if (p==null) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(p);
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*",maxAge=3600)
    public  ResponseEntity<Persona> buscarporid(@PathVariable("id") Long id){
        Persona persona = personaService.buscarporid(id);
        if (persona==null) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(persona);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "*",maxAge=3600)
    public  ResponseEntity<Persona> borrar(@PathVariable("id") Long id){
        Persona persona = personaService.eliminar(id);
        if (persona==null) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(persona);
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
