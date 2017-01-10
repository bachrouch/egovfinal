package tn.esprit.domain;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: transportMinistry
 *
 */
@Entity

public class transportMinistry implements Serializable {

	
	private int id;
	private String fname;
	private String lname;
	private Date birthdate;
	private String birthplace;
	private int cin;
	private String adress;
	private String category;
	private Date delevrencydate;
	private Date echeancedate;
	private String restriction;
	private String transformedcertificate;
	private String cargenre;
	private String constructortype;
	private int serialnumboftype;
	private String constructor;
	private Date dpmc;
	private String commercialtype;
	private String carosserie;
	private String energie;
	private String puissance;
	private String charge;
	private int placenumb;
	private int cylindre;
	private int lastimmatnumb;
	private int certifnumb;
	private Date dateofetab;
	private String establishmentplace;
	private boolean paid;
	private Date expiration;
	private Date permissionDate;
	private static final long serialVersionUID = 1L;

	
	@Id    
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}   
	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}   
	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}   
	public String getBirthplace() {
		return this.birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}   
	public int getCin() {
		return this.cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}   
	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}   
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}   
	public Date getDelevrencydate() {
		return this.delevrencydate;
	}

	public void setDelevrencydate(Date delevrencydate) {
		this.delevrencydate = delevrencydate;
	}   
	public Date getEcheancedate() {
		return this.echeancedate;
	}

	public void setEcheancedate(Date echeancedate) {
		this.echeancedate = echeancedate;
	}   
	public String getRestriction() {
		return this.restriction;
	}

	public void setRestriction(String restriction) {
		this.restriction = restriction;
	}   
	public String getTransformedcertificate() {
		return this.transformedcertificate;
	}

	public void setTransformedcertificate(String transformedcertificate) {
		this.transformedcertificate = transformedcertificate;
	}   
	public String getCargenre() {
		return this.cargenre;
	}

	public void setCargenre(String cargenre) {
		this.cargenre = cargenre;
	}   
	public String getConstructortype() {
		return this.constructortype;
	}

	public void setConstructortype(String constructortype) {
		this.constructortype = constructortype;
	}   
	public int getSerialnumboftype() {
		return this.serialnumboftype;
	}

	public void setSerialnumboftype(int serialnumboftype) {
		this.serialnumboftype = serialnumboftype;
	}   
	public String getConstructor() {
		return this.constructor;
	}

	public void setConstructor(String constructor) {
		this.constructor = constructor;
	}   
	public Date getDpmc() {
		return this.dpmc;
	}

	public void setDpmc(Date dpmc) {
		this.dpmc = dpmc;
	}   
	public String getCommercialtype() {
		return this.commercialtype;
	}

	public void setCommercialtype(String commercialtype) {
		this.commercialtype = commercialtype;
	}   
	public String getCarosserie() {
		return this.carosserie;
	}

	public void setCarosserie(String carosserie) {
		this.carosserie = carosserie;
	}   
	public String getEnergie() {
		return this.energie;
	}

	public void setEnergie(String energie) {
		this.energie = energie;
	}   
	public String getPuissance() {
		return this.puissance;
	}

	public void setPuissance(String puissance) {
		this.puissance = puissance;
	}   
	public String getCharge() {
		return this.charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}   
	public int getPlacenumb() {
		return this.placenumb;
	}

	public void setPlacenumb(int placenumb) {
		this.placenumb = placenumb;
	}   
	public int getCylindre() {
		return this.cylindre;
	}

	public void setCylindre(int cylindre) {
		this.cylindre = cylindre;
	}   
	public int getLastimmatnumb() {
		return this.lastimmatnumb;
	}

	public void setLastimmatnumb(int lastimmatnumb) {
		this.lastimmatnumb = lastimmatnumb;
	}   
	public int getCertifnumb() {
		return this.certifnumb;
	}

	public void setCertifnumb(int certifnumb) {
		this.certifnumb = certifnumb;
	}   
	public Date getDateofetab() {
		return this.dateofetab;
	}

	public void setDateofetab(Date dateofetab) {
		this.dateofetab = dateofetab;
	}   
	public String getEstablishmentplace() {
		return this.establishmentplace;
	}

	public void setEstablishmentplace(String establishmentplace) {
		this.establishmentplace = establishmentplace;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public Date getPermissionDate() {
		return permissionDate;
	}

	public void setPermissionDate(Date permissionDate) {
		this.permissionDate = permissionDate;
	}
   
}
