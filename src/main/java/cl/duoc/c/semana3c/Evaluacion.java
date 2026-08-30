package cl.duoc.c.semana3c;

public class Evaluacion {
    private String alumno;
    private double calificacion;
    private String comentario;

    public Evaluacion(String alumno, double calificacion, String comentario) {
        this.alumno = alumno;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }

    public String getCalificacion() {
        return String.format(java.util.Locale.US, "%.1f", calificacion);
    }

    public double obtenerNotaNumero() {
        return calificacion;
    }

    public String getAlumno() {
        return alumno;
    }

    public String getComentario() {
        return comentario;
    }
}