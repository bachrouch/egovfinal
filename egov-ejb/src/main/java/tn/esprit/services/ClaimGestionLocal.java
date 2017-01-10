package tn.esprit.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.domain.Reclamation;

@Local
public interface ClaimGestionLocal {
	
	Boolean addClaim(Reclamation rec);
	List<Reclamation> findReclamationByType(String type);
	Boolean deleteClaim(int id);
	Reclamation findClaimById(int id);
	public List<Reclamation> chercherReclamation();
	public void deleteClaim(Reclamation reclamation);

}
