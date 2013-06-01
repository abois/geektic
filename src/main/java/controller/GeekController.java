package controller;

import java.util.List;

import model.Geek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.GeekService;

@Controller
public class GeekController {
	
	@Autowired
	private GeekService service;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(ModelMap model) {
		/*Interest i = new Interest(2l, "python");
		List<Interest> interests = new ArrayList<Interest>();
		interests.add(i);
		List<Geek> geeks = service.findByInterests(interests);*/
		
		model.addAttribute("geeks", service.list());
		return "index";
	}
	
	@RequestMapping(value="/geeks", method=RequestMethod.GET)
	public String list(ModelMap model) {
		List<Geek> geeks = service.list();
		model.addAttribute("geeks", geeks);
		return "list";
	}
	
	@RequestMapping(value="/geek/{id}", method=RequestMethod.GET)
	public String detail(@PathVariable("id") Long geekId, ModelMap model) {
		Geek geek = service.find(geekId);
		model.addAttribute("geek", geek);
		return "detail";
	}
	
}
