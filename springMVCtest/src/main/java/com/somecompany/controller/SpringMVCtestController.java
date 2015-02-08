package com.somecompany.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.somecompany.datastore.CD;
import com.somecompany.datastore.Catalog;
import com.somecompany.service.CatalogService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class SpringMVCtestController {
    public static final String FILE_PATH = System.getProperty("user.dir") 
    		+ System.getProperty("file.separator") + "Catalog.xml";
	public static final Logger LOG = Logger.getLogger(SpringMVCtestController.class);
	private CatalogService catalogService;
    
    @Autowired
    public SpringMVCtestController(CatalogService catalogService) {
    	this.catalogService = catalogService;
    }

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public ModelAndView getCatalog() {
       	ModelAndView model = new ModelAndView("catalog");
       	List<CD> cdList;
       	try {
        	cdList = this.catalogService.getCatalog().getCDList(); 
        } catch (Exception ex) {
        	ex.printStackTrace();
        	cdList = Collections.emptyList();
        }
       	model.addObject("cdList", cdList);
       	return model;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String handleFormUpload(@RequestParam("name") String name,
            @RequestParam("file") Part file) {
    	try (
        		BufferedInputStream bis = new BufferedInputStream(file.getInputStream());
        		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(FILE_PATH));
        		) {
			int bytesRead = 0;
			byte[] byteBuffer = new byte[1024];
			while ((bytesRead = bis.read(byteBuffer)) != -1) {
				bos.write(byteBuffer, 0, bytesRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return "redirect:/uploadfailed";
		}
        return "redirect:/uploadsuccess";
    }
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String uploadForm() {
    	return "upload";
    }
    @RequestMapping(value = "/uploadsuccess") 
    public String uploadSuccess() {
    	return "uploadsuccess";
    }
    @RequestMapping(value = "/uploadfailed")
    public String uploadFailed() {
    	return "uploadfailed";
    }
    
    @RequestMapping(value = "/download")
    public void download(HttpServletRequest request, HttpServletResponse response) {
        File f = new File(FILE_PATH);
        try (
       		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
       		OutputStream out = response.getOutputStream();
       	) {
            response.setContentType("application/xml");
            response.setContentLength((int)f.length());
            response.setHeader("Content-Disposition", "attachment; filename=Catalog.xml");
            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while ((bytesRead = bis.read(buffer)) != -1) {
            	out.write(buffer, 0, bytesRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @RequestMapping(value = "/newcd", method = RequestMethod.GET)
    public String getNewCdForm() {
    	return "newcd";
    }
    
    @RequestMapping(value = "/newcd", method = RequestMethod.POST)
    public String addNewCd(@RequestParam("title") String title,
    		@RequestParam("artist") String artist,
    		@RequestParam("country") String country,
    		@RequestParam("company") String company,
    		@RequestParam("price") String price,
    		@RequestParam("year") String year) {
    	catalogService.saveCD(catalogService.createCD(title, artist, country, company, price, year));
    	return "redirect:/catalog";
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editCd(@RequestParam("id") String cdTitle) {
    	CD cd = catalogService.getCDbyTitle(cdTitle);
    	ModelAndView model = new ModelAndView("edit");
    	model.addObject("cd", cd);
    	return model;
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.POST) 
    public String editCdSubmit(@RequestParam("title") String title,
    		@RequestParam("artist") String artist,
    		@RequestParam("country") String country,
    		@RequestParam("company") String company,
    		@RequestParam("price") String price,
    		@RequestParam("year") String year) {
    	catalogService.saveCD(catalogService.createCD(title, artist, country, company, price, year));
    	return "redirect:/catalog";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteCD(@RequestParam("id") String cdTitle) {
    	catalogService.removeCD(cdTitle);
    	return "redirect:/catalog";
    }
}
