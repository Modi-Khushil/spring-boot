package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.RoleBean;
import com.dao.RoleDao;

@RestController
public class RoleController {

	@Autowired
	RoleDao roleDao;

	@PostMapping("/role")
	public String addRole(RoleBean roleBean) {
		roleDao.addRole(roleBean);
		return "success";
	}
	
	@GetMapping("/roles")
	public ArrayList<RoleBean> listRole() {
		return (ArrayList<RoleBean>) roleDao.listRole();
	}

	@DeleteMapping("/role/{id}")
	public List<RoleBean> deleteRole(@PathVariable("id") int id) {
		
		roleDao.deleteRole(id);
		return roleDao.listRole();//return all products
	}
	
	@PutMapping("/user")
	public ArrayList<RoleBean> updateProduct(RoleBean role){
		roleDao.updateRole(role);
		return (ArrayList<RoleBean>) roleDao.listRole();
	}

}
