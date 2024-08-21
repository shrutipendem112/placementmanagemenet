package com.sf.cm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Certificate {
	private int id;
	private int year;
	private String college;
	
	
	public Certificate() {
		super();
	}

	public Certificate(int id, int year, String college) {
		super();
		this.id = id;
		this.year = year;
		this.college = college;
	}
	
	
	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setyear(int year) {
		this.year = year;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	@Override
	public String toString() {
		return "Certificate [id=" + id + ", year=" + year + ", college=" + college + ", getId()=" + getId()
				+ ", getyear()=" + getYear() + ", getCollege()=" + getCollege() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
