package com.autenticathion.apirest.services;

import com.autenticathion.apirest.persistence.models.Author;
import com.autenticathion.apirest.persistence.models.Libro;

import java.util.List;
import java.util.Optional;

public interface IAuthorService {

    Iterable<Author> findAll();

    Optional<Author> findById(Long id);

    Author save(Author autor);

    Author update(Long id, Author autor);

    void delete(Long id);

    List<Libro> findLibrosByAutor(Long id);
}
