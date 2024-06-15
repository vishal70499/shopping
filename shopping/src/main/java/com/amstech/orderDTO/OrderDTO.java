package com.amstech.orderDTO;


import com.amstech.productDTO.ProductDTO;
import com.amstech.util.DBUtil;

import jakarta.servlet.annotation.WebServlet;

public class OrderDTO extends ProductDTO{
	private int productId;
    private int userId;
   
    public OrderDTO() {
    	
    }

	public OrderDTO(int productId, int userId, String date) {
		super();
		this.productId = productId;
		this.userId = userId;
		
	}
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	

	
    
	
	
}
