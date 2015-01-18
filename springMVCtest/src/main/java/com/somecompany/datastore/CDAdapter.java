package com.somecompany.datastore;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "CD")
public class CDAdapter {
	
	private String title;
	
	private String artist;
	
	private String country;
	
	private String company;
	
	private String price;
	
	private String year;
	
	public CDAdapter() {
		
	}
	public CDAdapter(CD cd) {
		this.title = cd.getTitle();
		this.artist = cd.getArtist();
		this.country = cd.getCountry();
		this.company = cd.getCompany();
		this.price = cd.getPrice();
		this.year = cd.getYear();
	}
	@XmlElement(name = "TITLE")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@XmlElement(name = "ARTIST")
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	@XmlElement(name = "COUNTRY")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	@XmlElement(name = "COMPANY")
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	@XmlElement(name = "PRICE")
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	@XmlElement(name = "YEAR")
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	
}
