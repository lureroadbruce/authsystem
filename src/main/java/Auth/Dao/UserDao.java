package Auth.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import Auth.Models.User;
@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 保存
	 * 
	 * @param user
	 *            ID=0 新增
	 * @return
	 */
	public long Save(User user) {
		long ID = 0;
		try {
			if (user.getId() == 0) {
				// 新增
				//user.setId(IdWorkerManage.getId());
				String strSql = "insert into user (name,email,password) values (?,?,?)";

				Object obj[] = { user.getName(),  user.getEmail(),user.getPassword()};
				int ret = jdbcTemplate.update(strSql, obj);
				if (ret > 0) {
					ID = user.getId();
				}
			} else {
				// 修改
				String strSql = "update user set name=?,email=?,password=? where id=?";
				Object obj[] = { user.getName(), user.getEmail(),user.getPassword(), user.getId() };
				int ret = jdbcTemplate.update(strSql, obj);
				if (ret > 0) {
					ID = user.getId();
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return ID;
	}

	/**
	 * 删除
	 * 
	 * @param ID
	 * @return
	 */
	public Boolean Delete(long ID) {
		String strSql = "delete from user where id=?";
		Object obj[] = { ID };
		int ret = jdbcTemplate.update(strSql, obj);
		return ret > 0;
	}

}
