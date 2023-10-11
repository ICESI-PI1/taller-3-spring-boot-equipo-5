package com.autentication.apirest.services.impl;

import com.autentication.apirest.model.Author;
import com.autentication.apirest.model.Libro;

import java.util.List;
import java.util.Optional;

public interface ILibroService {
    Iterable<Libro> findAll();

    Optional<Libro> findById(Long id);

    Libro save(Libro libro);

    Libro update(Long id, Libro libro);

    void delete(Long id);
}
