package com.somecompany.datastore;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CATALOG")
public class CatalogAdapter {

	private List<CDAdapter> cdAdapterList;
	
	public CatalogAdapter(List<CD> cdList) {
        cdAdapterList = new ArrayList<CDAdapter>();
        for (CD cd : cdList) {
            cdAdapterList.add(new CDAdapter(cd));
        }
	}

    public CatalogAdapter() {

    }
    @XmlElement(name = "CD")
	public List<CDAdapter> getCdAdapterListCdList() {
		return cdAdapterList;
	}

	public void setCdAdapterListList(List<CDAdapter> cdAdapterList) {
		this.cdAdapterList = cdAdapterList;
	}

    public Catalog getCatalog() {
        List<CD> cdList = new ArrayList<>();
        for (CDAdapter cdAdapter : getCdAdapterListCdList()) {
            cdList.add(cdAdapter.getCD());
        }
        return new Catalog(cdList);
    }
	
}
