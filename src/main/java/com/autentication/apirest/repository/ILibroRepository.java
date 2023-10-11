package com.autentication.apirest.repository;

import com.autentication.apirest.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ILibroRepository extends JpaRepository<Libro, Long> {

}
