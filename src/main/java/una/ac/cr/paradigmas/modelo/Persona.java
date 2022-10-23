/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.cr.paradigmas.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Angelly Cortes
 */
@Entity
public class Persona implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   private String Identificacion;
   private String Nombre;

    public Persona(long id, String Identificacion, String Nombre) {
        this.id = id;
        this.Identificacion = Identificacion;
        this.Nombre = Nombre;
    }

    public Persona() {
    }

    public long getId() {
        return id;
    }

    public String getIdentificacion() {
        return Identificacion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setIdentificacion(String Identificacion) {
        this.Identificacion = Identificacion;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", Identificacion=" + Identificacion + ", Nombre=" + Nombre + '}';
    }
    
   
}