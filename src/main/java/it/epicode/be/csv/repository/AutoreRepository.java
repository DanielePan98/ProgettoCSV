package it.epicode.be.csv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.be.csv.model.Author;

public interface AutoreRepository extends JpaRepository<Author, Long>{

}
