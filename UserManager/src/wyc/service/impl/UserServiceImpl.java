package wyc.service.impl;

import java.util.List;

import wyc.dao.UserDao;
import wyc.dao.impl.UserDaoImpl;
import wyc.pojo.User;
import wyc.service.UserService;

public class UserServiceImpl implements UserService {

	UserDao ud = new UserDaoImpl();
	
	@Override
	public User checkUserLogin(String uname, String pwd) {
		return ud.selectUser(uname, pwd);
	}

	@Override
	public User checkUserByName(String uname) {
		return ud.selectUserByName(uname);
	}

	@Override
	public List<User> getAllUsers() {
		return ud.selectUsers();
	}

	@Override
	public int addUser(User u) {
		return ud.insertUser(u);
	}

	@Override
	public int changePwd(String uname, String newPwd) {
		return ud.updatePwd(uname, newPwd);
	}

}
