/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package una.ac.cr.paradigmas.repositorio;

import org.springframework.data.repository.CrudRepository;
import una.ac.cr.paradigmas.modelo.PersonaMocion;

/**
 *
 * @author Angelly Cortes
 */
public interface PersonaMocionRepository extends CrudRepository <PersonaMocion, Long>{
    
}
