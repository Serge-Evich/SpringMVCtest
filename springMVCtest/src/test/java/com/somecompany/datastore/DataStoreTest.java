package com.somecompany.datastore;

import org.junit.Before;

public class DataStoreTest {
	private Catalog catalog;
	private CD cd1;
	private CD cd2;
	
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
		
	}
}
