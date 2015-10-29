package org.neos.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.neos.mv.domain.User;
import org.neos.mv.domain.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private DataSource datasource;
	
	
	@Override
	public User findUserByUserName(String username) {
		  String query = "select username,password,enabled from users where username=?";
	      JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
	      User user = jdbcTemplate.queryForObject(query, new Object[]{username}, new RowMapper<User>(){
	    	  public User mapRow(ResultSet rs, int rowNum)
	    			  throws SQLException {
	    		  User user = new User();
	    		  user.setUsername(rs.getString("username"));
	    		  user.setPassword(rs.getString("password"));
	    		  user.setEnabled(rs.getBoolean("enabled"));
	    		  return user;
	    	  }});
		return user;
	}

	@Override
	public List<UserRole> findRoleByUserName(String username) {
		String query = "select user_role_id,username,role from user_roles where username=?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        List<UserRole> lstRole = new ArrayList<UserRole>();
        
        List<Map<String,Object>> roleRows = jdbcTemplate.queryForList(query,username);
        
        for(Map<String,Object> roleRow : roleRows){
        	UserRole role = new UserRole();
        	role.setUserRoleId(Integer.parseInt(String.valueOf(roleRow.get("user_role_id"))));
        	role.setUser(String.valueOf(roleRow.get("username")));
        	role.setRole(String.valueOf(roleRow.get("role")));
        	lstRole.add(role);
        }
        return lstRole;
	}

}
