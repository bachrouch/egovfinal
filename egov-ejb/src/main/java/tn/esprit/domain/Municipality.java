package tn.esprit.domain;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Municipality
 *
 */
@Entity
@Inheritance(strategy =InheritanceType.TABLE_PER_CLASS)
public class Municipality implements Serializable {

	private int id;
	private int cin;
	private String fname;
	private String lname;
	private Date birthdate;
	private String birthplace;
	private String gender;
	private String fathername;
	private String fatherprofession;
	private String fathernationality;
	private String mothername;
	private String motherprofession;
	private String mothernationality;
	private Date dateofdeclaration;
	private String nameofpersondeclaring;
	private String nameofwriter;
	private Date deathDate;
	private String remarques;
	private static final long serialVersionUID = 1L;

	 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCin() {
		return cin;
	}
	public void setCin(int cin) {
		this.cin = cin;
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
	@Temporal(TemporalType.DATE)
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
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}   
	public String getFathername() {
		return this.fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}   
	public String getFatherprofession() {
		return this.fatherprofession;
	}

	public void setFatherprofession(String fatherprofession) {
		this.fatherprofession = fatherprofession;
	}   
	public String getFathernationality() {
		return this.fathernationality;
	}

	public void setFathernationality(String fathernationality) {
		this.fathernationality = fathernationality;
	}   
	public String getMothername() {
		return this.mothername;
	}

	public void setMothername(String mothername) {
		this.mothername = mothername;
	}   
	public String getMotherprofession() {
		return this.motherprofession;
	}

	public void setMotherprofession(String motherprofession) {
		this.motherprofession = motherprofession;
	}   
	public String getMothernationality() {
		return this.mothernationality;
	}

	public void setMothernationality(String mothernationality) {
		this.mothernationality = mothernationality;
	}   
	@Temporal(TemporalType.DATE)
	public Date getDateofdeclaration() {
		return this.dateofdeclaration;
	}

	public void setDateofdeclaration(Date dateofdeclaration) {
		this.dateofdeclaration = dateofdeclaration;
	}   
	public String getNameofpersondeclaring() {
		return this.nameofpersondeclaring;
	}

	public void setNameofpersondeclaring(String nameofpersondeclaring) {
		this.nameofpersondeclaring = nameofpersondeclaring;
	}   
	public String getNameofwriter() {
		return this.nameofwriter;
	}

	public void setNameofwriter(String nameofwriter) {
		this.nameofwriter = nameofwriter;
	}   
	public String getRemarques() {
		return this.remarques;
	}

	public void setRemarques(String remarques) {
		this.remarques = remarques;
	}
	@Temporal(TemporalType.DATE)
	public Date getDeathDate() {
		return deathDate;
	}
	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}
	
	
   
}
