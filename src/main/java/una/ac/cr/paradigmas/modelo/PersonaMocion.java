/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package una.ac.cr.paradigmas.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Angelly Cortes
 */
@Entity
public class PersonaMocion implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   @OneToOne
   @JoinColumn(name = "persona_id")
   private Persona persona;
    @OneToOne
    @JoinColumn(name = "mocion_id")
   private Mocion mocion;

    public PersonaMocion(Long id, Persona persona, Mocion mocion) {
        this.id = id;
        this.persona = persona;
        this.mocion = mocion;
    }

    public PersonaMocion() {
    }

    public Long getId() {
        return id;
    }

    public Persona getPersona() {
        return persona;
    }

    public Mocion getMocion() {
        return mocion;
    }

    public void setId(Long id) {
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
