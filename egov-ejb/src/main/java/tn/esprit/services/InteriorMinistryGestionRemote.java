package tn.esprit.services;

import java.sql.Date;

import javax.ejb.Remote;

import tn.esprit.domain.InteriorMinistry;

@Remote
public interface InteriorMinistryGestionRemote {
	Boolean addPerson(InteriorMinistry person);
	Boolean modifyPerson(InteriorMinistry person);
	InteriorMinistry findPersonByCin(int cin);
	InteriorMinistry findPersonByName(String fname, String lname, Date birthDte, String birthPlace);


}
