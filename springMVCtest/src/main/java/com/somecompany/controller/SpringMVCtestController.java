package com.somecompany.controller;

import com.somecompany.service.CatalogService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class SpringMVCtestController {
    private CatalogService catalogService;
    
    @Autowired
    public SpringMVCtestController(CatalogService catalogService) {
    	this.catalogService = catalogService;
    }

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public ModelAndView getCatalog() {
       	ModelAndView model = new ModelAndView("catalog");
        model.addObject("cdList", this.catalogService.getCatalog().getCDList());
        return model;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getIndex() {
        return "index";
    }

}
