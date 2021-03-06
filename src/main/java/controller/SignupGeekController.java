package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Geek;
import model.Interest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import service.GeekService;
import service.InterestService;

@Controller
@RequestMapping(value="/signup")
@SessionAttributes("geek")
public class SignupGeekController {
	
	@Autowired
	private GeekService geekService;
	
	@Autowired
	private InterestService interestService;

	@RequestMapping(method=RequestMethod.GET)
	public String signup(Model model) {
        model.addAttribute("geek", new Geek());
        model.addAttribute("interests", interestService.list());
        return "signup";
    }

	@RequestMapping(method=RequestMethod.POST)
	public String create(@ModelAttribute("geek") Geek geek, BindingResult bindingResult, Model model, String[] interests) {
		/* Ajout d'un geek avec ses interets */
		ValidationUtils.rejectIfEmpty(bindingResult, "firstname", "firstname.empty");
		ValidationUtils.rejectIfEmpty(bindingResult, "lastname", "lastname.empty");
		ValidationUtils.rejectIfEmpty(bindingResult, "email", "email.empty");
		if (bindingResult.hasErrors()) {
			model.addAttribute("interests", interestService.list());
			return "signup";
		}
		geekService.create(geek);
		return "redirect:/";
	}
	
	/* Rend possible l'ajout d'un geek avec plusieurs int�rets */
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
	       binder.registerCustomEditor(List.class, "interests", new CustomCollectionEditor(List.class) {
	           protected Object convertElement(Object element) {
	               if (element != null) {
	                   Long id = new Long((String)element);
	                   Interest i = interestService.find(id);
	                   return i;
	               }
	               return null;
	           }
	       });
	 }

}
