package org.neos.mvc;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/welcome")
	public String welcome(Model model) {
		model.addAttribute("greeting", "Welcome to Web Store!");
		model.addAttribute("tagline", "The one and only amazing web store");
		
		return "welcome";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		
		

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalido usuario / password!");
			//model.addObject("pass", pass);
			
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");
		System.out.println("EN EL CONTROLLER LOG IN");

		return model;
		
	}
	
	// for 403 access denied page
		@RequestMapping(value = "/403", method = RequestMethod.GET)
		public ModelAndView accesssDenied(Principal user) {

			ModelAndView model = new ModelAndView();

			if (user != null) {
				model.addObject("msg", "Hi " + user.getName() 
				+ ", you do not have permission to access this page!");
			} else {
				model.addObject("msg", 
				"You do not have permission to access this page!");
			}

			model.setViewName("403");
			return model;

		}
}
