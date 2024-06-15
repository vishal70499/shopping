package com.amstech.orderServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


import com.amstech.util.DBUtil;
import com.amstech.productDAO.ProductDAO;
//import com.amstech.producrDTO.ProductDTO;
import com.amstech.productService.ProductService;
import com.amstech.orderDTO.*;
import com.amstech.orderService.OrderService;
import com.amstech.util.DBUtil;
@WebServlet("/ordernow")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBUtil dbUtil;
	private ProductDAO productDAO;
	private OrderService orderService;
  
	

	public OrderServlet() {
		super();
		this.dbUtil = new DBUtil();
		this.productDAO = new ProductDAO(dbUtil);
		this.orderService = new OrderService(productDAO);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String task = request.getParameter("task");
		if (task.equalsIgnoreCase("order")) {
			System.out.println("task= " + task);
			System.out.println(" abc...");
			order(request, response);
		}
		
	}
	public void order(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			OrderDTO orderDTO = new OrderDTO();
			orderDTO.setUserId(Integer.parseInt(request.getParameter("userid")));
			orderDTO.setProductId(Integer.parseInt(request.getParameter("productid")));
			
			
			int count = orderService.order(orderDTO);
			if (count > 0) {
				System.out.println("order created successfully......");
			
				response.sendRedirect("finalpage.jsp");

			} else {
				System.out.println("failed");
				response.sendRedirect("finalpage.jsp");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
