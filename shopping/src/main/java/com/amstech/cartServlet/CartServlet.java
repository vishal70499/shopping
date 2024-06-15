package com.amstech.cartServlet;
import java.io.IOException;

import com.amstech.cartDTO.CartDTO;
import com.amstech.productDAO.ProductDAO;
import com.amstech.productService.ProductService;
import com.amstech.util.DBUtil;
//import com.mysql.cj.Session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DBUtil dbUtil;
	ProductDAO productDAO;
	ProductService productService;

    public CartServlet() {
    	this.dbUtil = new DBUtil();
		this.productDAO = new ProductDAO(dbUtil);
		this.productService = new ProductService(productDAO);
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		String task = request.getParameter("task");
		try {	if (task.equalsIgnoreCase("addToCart")) {
			System.out.println("task= " + task);
			addToCart(request, response);
		}else if (task.equalsIgnoreCase("removecart")) {
			System.out.println("task= " + task);
			removeCart(request, response);
		}else {
			System.out.println("no task found");
		}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
	}
	public void addToCart(HttpServletRequest request, HttpServletResponse response) {
		try {
			CartDTO cartDTO = new CartDTO();
			int id=Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
			cartDTO.setId(id);
			cartDTO.setQuantity(1);
			cartDTO=productService.addToCart(cartDTO);
			if (cartDTO.getId()>0) {
			HttpSession session = request.getSession();
			session.setAttribute("item", cartDTO);
			response.sendRedirect("cart.jsp");
		} else {
			System.out.println("product not found .........");
			response.sendRedirect("home.jsp");

		}

	} catch (Exception e) {

		e.printStackTrace();
	}
}
	public void removeCart(HttpServletRequest request, HttpServletResponse response){
		try {	CartDTO item = (CartDTO)request.getSession().getAttribute("item");
			if(item!=null) {
			
				request.getSession().removeAttribute("item");
			
			response.sendRedirect("cart.jsp");
			
			}else {
				response.sendRedirect("cart.jsp");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	}
