/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.cr.paradigmas.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
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
    private Long id;
    private String metodo;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fecha;

    public Log() {

    }

    public void setMetodo(String name) {
      metodo=name;
    }

    public void setFecha(Date now) {
        fecha=now;
    }

    public Log(Long id, String metodo, Date fecha) {
        id = id;
        metodo = metodo;
        fecha = fecha;
    }


    @Override
    public String toString() {
        return "Log{" +
                "Id=" + id +
                ", Metodo='" + metodo + '\'' +
                ", Fecha=" + fecha +
                '}';
    }
}

