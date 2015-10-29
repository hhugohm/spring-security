package org.neos.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CloseSession {
	
	@RequestMapping("/close")
	public String welcome(HttpServletRequest request, HttpServletResponse response) {
	
		
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
		 System.out.println("NOMBRE DE USUARIOOO: " + auth.getName() + "-" +auth.getAuthorities().toString());
		 
		 SecurityContextLogoutHandler ctxLogOut = new SecurityContextLogoutHandler();
		 ctxLogOut.logout(request, response,auth); 
		return "close";

	
	}


}
