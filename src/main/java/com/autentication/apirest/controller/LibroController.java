package com.autentication.apirest.controller;


import com.autentication.apirest.model.Author;
import com.autentication.apirest.model.Libro;
import com.autentication.apirest.services.ILibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libros")
public class LibroController {
    private ILibroService libroService;
    public LibroController(ILibroService libroService){
        this.libroService = libroService;
    }

    //Devuelve todos los autores
    //El metodo retorna ResponseEntity porque nos da mayor control sobre los Status http que nos da el request
    //Sirve para hacer las pruebas en PostmMan
    @GetMapping
    public ResponseEntity<List<Libro>> getLibros() {
        List<Libro> libros = this.libroService.listLibros();
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }


    // GET /libros/id
    @GetMapping("/{id}")
    public ResponseEntity<Libro> getLibroById(@PathVariable Long id) {
        Optional<Libro> libro = this.libroService.searchLibro(id);

        if (libro.isPresent()){
            return new ResponseEntity<>(libro.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    // POST /libros
    @PostMapping
    public ResponseEntity<Libro> createLibro(@RequestBody Libro libro) {
        Libro newLibro = this.libroService.createLibro(libro);

        if (newLibro != null){
            return new ResponseEntity<>(newLibro, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    //@PutMapping("/{id}")
    //public ResponseEntity<Libro> updateLibro(@PathVariable Long id, @RequestBody Libro libro) {
    //    Libro updateLibro = libroService.update(id, libro);
    //    return new ResponseEntity<>(updateLibro, HttpStatus.OK);
    //}

    // DELETE /autores/{id}: Eliminar un autor.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable Long id) {
        boolean result = libroService.deleteLibro(id);

        return result ? (new ResponseEntity<>(HttpStatus.NO_CONTENT)) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}