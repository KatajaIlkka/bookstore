package bookstore.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;
import bookstore.bookstore.domain.Category;
import bookstore.bookstore.domain.CategoryRepository;
import bookstore.bookstore.domain.User;
import bookstore.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Cook"));
			crepository.save(new Category("Science"));
			
			brepository.save(new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "1232323-21", 9.45, crepository.findByName("Cook").get(0)));
			brepository.save(new Book("Animal Farm", "George Orwell", 1945, "2212343-5", 12.00, crepository.findByName("Horror").get(0)));
			
			// Create users: admin/admin testi/testi ilkka/salasana
			User user1 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "admin@bookstore.com", "ADMIN");
			User user2 = new User("testi", "$2a$04$y8VjE5a5S7Gak5L/.a9oA.6SeBaqAdgv2ROvelegj0tAbZweEfCxC", "testi@bookstore.com", "USER");
			User user3 = new User("ilkka", "$2a$04$T2rOJDysrF.XaFeSkCQJSOTuROF610Ros0.kxj8KKaVpiXj5A0e9m", "ilkka@bookstore.com", "USER");
			urepository.save(user1);
			urepository.save(user2);
			urepository.save(user3);
			
		};
	}
}
