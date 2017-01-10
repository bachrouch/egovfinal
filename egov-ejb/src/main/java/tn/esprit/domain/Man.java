package tn.esprit.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Man
 *
 */
@Entity

public class Man extends Municipality implements Serializable {
	
	private Date weddingDate;
	private Municipality woman;
	private static final long serialVersionUID = 1L;

	
	  @OneToOne(cascade=CascadeType.ALL)
	public Municipality getWoman() {
		return woman;
	}

	public void setWoman(Municipality woman) {
		this.woman = woman;
	}
	@Temporal(TemporalType.DATE)
	public Date getWeddingDate() {
		return weddingDate;
	}

	public void setWeddingDate(Date weddingDate) {
		this.weddingDate = weddingDate;
	}
  
	
}
