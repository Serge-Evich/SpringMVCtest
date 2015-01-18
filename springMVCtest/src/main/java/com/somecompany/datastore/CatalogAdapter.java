package com.somecompany.datastore;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CATALOG")
public class CatalogAdapter {
	@XmlElement(name = "CD")
	private List<CD> cdList;
	
	public CatalogAdapter(List<CD> cdList) {
		this.cdList = cdList;
	}

	public List<CD> getCdList() {
		return cdList;
	}

	public void setCdList(List<CD> cdList) {
		this.cdList = cdList;
	}
	
}
