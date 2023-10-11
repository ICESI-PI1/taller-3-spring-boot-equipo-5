package com.autenticathion.apirest.services;

import com.autenticathion.apirest.persistence.models.Author;
import com.autenticathion.apirest.persistence.models.Libro;

import java.util.List;
import java.util.Optional;

public interface ILibroService {
    Iterable<Libro> findAll();

    Optional<Libro> findById(Long id);

    Libro save(Libro libro);

    Libro update(Long id, Libro libro);

    void delete(Long id);
}
