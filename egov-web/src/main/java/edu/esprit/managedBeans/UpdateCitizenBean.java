package edu.esprit.managedBeans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.domain.Citizen;
import tn.esprit.services.CitizenGestionLocal;


@ManagedBean
@ViewScoped
public class UpdateCitizenBean {
	private Citizen citizen;
	@EJB
	CitizenGestionLocal citizenService;
	@PostConstruct
	public void init() {

		citizen = new Citizen();
	}
	public String doUpdate() {

		String navigateTo = null;
		 citizenService.update(citizen);
		if (citizen != null) {
			
				navigateTo = "/citizen/dashboard?faces-redirect=true";
			
		}
		return navigateTo ;
	}
	public String doInscription(){
		String navigateTo = null;
		citizenService.inscription(citizen);
		navigateTo="/citizen/dashboard?faces-redirect=true";
		return navigateTo;
		
	}
	public Citizen getCitizen() {
		return citizen;
	}
	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

}
