package com.somecompany.service;

import com.somecompany.datastore.CD;
import com.somecompany.datastore.Catalog;

/**
 * Created by Dmitry on 22.01.2015.
 */
public interface CatalogService {
    CD createCD(String title, String artist, String country, String company, String price, String year);
    void saveCD(CD cd);
    CD getCDbyTitle(String title);
    CD removeCD(String title);
    Catalog getCatalog();
}
