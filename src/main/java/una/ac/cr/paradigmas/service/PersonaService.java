/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.cr.paradigmas.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import una.ac.cr.paradigmas.modelo.Persona;
import una.ac.cr.paradigmas.repositorio.PersonaRepository;

/**
 *
 * @author Angelly Cortes
 */
@Service
public class PersonaService {
    @Autowired
    private PersonaRepository repositorio;
    
    public List<Persona> listar(){
        List<Persona> lista=new ArrayList();
        repositorio.findAll().forEach(Persona->{
        lista.add(Persona);
        }
                
        );
        return lista;
    }
    
    public Persona guardar(Persona persona){
        return repositorio.save(persona);
    }
    public Persona buscarporid(Long id){
        Persona persona=repositorio.findById(id).orElse(null);
        if(!repositorio.findById(id).isPresent()){
            return null;
        }
        return persona;
    }
    
    public Persona eliminar(Long id){
        Persona persona=repositorio.findById(id).orElse(null);
        if(persona==null){
            return null;
        }
        repositorio.delete(persona);
        return persona;
    }
}
