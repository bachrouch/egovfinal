package tn.esprit.services;

import java.util.Date;

import javax.ejb.Local;

import tn.esprit.domain.HightEducationMinistry;
import tn.esprit.domain.Reclamation;

@Local
public interface EducationMinistryGestionLocal {
	Boolean addStudent(HightEducationMinistry student);
	Boolean addDiploma(HightEducationMinistry student, byte[] diploma);
	byte[] findDiplomaByCin(int cin);
	HightEducationMinistry findStudentByCin(int cin);
	byte[] extractBytes (String ImageName);
	Boolean modifyStudent(HightEducationMinistry student);
	public Boolean deleteStudent(int cin);
	public HightEducationMinistry findStudentById(int id);
	public boolean updateStudent(int cin , String name, String lastname, String adress,String level,String establisement,Date date);
	public HightEducationMinistry afficherStudent(int cin1);
}
