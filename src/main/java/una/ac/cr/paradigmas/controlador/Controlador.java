package una.ac.cr.paradigmas.controlador;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import una.ac.cr.paradigmas.modelo.Persona;
import una.ac.cr.paradigmas.service.MocionService;
import una.ac.cr.paradigmas.service.PersonaMocionService;
import una.ac.cr.paradigmas.service.PersonaService;
import una.ac.cr.paradigmas.service.TipoMocionService;

import java.sql.ClientInfoStatus;
import java.util.List;

@RestController
@RequestMapping
public class Controlador {

    @Autowired private MocionService mocionService;
    @Autowired private PersonaMocionService personaMocionService;
    @Autowired private PersonaService personaService;
    @Autowired private TipoMocionService tipoMocionService;

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
        return ResponseEntity.ok().body(PersonaService.eliminar(id));
    }

    private final LogRepository LR;

    @GetMapping("/Log")
    @CrossOrigin(origins = "*",maxAge=3600)
    public  ResponseEntity<List<Log>> listarLog(){
        List<Log> lista = new ArrayList<Log>();
        LR.findAll().forEach(log -> lista.add(log));
        return ResponseEntity.ok(lista);
    }

}
