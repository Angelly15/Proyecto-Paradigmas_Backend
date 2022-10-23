/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.cr.paradigmas.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Angelly Cortes
 */
@Entity
public class Log implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Metodo;
    private LocalDateTime Fecha;           

    public void setMetodo(String name) {
      Metodo=name;
    }

    public void setFecha(LocalDateTime now) {
        Fecha=now;
    }
    
}

