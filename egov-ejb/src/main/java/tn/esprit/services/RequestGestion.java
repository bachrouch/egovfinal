package tn.esprit.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.ejb3.annotation.Clustered;

import tn.esprit.domain.Citizen;
import tn.esprit.domain.Reclamation;
import tn.esprit.domain.Request;

/**
 * Session Bean implementation class RequestGestion
 */
@Stateful
@Clustered
@Remote(RequestGestionRemote.class)

@LocalBean
public class RequestGestion implements RequestGestionRemote, RequestGestionLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="egovernment")
    EntityManager em;
    public RequestGestion() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Request> findRequestByDepartement(String departement) {
		String requete="select t from Request t where t.departement=:departement";
		return em.createQuery(requete).setParameter("departement", departement).getResultList();
        
	}

	@Override
	public List<Request> findRequestByType(String service) {
		Query qr;
		qr= em.createQuery("select t from Request t where t.service=:service");
        qr.setParameter("service", service);
		
		return qr.getResultList();
			
	}

	@Override
	public Request findRequestById(int id) {
		Request rec = null;
		Query qr;
		try {
			qr= em.createQuery("SELECT c FROM Request c WHERE c.id=:id");
			qr.setParameter("id", id);
			rec=(Request) qr.getSingleResult();
			return rec;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Boolean RequestDone(int id) {
		
		return false;
	

}
	public Boolean addRequest(Request req) {
		try {
			em.persist(req);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Request> affichageRequest() {
		Query qr;
		qr= em.createQuery("select t from Request t ");
     
		
		return qr.getResultList();
			

	}
	
	
	@Override
	public List<Request> findRequestByCin(int cin) {
	
		Query qr;
		try {
			qr= em.createQuery("SELECT c FROM Request c WHERE c.cin=:cin ");
			qr.setParameter("cin", cin);
			
			return qr.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public List<Citizen> findCitizienByCin(int cin) {
	
		Query qr;
		try {
			qr= em.createQuery("SELECT c FROM Citizen c WHERE c.cin=:cin");
			qr.setParameter("cin", cin);
			
			return qr.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Citizen findCitizienCin(int cin) {
		Query qr;
		try {
			qr= em.createQuery("SELECT c FROM Citizen c WHERE c.cin=:cin ",Citizen.class);
			qr.setParameter("cin", cin);
		
			
			
			return (Citizen) qr.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Request> findRequestByDepartementState(String departement) {
		
		String requete="select t from Request t where t.departement=:departement and t.etat='0'";
		return em.createQuery(requete).setParameter("departement", departement).getResultList();
        
	}
	

}
