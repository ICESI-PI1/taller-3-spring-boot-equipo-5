package com.autentication.apirest.services.impl;

import com.autentication.apirest.model.Libro;
import com.autentication.apirest.repository.ILibroRepository;
import com.autentication.apirest.services.ILibroService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class LibroServiceImpl implements ILibroService {
    private ILibroRepository iRepository;

    @Override
    public Libro createLibro(Libro libro) {
        return iRepository.createLibro(libro);
    }

    @Override
    public boolean deleteLibro(Long id) {
        return iRepository.deleteLibro(id);
    }

    @Override
    public Optional<Libro> searchLibro(Long id) {
        return iRepository.searchLibro(id);
    }

    @Override
    public List<Libro> listLibros() {
        return iRepository.listLibros();
    }

    @Override
    public Libro editLibro(Long id, Libro libro) {
        return iRepository.editLibro(id, libro);
    }
}
