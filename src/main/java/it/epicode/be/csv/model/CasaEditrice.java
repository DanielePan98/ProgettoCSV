package it.epicode.be.csv.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CasaEditrice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String citta;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "editrice_book", joinColumns = @JoinColumn(name = "casaeditrice_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"))
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Book> books;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "editrice_author", joinColumns = @JoinColumn(name = "casaeditrice_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"))
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Author> authors;
	
	public CasaEditrice(String nome, String citta) {
		this.nome = nome;
		this.citta = citta;
	}

	
}
