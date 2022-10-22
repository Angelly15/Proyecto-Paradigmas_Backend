package una.ac.cr.paradigmas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import una.ac.cr.paradigmas.modelo.Persona;
import una.ac.cr.paradigmas.service.PersonaService;

import java.util.List;

@RestController
@RequestMapping
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
        return ResponseEntity.ok(personaService.guardar(persona));
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*",maxAge=3600)
    public  ResponseEntity<Persona> buscarporid(@PathVariable("id") Long id){
        return ResponseEntity.ok(personaService.buscarporid(id));
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "*",maxAge=3600)
    public  ResponseEntity<Persona> borrar(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(personaService.eliminar(id));
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
