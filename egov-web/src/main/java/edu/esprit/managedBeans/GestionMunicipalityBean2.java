package edu.esprit.managedBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import tn.esprit.domain.Municipality;
import tn.esprit.domain.Request;
import tn.esprit.services.MunicipalityGestionLocal;
import tn.esprit.services.RequestGestionLocal;

@ManagedBean
@ApplicationScoped
public class GestionMunicipalityBean2 {
	 public Map<Long, Boolean> getChecked() {
		return checked;
	}
	public void setChecked(Map<Long, Boolean> checked) {
		this.checked = checked;
	}
	private Map<Long, Boolean> checked = new HashMap<Long, Boolean>();
	private Municipality mun1;
	private List<Municipality> municipalities;
	 private String firstname;
	 private String lastname;
	 private String birthplace;
	 public List<Municipality> getMunicipalities() {
		return municipalities;
	}
	public void setMunicipalities(List<Municipality> municipalities) {
		this.municipalities = municipalities;
	}
	private Date birthdate;
	private Date deathdate;
	 private String[] selectedCities2;

	    private List<String> cities;
   
	public String[] getSelectedCities2() {
			return selectedCities2;
		}
		public void setSelectedCities2(String[] selectedCities2) {
			this.selectedCities2 = selectedCities2;
		}
		public List<String> getCities() {
			return cities;
		}
		public void setCities(List<String> cities) {
			this.cities = cities;
		}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getBirthplace() {
		return birthplace;
	}
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public Date getDeathdate() {
		return deathdate;
	}
	public void setDeathdate(Date deathdate) {
		this.deathdate = deathdate;
	}
	@EJB
	static
	MunicipalityGestionLocal muni;
	@EJB
	MunicipalityGestionLocal municipalitygestionlocal;
	
	
	@PostConstruct
	public void init() {
		mun1 = new Municipality();
		
		setMunicipalities(municipalitygestionlocal.chercherlistebebe());
		  cities = new ArrayList<String>();
		  cities.add("girl");
	        cities.add("boy");
	
		
	}
	public Municipality getMun1() {
		return mun1;
	}
	public void setMun1(Municipality mun1) {
		this.mun1 = mun1;
	}
	public String addbaby(String[] selectedCities2){
		String navigateTo = null;
		Boolean activ;
	   mun1.setCin(0);
		mun1.setRemarques(null);
	mun1.setGender(selectedCities2[0]);
	 
		activ =  municipalitygestionlocal.babyRedistration(mun1);
		if(activ)
			navigateTo = "/agent/dashboard?faces-redirect=true";
		return navigateTo;
	}
	
	
	public String addDeathdate(){
		String navigateTo = null;
		Boolean activ;
	   
	
	 
		activ =  municipalitygestionlocal.DeathRegistrationByName(deathdate,firstname,lastname,birthdate,birthplace);
		if(activ)
			navigateTo = "/agent/dashboard?faces-redirect=true";
		return navigateTo;
	}
	public void Number(){
		xx=municipalitygestionlocal.chercherlistMale().size();
		xy=municipalitygestionlocal.chercherlistFemale().size();
	}
	
	public static int xx;
	public static int xy;
	public static int getXx() {
		return xx;
	}
	public void setXx(int xx) {
		this.xx = xx;
	}

}
