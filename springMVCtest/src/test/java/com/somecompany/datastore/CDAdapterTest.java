package com.somecompany.datastore;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.sun.xml.internal.ws.util.Pool;
import org.junit.Before;
import org.junit.Test;


import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

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
	    StringWriter sw = new StringWriter();
        m.marshal(testCDAdapter, sw);
        System.out.println(sw.toString());
        Unmarshaller unmarshaller = context.createUnmarshaller();
        CDAdapter cdUmarsh = (CDAdapter)unmarshaller.unmarshal(new StringReader(sw.toString()));
        CD afterUnmarsh = new CD(cdUmarsh.getTitle(),
                cdUmarsh.getArtist(),
                cdUmarsh.getCountry(),
                cdUmarsh.getCompany(),
                cdUmarsh.getPrice(),
                cdUmarsh.getYear());
        assertEquals(testCD, afterUnmarsh);
	}
}