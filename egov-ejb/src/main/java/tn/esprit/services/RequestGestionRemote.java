package tn.esprit.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.domain.Request;

@Remote
public interface RequestGestionRemote {
	public List<Request> findRequestByDepartement(String departement);
	public List<Request> findRequestByType(String service);
	public Request findRequestById(int id);
	public Boolean RequestDone(int id);

}
