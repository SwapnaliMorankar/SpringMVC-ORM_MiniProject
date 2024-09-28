package spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.Model.User;
import spring.Service.UserService;

@Controller
public class ContactController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String Home() {
		return "index";
	}
	
	@RequestMapping("/contact")
	public String Contact() {
		return "Contact";
	}
	
	@RequestMapping(path="/processform", method=RequestMethod.POST)
	public String processform(@ModelAttribute User user, Model model) {	
		
		if(user.getEmail().isBlank()) {
			return "redirect:/contact";
		}
		
		this.userService.createUser(user);
		return "Success";
	}

}
