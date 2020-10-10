package com.idat.pe.model;

public enum Region {

	Northern_california("NC"),
	Central_coast("CC"),
	Southren_California("SC"),
	Varies("V");
	
	private String region ;

	private Region(String region) {
		this.region = region;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	
}
