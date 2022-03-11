package it.epicode.be.csv.util;

import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;

import it.epicode.be.csv.model.Author;
import it.epicode.be.csv.model.Book;
import it.epicode.be.csv.model.CasaEditrice;
import it.epicode.be.csv.repository.AutoreRepository;
import it.epicode.be.csv.repository.BookRepository;
import it.epicode.be.csv.repository.CasaEditriceRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DataLoadRunner implements CommandLineRunner {

	@Autowired
	BookRepository bookRepository;
	@Autowired
	CasaEditriceRepository casaRepository;
	@Autowired
	AutoreRepository autoreRepository;

	@Override
	public void run(String... args) throws Exception {
		log.info("*** Inizio caricamento dati ***");
		initCasaEditore();
		initAuthor();
		initBook();
		log.info("*** Fine caricamento dati ***");
	}

	private void initCasaEditore() throws Exception {
		try (CSVReader csvReader = new CSVReader(new FileReader("casaeditrice.csv"));) {
			String[] values = null;
			csvReader.readNext();	
			while ((values = csvReader.readNext()) != null) {
				casaRepository.save(new CasaEditrice(values[0], values[1]));
			}
		}
	}
	
	private void initAuthor() throws Exception {
		try (CSVReader csvReader = new CSVReader(new FileReader("autore.csv"));) {
			String[] values = null;
			csvReader.readNext();	
			while ((values = csvReader.readNext()) != null) {
				autoreRepository.save(new Author(values[0], values[1]));
			}
		}
	}
	
	private void initBook() throws Exception {
		try (CSVReader csvReader = new CSVReader(new FileReader("book.csv"));) {
			String[] values = null;
			csvReader.readNext();	
			while ((values = csvReader.readNext()) != null) {
				bookRepository.save(new Book(values[0], values[1],values[2]));
			}
		}
	}

//	
//	try (CSVReader csvReader = new CSVReader(new FileReader("book.csv"));) {
//		String[] values = null;
//		csvReader.readNext();//serve per fare saltare la prima riga del csv ovvero l'intestazione
//		while ((values = csvReader.readNext()) != null) {
	// records.add(Arrays.asList(values));
//			bookRepository.save(new Book(values[0],values[1]));
//		}
//	}
//	System.out.println("Test");

}
