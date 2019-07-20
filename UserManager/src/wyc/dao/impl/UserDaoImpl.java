package wyc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wyc.dao.UserDao;
import wyc.pojo.User;

public class UserDaoImpl implements UserDao {

	@Override
	public User selectUser(String uname, String pwd) {
		// 声明数据库对象
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 声明查询对象
		User u = null;
		try {
			// 装载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 建立连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermgr", "root", "211911");
			// 创建SQL查询语句
			String sql = "select * from t_user where uname=? and pwd=?";
			// PrepareStatement并给占位符赋值
			ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pwd);
			// 查询
			rs = ps.executeQuery();
			if (rs.next()) {
				u = new User();
				u.setUid(rs.getInt(1));
				u.setUname(uname);
				u.setPwd(pwd);
				u.setSex(rs.getString(4).equals("1") ? "男" : "女");
				u.setAge(rs.getInt(5));
				u.setBirth(rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		// 返回查到的结果
		return u;
	}

	@Override
	public User selectUserByName(String uname) {
		// 声明数据库对象
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 声明查询对象
		User u = null;
		try {
			// 装载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 建立连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermgr", "root", "211911");
			// 创建SQL查询语句
			String sql = "select * from t_user where uname=?";
			// PrepareStatement并给占位符赋值
			ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			// 查询
			rs = ps.executeQuery();
			if (rs.next()) {
				u = new User();
				u.setUid(rs.getInt(1));
				u.setUname(rs.getString(2));
				u.setPwd(rs.getString(3));
				u.setSex(rs.getString(4).equals("1") ? "男" : "女");
				u.setAge(rs.getInt(5));
				u.setBirth(rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		// 返回查到的结果
		return u;
	}

	@Override
	public List<User> selectUsers() {
		// 声明数据库对象
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 声明数据对象
		List<User> userList = new ArrayList<User>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermgr", "root", "211911");
			String sql = "select * from t_user";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setUid(rs.getInt(1));
				u.setUname(rs.getString(2));
				u.setPwd(rs.getString(3));
				u.setSex(rs.getString(4).equals("1") ? "男" : "女");
				u.setAge(rs.getInt(5));
				u.setBirth(rs.getString(6));
				userList.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return userList;
	}

	@Override
	public int insertUser(User u) {
		// 声明数据库对象
		Connection conn = null;
		PreparedStatement ps = null;
		// 声明数据对象
		int index = -1;
		try {
			// 注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 建立连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermgr", "root", "211911");
			// 创建SQL语句
			String sql = "insert into t_user values(default,?,?,?,?,?);";
			// Prepare Statement 并给占位符赋值
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUname());
			ps.setString(2, u.getPwd());
			ps.setString(3, u.getSex());
			ps.setInt(4, u.getAge());
			ps.setString(5, u.getBirth());
			// 执行SQL语句
			index = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return index;
	}

	@Override
	public int updatePwd(String uname, String newPwd) {
		// 声明数据库对象
		Connection conn = null;
		PreparedStatement ps = null;
		// 声明数据对象
		int index = -1;
		try {
			// 注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 建立连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermgr", "root", "211911");
			// 创建SQL语句
			String sql = "update t_user set pwd=? where uname=?;";
			// Prepare Statement 并给占位符赋值
			ps = conn.prepareStatement(sql);
			ps.setString(1, newPwd);
			ps.setString(2, uname);
			// 执行SQL语句
			index = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return index;
	}

}
