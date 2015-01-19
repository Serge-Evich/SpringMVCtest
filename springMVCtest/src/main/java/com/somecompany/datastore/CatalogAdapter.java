package com.somecompany.datastore;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CATALOG")
@XmlAccessorType(XmlAccessType.FIELD)
public class CatalogAdapter {
	
	@XmlElement(name = "CD")
	private List<CDAdapter> cdAdapterList;
	
	public CatalogAdapter(List<CD> cdList) {
        cdAdapterList = new ArrayList<CDAdapter>();
        for (CD cd : cdList) {
            cdAdapterList.add(new CDAdapter(cd));
        }
	}

    public CatalogAdapter() {

    }
   
    
	public List<CDAdapter> getCdAdapterListCdList() {
		return cdAdapterList;
	}

	public void setCdAdapterListList(List<CDAdapter> cdAdapterList) {
		this.cdAdapterList = cdAdapterList;
	}

    public Catalog getCatalog() {
        List<CD> cdList = new ArrayList<>();
        if (getCdAdapterListCdList() == null) return null;
        for (CDAdapter cdAdapter : getCdAdapterListCdList()) {
            cdList.add(cdAdapter.getCD());
        }
        return new Catalog(cdList);
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CatalogAdapter [cdAdapterList=");
		if (cdAdapterList != null) {
			for (CDAdapter cdAdapter : cdAdapterList) {
				builder.append(cdAdapter).append(", ");
			}
		} else {
			builder.append("null");
		}
		builder.append("]");
		return builder.toString();
	}
    
	
}
