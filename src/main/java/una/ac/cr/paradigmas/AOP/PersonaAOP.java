/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.cr.paradigmas.AOP;

import java.time.LocalDateTime;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import una.ac.cr.paradigmas.modelo.Log;
/**
 *
 * @author Angelly Cortes
 */
public class PersonaAOP {
    @Autowired
    private LogRepositorio lr;

   @Before("execution(* una.ac.cr.paradigmas.repositorio.personaRespository.findAll(..))")
    public void logBeforeV1(JoinPoint joinPoint){
       Log log = new Log();
       log.setMetodo(joinPoint.getSignature().getName());
       log.setFecha(LocalDateTime.now());
    }
    @Before("execution(* una.ac.cr.paradigmas.repositorio.personaRespository.delete(..))")
    public void logeliminar(JoinPoint joinPoint){
        Log log = new Log();
        log.setMetodo(joinPoint.getSignature().getName());
        log.setFecha(LocalDateTime.now());
        lr.save(log);}
    @Before("execution(* una.ac.cr.paradigmas.repositorio.personaRespository.save(..))")
    public void logguardar(JoinPoint joinPoint){
        Log log = new Log();
        log.setMetodo(joinPoint.getSignature().getName());
        log.setFecha(LocalDateTime.now());
        lr.save(log);}
    @Before("execution(* una.ac.cr.paradigmas.repositorio.personaRespository.findById(..))")
    public void logbuscar(JoinPoint joinPoint){
        Log log = new Log();
        log.setMetodo(joinPoint.getSignature().getName());
        log.setFecha(LocalDateTime.now());
        lr.save(log);
    }

}