package com.netcracker.model;

/**
 * Created by yopa0716 on 6/2/2017.
 */
public class Quote {
	
	  private int id;
	  private String name;
	  private String description;
	  private String MRC;
	  private String NRC;

	  
	  
	  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMRC() {
		return MRC;
	}

	public void setMRC(String MRC) {
		this.MRC = MRC;
	}

	public String getNRC() {
		return NRC;
	}

	public void setNRC(String NRC) {
		this.NRC = NRC;
	}
}
