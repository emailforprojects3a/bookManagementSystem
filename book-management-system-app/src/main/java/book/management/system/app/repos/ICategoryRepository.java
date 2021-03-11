package book.management.system.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import book.management.system.app.entities.Category;


@Repository
public interface ICategoryRepository extends JpaRepository<Category,Integer>{

	public Category findByCategoryName(String name);
	
}
