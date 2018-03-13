package bookstore.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import bookstore.bookstore.domain.Category;
import bookstore.bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {

	@Autowired
	private CategoryRepository crepository;

	// Search
	@Test
	public void findByCategoryName() {
		List<Category> category = crepository.findByName("Horror");

		assertThat(category).hasSize(1);
	}

	// Add
	@Test
	public void addNewCategory() {
		Category category = new Category("Fantasy");
		crepository.save(category);
		assertThat(category.getCategoryid()).isNotNull();
	}

	// Delete
	@Test
	public void deleteCategory() {
		List<Category> category = crepository.findByName("Horror");

		assertThat(category).hasSize(1);
		crepository.delete(category);
	}
}
