package com.autenticathion.apirest.services.impl;

import com.autenticathion.apirest.persistence.models.Author;
import com.autenticathion.apirest.persistence.models.Libro;
import com.autenticathion.apirest.persistence.repository.IAuthorRepository;
import com.autenticathion.apirest.services.IAuthorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements IAuthorService {
    @Autowired
    IAuthorRepository authorRepository;
    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author update(Long id, Author author) {
        Optional<Author> existingAuthorOptional = authorRepository.findById(id);

        if (existingAuthorOptional.isPresent()) {
            Author existingAuthor = existingAuthorOptional.get();
            //No se puede actualizar el id por que es primary key
            // Actualiza los campos del autor existente con los valores del nuevo autor
            existingAuthor.setNombre(author.getNombre());
            existingAuthor.setNacionalidad(author.getNacionalidad());

            // Guarda el autor actualizado en el repositorio
            return authorRepository.save(existingAuthor);
        } else {
            // Si no se encuentra el autor con el ID dado, puedes lanzar una excepción
            throw new EntityNotFoundException("Autor no encontrado con ID: " + id);
        }
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<Libro> findLibrosByAutor(Long id) {
        Optional<Author> authorOptional = authorRepository.findById(id);

        if (authorOptional.isPresent()) {
            Author author = authorOptional.get();
            return author.getLibros();
        } else {
            throw new EntityNotFoundException("Autor no encontrado con ID: " + id);
        }
    }


}
