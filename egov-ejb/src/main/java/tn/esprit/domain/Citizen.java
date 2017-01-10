package tn.esprit.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Citizen
 *
 */
@Entity

public class Citizen implements Serializable {

	
	 private static final long serialVersionUID = 1L;
	 private int id;
	 private String address; 
	 private Date birth;
	 private int cin;
	 private String fname;
	 private byte[] inpic;
	 private String lname;
	 private String login;
	 private String pwd;
	 private String email;
	public Citizen() {
		super();
	}
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Temporal(TemporalType.DATE)
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public int getCin() {
		return cin;
	}
	public void setCin(int cin) {
		this.cin = cin;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public byte[] getInpic() {
		return inpic;
	}
	public void setInpic(byte[] inpic) {
		this.inpic = inpic;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
   
}
