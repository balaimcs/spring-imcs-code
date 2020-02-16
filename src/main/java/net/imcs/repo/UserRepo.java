package net.imcs.repo;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.imcs.entity.User;

@Repository("userRepo")
public interface UserRepo extends CrudRepository<User, Long> {
	
	public User findByEmail(String email);
	public boolean existsByEmail(String email);

}
