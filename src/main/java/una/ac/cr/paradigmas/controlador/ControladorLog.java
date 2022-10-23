package una.ac.cr.paradigmas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import una.ac.cr.paradigmas.modelo.Log;
import una.ac.cr.paradigmas.repositorio.LogRepositorio;

import java.util.ArrayList;
import java.util.List;
@RestController @RequestMapping("/Log")
public class ControladorLog {
    @Autowired
    private LogRepositorio LR;

    @GetMapping()
    @CrossOrigin(origins = "*",maxAge=3600)
    public  ResponseEntity<List<Log>> listarLog(){
        List<Log> lista = new ArrayList<Log>();
        LR.findAll().forEach(log -> lista.add(log));
        return ResponseEntity.ok(lista);
    }


}