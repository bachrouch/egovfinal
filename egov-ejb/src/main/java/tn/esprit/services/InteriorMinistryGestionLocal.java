package tn.esprit.services;

import java.sql.Date;

import javax.ejb.Local;

import tn.esprit.domain.InteriorMinistry;

@Local
public interface InteriorMinistryGestionLocal {
	Boolean addPerson(InteriorMinistry person);
	Boolean modifyPerson(InteriorMinistry person);
	InteriorMinistry findPersonByCin(int cin);
	InteriorMinistry findPersonByName(String fname, String lname, Date birthDte, String birthPlace);


}
