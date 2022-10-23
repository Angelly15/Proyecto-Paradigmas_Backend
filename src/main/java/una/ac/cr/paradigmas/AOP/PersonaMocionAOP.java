/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.cr.paradigmas.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import una.ac.cr.paradigmas.modelo.Log;
import una.ac.cr.paradigmas.repositorio.LogRepositorio;

import java.time.LocalDateTime;

/**
 *
 * @author Angelly Cortes
 */
public class PersonaMocionAOP {
    @Autowired
    private LogRepositorio lr;

   @Before("execution(* una.ac.cr.paradigmas.repositorio.PersonaMocionRepository.findAll(..))")
    public void logBeforeV1(JoinPoint joinPoint){
       Log log = new Log();
       log.setMetodo(joinPoint.getSignature().getName());
       log.setFecha(LocalDateTime.now());
    }
    @Before("execution(* una.ac.cr.paradigmas.repositorio.PersonaMocionRepository.delete(..))")
    public void logeliminar(JoinPoint joinPoint){
        Log log = new Log();
        log.setMetodo(joinPoint.getSignature().getName());
        log.setFecha(LocalDateTime.now());
        lr.save(log);}
    @Before("execution(* una.ac.cr.paradigmas.repositorio.PersonaMocionRepository.save(..))")
    public void logguardar(JoinPoint joinPoint){
        Log log = new Log();
        log.setMetodo(joinPoint.getSignature().getName());
        log.setFecha(LocalDateTime.now());
        lr.save(log);}
    @Before("execution(* una.ac.cr.paradigmas.repositorio.PersonaMocionRepository.findById(..))")
    public void logbuscar(JoinPoint joinPoint){
        Log log = new Log();
        log.setMetodo(joinPoint.getSignature().getName());
        log.setFecha(LocalDateTime.now());
        lr.save(log);
    }

}