package com.amstech.productServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.amstech.productDAO.ProductDAO;
import com.amstech.productDTO.ProductDTO;
import com.amstech.productService.ProductService;
import com.amstech.userDAO.UserDAO;
import com.amstech.userDTO.UserDTO;
import com.amstech.userService.UserService;
import com.amstech.util.DBUtil;

@WebServlet("/product")

public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DBUtil dbUtil;
	ProductDAO productDAO;
	ProductService productService;

	public ProductServlet() {
		this.dbUtil = new DBUtil();
		this.productDAO = new ProductDAO(dbUtil);
		this.productService = new ProductService(productDAO);
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String task = request.getParameter("task");
		try {	if (task.equalsIgnoreCase("addProduct")) {
			System.out.println("task= " + task);
			addProduct(request, response);
		}else if (task.equalsIgnoreCase("delete")) {
			System.out.println("task= " + task);
			
				delete(request, response);
			
		} 
		else {
			System.out.println("no task found");
		}} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	public void addProduct(HttpServletRequest request, HttpServletResponse response) {
		try {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setName(request.getParameter("name"));
			productDTO.setCategory(request.getParameter("category"));
			productDTO.setPrice(Double.parseDouble(request.getParameter("price")));
			productDTO.setImage(request.getParameter("image"));
			System.out.println("successfully saved in dto..........");
			int count = productService.addProduct(productDTO);
			if (count > 0) {
				System.out.println("product added successfully......");
				response.sendRedirect("adminHome.jsp?msg=valid");

			} else {
				System.out.println("failed");
				response.sendRedirect("adminHome.jsp?msg=invalid");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	public void delete(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		try {
			ProductDTO productDTO = new ProductDTO();

			productDTO.setId(Integer.parseInt( request.getParameter("id")));

			int count = productService.deleteById(productDTO);

			if (count > 0) {
				System.out.println("product deleted successfully");
			response.sendRedirect("adminHome.jsp?msg=valid");}
			else {
				System.out.println("Failed to delete product data..");
			response.sendRedirect("adminHome.jsp?msg=invalid");
		} 
		}
	catch (Exception e) {
		e.printStackTrace();
	}
}}
