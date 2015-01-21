package com.somecompany.datastore;

import java.io.BufferedReader;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * Created by Dmitry on 21.01.2015.
 */
public class XMLCatalogDataStore implements CatalogDataStore {
    private Path filePath;
    
    
	public Path getFilePath() {
		return filePath;
	}

	public void setFilePath(Path filePath) {
		this.filePath = filePath;
	}

	@Override
    public Catalog get(String id) {
		JAXBContext context;
		Catalog catalog = null;
		try (BufferedReader br = Files.newBufferedReader(this.filePath, Charset.forName("UTF-8"))) {
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
    public void save(Catalog pojo) {

    }

    @Override
    public void update(Catalog pojo) {

    }

    @Override
    public Catalog remove(Catalog pojo) {
        return null;
    }
}
