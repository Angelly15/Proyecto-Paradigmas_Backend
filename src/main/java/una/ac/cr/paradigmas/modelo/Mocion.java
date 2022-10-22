package una.ac.cr.paradigmas.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Date;
@Entity
public class Mocion implements Serializable {
    @Id
    private Long id;
    private String texto;
    @OneToOne
    @JoinColumn(name = "tipomocion_id")
    private TipoMocion tipo;
    @JsonFormat(pattern="yyyy-MM-dd")

    private Date fecha;


    public Mocion() {
    }

    public Mocion(long id, String texto, TipoMocion tipo, Date fecha) {
        this.id = id;
        this.texto = texto;
        this.tipo = tipo;
        this.fecha = fecha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public TipoMocion getTipo() {
        return tipo;
    }

    public void setTipo(TipoMocion tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Mocion{" +
                "id=" + id +
                ", texto='" + texto + '\'' +
                ", tipo=" + tipo +
                ", fecha=" + fecha +
                '}';
    }
}

