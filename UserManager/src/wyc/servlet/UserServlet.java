package wyc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wyc.pojo.User;
import wyc.service.UserService;
import wyc.service.impl.UserServiceImpl;

/**
 * 用户Servlet
 * @author Yicheng Wang
 */
@SuppressWarnings("serial")
public class UserServlet extends HttpServlet {

	UserService us = new UserServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String oper = req.getParameter("oper");
		if ("login".equals(oper)) {
			// 实现登录功能
			checkUserLogin(req, resp);
		} else if ("reg".equals(oper)) {
			// 实现注册功能
			userReg(req, resp);
		} else if ("pwd".equals(oper)) {
			// 实现注册功能
			changePwd(req, resp);
		} else if ("show".equals(oper)) {
			// 实现注册功能
			userShow(req, resp);
		} else {
			System.out.println("未找到匹配的操作符");
		}
	}

	/**
	 * 用户登录功能
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/* 获取请求数据 */
		// 用户名、密码
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		/* 处理请求 */
		// 根据用户名和密码去库里查找是否有用户
		User u = us.checkUserLogin(uname, pwd);
		/* 响应页面 */
		if (u != null) { // 如果有，则跳转到main页面
			HttpSession hs = req.getSession();
			hs.setAttribute("user", u);
			resp.sendRedirect("/mg/main/main.jsp");
		} else { // 如果没有，则显示用户登录失败
			System.out.println("用户名或密码错误");
			resp.sendRedirect("/mg/login.jsp");
		}
	}

	/**
	 * 用户注册功能
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void userReg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 获取请求数据
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		String sex = req.getParameter("sex");
		String ageStr = req.getParameter("age");
		int age = Integer.valueOf(ageStr == "" ? "0" : ageStr);
		String[] birthStr = (req.getParameter("birth")).split("/");
		String birth = birthStr[2] + "-" + birthStr[0] + "-" + birthStr[1];
		User u = us.checkUserByName(uname);
		if (u == null) {
			System.out.println("可以注册");
			u = new User(uname, pwd, sex, age, birth);
			int index = us.addUser(u);
			System.out.println("添加用户结果index：" + index);
			HttpSession hs = req.getSession();
			hs.setAttribute("flag", 1);
			resp.sendRedirect("/mg/login.jsp");
		} else {
			System.out.println("用户重复，不可以注册：" + u.getUname());
		}
	}

	/**
	 * 修改用户密码
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void changePwd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String uname = ((User) req.getSession().getAttribute("user")).getUname();
		String oldPwd = req.getParameter("oldPwd");
		if (us.checkUserLogin(uname, oldPwd) != null) {
			String newPwd = req.getParameter("newPwd");
			int index = us.changePwd(uname, newPwd);
			System.out.println("修改密码影响的行数：" + index);
			HttpSession hs = req.getSession();
			hs.setAttribute("flag", 2);
			resp.sendRedirect("/mg/login.jsp");
		} else {
			System.out.println("原始密码错误");
			resp.sendRedirect("/mg/user/changePwd.jsp");
		}
		// resp.sendRedirect("/mg/login.jsp");
	}

	/**
	 * 展示所有用户的信息
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void userShow(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<User> userList = us.getAllUsers();
		HttpSession hs = req.getSession();
		hs.setAttribute("userList", userList);
		resp.sendRedirect("/mg/user/allUserInfo.jsp");
	}

}
