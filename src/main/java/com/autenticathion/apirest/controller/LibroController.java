package com.autenticathion.apirest.controller;

import com.autenticathion.apirest.persistence.models.Author;
import com.autenticathion.apirest.persistence.models.Libro;
import com.autenticathion.apirest.services.IAuthorService;
import com.autenticathion.apirest.services.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/libros")
public class LibroController {
    @Autowired
    ILibroService libroService;

    //Devuelve todos los autores
    //El metodo retorna ResponseEntity porque nos da mayor control sobre los Status http que nos da el request
    //Sirve para hacer las pruebas en PostmMan
    @GetMapping
    public ResponseEntity<Iterable<Libro>> getAllAuthors() {
        Iterable<Libro> libros = libroService.findAll();
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    // GET /autores/{id}: Obtener detalles de un autor específico.
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Libro>> getAuthorById(@PathVariable Long id) {
        Optional<Libro> libro = libroService.findById(id);
        return new ResponseEntity<>(libro, HttpStatus.OK);
    }


    // POST /autores: Crear un nuevo autor.
    @PostMapping
    public ResponseEntity<Libro> createAuthor(@RequestBody Libro libro) {
        Libro newLibro = libroService.save(libro);
        return new ResponseEntity<>(newLibro, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> updateAuthor(@PathVariable Long id, @RequestBody Libro libro) {
        Libro updateLibro = libroService.update(id, libro);
        return new ResponseEntity<>(updateLibro, HttpStatus.OK);
    }

    // DELETE /autores/{id}: Eliminar un autor.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        libroService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
