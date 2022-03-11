package it.epicode.be.csv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.be.csv.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	

}
