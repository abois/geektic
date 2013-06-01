package controller;

import model.Geek;
import model.Interest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.GeekService;
import service.InterestService;

@Controller
@RequestMapping(value="/signup")
public class SignupGeekController {
	
	@Autowired
	private GeekService service;
	
	@Autowired
	private InterestService interestService;

	@RequestMapping(method=RequestMethod.GET)
	public String signup(Model model) {
        model.addAttribute("geek", new Geek());
        model.addAttribute("interests", interestService.list());
        return "signup";
    }

	@RequestMapping(method=RequestMethod.POST)
	public String create(@ModelAttribute("geek") Geek geek, BindingResult bindingResult) {
		ValidationUtils.rejectIfEmpty(bindingResult, "prenom", "prenom.empty");
		ValidationUtils.rejectIfEmpty(bindingResult, "nom", "nom.empty");
		ValidationUtils.rejectIfEmpty(bindingResult, "email", "email.empty");
		if (bindingResult.hasErrors()) {
			return "signup";
		}
		/*for(String s : interests){
	        Interest i = new Interest();
	        i.setNom(s);
	        geek.getInterests().add(i);
		}*/
		service.create(geek);
		return "redirect:/";
	}
	

}
