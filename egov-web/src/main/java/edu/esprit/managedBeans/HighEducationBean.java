package edu.esprit.managedBeans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import tn.esprit.domain.HightEducationMinistry;
import tn.esprit.services.EducationMinistryGestionLocal;

@ManagedBean
@ViewScoped
public class HighEducationBean {
	private int ciin;
	String var ;
	private HightEducationMinistry std1;
	private HightEducationMinistry std2;
	private HightEducationMinistry maliste;
	
	@EJB
	EducationMinistryGestionLocal educationMinistryGestionLocal;

	@PostConstruct
	public void init() {
		std2=new HightEducationMinistry();
	}

	public int getCiin() {
		return ciin;
	}

	public void setCiin(int ciin) {
		this.ciin = ciin;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public HightEducationMinistry getStd1() {
		return std1;
	}

	public void setStd1(HightEducationMinistry std1) {
		this.std1 = std1;
	}

	public HightEducationMinistry getMaliste() {
		return maliste;
	}

	public void setMaliste(HightEducationMinistry maliste) {
		this.maliste = maliste;
	}
	
	
	public HightEducationMinistry getStd2() {
		return std2;
	}

	public void setStd2(HightEducationMinistry std2) {
		this.std2 = std2;
	}

	public void show(int cin) {
		maliste = educationMinistryGestionLocal.afficherStudent(ciin);

		init();
	}

	public  String showmsg(int cin) {
		var ="";
		std1 = educationMinistryGestionLocal.findStudentByCin(ciin);
		 
         
		if (std1.isPaid()) {
		
			var = " Vous avez Déjà Payé vos Frais D'Inscription";
		} else  {
			var = " Vous N'avez Pas Payé Vos Frais D'inscription ";
		}
		
		return var;
			
	}
	
	public String rediraction(){
		return "/citizen/dashboard?faces-redirect=true";
	}

	public String addaStudent(){
		String navigateTo = null;
		Boolean activ;
	   std2.setId(0);
		std2.setPaid(false);
		
		activ =  educationMinistryGestionLocal.addStudent(std2);
		if(activ)
			navigateTo = "/agent/AjoutEtudiant?faces-redirect=true";
		return navigateTo;
	}
	
}
