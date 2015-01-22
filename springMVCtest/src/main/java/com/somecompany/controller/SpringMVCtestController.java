package com.somecompany.controller;

import com.somecompany.service.CatalogService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SpringMVCtestController {
    private CatalogService catalogService;
    
    @Autowired
    public SpringMVCtestController(CatalogService catalogService) {
    	this.catalogService = catalogService;
    }
}
