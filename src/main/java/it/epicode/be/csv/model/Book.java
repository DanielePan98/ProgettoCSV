package it.epicode.be.csv.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titolo;
	private Genere genere;
	private Tipo tipo;
//	@ManyToMany(mappedBy = "authors")
//	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//	private List<Author> authors;
//	
	@ManyToMany(mappedBy = "books")
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	private List<CasaEditrice> editori;
	
	public Book(String titolo, String genere, String tipo) {
		this.titolo = titolo;
		this.genere = Genere.valueOf(genere);
		this.tipo = Tipo.valueOf(tipo);
	}

	



}
