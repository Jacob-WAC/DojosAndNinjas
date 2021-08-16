package jj.DojosAndNinjas.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jj.DojosAndNinjas.models.Dojo;
import jj.DojosAndNinjas.models.Ninja;
import jj.DojosAndNinjas.services.AppService;

@Controller
public class MainController {
	
	private final AppService appService;
	
	public MainController(AppService appService) {
		this.appService = appService;
		
		
	}
	

	@GetMapping("/")
	public String home(@ModelAttribute("dojo") Dojo dojo ) {
		
		return "newDojo.jsp";
	}
	
	@PostMapping("/createDojo")
	public String createDojo(@ModelAttribute("dojo") Dojo dojo,BindingResult result) {
		if(result.hasErrors()) {
			
			return "newDojo.jsp";
		} else {
			this.appService.createDojo(dojo);
			return "redirect:/formNinja";
		}
		
	}
	
	@GetMapping("/formNinja")
	public String ninjaForm(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> allDojos = this.appService.findAllDojos();
		model.addAttribute("dojos", allDojos);
		return "newNinja.jsp";
	}
	

	@PostMapping("/createNinja")
	public String createNinja(@ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
			if(result.hasErrors()) {
				List<Dojo> allDojos = this.appService.findAllDojos();
				model.addAttribute("dojos", allDojos);
			return "newNinja.jsp";
			} else {
				this.appService.createNinja(ninja);
				return "redirect:/show/" + ninja.getDojo().getId();
			}
		
	}
	
	
	@GetMapping("/show/{id}")
	public String showDojo(@PathVariable("id")Long id, Model model) {
		
		Dojo dojo = this.appService.getDojoById(id);
		model.addAttribute("dojo",dojo);
		
		return "showDojo.jsp";
	}
	
	
	
	
	
}
