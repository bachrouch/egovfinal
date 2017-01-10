package tn.esprit.services;

import java.util.Date;

import javax.ejb.Remote;

import tn.esprit.domain.HightEducationMinistry;

@Remote
public interface EducationMinistryGestionRemote {

	Boolean addStudent(HightEducationMinistry student);
	Boolean addDiploma(HightEducationMinistry student, byte[] diploma);
	boolean updateDiploma(HightEducationMinistry student);
	byte[] findDiplomaByCin(int cin);
	HightEducationMinistry findStudentByCin(int cin);
	Boolean modifyStudent(HightEducationMinistry student);
	byte[] extractBytes (String ImageName);
	public Boolean deleteStudent(int id);
	public HightEducationMinistry findStudentById(int id);
	public boolean updateStudent(int cin , String name, String lastname, String adress,String level,String establisement,Date date);
	public HightEducationMinistry afficherStudent(int cin1);
	//boolean addDiplona(HightEducationMinistry student, String path);

}
