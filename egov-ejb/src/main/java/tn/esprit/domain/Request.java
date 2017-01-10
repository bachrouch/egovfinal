package tn.esprit.domain;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Request
 *
 */
@Entity

public class Request implements Serializable {

	private int id;
	private String service;
	private int cin;
	private int etat;
	private String departement;
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getService() {
		return this.service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public int getCin() {
		return this.cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public int getEtat() {
		return this.etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", service=" + service + ", cin=" + cin + ", etat=" + etat + ", departement="
				+ departement + "]";
	}
	

}
