package com.amstech.userDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.amstech.userDTO.UserDTO;
import com.amstech.util.DBUtil;
//import com.mysql.cj.protocol.Resultset;

public class UserDAO {
	private final String USER_INSERT_DATA = "insert into user(name,email,mobileNumber,password,address,city,state,country)values(?,?,?,?,?,?,?,?)";

	private final String USER_UPDATE_DATA = "update user set name=?, mobileNumber=?,password=? where id=?";

	private final String USER_FIND_BY_ID = "select * from user where id=?";

	private final String USER_FIND_BY_MOBILENUMBER_AND_PASSWORD = "select * from user where mobileNumber=? and password=?";

	private final String USER_FIND_BY_PASSWORD = "select * from user where mobileNumber=? and password=?";

	private final String USER_FIND_ALL = "select * from user";

	private final String USER_DELETE_BY_ID = "delete from user where id=?";

	private DBUtil dbUtil;

	public UserDAO(DBUtil dbUtil) {
		this.dbUtil = dbUtil;
	}

	public int save(UserDTO userDTO) throws SQLException, ClassNotFoundException {
		Connection connection = dbUtil.getConnection();
		PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(USER_INSERT_DATA);
		pstmt.setString(1, userDTO.getName());
		pstmt.setString(2, userDTO.getEmail());
		pstmt.setString(3, userDTO.getMobileNumber());
		pstmt.setString(4, userDTO.getPassword());
		pstmt.setString(5, userDTO.getAddress());
		pstmt.setString(6, userDTO.getCity());
		pstmt.setString(7, userDTO.getState());
		pstmt.setString(8, userDTO.getCountry());

		int count = pstmt.executeUpdate();

		dbUtil.getClose(connection, pstmt);
		return count;

	}

	public int update(UserDTO userDTO) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement pstmt = null;
		connection = dbUtil.getConnection();
		pstmt = connection.prepareStatement(USER_UPDATE_DATA);

		pstmt.setString(1, userDTO.getName());
		pstmt.setString(2, userDTO.getEmail());
		pstmt.setString(3, userDTO.getMobileNumber());
		pstmt.setString(4, userDTO.getPassword());
		pstmt.setString(5, userDTO.getAddress());
		pstmt.setString(6, userDTO.getCity());
		pstmt.setString(7, userDTO.getState());
		pstmt.setString(8, userDTO.getCountry());

		int count = pstmt.executeUpdate();

		dbUtil.getClose(connection, pstmt);
		return count;

	}

//	public int findById(UserDTO userdto) throws ClassNotFoundException, SQLException {
//		Connection connection = dbUtil.getConnection();
//		
//		PreparedStatement pstmt = connection.prepareStatement(USER_FIND_BY_MOBILENUMBER);
//		
//		pstmt.setInt(1, userdto.getId());
//		
//		int count = pstmt.executeUpdate();
//		
//		dbUtil.getClose(connection, pstmt);
//		return count;
//
//	}

	public UserDTO findBymobileNumberAndPassword(UserDTO userDTO) throws SQLException, ClassNotFoundException {
		Connection connection = null;
		PreparedStatement pstmt = null;

		connection = dbUtil.getConnection();
		pstmt = connection.prepareStatement(USER_FIND_BY_MOBILENUMBER_AND_PASSWORD);
		pstmt.setString(1, userDTO.getMobileNumber());
		pstmt.setString(2, userDTO.getPassword());
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			userDTO= new UserDTO();
			userDTO.setName(rs.getString("name"));
			userDTO.setEmail(rs.getString("email"));
			userDTO.setMobileNumber(rs.getString("mobileNumber"));
			userDTO.setPassword(rs.getString("password"));
			userDTO.setAddress(rs.getString("address"));
			userDTO.setCity(rs.getString("city"));
			userDTO.setState(rs.getString("state"));
			userDTO.setCountry(rs.getString("country"));
			userDTO.setId(rs.getInt("id"));
		}

		dbUtil.getClose(connection, pstmt);
		return userDTO;
	}

	private void findByPassword() {
		// TODO Auto-generated method stub

	}

	private void findAll() {
		// TODO Auto-generated method stub

	}

	public int deleteById(UserDTO userDTO) throws Exception {
		Connection connection = dbUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(USER_DELETE_BY_ID);

		pstmt.setInt(1, userDTO.getId());
		int count = pstmt.executeUpdate();
		
		dbUtil.getClose(connection, pstmt);
		return count;

		
	}
}
