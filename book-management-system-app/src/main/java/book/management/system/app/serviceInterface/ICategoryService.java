package book.management.system.app.serviceInterface;

import java.util.List;

import book.management.system.app.entities.Category;


public interface ICategoryService {

	public Category addCategory(String categoryName);
	public Category editCategory(Category category);
	public List<Category> viewAllCategories();
	public Category removeCategory(Category category);
}
