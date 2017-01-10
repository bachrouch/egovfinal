package tn.esprit.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.domain.Bus;
import tn.esprit.domain.Reclamation;
import tn.esprit.domain.Request;
import tn.esprit.domain.transportMinistry;

@Remote
public interface TransportMinistryGestionRemote {

	boolean ReponseRequestsub(Request request);

	boolean ReponseRequestve(Request request);

	List<Request> viewrequestsub(String departement,int etat);

	List<Request> viewrequestve();
	transportMinistry  informationcitzensub( int cin);
	transportMinistry  informationcar( int cin);
	public Boolean RequestDone(int id) ;
	public Request findRequestById(int id);
	public List<Bus> ViewBus();
	public boolean addBus(Bus bus);
	public boolean removeBus(Bus bus);
	public boolean updateBus(Bus bus) ;
	public  Bus findlineBus(int id);

}
