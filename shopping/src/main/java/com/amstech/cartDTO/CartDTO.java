package com.amstech.cartDTO;

import com.amstech.productDTO.ProductDTO;

public class CartDTO extends ProductDTO {
	private int quantity;
public CartDTO() {}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}


}
