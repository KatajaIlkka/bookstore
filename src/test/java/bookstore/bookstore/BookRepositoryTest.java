package bookstore.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;
import bookstore.bookstore.domain.Category;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository brepository;

    //Search
    @Test
    public void findBookByTitle() {
        List<Book> book = brepository.findByTitle("Animal Farm");
        
        assertThat(book).hasSize(1);
        assertThat(book.get(0).getAuthor()).isEqualTo("George Orwell");
    }
    
    //Add
    @Test
    public void addNewBook() {
    	Book book = new Book("Lord of the rings", "J.R.R. Tolkien", 1954, "123456789", 20.00, new Category("Fantasy"));
    	brepository.save(book);
    	assertThat(book.getId()).isNotNull();
    }  
    
    //Delete
    @Test
    public void deleteBook() {
    	List<Book> book = brepository.findByTitle("Animal Farm");
    	assertThat(book).hasSize(1);
        assertThat(book.get(0).getAuthor()).isEqualTo("George Orwell");
    	brepository.delete(book);
    }

}