package com.autenticathion.apirest.persistence.repository;

import com.autenticathion.apirest.persistence.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorRepository extends JpaRepository<Author, Long> {

}
