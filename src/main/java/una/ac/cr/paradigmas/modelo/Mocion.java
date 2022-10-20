package una.ac.cr.paradigmas.modelo;

import java.util.Date;

public class Mocion {

    private long id;
    private String texto;
    private TipoMocion tipo;
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

