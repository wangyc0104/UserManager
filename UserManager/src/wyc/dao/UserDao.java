package wyc.dao;

import java.util.List;

import wyc.pojo.User;

/**
 * 用户DAO
 * @author Yicheng Wang
 *
 */
public interface UserDao {
	
	/**
	 * 查找单个用户（根据用户名和密码）
	 * @param uname 用户名
	 * @param pwd 密码
	 * @return 如果找到了则返回用户对象，没找到则返回null
	 */
	User selectUser(String uname, String pwd);

	/**
	 * 查找单个用户（根据用户名）
	 * @param uname 用户名
	 * @return 如果找到了则返回用户对象，没找到则返回null
	 */
	User selectUserByName(String uname);
	
	/**
	 * 获取用户列表
	 * @return 包含所有用户的List
	 */
	List<User> selectUsers();
	
	/**
	 * 添加用户
	 * @param u 用户对象
	 * @return 影响的行数（添加成功则返回1，未添加成功则返回-1）
	 */
	int insertUser(User u);

	/**
	 * 修改密码
	 * @param uname 用户名
	 * @param newPwd 新密码
	 * @return
	 */
	int updatePwd(String uname, String newPwd);
}
