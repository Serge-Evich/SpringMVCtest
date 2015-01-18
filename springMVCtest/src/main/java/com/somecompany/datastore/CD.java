package com.somecompany.datastore;

import java.io.Serializable;

public class CD implements Serializable{
	private final String title;
	private final String artist;
	private final String country;
	private final String company;
	private final String price;
	private final String year;
	
	public CD(String title, String artist, String country, String company, String price, String year) {
		this.title = title;
		this.artist = artist;
		this.country = country;
		this.company = company;
		this.price = price;
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public String getCountry() {
		return country;
	}

	public String getCompany() {
		return company;
	}

	public String getPrice() {
		return price;
	}

	public String getYear() {
		return year;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		CD other = (CD) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CD [title=");
		builder.append(title);
		builder.append(", artist=");
		builder.append(artist);
		builder.append(", country=");
		builder.append(country);
		builder.append(", company=");
		builder.append(company);
		builder.append(", price=");
		builder.append(price);
		builder.append(", year=");
		builder.append(year);
		builder.append("]");
		return builder.toString();
	}

	
	
}
