package com.autentication.apirest.services.impl;


import com.autentication.apirest.model.Author;
import com.autentication.apirest.model.Libro;

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