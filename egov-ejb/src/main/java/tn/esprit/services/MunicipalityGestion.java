package tn.esprit.services;

import java.awt.List;
import java.util.Date;


import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.Query;

import org.jboss.ejb3.annotation.Clustered;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.domain.Man;
import tn.esprit.domain.Municipality;
import tn.esprit.domain.Woman;

/**
 * Session Bean implementation class MunicipalityGestion
 */
@Stateful
@Clustered
@Remote(MunicipalityGestionRemote.class)

@LocalBean
public class MunicipalityGestion implements MunicipalityGestionRemote, MunicipalityGestionLocal {
@PersistenceContext(unitName="egovernment")
    EntityManager em;
    public MunicipalityGestion() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Municipality birthCertificateByCin(int cin) {
		Municipality municipality=null;
		
		try {
			Query queryBCbyCin = em.createQuery("SELECT m FROM Municipality m WHERE m.cin= :cin");
			queryBCbyCin.setParameter("cin", cin);
			municipality = (Municipality) queryBCbyCin.getSingleResult();
			return municipality;
		} catch (Exception e) {
			System.out.println(e);
		}
		return municipality;
	}

	@Override
	public Municipality birthCertificateByName(String fname, String lname, Date birthDate, String birthplace) {
		Municipality municipality=null;
		
		try {
			Query queryBCbyCin = em.createQuery("SELECT m FROM Municipality m WHERE m.fname=:fname and m.lname=:lname and m.birthdate=:birthDate and m.birthplace=:birthplace");
			queryBCbyCin.setParameter("fname", fname).setParameter("lname", lname).setParameter("birthDate", birthDate).setParameter("birthplace", birthplace);
			municipality = (Municipality) queryBCbyCin.getSingleResult();
			return municipality;
		} catch (Exception e) {
			System.out.println(e);
		}
		return municipality;
	}

	@Override
	public Municipality deathCertificateByCin(int cin) {
		
		Municipality municipality=null;
		
		try {
			Query queryBCbyCin = em.createQuery("SELECT m FROM Municipality m WHERE m.cin= :cin");
			queryBCbyCin.setParameter("cin", cin);
			municipality = (Municipality) queryBCbyCin.getSingleResult();
			if(municipality.getDeathDate()!=null)
				return municipality;
			else
				return municipality=null;
		} catch (Exception e) {
			System.out.println(e);
		}
		return municipality;
	}

	@Override
	public Municipality deathCertificateByName(String fname, String lname, Date deathDate) {
		Municipality municipality=null;
		
		try {
			Query queryBCbyCin = em.createQuery("SELECT m FROM Municipality m WHERE m.fname=:fname and m.lname=:lname and m.deathDate=:deathDate");
			queryBCbyCin.setParameter("fname", fname).setParameter("lname", lname).setParameter("deathDate", deathDate);
			municipality = (Municipality) queryBCbyCin.getSingleResult();
			if(municipality.getDeathDate()!=null)
				return municipality;
			else
				return municipality=null;
		} catch (Exception e) {
			System.out.println(e);
		}
		return municipality;
		
	}

	@Override
	public String weddingCertificateGenderByCin(int cin) {
		Municipality municipality=null;
		
		
		try {
			Query queryBCbyCin = em.createQuery("SELECT m FROM Municipality m WHERE m.cin= :cin");
			queryBCbyCin.setParameter("cin", cin);
			municipality = (Municipality) queryBCbyCin.getSingleResult();
			return municipality.getGender();
		} catch (Exception e) {
			System.out.println(e);
		}
		return municipality.getGender();
		
	}

