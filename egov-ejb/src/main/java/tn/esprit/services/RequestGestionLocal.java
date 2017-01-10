package tn.esprit.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.domain.Citizen;
import tn.esprit.domain.Request;

@Local
public interface RequestGestionLocal {
	public List<Request> findRequestByDepartement(String departement);
	public List<Request> findRequestByDepartementState(String departement);
	
	public List<Request> findRequestByType(String service);

	public Request findRequestById(int id);

	public Boolean RequestDone(int id);

	public Boolean addRequest(Request req);

	public List<Request> affichageRequest();

	public List<Request> findRequestByCin(int cin);

	public List<Citizen> findCitizienByCin(int cin);

	public Citizen findCitizienCin(int cin);
}
