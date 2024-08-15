package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.RoleBean;

@Repository
public class RoleDao {

	@Autowired
	JdbcTemplate stmt;
	
	ArrayList<RoleBean> roles = new ArrayList<>();

	public void addRole(RoleBean roleBean) {

		stmt.update("insert into role (roleName) values (?)",roleBean.getRoleName());
	}

	public List<RoleBean> listRole() {
		return stmt.query("select * from role", new RowMapper<RoleBean>() {
			
			@Override
			public RoleBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				RoleBean roleBean = new RoleBean();
				roleBean.setRoleName(((ResultSet) rs).getString("name"));
				roleBean.setRoleId(((ResultSet) rs).getInt("id"));
				return roleBean;
			}
		});		
	}
	
	public void deleteRole(int id) {
		stmt.update("delete from role where roleId = ",id);
	}
	
	public void updateRole(RoleBean role) {
		int i = 0;
		for (i = 0; i < roles.size(); i++) {
			if (roles.get(i).getRoleId() == role.getRoleId()) {
				break;
			}
		}
		roles.remove(i);
		roles.add(role);

	}

}
