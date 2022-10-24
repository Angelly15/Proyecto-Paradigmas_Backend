/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.cr.paradigmas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import una.ac.cr.paradigmas.modelo.Log;

/**
 *
 * @author Angelly Cortes
 */
public interface LogRepositorio extends JpaRepository<Log, Long> {

 
    
}
