package bookstore.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;
import bookstore.bookstore.domain.Category;
import bookstore.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Cook"));
			crepository.save(new Category("Science"));
			
			brepository.save(new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "1232323-21", 9.45, crepository.findByName("Cook").get(0)));
			brepository.save(new Book("Animal Farm", "George Orwell", 1945, "2212343-5", 12.00, crepository.findByName("Horror").get(0)));
		};
	}
}
