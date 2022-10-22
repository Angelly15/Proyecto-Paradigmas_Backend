package una.ac.cr.paradigmas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import una.ac.cr.paradigmas.modelo.Mocion;
import una.ac.cr.paradigmas.service.MocionService;


import java.util.List;

@RestController
@RequestMapping
public class ControladorMocion {

    @Autowired private MocionService mocionService;


    @GetMapping()
    @CrossOrigin(origins = "*",maxAge=3600)
    public ResponseEntity <List<Mocion>>Listar(){
        return ResponseEntity.ok().body(mocionService.listar());
    }

    @PostMapping()
    @CrossOrigin(origins = "*",maxAge=3600)

    public  ResponseEntity<Mocion> guardar(@RequestBody Mocion mocion){
        return ResponseEntity.ok(mocionService.guardar(mocion));
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*",maxAge=3600)
    public  ResponseEntity<Mocion> buscarporid(@PathVariable("id") Long id){
        return ResponseEntity.ok(mocionService.buscarporid(id));
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "*",maxAge=3600)
    public  ResponseEntity<Mocion> borrar(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(mocionService.eliminar(id));
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
