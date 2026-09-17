package cl.duoc.c.semana3c.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity 
@Table (name="publicaciones")
@JsonPropertyOrder({ "id", "profesor", "titulo", "promedio", "evaluaciones" })
public class Publicacion {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id")
    private Long id;

    @Column (name="profesor")
    private String profesor;

    @Column (name="titulo")
    private String titulo;
    
    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL)
    @JsonManagedReference 
    private List<Evaluacion> evaluaciones;


    public String getPromedio() {
        if (evaluaciones == null || evaluaciones.isEmpty()) return "0.0";
        
        double suma = 0.0;
        for (Evaluacion e : evaluaciones) {
            suma += e.obtenerNotaNumero();
        }
        
        double promedio = suma / evaluaciones.size();
        return String.format(java.util.Locale.US, "%.1f", promedio);
    }

    public Long getId() {
        return id;
    }

    public String getProfesor() {
        return profesor;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }
}