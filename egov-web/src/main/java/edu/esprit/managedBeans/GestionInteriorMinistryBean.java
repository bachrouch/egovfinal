package edu.esprit.managedBeans;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import tn.esprit.domain.Request;
import tn.esprit.services.RequestGestionLocal;

@ManagedBean
//@SessionScoped
@ViewScoped
public class GestionInteriorMinistryBean {

	private String fname;
	private String lname;
	private int cin;
	private Date birthDate;
	private String birthPlace;
	private String residencePlace ;
	private Request request;
	
	@EJB
	RequestGestionLocal req;
	
	@PostConstruct
	public void init() {
		request = new Request();
	}
	
	public String doServiceB3(){
		String serv="";
		serv="Asking for Bulletin n°3:"+" / "+fname+" / "+lname+" / "+cin+" / "+birthDate+" / "+birthPlace+" / "+residencePlace;
		return serv;
	}
	
	
	public String doServiceResidence(){
		String serv="";
		serv="Asking for Residence Certificate:"+" / "+fname+" / "+lname+" / "+cin+" / "+birthDate+" / "+birthPlace+" / "+residencePlace;
		return serv;
	}
	
	public String doServiceCin(){
		String serv="";
		serv="Asking for Getting a CIN Card:"+" / "+fname+" / "+lname+" / "+birthDate+" / "+birthPlace+" / "+residencePlace;
		return serv;
	}
	
	public String addaskB3(){
		String navigateTo = null;
		Boolean activ;
		request.setDepartement("Interior Ministry");
		request.setEtat(0);
		request.setService(doServiceB3());
		request.setCin(GestionCitizenBean.idCard);
		activ = req.addRequest(request);
		if(activ)
			navigateTo = "/citizen/asked?faces-redirect=true";
		return navigateTo;
	}
	
	public String addaskResidenceCertificate(){
		String navigateTo = null;
		Boolean activ;
		request.setDepartement("Interior Ministry");
		request.setEtat(0);
		request.setService(doServiceResidence());
		request.setCin(GestionCitizenBean.idCard);
		activ = req.addRequest(request);
		if(activ)
			navigateTo = "/citizen/asked?faces-redirect=true";
		return navigateTo;
	}
	
	public String addaskCin(){
		String navigateTo = null;
		Boolean activ;
		request.setDepartement("Interior Ministry");
		request.setEtat(0);
		request.setService(doServiceCin());
		request.setCin(GestionCitizenBean.idCard);
		activ = req.addRequest(request);
		if(activ)
			navigateTo = "/citizen/asked?faces-redirect=true";
		return navigateTo;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getResidencePlace() {
		return residencePlace;
	}

	public void setResidencePlace(String residencePlace) {
		this.residencePlace = residencePlace;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public RequestGestionLocal getReq() {
		return req;
	}

	public void setReq(RequestGestionLocal req) {
		this.req = req;
	}
	
	

	
}
