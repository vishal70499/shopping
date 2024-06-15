package com.amstech.userServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.amstech.userDAO.UserDAO;
import com.amstech.userDTO.UserDTO;
import com.amstech.userService.UserService;
import com.amstech.util.DBUtil;
//import com.mysql.cj.Session;

@WebServlet("/user")
public class USERSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DBUtil dbUtil;
	private UserDAO userDAO;
	private UserService userService;

	public USERSERVLET() {

		this.dbUtil = new DBUtil();
		this.userDAO = new UserDAO(dbUtil);
		this.userService = new UserService(userDAO);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String task = request.getParameter("task");
		if (task.equalsIgnoreCase("signup")) {
			System.out.println("task= " + task);
			save(request, response);
		} else if (task.equalsIgnoreCase("login")) {

			System.out.println("task= " + task);
			findByMobileNumber(request, response);

			// find by mobile..by..
		} else if (task.equalsIgnoreCase("logout")) {

			System.out.println("task= " + task);
			logOut(request, response);

			// find by mobile..by..
		} else {
			System.out.println("no task found");
		}

	}

	public void save(HttpServletRequest request, HttpServletResponse response) {
		try {
			UserDTO userDTO = new UserDTO();
			userDTO.setName(request.getParameter("name"));
			userDTO.setEmail(request.getParameter("email"));
			userDTO.setMobileNumber(request.getParameter("mobileNumber"));
			userDTO.setPassword(request.getParameter("password"));
			userDTO.setAddress(request.getParameter("address"));
			userDTO.setCity(request.getParameter("city"));
			userDTO.setState(request.getParameter("state"));
			userDTO.setCountry(request.getParameter("country"));
			int count = userService.save(userDTO);
			if (count > 0) {
				System.out.println("user created successfully......");
				response.sendRedirect("login.jsp?msg=valid");

			} else {
				System.out.println("failed");
				response.sendRedirect("signup.jsp?msg=invalid");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void findByMobileNumber(HttpServletRequest request, HttpServletResponse response) throws IOException {
		UserDTO userDTO = new UserDTO();
		userDTO.setMobileNumber(request.getParameter("mobileNumber"));
		userDTO.setPassword(request.getParameter("password"));
		HttpSession session = request.getSession();
		if ("9988776655".equals(userDTO.getMobileNumber()) && "admin".equals(userDTO.getPassword())) {
			userDTO.setName("---ADMIN---");
			userDTO.setMobileNumber("9988776655");
			
			session.setAttribute("admin", userDTO);
			
			response.sendRedirect("adminHome.jsp");

		} else {
			try {
				UserDTO admin = (UserDTO) session.getAttribute("admin");
				if(admin!=null) {
				
				request.getSession().removeAttribute("admin");
			
		
			}
				userDTO = userService.findBymobileNumberAndPassword(userDTO);
				if (userDTO.getId() != 0) {
					System.out.println("user found successfully.........");
					System.out.println("user id is= " + userDTO.getId());
					System.out.println("user name is= " + userDTO.getName());
					System.out.println("user Email is= " + userDTO.getEmail());
					System.out.println("user MobileNumber is= " + userDTO.getMobileNumber());
					System.out.println("user Address is= " + userDTO.getAddress());
					System.out.println("user City is= " + userDTO.getCity());
					System.out.println("user State is= " + userDTO.getState());
					System.out.println("user Country is= " + userDTO.getCountry());
					
					session.setAttribute("auth", userDTO);
					response.sendRedirect("home.jsp");
				} else {
					System.out.println("user not found .........");
					response.sendRedirect("login.jsp?msg=notexist");

				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}

	public void delete() throws Throwable {
		try {
			UserDTO userDTO = new UserDTO();

			userDTO.setId(2);

			int count = userService.deleteById(userDTO);

			if (count > 0)
				System.out.println("User deleted successfully");
			else
				System.out.println("Failed to delete user data..");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void logOut(HttpServletRequest request, HttpServletResponse response){
	try {	UserDTO auth = (UserDTO)request.getSession().getAttribute("auth");
	UserDTO admin = (UserDTO)request.getSession().getAttribute("admin");
		if(auth!=null) {
		
			request.getSession().removeAttribute("auth");
		
		response.sendRedirect("login.jsp");
		
		}else if(admin!=null) {
		
			request.getSession().removeAttribute("admin");
		
		response.sendRedirect("login.jsp");
		
		}{
			response.sendRedirect("home.jsp");
		}
	}catch (Exception e) {
		System.out.println(e.getMessage());
	}
}}
