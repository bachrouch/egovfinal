package tn.esprit.services;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.ejb3.annotation.Clustered;

import tn.esprit.domain.Reclamation;

/**
 * Session Bean implementation class ClaimGestion
 */
@Stateful
@Clustered
@Remote(ClaimGestionRemote.class)


public class ClaimGestion implements ClaimGestionRemote, ClaimGestionLocal {

	@PersistenceContext(unitName="egovernment")
	EntityManager em;
	@Override
	public Boolean addClaim(Reclamation rec) {
		try {
			em.persist(rec);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public Reclamation findClaimById(int id) {
		Reclamation rec = null;
		Query qr;
		try {
			qr= em.createQuery("SELECT c FROM Reclamation c WHERE c.id=:id");
			qr.setParameter("id", id);
			rec=(Reclamation) qr.getSingleResult();
			return rec;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rec;
	}

	@Override
	public Boolean deleteClaim(int id) {
		System.out.println("molka");
		Reclamation rec;
		try {
			System.out.println("houss");
			rec = findClaimById(id);
			System.out.println("findby");
			em.remove(em.merge(rec));
			System.out.println("remove");
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public List<Reclamation> findReclamationByType(String type) {
		Query qr;
		qr= em.createQuery("SELECT m FROM Reclamation m where m.type=:type");
		qr.setParameter("type", type);
		
		return qr.getResultList();
		
	}

	@Override
	public List<Reclamation> chercherReclamation() {
		return em
				.createQuery("SELECT R FROM Reclamation R", Reclamation.class)
				.getResultList();
	
	}
	@Override
	public void deleteClaim(Reclamation reclamation) {
		em.remove(em.merge(reclamation));
		
	}

	

}
