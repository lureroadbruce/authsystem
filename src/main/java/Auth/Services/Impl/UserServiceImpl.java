package Auth.Services.Impl;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Auth.Models.User;
import Auth.Repositories.UserRepository;
import Auth.Services.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	public long save(User user) {

		user.setUpdatetime(new Date());
		if (user.getId() == 0) {
			user.setCreatetime(new Date());
		}
		user = userRepository.save(user);
		return user.getId();
	}

	public Boolean delete(long ID) {

		return true;
	}
	public Iterable<User> findAll()
	{
		return userRepository.findAll();
	}
}
