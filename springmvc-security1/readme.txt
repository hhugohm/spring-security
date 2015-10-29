
Parte 1

Breve explicacion de Spring MVC

El front controller usado es la clase org.springframework.web.servlet.DispatcherServlet

con el nombre con el que es configurado el servlet en el web xml 
debera existir un XML donde se configura Spring MVC

para este ejemplo el xml es: DispatcherServlet-servlet.xml


un Controller simple es

@Controller
public class HomeController

@RequestMapping("/")
	public String welcome(Model model) 
	
quiere decir que cuando en la URL la peticion

http://localhost:8080/springmvc1/  -> HomeController





