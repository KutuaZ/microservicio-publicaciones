package cl.duoc.c.semana3c.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name = "evaluaciones")
public class Evaluacion {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;
    
    @Column (name = "alumno")
    private String alumno;

    @Column (name = "calificacion")
    private double calificacion;

    @Column (name = "comentario")
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "publicacion_id")
    @JsonBackReference
    private Publicacion publicacion;

    public Publicacion getPublicacion() {
        return publicacion;
    }


    public String getCalificacion() {
        return String.format(java.util.Locale.US, "%.1f", calificacion);
    }

    public double obtenerNotaNumero() {
        return calificacion;
    }

    public Long getId() {
        return id;
    }

    public String getAlumno() {
        return alumno;
    }

    public String getComentario() {
        return comentario;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }
}