package com.somecompany.datastore.service;

import com.somecompany.datastore.CD;
import com.somecompany.datastore.Catalog;
import com.somecompany.datastore.CatalogDataStore;
import com.somecompany.datastore.XMLCatalogDataStore;
import com.somecompany.service.CatalogService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitry on 22.01.2015.
 */
public class CatalogServiceTest {
    private CatalogService catalogService;
    private CD cd1;
    private CD cd2;
    private Catalog catalog;
    private List<CD> cdList;
    private CatalogDataStore catalogDataStore;

    @Before
    public void setup() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContextTest.xml");
        catalogService = context.getBean("catalogService", CatalogService.class);
        cd1 = new CD("Empire Burlesque",
                "Bob Dylan",
                "USA",
                "Columbia",
                "10.90",
                "1985");
        cd2 = new CD("Hide your heart",
                "Bonnie Tyler",
                "UK",
                "CBS Records",
                "9.90",
                "1988");
        cdList = new ArrayList<>();
        cdList.add(cd1);
        cdList.add(cd2);
        catalog = new Catalog(cdList);
        //create test file
        catalogDataStore = context.getBean("catalogDataStore", CatalogDataStore.class);
        catalogDataStore.save(catalog);
    }
    @Test
    public void testGetCDbyTitle() {
        CD testCd = catalogService.getCDbyTitle("Empire Burlesque");
        System.out.println(testCd);
        Assert.assertEquals(cd1, testCd);
    }


}
