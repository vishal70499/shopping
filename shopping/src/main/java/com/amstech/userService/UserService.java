package com.amstech.userService;

import java.sql.SQLException;

import com.amstech.userDAO.UserDAO;
import com.amstech.userDTO.UserDTO;

public class UserService {

	private UserDAO userDAO;

	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public int save(UserDTO userDTO) throws Exception {
		int count = userDAO.save(userDTO);
		return count;
	}

	public int update(UserDTO userDTO) throws ClassNotFoundException, SQLException {
		return userDAO.update(userDTO);
	}

//	public UserDTO findById(UserDTO userdto) throws ClassNotFoundException, SQLException {
//		return userDAO.findById(userdto);

//	}

	public  UserDTO findBymobileNumberAndPassword(UserDTO userDTO) throws ClassNotFoundException, SQLException {
		return userDAO.findBymobileNumberAndPassword(userDTO);

	}

	private void findByPassword() {
		// TODO Auto-generated method stub

	}

	private void findAll() {
		// TODO Auto-generated method stub

	}

	public int deleteById(UserDTO userDTO) throws Throwable {
		int count= userDAO.deleteById(userDTO);
	return count;
	}
}
