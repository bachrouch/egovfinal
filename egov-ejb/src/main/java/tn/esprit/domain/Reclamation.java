package tn.esprit.domain;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Reclamation
 *
 */
@Entity

public class Reclamation implements Serializable {

	
	private int id;
	private String type;
	private String sujet;
	private String text;
	private String mail ;
	private static final long serialVersionUID = 1L;

	 
	@Id    
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return this.id;
	}
	

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public void setId(int id) {
		this.id = id;
	}   
	public String getSujet() {
		return this.sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}   
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}
   
}
