package tn.esprit.services;

import javax.ejb.Local;

import tn.esprit.domain.Poste;
import tn.esprit.domain.Reclamation;

@Local
public interface PostGestionLocal {
	
	Boolean addReceipt(Poste receipt);
	Boolean deleteReceipt(int id);
	Poste findReceiptById(int id);
	Poste findReceiptByCin(int cin);
	

}