	@Override
	public Boolean addWeddingCertificate(int cin1, int cin2, Date weddingDate) {
		Municipality first= null;
		Municipality second =null;
		Man epoux =null;
		Woman epouse = null;
		try {
			first = birthCertificateByCin(cin1);
			System.out.println("*****************");
			System.out.println(first.getFname());
			System.out.println("*****************");
			second = birthCertificateByCin(cin2);
			
			
			/* if(first.getGender().equals("male")){ */
				System.out.println("//////////////");
				epoux = new Man();
				//epouse = new Woman();
				//epouse.setWeddingDate(weddingDate);
				//epouse.setMan(first);
				
				epoux.setWoman(second);
				
				epoux.setFname(first.getFname());
				epoux.setLname(first.getLname());
				epoux.setCin(first.getCin());
				epoux.setBirthdate(first.getBirthdate());
				epoux.setBirthplace(first.getBirthplace());
				epoux.setDateofdeclaration(first.getDateofdeclaration());
				epoux.setDeathDate(first.getDeathDate());
				epoux.setFathername(first.getFathername());
				epoux.setFathernationality(first.getFathernationality());
				epoux.setFatherprofession(first.getFatherprofession());
				epoux.setGender(first.getGender());
				epoux.setMothername(first.getMothername());
				epoux.setMothernationality(first.getMothernationality());
				epoux.setMotherprofession(first.getMotherprofession());
				epoux.setNameofwriter(first.getNameofwriter());
				epoux.setNameofpersondeclaring(first.getNameofpersondeclaring());
				
				/*
				epoux.setWeddingDate(weddingDate);
				
				epoux.setFname(second.getFname());
				epoux.setLname(second.getLname());
				epoux.setCin(second.getLname());
				epoux.setBirthdate(second.getBirthdate());
				epoux.setBirthplace(second.getBirthplace());
				epoux.setDateofdeclaration(second.getDateofdeclaration());
				epoux.setDeathDate(second.getDeathDate());
				epoux.setFathername(second.getFathername());
				epoux.setFathernationality(second.getFathernationality());
				epoux.setFatherprofession(second.getFatherprofession());
				epoux.setGender(second.getGender());
				epoux.setMothername(second.getMothername());
				epoux.setMothernationality(second.getMothernationality());
				epoux.setMotherprofession(second.getMotherprofession());
				epoux.setNameofwriter(second.getNameofwriter());
				epoux.setNameofpersondeclaring(second.getNameofpersondeclaring());
				
				*/
				//epouse.setRemarques("is married to"+ first.getFname() +" " + first.getLname());
				epoux.setRemarques("is married to"+ second.getFname() +" " + second.getLname());
				second.setRemarques("is married to"+ first.getFname() +" " + first.getLname());
				first.setRemarques("is married to"+ second.getFname() +" " + second.getLname());
				em.persist(epoux);
				//em.persist(epouse);
				em.merge(first);
				em.merge(second);
				System.out.println("epouse ajout�");
		//	}
			
			/*
			else if(first.getGender().equals("female")){
				System.out.println("");
				epoux = new Man();
				epouse = new Woman();
				epouse.setWeddingDate(weddingDate);
				epoux.setWeddingDate(weddingDate);
				epouse.setMan(second);
				epoux.setWoman(first);
				
				epouse.setFname(second.getFname());
				epouse.setLname(second.getLname());
				epouse.setCin(second.getCin());
				epouse.setBirthdate(second.getBirthdate());
				epouse.setBirthplace(second.getBirthplace());
				epouse.setDateofdeclaration(second.getDateofdeclaration());
				epouse.setDeathDate(second.getDeathDate());
				epouse.setFathername(second.getFathername());
				epouse.setFathernationality(second.getFathernationality());
				epouse.setFatherprofession(second.getFatherprofession());
				epouse.setGender(second.getGender());
				epouse.setMothername(second.getMothername());
				epouse.setMothernationality(second.getMothernationality());
				epouse.setMotherprofession(second.getMotherprofession());
				epouse.setNameofwriter(second.getNameofwriter());
				epouse.setNameofpersondeclaring(second.getNameofpersondeclaring());
				
		
				epoux.setFname(first.getFname());
				epoux.setLname(first.getLname());
				epoux.setCin(first.getCin());
				epoux.setBirthdate(first.getBirthdate());
				epoux.setBirthplace(first.getBirthplace());
				epoux.setDateofdeclaration(first.getDateofdeclaration());
				epoux.setDeathDate(first.getDeathDate());
				epoux.setFathername(first.getFathername());
				epoux.setFathernationality(first.getFathernationality());
				epoux.setFatherprofession(first.getFatherprofession());
				epoux.setGender(first.getGender());
				epoux.setMothername(first.getMothername());
				epoux.setMothernationality(first.getMothernationality());
				epoux.setMotherprofession(first.getMotherprofession());
				epoux.setNameofwriter(first.getNameofwriter());
				epoux.setNameofpersondeclaring(first.getNameofpersondeclaring());
				
				//epouse.setRemarques("is married to"+ second.getFname() +" " + second.getLname());
				epoux.setRemarques("is married to"+ first.getFname() +" " + first.getLname());
				second.setRemarques("is married to"+ first.getFname() +" " + first.getLname());
				first.setRemarques("is married to"+ second.getFname() +" " + second.getLname());
				em.persist(epoux);
				em.persist(epouse);
				em.merge(first);
				em.merge(second);
			}
			*/

			
			return true;
		} catch (Exception e) {
			System.out.println("erreuuurr");
			return false;
		}
		
	}

	@Override
	public Man weddingCertificateMan(int cin) {
		Man weddingCertificateMan=null;
		try {
			Query queryBCbyCin1 = em.createQuery("SELECT ma FROM Man ma WHERE ma.cin=:cin");
			queryBCbyCin1.setParameter("cin", cin);
			weddingCertificateMan = (Man) queryBCbyCin1.getSingleResult();
		
		} catch (Exception e) {
			System.out.println(e);
		}
		return weddingCertificateMan;
		
	}

	@Override
	public Woman weddingCertificateWoman(int cin) {
		Woman weddingCertificateWoman=null;

		try {
			Query queryBCbyCin2 = em.createQuery("SELECT w FROM Woman w WHERE w.cin= :cin");
			queryBCbyCin2.setParameter("cin", cin);
			weddingCertificateWoman = (Woman) queryBCbyCin2.getSingleResult();
		
		} catch (Exception e) {
			System.out.println(e);
		}
		return weddingCertificateWoman;
		
	}

	@Override
	public Boolean babyRedistration(Municipality baby) {
		try {
			em.persist(baby);
			return true;
		} catch (Exception e) {
		return false;
		}
	}

	@Override
	public Boolean DeathRegistration(int cin, Date date) {
		Municipality m=null;
		m=birthCertificateByCin(cin);
		if(m!=null){
			m.setDeathDate(date);
			em.merge(m);
			return true;
		}else
			return false;
		
		
	}
	@Override
	public Boolean DeathRegistrationByName(Date date, String fname, String lname, Date birthDate, String birthPlace) {
		Municipality mun=null;
		try {
			mun=birthCertificateByName(fname, lname, birthDate, birthPlace);
			mun.setDeathDate(date);
			em.persist(mun);
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	@Override
	public java.util.List<String> chercherlistMale() {
		return em.createQuery("select n.gender from Municipality n").getResultList();
	}

	@Override
	public java.util.List<String> chercherlistFemale() {
		return em.createQuery("select n.gender from Municipality n").getResultList();
	}


	@Override
	public java.util.List<Municipality> chercherlistebebe() {
		
		return em
				.createQuery("SELECT R FROM Municipality R", Municipality.class)
				.getResultList();
		
	}

		
		}

	
	
