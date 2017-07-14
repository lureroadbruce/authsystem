package Auth.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import Auth.Models.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRolesRepository extends CrudRepository<User, Long> {
	@Query("select a.role from UserRole a, User b where b.name=?1 and a.user_id=b.id")
	public List<String> findRoleByUserName(String username);
}