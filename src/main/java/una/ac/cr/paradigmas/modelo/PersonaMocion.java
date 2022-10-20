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
public class PersonaMocion implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;
   private Persona persona;
   private Mocion mocion;

    public PersonaMocion(long id, Persona persona, Mocion mocion) {
        this.id = id;
        this.persona = persona;
        this.mocion = mocion;
    }

    public PersonaMocion() {
    }

    public long getId() {
        return id;
    }

    public Persona getPersona() {
        return persona;
    }

    public Mocion getMocion() {
        return mocion;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setMocion(Mocion mocion) {
        this.mocion = mocion;
    }

    @Override
    public String toString() {
        return "PersonaMocion{" + "id=" + id + ", persona=" + persona + ", mocion=" + mocion + '}';
    }
   
   
}
