package cl.duoc.c.semana3c.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.duoc.c.semana3c.model.Publicacion;

public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {
    
}
