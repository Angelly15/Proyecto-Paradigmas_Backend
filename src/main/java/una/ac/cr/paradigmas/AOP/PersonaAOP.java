/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.cr.paradigmas.AOP;

import java.time.LocalDateTime;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import una.ac.cr.paradigmas.modelo.Log;
import una.ac.cr.paradigmas.repositorio.LogRepositorio;

/**
 *
 * @author Angelly Cortes
 */
@Component @Aspect
public class PersonaAOP {
    @Autowired
    private LogRepositorio lr;
    Date date = new Date(System.currentTimeMillis());
   @Before("execution(* una.ac.cr.paradigmas.repositorio.PersonaRepository.findAll(..))")
    public void logBeforeV1(JoinPoint joinPoint){
       Log log = new Log();
       log.setMetodo(joinPoint.getSignature().getName());
       log.setFecha(date);
       lr.save(log);
    }
    @Before("execution(* una.ac.cr.paradigmas.repositorio.PersonaRepository.delete(..))")
    public void logeliminar(JoinPoint joinPoint){
        Log log = new Log();
        log.setMetodo(joinPoint.getSignature().getName());
        log.setFecha(date);
        lr.save(log);}
    @Before("execution(* una.ac.cr.paradigmas.repositorio.PersonaRepository.save(..))")
    public void logguardar(JoinPoint joinPoint){
        Log log = new  Log(null , joinPoint.getSignature().getName(),date);
        lr.save(log);}
    @Before("execution(* una.ac.cr.paradigmas.repositorio.PersonaRepository.findById(..))")
    public void logbuscar(JoinPoint joinPoint){
        Log log = new Log();
        log.setMetodo(joinPoint.getSignature().getName());
        log.setFecha(date);
        lr.save(log);
    }

}