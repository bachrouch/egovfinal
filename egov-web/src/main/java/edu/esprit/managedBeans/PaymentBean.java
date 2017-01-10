package edu.esprit.managedBeans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PaymentBean {

	@PostConstruct
	public void init(){
		
	}
	
	public String payment(){
		return "payment?faces-redirect=true";
	}

}
