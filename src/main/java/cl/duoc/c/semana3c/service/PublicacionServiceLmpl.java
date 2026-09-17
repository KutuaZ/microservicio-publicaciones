package cl.duoc.c.semana3c.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.c.semana3c.model.Evaluacion;
import cl.duoc.c.semana3c.model.Publicacion;
import cl.duoc.c.semana3c.repository.PublicacionRepository;

@Service
public class PublicacionServiceLmpl implements PublicacionService {
    
    @Autowired
    private PublicacionRepository publicacionRepository;

    @Override
    public List<Publicacion> getAllPublicaciones() {
        return publicacionRepository.findAll();
    }

    @Override
    public Optional<Publicacion> getPublicacionById(Long id) {
        return publicacionRepository.findById(id);
    }

    @Override 
    public Publicacion guardarPublicacion(Publicacion publicacion) {
        if (publicacion.getEvaluaciones() != null) {
            for (Evaluacion e : publicacion.getEvaluaciones()) {
                e.setPublicacion(publicacion);
            }
        }
        return publicacionRepository.save(publicacion);
    }
}