package org.neos.mvc;

import org.neos.mv.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class EmployeeController {

	
	

	@RequestMapping("/get-by-id")
	@ResponseBody
	public User geById(int id) {
		User user= new User();
		try {
			user.setUsername("hugo");
			user.setPassword("1234");
			user.setEnabled(true);
		
		} catch (Exception ex) {
			return null;
		}
		return user;
	}


}
