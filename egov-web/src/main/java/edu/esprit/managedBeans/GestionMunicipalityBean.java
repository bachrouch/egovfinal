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
@ViewScoped
public class GestionMunicipalityBean {
	private String fname;
	private String lname;
	private Date birthDate;
	private String birthPlace;
	private String deathDate;
	private int idCard;
	private Request request;
	
	@EJB
	RequestGestionLocal req;
	
	@PostConstruct
	public void init() {
		request = new Request();
	}
	
	public String doServiceBirth(){
		String serv="";
		serv="Birth certificate"+" / "+fname+" / "+lname+" / "+birthDate+" / "+birthPlace;
		return serv;
	}
	public String doServiceDeath(){
		String serv="";
		serv="Death certificate"+" / "+fname+" / "+lname+" / "+deathDate;
		return serv;
	}
	public String doServiceWedding(){
		String serv="";
		serv="Wedding certificate"+" / "+fname+" / "+lname+" / "+idCard;
		return serv;
	}
	
	public String addaskBirth(){
		String navigateTo = null;
		Boolean activ;
		request.setDepartement("municipality");
		request.setEtat(0);
		request.setService(doServiceBirth());
		request.setCin(GestionCitizenBean.idCard);
		activ = req.addRequest(request);
		if(activ)
			navigateTo = "/citizen/dashboard?faces-redirect=true";
		return navigateTo;
	}
	
	public String addaskDeath(){
		String navigateTo = null;
		Boolean activ;
		request.setDepartement("municipality");
		request.setEtat(0);
		request.setService(doServiceDeath());
		request.setCin(GestionCitizenBean.idCard);
		activ = req.addRequest(request);
		if(activ)
			navigateTo = "/citizen/dashboard?faces-redirect=true";
		return navigateTo;
	}
	
	public String addaskWedding(){
		String navigateTo = null;
		Boolean activ;
		request.setDepartement("municipality");
		request.setEtat(0);
		request.setService(doServiceWedding());
		request.setCin(GestionCitizenBean.idCard);
		activ = req.addRequest(request);
		if(activ)
			navigateTo = "/citizen/dashboard?faces-redirect=true";
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

	public String getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(String deathDate) {
		this.deathDate = deathDate;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public int getIdCard() {
		return idCard;
	}

	public void setIdCard(int idCard) {
		this.idCard = idCard;
	}
	
	
}
