package tn.esprit.domain;

import java.io.Serializable;

import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity

public class Admin implements Serializable {

	
	private int id;
	private String login;
	private String pwd;
	private static final long serialVersionUID = 1L;

	
	@Id    
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}   
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
   
}
