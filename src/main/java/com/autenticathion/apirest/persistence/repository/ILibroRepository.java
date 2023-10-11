package com.autenticathion.apirest.persistence.repository;

import com.autenticathion.apirest.persistence.models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ILibroRepository extends JpaRepository<Libro, Long> {

}
