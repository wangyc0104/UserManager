package wyc.service;

import java.util.List;

import wyc.pojo.User;

public interface UserService {
	
	/**
	 * 检查登录的用户名和密码是否正确
	 * @param uname 用户名
	 * @param pwd 密码
	 * @return 如果正确，则返回该用户信息，如果错误，则返回 null
	 */
	User checkUserLogin(String uname, String pwd);
	
	/**
	 * 检查是否存在某用户名
	 * @param uname 用户名
	 * @return 如果存在，则返回该用户信息，如果错误，则返回 null
	 */
	User checkUserByName(String uname);
	
	/**
	 * 获取所有的用户信息
	 * @return 装有所有用户对象的List
	 */
	List<User> getAllUsers();
	
	/**
	 * 进行用户注册
	 * @param u 用户对象
	 * @return
	 */
	int addUser(User u);

	/**
	 * 进行用户密码修改
	 * @param uname 要修改密码的用户名
	 * @param newPwd 用户的新密码
	 * @return 影响的行数
	 */
	int changePwd(String uname, String newPwd);
}
