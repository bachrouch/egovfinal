package tn.esprit.services;

import java.sql.Date;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.ejb3.annotation.Clustered;

import tn.esprit.domain.InteriorMinistry;

/**
 * Session Bean implementation class InteriorMinistryGestion
 */
@Stateful
@Clustered
@Remote(InteriorMinistryGestionRemote.class)

public class InteriorMinistryGestion implements InteriorMinistryGestionRemote, InteriorMinistryGestionLocal {

	@PersistenceContext(unitName="egovernment")
    EntityManager em;
    public InteriorMinistryGestion() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addPerson(InteriorMinistry person) {
		
		try {
			em.persist(person);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean modifyPerson(InteriorMinistry person) {
		
		
		try {
			em.merge(person);
			return true;
		} catch (Exception e) {
			return false;
		}
		
		
		
		
	/*	
		 InteriorMinistry pr;
		try {
		
		
		
			pr=findPersonByCin(45644564);
			System.out.println(pr.getId());
			
			/*pr.setFname(fname);
			pr.setLname(lname);
			pr.setAddress(address);
			pr.setB3Information(b3Information);
			pr.setBirthDate(birthDate);
			em.merge(pr);
			return true;
		} catch (Exception e) {
			return false;
		}
		*/ 
	}


	

	@Override
	public InteriorMinistry findPersonByName(String fname, String lname, Date birthDate, String birthPlace) {
		InteriorMinistry person=null;
		Query qr;
		try {
			qr=em.createQuery("SELECT p FROM InteriorMinistry p WHERE p.fname=:fname AND p.lname=:lname AND p.birthDate=:birthDate AND p.birthPlace=:birthPlace");
			qr.setParameter("fname", fname).setParameter("lname", lname).setParameter("birthDate", birthDate).setParameter("birthPlace", birthPlace);
			person = (InteriorMinistry) qr.getSingleResult();
			return person;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return person;
	}

	@Override
	public InteriorMinistry findPersonByCin(int cin) {
		InteriorMinistry person=null;
		Query qr;
		try {
			qr=em.createQuery("SELECT p FROM InteriorMinistry p WHERE p.cin=:cin");
			qr.setParameter("cin", cin);
			person = (InteriorMinistry) qr.getSingleResult();
			return person;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return person;
		
		
		
	}

}
