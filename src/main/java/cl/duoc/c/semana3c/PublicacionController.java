package cl.duoc.c.semana3c;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicacionController {

    private List<Publicacion> publicaciones = new ArrayList<>();

    public PublicacionController() {
        List<Evaluacion> ev1 = new ArrayList<>();
        ev1.add(new Evaluacion("Renato Ortiz", 6.5, "Buena explicacion."));
        ev1.add(new Evaluacion("Ana Gomez", 5.0, "Faltaron ejemplos."));
        ev1.add(new Evaluacion("Carlos Vera", 7.0, "Excelente clase."));
        publicaciones.add(new Publicacion(1, "Prof. Juan Perez", "Controladores REST", ev1));

        List<Evaluacion> ev2 = new ArrayList<>();
        ev2.add(new Evaluacion("Diego Soto", 4.0, "Rapido el ritmo."));
        ev2.add(new Evaluacion("Maria Silva", 6.0, "Se entendio."));
        ev2.add(new Evaluacion("Lucas Rivas", 5.5, "Aceptable."));
        publicaciones.add(new Publicacion(2, "Prof. Maria Gonzalez", "Estructuras Java", ev2));
    }

    @GetMapping("/publicaciones")
    public List<Publicacion> getAllPublicaciones() {
        return publicaciones;
    }

    @GetMapping("/publicaciones/{id}")
    public Publicacion getPublicacionById(@PathVariable int id) {
        for (Publicacion p : publicaciones) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}