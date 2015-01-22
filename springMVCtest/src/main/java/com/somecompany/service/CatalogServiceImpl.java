package com.somecompany.service;

import com.somecompany.datastore.CD;
import com.somecompany.datastore.Catalog;
import com.somecompany.datastore.dao.CatalogDao;

import java.util.*;

/**
 * Created by Dmitry on 22.01.2015.
 */
public class CatalogServiceImpl implements CatalogService {
    private CatalogDao catalogDao;
    public CatalogServiceImpl(){

    }

    public CatalogServiceImpl(CatalogDao catalogDao) {
        this.catalogDao = catalogDao;
    }
    @Override
    public CD createCD(String title, String artist, String country, String company, String price, String year) {
        return new CD(title, artist, country, company, price, year);
    }

    @Override
    public void saveCD(CD cd) {
        Catalog catalog = catalogDao.findOne("");
        List<CD> cdList = null;
        if (catalog == null || catalog.getCDList() == null) {
            cdList = new ArrayList<CD>();
            cdList.add(cd);
            catalog = new Catalog(cdList);


        } else {
            cdList = catalog.getCDList();
            ListIterator<CD> iterator = cdList.listIterator();
            while (iterator.hasNext()) {
                CD c = iterator.next();
                if (c.getTitle().equals(cd.getTitle())) {
                    iterator.remove();
                }
            }
            cdList.add(cd);
        }
        catalogDao.create(catalog);
    }

    @Override
    public CD getCDbyTitle(String title) {
        CD cd = null;
        Catalog catalog = catalogDao.findOne("");
        List<CD> cdList = null;
        if (catalog == null || catalog.getCDList() == null) {
            return null;
        }
        cdList = catalog.getCDList();
        for (CD c : cdList) {
            if (c.getTitle().equals(title)) {
                cd = c;
            }
        }
        return cd;
    }

    @Override
    public CD removeCD(String title) {
        CD cd = null;
        Catalog catalog = catalogDao.findOne("");
        List<CD> cdList = null;
        if (catalog == null || catalog.getCDList() == null) {
            return null;
        }
        cdList = catalog.getCDList();
        ListIterator<CD> iterator = cdList.listIterator();
        while (iterator.hasNext()) {
            CD c = iterator.next();
            if (c.getTitle().equals(title)) {
                iterator.remove();
                cd = c;
            }
        }
        return cd;
    }

    @Override
    public Catalog getCatalog() {
        return catalogDao.findOne("");
    }
}
