package test1.conrtoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test1.model.UserModel;
import test1.service.UserService;

@Controller
public class UserConrtoller {
	private UserService tserService;
	
	@Autowired
	public UserConrtoller(UserService tserService) {
		this.tserService = tserService;
	}
	@RequestMapping(method=RequestMethod.GET,value="/user")
	public String register(){
		
		return "user-register";
	}
	@RequestMapping(method=RequestMethod.POST,value="/user")
	public String add(@ModelAttribute UserModel userModel){
		tserService.add(userModel);
		return "redirect:/test";
	}
}
