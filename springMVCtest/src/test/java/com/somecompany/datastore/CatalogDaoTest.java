package com.somecompany.datastore;

import com.somecompany.datastore.dao.CatalogDao;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CatalogDaoTest {
	private CatalogDao catalogDao;
    private CatalogDataStore catalogDataStore;
    private Catalog catalog;

    @Before
	public void setup() {
        catalogDataStore = mock(CatalogDataStore.class);
        catalogDao = new CatalogDao(catalogDataStore);
        catalog = new Catalog(new ArrayList<CD>());
	}
	@Test
	public void testFindOne() {
		catalogDao.findOne("");
        verify(catalogDataStore).get("");
	}

    @Test
    public void testCreate() {
        catalogDao.create(catalog);
        verify(catalogDataStore).save(catalog);
    }
}
