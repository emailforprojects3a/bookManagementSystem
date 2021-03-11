package book.management.system.app.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import book.management.system.app.entities.Category;
import book.management.system.app.exception.CategoryAlreadyExistException;
import book.management.system.app.exception.CategoryNotFoundException;
import book.management.system.app.repos.ICategoryRepository;

@RestController
public class CategoryController {

	@Autowired
	ICategoryRepository categoryRepository;

	@PostMapping("/categories")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Category addCategory (@RequestBody Category category) {
		
		Category cat = categoryRepository.findByCategoryName(category.getCategoryName());
		
		if(cat == null) {
		
			categoryRepository.save(new Category());
			
		}
		
		else
			throw new CategoryAlreadyExistException("Category already exist");
		
		return category;
	}

	@PutMapping("/categories/{CategoryName}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@Transactional
	public Category editCategory(@RequestBody Category category) {

//		Category cat = categoryRepository.findByCategoryName(category.getCategoryName());
//		
//		if(cat == null) 
//			throw new CategoryNotFoundException("There is no category in the repository with the name " + category.getCategoryName());
//			
//		else
//			cat.setCategoryName(category.getCategoryName());

		return categoryRepository.save(category);
	}

	@GetMapping("/categories/list")
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<Category> viewAllCategories() {
		
		List<Category> list = categoryRepository.findAll();
		
		if(list.isEmpty())
			throw new CategoryNotFoundException("There is no category in the repository");
		
		return list;
	}

	@DeleteMapping("/categories/{categoryName}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public Category removeCategory(@RequestBody Category category) {

		Category cat  = categoryRepository.findByCategoryName(category.getCategoryName());
		
		if(cat==null)
			throw new CategoryNotFoundException("There is no category in the repository to delete with the name " + category.getCategoryName());
		else
			categoryRepository.delete(cat);
		
		return cat;
	}

}
