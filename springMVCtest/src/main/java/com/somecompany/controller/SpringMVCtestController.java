package com.somecompany.controller;

import com.somecompany.service.CatalogService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringMVCtestController {
    private CatalogService catalogService;
    
    @Autowired
    public SpringMVCtestController(CatalogService catalogService) {
    	this.catalogService = catalogService;
    }

    @RequestMapping(value = "/catalog")
    public ModelAndView getCatalog() {
        ModelAndView model = new ModelAndView("catalog");
        model.addObject("cdList", this.catalogService.getCatalog().getCDList());
        return model;
    }

    @RequestMapping("/index")
    public String getIndex() {
        return "index";
    }

}
