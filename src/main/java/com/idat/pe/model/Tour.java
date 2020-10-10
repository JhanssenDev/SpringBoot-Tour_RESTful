package com.idat.pe.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tour implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private String title;
	private String description;
	private String blurb;
	private Integer price;
	private String duration;
	private String bullets;
	private String keywords;
	
	@JoinColumn(name = "id_tour_package",referencedColumnName = "id_tour_package")
	@ManyToOne
	private TourPackage tourPackage;
	
	@Enumerated(EnumType.STRING)
	private Region region;
	
	@Enumerated(EnumType.ORDINAL)
	private Difficulty difficulty;
	
	
	
	public Tour() {}

	public Tour(Integer id, String title, String description, String blurb, Integer price, String duration,
			String bullets, String keywords) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.blurb = blurb;
		this.price = price;
		this.duration = duration;
		this.bullets = bullets;
		this.keywords = keywords;
	}

	public Tour(Integer id, String title, String description, String blurb, Integer price, String duration,
			String bullets, String keywords, TourPackage tourPackage, Region region, Difficulty difficulty) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.blurb = blurb;
		this.price = price;
		this.duration = duration;
		this.bullets = bullets;
		this.keywords = keywords;
		this.tourPackage = tourPackage;
		this.region = region;
		this.difficulty = difficulty;
	}

	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBlurb() {
		return blurb;
	}
	public void setBlurb(String blurb) {
		this.blurb = blurb;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getBullets() {
		return bullets;
	}
	public void setBullets(String bullets) {
		this.bullets = bullets;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public TourPackage getTourPackage() {
		return tourPackage;
	}
	public void setTourPackage(TourPackage tourPackage) {
		this.tourPackage = tourPackage;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public Difficulty getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	@Override
	public String toString() {
		return "Tour [id=" + id + ", description=" + description + ", blurb=" + blurb + ", price=" + price
				+ ", duration=" + duration + ", bullets=" + bullets + ", keywords=" + keywords + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	
	
}
