package controller;

import model.Geek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.GeekService;

@Controller
@RequestMapping(value="/signin")
public class SigninGeekController {
	
	@Autowired
	private GeekService geekService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String signin(Model model) {
		model.addAttribute("geek", new Geek());
        return "signin";
    }

	@RequestMapping(method=RequestMethod.POST)
	public String signin(@ModelAttribute("geek") Geek geek, BindingResult bindingResult) {
		return "redirect:/";
	}
	
	

}
