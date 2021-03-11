package book.management.system.app;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import book.management.system.app.entities.Category;
import book.management.system.app.repos.ICategoryRepository;
import book.management.system.app.service.CategoryService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestCategoryService {

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ICategoryRepository categoryRepository;
	
	
//	@Test
	public void testAddCategory() {
		
//		categoryService.addCategory("Science Fiction Time");
		categoryService.addCategory("Drama 2");
		
		
//		assertEquals(5, categoryRepository.count());
		
		
	}
	
//	@Test
	public void testEditCategory() {
		
		Category cat  = categoryRepository.findByCategoryName("Horror 2");
		cat.setCategoryName("Horror comedy");
		categoryService.editCategory(cat);
	}
	
//	@Test
	public void testViewAllCategories() {
		
		List<Category> myList = categoryService.viewAllCategories();
		System.out.println(myList);
	}
	
	@Test
	public void testRemoveCategory() {
	
		Category cat  = categoryRepository.findByCategoryName("Drama 2");
		categoryService.removeCategory(cat);
	}
	
	
}
