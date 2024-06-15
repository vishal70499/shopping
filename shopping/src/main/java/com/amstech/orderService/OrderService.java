package com.amstech.orderService;

import com.amstech.orderDTO.OrderDTO;
import com.amstech.productDAO.ProductDAO;
import com.amstech.userDTO.UserDTO;

public class OrderService {
	ProductDAO productDAO;

	public OrderService(ProductDAO productDAO) {
		
		this.productDAO = productDAO;
	}
	public int order(OrderDTO orderDTO) throws Exception {
		int count = productDAO.order(orderDTO);
		return count;
	}
	
	
}
