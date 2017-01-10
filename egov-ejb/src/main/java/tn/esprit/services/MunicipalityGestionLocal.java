package tn.esprit.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import tn.esprit.domain.Man;
import tn.esprit.domain.Municipality;
import tn.esprit.domain.Woman;

@Local
public interface MunicipalityGestionLocal {

	Municipality birthCertificateByCin(int cin);
	Municipality birthCertificateByName(String fname, String lname, Date birthDate, String place);
	Municipality deathCertificateByCin(int cin);
	Municipality deathCertificateByName(String fname, String lname, Date deathDate);
	String weddingCertificateGenderByCin(int cin);
	Boolean  addWeddingCertificate(int cin1, int cin2, Date weddingDate);
	Man weddingCertificateMan(int cin);
	Woman weddingCertificateWoman(int cin);
	Boolean babyRedistration(Municipality baby);
	Boolean DeathRegistration(int cin, Date date);
	Boolean DeathRegistrationByName(Date date, String fname, String lname, Date birthDate, String birthPlace);
	List<String> chercherlistMale();
	List<String> chercherlistFemale();
	List<Municipality> chercherlistebebe();
}
