package book.management.system.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import book.management.system.app.entities.User;

@Repository
public interface ILoginRepository extends JpaRepository<User,Integer>{

	public User findByEmail(String email);
}
