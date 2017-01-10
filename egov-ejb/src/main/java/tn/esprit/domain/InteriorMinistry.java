package tn.esprit.domain;

import java.io.Serializable;
import java.lang.Byte;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: InteriorMinistry
 *
 */
@Entity

public class InteriorMinistry implements Serializable {

	
	private int id;
	private int cin;
	private String fname;
	private String lname;
	private Date birthDate;
	private String fatherName;
	private String grandFatherName;
	private String birthPlace;
	private String motherName;
	private String address;
	private Date issueDate;
	private byte[] picture;
	private String b3Information;
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public int getCin() {
		return this.cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}   
	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}   
	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}   
	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}   
	public String getFatherName() {
		return this.fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}   
	public String getGrandFatherName() {
		return this.grandFatherName;
	}

	public void setGrandFatherName(String grandFatherName) {
		this.grandFatherName = grandFatherName;
	}   
	public String getBirthPlace() {
		return this.birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}   
	public String getMotherName() {
		return this.motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}   
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}   
	public Date getIssueDate() {
		return this.issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}   
	@Lob
	
	public byte[] getPicture() {
		return this.picture;
	}
	
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}   
	public String getB3Information() {
		return this.b3Information;
	}

	public void setB3Information(String b3Information) {
		this.b3Information = b3Information;
	}
   
}
