package com.autenticathion.apirest.services.impl;

import com.autenticathion.apirest.persistence.models.Author;
import com.autenticathion.apirest.persistence.models.Libro;
import com.autenticathion.apirest.persistence.repository.ILibroRepository;
import com.autenticathion.apirest.services.ILibroService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class LibroServiceImpl implements ILibroService {
    @Autowired
    ILibroRepository libroRepository;
    @Override
    public Iterable<Libro> findAll() {
        return libroRepository.findAll();
    }

    @Override
    public Optional<Libro> findById(Long id) {
        return libroRepository.findById(id);
    }

    @Override
    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Libro update(Long id, Libro libro) {
        Optional<Libro> existingAuthorOptional = libroRepository.findById(id);

        if (existingAuthorOptional.isPresent()) {
            Libro existingLibro = existingAuthorOptional.get();
            //No se puede actualizar el id por que es primary key
            // Actualiza los campos del autor
            existingLibro.setTitulo(libro.getTitulo());
            existingLibro.setAuthor(libro.getAuthor());
            existingLibro.setFechaPublicacion(libro.getFechaPublicacion());

            // Guarda el autor actualizado en el repositorio
            return libroRepository.save(existingLibro);
        } else {
            // Si no se encuentra el autor con el ID dado, puedes lanzar una excepción
            throw new EntityNotFoundException("Autor no encontrado con ID: " + id);
        }
    }

    @Override
    public void delete(Long id) {
        libroRepository.deleteById(id);
    }
}
