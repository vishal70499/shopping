package com.amstech.productService;

import java.util.ArrayList;

import com.amstech.cartDTO.CartDTO;
import com.amstech.orderDTO.OrderDTO;
import com.amstech.productDAO.ProductDAO;
import com.amstech.productDTO.ProductDTO;
import com.amstech.userDAO.UserDAO;
import com.amstech.userDTO.UserDTO;

public class ProductService {
	
	ProductDAO productDAO;
	public ProductService(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	public int addProduct(ProductDTO productDTO) throws Exception {
		int count = productDAO.addProduct(productDTO);
		return count;
	}

	public int deleteById(ProductDTO productDTO) throws Throwable {
		int count= productDAO.deleteById(productDTO);
	return count;
	}
	public CartDTO addToCart(CartDTO cartDTO) throws Exception {
		return productDAO.getCartProducts(cartDTO);
	}
	public OrderDTO order(OrderDTO orderDTO) {
		return orderDTO;
		
		
	}
}
