package tn.esprit.domain;

import java.io.Serializable;
import java.lang.String;
import java.math.BigInteger;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Poste
 *
 */
@Entity

public class Poste implements Serializable {

	
	private int id;
	private String fname;
	private String lname;
	private int cin;
	private int ncc;
	private Long iban;
	private boolean state;
	

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
	public int getCin() {
		return this.cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}   
	public int getNcc() {
		return this.ncc;
	}

	public void setNcc(int ncc) {
		this.ncc = ncc;
	}

	

	public Long getIban() {
		return iban;
	}

	public void setIban(Long iban) {
		this.iban = iban;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Poste [id=" + id + ", fname=" + fname + ", lname=" + lname + ", cin=" + cin + ", ncc=" + ncc + ", iban="
				+ iban + ", state=" + state + "]";
	}

}
