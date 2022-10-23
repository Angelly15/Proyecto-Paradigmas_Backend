package una.ac.cr.paradigmas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import una.ac.cr.paradigmas.modelo.Mocion;
import una.ac.cr.paradigmas.service.MocionService;


import java.util.List;

@RestController
@RequestMapping("/Mocion")
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
        Mocion m= mocionService.guardar(mocion);
        if (m==null) {
            return  ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(m);
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*",maxAge=3600)
    public  ResponseEntity<Mocion> buscarporid(@PathVariable("id") Long id){
        Mocion mocion = mocionService.buscarporid(id);
        if (mocion==null) {
            return  ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(mocion);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "*",maxAge=3600)
    public  ResponseEntity<Mocion> borrar(@PathVariable("id") Long id){
        Mocion mocion = mocionService.eliminar(id);
        if (mocion==null) {
            return  ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(mocion);
    }
    @PutMapping("/{id}")
    @CrossOrigin(origins = "*",maxAge=3600)
    public  ResponseEntity<Mocion> anadirTipo(@PathVariable("id") Long id, @RequestBody Mocion m){
        Mocion mocion =  mocionService.anadirTipo(id, m);
        if (mocion==null) {
            return  ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(mocion);
    }



}
