package tn.esprit.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Woman
 *
 */
@Entity

public class Woman extends Municipality implements Serializable  {
	private Date weddingDate;
	private Municipality man ;
	private static final long serialVersionUID = 1L;

	
	@OneToOne(cascade=CascadeType.ALL)
	public Municipality getMan() {
		return man;
	}

	public void setMan(Municipality man) {
		this.man = man;
	}
	@Temporal(TemporalType.DATE)
	public Date getWeddingDate() {
		return weddingDate;
	}

	public void setWeddingDate(Date weddingDate) {
		this.weddingDate = weddingDate;
	}
    
	
}
