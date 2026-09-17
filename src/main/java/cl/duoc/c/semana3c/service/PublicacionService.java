package cl.duoc.c.semana3c.service;

import java.util.List;
import java.util.Optional;

import cl.duoc.c.semana3c.model.Publicacion;

public interface PublicacionService {
    
    List<Publicacion> getAllPublicaciones();
    Optional<Publicacion> getPublicacionById(Long id);

    Publicacion guardarPublicacion(Publicacion publicacion);

    

}
