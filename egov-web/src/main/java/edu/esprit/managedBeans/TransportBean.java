package edu.esprit.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;

import tn.esprit.domain.Citizen;
import tn.esprit.domain.Request;
import tn.esprit.services.RequestGestionLocal;

@ManagedBean
@SessionScoped
public class TransportBean implements Serializable {
	private List<Request> requests;
	private List<Citizen> citizens;
	private String chaine;
	private Citizen citizen;
	private Request request;
	private String FirstName;
	private String Lastname;
	private String charge;
	private String Puissance;
	private String immatricule;

	private String Cin;
	private String category;
	private String BusLine;

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public String getChaine() {
		return chaine;
	}

	public void setChaine(String chaine) {
		this.chaine = chaine;
	}

	@EJB
	RequestGestionLocal requestGestionLocal;

	@PostConstruct
	public void init() {
		setRequest(new Request());
		citizen=new Citizen();
	
		
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

	public String getPuissance() {
		return Puissance;
	}

	public void setPuissance(String puissance) {
		Puissance = puissance;
	}

	public String getImmatricule() {
		return immatricule;
	}

	public void setImmatricule(String immatricule) {
		this.immatricule = immatricule;
	}

	public String DoaddRequest() {
		request.setEtat(0);
		request.setDepartement(" Department of Transportation");
		request.setCin(GestionCitizenBean.idCard);

		String service = "Car sticker / " + Lastname + " / " + FirstName + " / " + category + " / " + Puissance + " / "
				+ immatricule + " / " + charge + " / ";

		request.setService(service);

		addMessage("Welcome to Primefaces!!");

		requestGestionLocal.addRequest(request);

		init();
		return null;
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public String DoaddRequest2() {
		request.setEtat(0);
		request.setDepartement("Department of Transportation");
		request.setCin(GestionCitizenBean.idCard);

		String service = "subscription transport  /  " + Lastname + " / " + FirstName + " / " + BusLine + " / ";

		request.setService(service);

		requestGestionLocal.addRequest(request);

		init();
		return null;
	}

	public String getCin() {
		return Cin;
	}

	public void setCin(String cin) {
		Cin = cin;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBusLine() {
		return BusLine;
	}

	public void setBusLine(String busLine) {
		BusLine = busLine;
	}

	public List<Citizen> getCitizens() {
		return citizens;
	}

	public void setCitizens(List<Citizen> citizens) {
		this.citizens = citizens;
	}

	public Citizen getCitizen() {
		return citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

}
