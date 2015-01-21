package com.somecompany.datastore.dao;

import com.somecompany.datastore.Catalog;
import com.somecompany.datastore.CatalogDataStore;
import com.somecompany.datastore.DataStore;

/**
 * Created by Dmitry on 21.01.2015.
 */
public class CatalogDao extends AbstractDao<Catalog> {
    @Override
    protected DataStore<Catalog> getDataStore() {
        return null;
    }
}
