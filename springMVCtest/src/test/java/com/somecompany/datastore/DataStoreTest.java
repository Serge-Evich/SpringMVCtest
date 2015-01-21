package com.somecompany.datastore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DataStoreTest {
	private Catalog catalog;
	private CD cd1;
	private CD cd2;
    private CatalogDataStore catalogDataStoreMock;
    private String catalogString = "<CATALOG>\n" +
            "    <CD>\n" +
            "        <ARTIST>Bob Dylan</ARTIST>\n" +
            "        <COMPANY>Columbia</COMPANY>\n" +
            "        <COUNTRY>USA</COUNTRY>\n" +
            "        <PRICE>10.90</PRICE>\n" +
            "        <TITLE>Empire Burlesque</TITLE>\n" +
            "        <YEAR>1985</YEAR>\n" +
            "    </CD>\n" +
            "</CATALOG>";
    private List<CD> cdList;
	@Before
	public void setup() {
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
        catalogDataStoreMock = mock(CatalogDataStore.class);

    }

    @Test
    public void testDataStore_mock() {
        when(catalogDataStoreMock.get("")).thenReturn(catalog);
        Assert.assertEquals(catalog, catalogDataStoreMock.get(""));
    }

}
