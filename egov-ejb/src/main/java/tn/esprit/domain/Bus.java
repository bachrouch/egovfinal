package tn.esprit.domain;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Bus
 *
 */
@Entity

public class Bus implements Serializable {

	
	private int id;
	private int cin;

	private String busLine;
	
	private float price;
	private static final long serialVersionUID = 1L;

	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public String getBusLine() {
		return this.busLine;
	}

	public void setBusLine(String busLine) {
		this.busLine = busLine;
	}   
	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
   
}
