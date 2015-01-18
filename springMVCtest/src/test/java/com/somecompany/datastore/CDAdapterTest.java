package com.somecompany.datastore;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.junit.Before;
import org.junit.Test;

public class CDAdapterTest {
	private CD testCD;
	private CDAdapter testCDAdapter;
	@Before
	public void setup() {
		testCD = new CD("Empire Burlesque",
				"Bob Dylan",
				"USA",
				"Columbia",
				"10.90",
				"1985");
		testCDAdapter = new CDAdapter(testCD);
	}
	@Test
	public void testMarshallUnmarshall() throws Exception {
		// create JAXB context and instantiate marshaller
	    JAXBContext context = JAXBContext.newInstance(CDAdapter.class);
	    Marshaller m = context.createMarshaller();
	    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

	    // Write to System.out
	    m.marshal(testCDAdapter, System.out);
	}
}