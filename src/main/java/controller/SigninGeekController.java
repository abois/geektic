package controller;

import javax.servlet.http.HttpSession;

import model.Geek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import service.GeekService;

@Controller
@SessionAttributes("geek")
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
	public String signin(@ModelAttribute("geek") Geek tempGeek, BindingResult bindingResult, HttpSession session, SessionStatus status) {
		Geek geek = null;
		if(geekService.checkCredentials(tempGeek.getEmail(), tempGeek.getPassword())) {
			geek = geekService.findByEmail(tempGeek.getEmail());
		}
		if(geek == null) {
			return "redirect:/signin";
		}
		session.setAttribute("geek", geek);
		status.setComplete();
		/*Geek  _geek = (Geek)session.getAttribute("geek");
		System.out.println("SIGNIN " +_geek.getFirstname());*/
		return "redirect:/";
	}
	
	

}
