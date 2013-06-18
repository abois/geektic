package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.Geek;
import model.Interest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import service.GeekService;
import service.InterestService;

@Controller
@SessionAttributes("geek")
@RequestMapping(value="/")
public class GeekController {
	
	@Autowired
	private GeekService geekService;
	
	@Autowired
	private InterestService interestService;

	@RequestMapping(method=RequestMethod.GET)
	public String index(ModelMap model, HttpSession session) {
		List<Interest> interests = interestService.list();
		if(!session.isNew()) 
			model.addAttribute("connected_geek", session.getAttribute("geek"));
		
		session.getAttribute("geek");
		model.addAttribute("interests", interests);
		model.addAttribute("geeks", geekService.list());
		return "index";
	}
	
	@RequestMapping(value="/geeks", method=RequestMethod.GET)
	public String list(ModelMap model) {
		List<Geek> geeks = geekService.list();
		model.addAttribute("geeks", geeks);
		return "list";
	}
	@RequestMapping(value="/geeks/{id}", method=RequestMethod.GET)
	public String detail(@PathVariable("id") Long geekId, ModelMap model) {
		Geek geek = geekService.find(geekId);
		model.addAttribute("geek", geek);
		return "detail";
	}
	
	@RequestMapping(value="/geeks/search", method=RequestMethod.GET)
	/* Return Geeks as JSON */
	public @ResponseBody List<Geek> searchGeeks(@RequestParam(value="interests", required=false) Long[] interests_ids, @RequestParam(value="gender", required=false) Boolean[] genders) {
		List<Interest> interests = interestService.listByIds(interests_ids);
		List<Geek> geeks = geekService.search(interests, genders != null ? Arrays.asList(genders) : new ArrayList<Boolean>());
		return geeks;
	}
	
}
