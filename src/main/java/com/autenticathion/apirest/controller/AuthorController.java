package com.autenticathion.apirest.controller;

import com.autenticathion.apirest.persistence.models.Author;
import com.autenticathion.apirest.persistence.models.Libro;
import com.autenticathion.apirest.services.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autores")
public class AuthorController {

    @Autowired
    IAuthorService authorService;

    //Devuelve todos los autores
    //El metodo retorna ResponseEntity porque nos da mayor control sobre los Status http que nos da el request
    //Sirve para hacer las pruebas en PostmMan
    @GetMapping
    public ResponseEntity<Iterable<Author>> getAllAuthors() {
        Iterable<Author> authors = authorService.findAll();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    // GET /autores/{id}: Obtener detalles de un autor específico.
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Author>> getAuthorById(@PathVariable Long id) {
        Optional<Author> author = authorService.findById(id);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }


    // POST /autores: Crear un nuevo autor.
    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author autor) {
        Author newAuthor = authorService.save(autor);
        return new ResponseEntity<>(newAuthor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author autor) {
        Author updatedAuthor = authorService.update(id, autor);
        return new ResponseEntity<>(updatedAuthor, HttpStatus.OK);
    }

    // DELETE /autores/{id}: Eliminar un autor.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // GET /autores/{id}/libros: Listar los libros de un autor específico.
    @GetMapping("/{id}/libros")
    public ResponseEntity<List<Libro>> getLibrosByAuthor(@PathVariable Long id) {
        List<Libro> libros = authorService.findLibrosByAutor(id);
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

}
