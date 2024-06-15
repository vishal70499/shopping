package com.amstech.userServlet;

import com.amstech.userDAO.UserDAO;
import com.amstech.userDTO.UserDTO;
import com.amstech.userService.UserService;
import com.amstech.util.DBUtil;
//import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;

public class UserServletMainClass {
	private DBUtil dbUtil;
	private UserDAO userDAO;
	private UserService userService;

	public UserServletMainClass() {
		this.dbUtil = new DBUtil();
		this.userDAO = new UserDAO(dbUtil);
		this.userService = new UserService(userDAO);

	}

	public static void main(String[] args) throws Throwable {
		UserServletMainClass main = new UserServletMainClass();
		 main.save();
        //main.update();
		 // main.deleteById();
	     //main.findById();

	}

	private void save() {
		try {
			UserDTO userDTO = new UserDTO();
			userDTO.setName("vishal");
			userDTO.setMobileNumber("797777655");
			userDTO.setPassword("root");

			int count = userService.save(userDTO);
			if (count > 0) {
				System.out.println("user created successfully......");
			} else {				System.out.println("failed");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void update() {
		try {
			UserDTO userDTO = new UserDTO();
			userDTO.setName("raj");
			userDTO.setId(1);
			userDTO.setMobileNumber("9988776655");
			userDTO.setPassword("root");

			int count = userService.update(userDTO);
			if (count > 0) {
				System.out.println("user updated successfully......");
			} else {
				System.out.println("failed to update");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	private void findById() {
		try {
			UserDTO userDto = new UserDTO();
			userDto.setId(1);
			int count = userService.update(userDto);
			if (count > 0) {
				System.out.println("founded.....");
			} else {
				System.out.println("not founded....");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private void findBymobileNumber() {
		// TODO Auto-generated method stub

	}

	private void findByPassword() {
		// TODO Auto-generated method stub

	}

	private void findAll() {
		// TODO Auto-generated method stub

	}

	private void deleteById() {
		try {
			UserDTO userDTO = new UserDTO();
			userDTO.setId(4);

			int count = userService.deleteById(userDTO);

			if (count > 0) {
				System.out.println("deleted succesfully........");
			} else {
				System.out.println("failed to Delete");
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
