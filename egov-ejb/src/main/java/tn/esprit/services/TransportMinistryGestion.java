package tn.esprit.services;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.ejb3.annotation.Clustered;

import tn.esprit.domain.Bus;
import tn.esprit.domain.Request;
import tn.esprit.domain.transportMinistry;


@Stateful
@Clustered
@Remote(TransportMinistryGestion.class)

public class TransportMinistryGestion implements TransportMinistryGestionRemote, TransportMinistryGestionLocal {

	@PersistenceContext(name="egovernment")
	EntityManager entityManager;
	
    public TransportMinistryGestion() {
        // TODO Auto-generated constructor stub
    }
/*
    public List<Request> findRequestByDepartement() {
*/


	@Override
	public List<Request> viewrequestsub(String service,int etat) {
		String requete="select t from Request t where (t.service=:p)  and( t.etat=:e)";
		return entityManager.createQuery(requete,Request.class)
				.setParameter("p", service)
				.setParameter("e", etat)
				.getResultList();
			
		}

	@Override
	public List<Request> viewrequestve() {
		Query qr;
		qr= entityManager.createQuery("select R from request  R");//Car sticker
	
		
		return qr.getResultList();
	
	}

	@Override
	public boolean ReponseRequestsub(Request request) {
		try {
			entityManager.merge(request);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean ReponseRequestve(Request request) {
		try {
			entityManager.merge(request);
			return true;
		} catch (Exception e) {
			return false;
		}
	}




	@Override
	public transportMinistry informationcitzensub(int cin) {

		transportMinistry tran= null;
		Query qr;
		try {
			qr= entityManager.createQuery("SELECT t FROM transportMinistry t WHERE t.cin=:cin");
			qr.setParameter("cin", cin);
			tran=(transportMinistry) qr.getSingleResult();
			return tran;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tran;
	}




	@Override
	public transportMinistry informationcar(int cin) {
		transportMinistry tran= null;
		Query qr;
		try {
			qr= entityManager.createQuery("SELECT t FROM transportMinistry t WHERE t.cin=:cin");
			qr.setParameter("cin", cin);
			tran=(transportMinistry) qr.getSingleResult();
			return tran;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tran;
	}


	@Override
	public Boolean RequestDone(int id) {
		Request rec=null;
		try {
			rec=findRequestById(id);
			rec.setEtat(1);
			entityManager.persist(rec);
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	@Override
	public Request findRequestById(int id) {
		Request req= null;
		try {
			req = entityManager.find(Request.class, id);
			return req;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return req;
	}
	@Override
	public List<Bus> ViewBus() {

				return entityManager.createQuery("select b from Bus b",Bus.class)
						.getResultList();
				}


	@Override
	public boolean addBus(Bus bus) {
	
	
		try {
	 entityManager.persist(bus);
				return true;	
		} catch (Exception e) {
			System.out.println("false");
			return false ;
		
		}
	
	}
	@Override
	public boolean updateBus(Bus bus) {
		try {
	 entityManager.merge(bus);
				return true;	
		} catch (Exception e) {
			System.out.println("false");
			return false ;
		
		}
	}
	@Override
	public boolean removeBus(Bus bus) {
		try {
			entityManager.remove(entityManager.merge(bus));
				return true;	
		} catch (Exception e) {
			System.out.println("false");
			return false ;
		
		}
		
	
	}


	@Override
	public Bus findlineBus(int cin) {
		System.out.println(cin);
	/*Bus bus =null ;
		Query qr;
		qr= entityManager.createQuery("SELECT b FROM bus b WHERE b.cin=:cin", Bus.class); //WHERE b.cin=:(SELECT request.cin FROM request r  WHERE r.id=:id)  ", Bus.class);
		qr.setParameter("cin", ccin);

		bus=(Bus) qr.getSingleResult();
		return bus ;*/
	Bus bus= null;
		Query qr;
		try {
			qr= entityManager.createQuery("SELECT b FROM bus b WHERE b.cin=:cin");
			qr.setParameter("cin", cin);
			bus=(Bus) qr.getSingleResult();
			return bus;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bus;
	}




	
	
	
	}






		




