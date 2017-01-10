package tn.esprit.domain;

import java.io.Serializable;
import java.lang.Byte;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: HightEducationMinistry
 *
 */
@Entity

public class HightEducationMinistry implements Serializable {

	
	private int id;
	private String fname;
	private String lname;
	private String establisment;
	private String level;
	private byte[] diploma;
	private Date birthdate;
	private int cin;
	private String adress;
	private boolean paid;
	private static final long serialVersionUID = 1L;

	
	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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
	public String getEstablisment() {
		return this.establisment;
	}

	public void setEstablisment(String establisment) {
		this.establisment = establisment;
	}   
	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}   
	
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	public byte[] getDiploma() {
		return diploma;
	}

	public void setDiploma(byte[] diploma) {
		this.diploma = diploma;
	}
	 @Temporal(TemporalType.DATE)
	public Date getBirthdate() {
		return this.birthdate;
	}
	
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}   
	public int getCin() {
		return this.cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}   
	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}
   
}
