package org.fcbogle.spring.controller;

import java.util.List;

import org.fcbogle.spring.domain.ResearchItem;
import org.fcbogle.spring.manager.ResearchManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ResearchManager researchManager;
	
	@GetMapping("/")
	public String home() {
		logger.info("Returning home page");
		return "homepage";
	}
	
	@GetMapping("/research")
	public String showAllItems(Model model) {
		logger.info("HomeController showAllItems() operation invoked");
		List<ResearchItem> allItems = this.researchManager.getAllResearchItems();
		model.addAttribute("allItems", allItems);
		return "all-items";
	}
	
	@GetMapping("/research/{id:.*}/show")
	public String showIndividualItem(@PathVariable("id") String id, Model model) {		
		ResearchItem single = this.researchManager.getSingleItem(id);
		model.addAttribute("single", single);		
		logger.info("HomeController showIndividualItem() operation invoked: " + " item id: " + single.getId());		
		return "single-item";		
	}

}
