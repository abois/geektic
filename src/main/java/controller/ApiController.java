package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Interest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.GeekService;
import service.InterestService;

@Controller
@RequestMapping("/api")
public class ApiController {

	
	/*@ExceptionHandler(GeekRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody String whenInvalidRequest(Exception e) {
	    return e.getMessage();
	}*/
	/*@InitBinder
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
	 }*/
}
