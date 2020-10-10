package com.idat.pe.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TourPackage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id_tour_package;
	
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tourPackage")
	private List<Tour> tours;
	
	public TourPackage() {}
	
	public TourPackage(Integer id_tour_package, String name) {
		super();
		this.id_tour_package = id_tour_package;
		this.name = name;
	}

	public Integer getId() {
		return id_tour_package;
	}

	public void setId(Integer id_tour_package) {
		this.id_tour_package = id_tour_package;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId_tour_package(Integer id_tour_package) {
		this.id_tour_package = id_tour_package;
	}
	
	
	
	

}
