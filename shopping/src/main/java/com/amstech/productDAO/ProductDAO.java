package com.amstech.productDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.amstech.cartDTO.CartDTO;
import com.amstech.orderDTO.OrderDTO;
import com.amstech.productDTO.ProductDTO;
import com.amstech.userDTO.UserDTO;
import com.amstech.util.DBUtil;
//import com.mysql.cj.protocol.Resultset;

public class ProductDAO {
	private final String ADD_PRODUCT= "insert into product(name,category,price,image)values(?,?,?,?)";
	private final String PRODUCT_DELETE_BY_ID = "delete from product where id=?";
	private final String SELECT_ALL_PRODUCT ="select * from product";
	private final String	FIND_PRODUCT_BY_ID= "select * from product where id=?";
	private final String ORDER_BY_ID= "insert into orders(product_Id,user_Id) values(?,?)";
	//private final String ORDER_FIND_ALL = "select * from orders";
	private DBUtil dbUtil;
	

	public ProductDAO(DBUtil dbUtil) {
	
		this.dbUtil = dbUtil;
	}
	public int addProduct(ProductDTO productDTO) throws SQLException, ClassNotFoundException {
		Connection connection = dbUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(ADD_PRODUCT);
		pstmt.setString(1, productDTO.getName());
		pstmt.setString(2, productDTO.getCategory());
		pstmt.setDouble(3, productDTO.getPrice());
		pstmt.setString(4, productDTO.getImage());
		

		int count = pstmt.executeUpdate();

		dbUtil.getClose(connection, pstmt);
		return count;

	}
	
	public List<ProductDTO> getAllProduct() throws ClassNotFoundException, SQLException{
		List<ProductDTO> products= new ArrayList<ProductDTO>();
		Connection con=dbUtil.getConnection();
		PreparedStatement pstmt=con.prepareStatement(SELECT_ALL_PRODUCT);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			ProductDTO row=new ProductDTO();
			row.setId(rs.getInt("id"));
			row.setName(rs.getString("name"));
			row.setCategory(rs.getString("category"));
			row.setPrice(rs.getDouble("price"));
			row.setImage(rs.getString("image"));
			
			products.add(row);
			
			
		}
		dbUtil.getClose(con, pstmt);
		return products;
		
	}
	
	
	public CartDTO getCartProducts(CartDTO cartDTO) throws SQLException{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		CartDTO row = null;
		try { 
			con=dbUtil.getConnection();
		   pstmt=con.prepareStatement(FIND_PRODUCT_BY_ID);
			pstmt.setInt(1, cartDTO.getId());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				
				row=new CartDTO();
					row.setId(rs.getInt("id"));
					row.setName(rs.getString("name"));
					row.setCategory(rs.getString("category"));
					row.setImage(rs.getString("image"));
					row.setPrice(rs.getDouble("price"));
					
			}
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			dbUtil.getClose(con, pstmt);
		}
		return row;
		
	}
	
	
	public int deleteById(ProductDTO productDTO) throws Exception {
		Connection connection = dbUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(PRODUCT_DELETE_BY_ID);

		pstmt.setInt(1, productDTO.getId());
		int count = pstmt.executeUpdate();
		
		dbUtil.getClose(connection, pstmt);
		return count;

		
	}
	public int order(OrderDTO ordertDTO) throws SQLException, ClassNotFoundException {
		Connection connection = dbUtil.getConnection();
		PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(ORDER_BY_ID);
		pstmt.setInt(1,  ordertDTO.getProductId());
		pstmt.setInt(2,  ordertDTO.getUserId());
		
		

		int count = pstmt.executeUpdate();

		dbUtil.getClose(connection, pstmt);
		return count;

	}
//	public List<UserDTO> AllOrder() throws Exception {
//		Connection connection = null;
//		PreparedStatement pstmt = null;
//		List<OrderDTO> orderDTOList = new ArrayList<>();
//
//		try {
//			connection = dbUtil.getConnection();
//			pstmt = connection.prepareStatement(ORDER_FIND_ALL);
//			ResultSet rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				OrderDTO orderDTO = new OrderDTO();
//				orderDTO.setId(rs.getInt("id"));
//				userDTO.setFirstName(rs.getString("first_name"));
//				userDTO.setLastName(rs.getString("last_name"));
//				userDTO.setEmail(rs.getString("email"));
//				userDTO.setMobileNumber(rs.getString("mobile_number"));
//				userDTO.setAddress(rs.getString("Address"));
//				userDTOList.add(userDTO);
//			}
//			return userDTOList;
//		} catch (Exception e) {
//			throw e;
//		} finally {
//			dbUtil.getClose(connection, pstmt);
//		}
//	}
}
