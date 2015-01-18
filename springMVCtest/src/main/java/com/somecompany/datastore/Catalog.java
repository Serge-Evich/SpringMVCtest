package com.somecompany.datastore;

import java.io.Serializable;

import java.util.List;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


public class Catalog implements Serializable {
	
	private final List<CD> cdList;
	
	public Catalog(List<CD> cdList) {
		this.cdList = cdList;
	}
	
	public List<CD> getCDList() {
		return cdList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdList == null) ? 0 : cdList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Catalog other = (Catalog) obj;
		if (cdList == null) {
			if (other.cdList != null)
				return false;
		} else if (!cdList.equals(other.cdList))
			return false;
		return true;
	}
	
}
