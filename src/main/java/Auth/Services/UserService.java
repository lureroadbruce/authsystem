package Auth.Services;

import Auth.Models.User;
public interface UserService {

	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public long save(User user);
	
	/**
	 * 删除
	 * @param ID
	 * @return
	 */
	public Boolean delete(long ID);
	


	public Iterable<User> findAll();
	
	
}
