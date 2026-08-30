package cl.duoc.c.semana3c;

import java.util.List;

public class Publicacion {
    private int id;
    private String profesor;
    private String titulo;
    private List<Evaluacion> evaluaciones;

    public Publicacion(int id, String profesor, String titulo, List<Evaluacion> evaluaciones) {
        this.id = id;
        this.profesor = profesor;
        this.titulo = titulo;
        this.evaluaciones = evaluaciones;
    }

    public String getPromedio() {
        if (evaluaciones == null || evaluaciones.isEmpty()) return "0.0";
        
        double suma = 0.0;
        for (Evaluacion e : evaluaciones) {
            suma += e.obtenerNotaNumero();
        }
        
        double promedio = suma / evaluaciones.size();
        return String.format(java.util.Locale.US, "%.1f", promedio);
    }

    public int getId() {
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