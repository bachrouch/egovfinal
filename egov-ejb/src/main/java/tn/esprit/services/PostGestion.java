package tn.esprit.services;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.ejb3.annotation.Clustered;

import tn.esprit.domain.Poste;
import tn.esprit.domain.Reclamation;

/**
 * Session Bean implementation class PostGestion
 */
@Stateful
@Clustered
@Remote(PostGestionRemote.class)

public class PostGestion implements PostGestionRemote, PostGestionLocal {


	@PersistenceContext(unitName="egovernment")
    EntityManager em;
    public PostGestion() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addReceipt(Poste receipt) {
		try {
			em.persist(receipt);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Poste findReceiptByCin(int cin) {
		Poste p = null;
		Query qr;
		try {
			qr= em.createQuery("SELECT c FROM Poste c WHERE c.cin=:cin");
			qr.setParameter("cin", cin);
			p=(Poste) qr.getSingleResult();
			return p;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return p;
	}

	@Override
	public Boolean deleteReceipt(int id) {
		
		Poste p;
		try {
			
			p = findReceiptById(id);
			
			em.remove(em.merge(p));
			
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public Poste findReceiptById(int id) {
		Poste p = null;
		Query qr;
		try {
			qr= em.createQuery("SELECT c FROM Poste c WHERE c.id=:id");
			qr.setParameter("id", id);
			p=(Poste) qr.getSingleResult();
			return p;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return p;
	}

	
}
