package controller;

import java.util.List;

import model.Geek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.GeekService;

@Controller
@RequestMapping("/geeks")
public class GeekController {
	
	@Autowired
	private GeekService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public String list(ModelMap model) {
		List<Geek> geeks = service.list();
		model.addAttribute("geeks", geeks);
		return "list";
	}

}
