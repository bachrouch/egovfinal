package tn.esprit.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.domain.Reclamation;

@Remote
public interface ClaimGestionRemote {
	Boolean addClaim(Reclamation rec);
	Boolean deleteClaim(int id);
	Reclamation findClaimById(int id);
	List<Reclamation> findReclamationByType(String type);

}
