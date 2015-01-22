package com.somecompany.datastore;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.nio.charset.Charset;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.List;

import javax.xml.bind.JAXBContext;

import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;



/**
 * Created by Dmitry on 21.01.2015.
 */
public class XMLCatalogDataStore implements CatalogDataStore {
   
	private String filePath;
    public XMLCatalogDataStore(String filePath) {
        this.filePath = filePath;
    }
    
    
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
    public Catalog get(String id) {
		JAXBContext context;
		Catalog catalog = null;
		try (BufferedReader br = Files.newBufferedReader(Paths.get(this.filePath), Charset.forName("UTF-8"))) {
			context = JAXBContext.newInstance(CatalogAdapter.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			CatalogAdapter catalogAdapterUmarsh = (CatalogAdapter)unmarshaller.unmarshal(br);
			catalog = catalogAdapterUmarsh.getCatalog();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return catalog;
	     
    }

    @Override
    public List<Catalog> getByName(String name) {
        return null;
    }

    @Override
    public List<Catalog> getAll() {
        return null;
    }

    @Override
    public void save(Catalog catalog) {
    	try (
    			BufferedWriter bw = Files.newBufferedWriter(Paths.get(this.filePath), 
    			Charset.forName("UTF-8"))
    	) {
    		JAXBContext context = JAXBContext.newInstance(CatalogAdapter.class);
    		Marshaller m = context.createMarshaller();
    		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    	    CatalogAdapter catalogAdapter = new CatalogAdapter(catalog.getCDList());
            m.marshal(catalogAdapter, bw);
    	    
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
    }

    @Override
    public void update(Catalog pojo) {

    }

    @Override
    public Catalog remove(Catalog pojo) {
        return null;
    }
}
