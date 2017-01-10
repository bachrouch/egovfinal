package tn.esprit.services;

import javax.ejb.Remote;

import tn.esprit.domain.Poste;

@Remote
public interface PostGestionRemote {
	Boolean addReceipt(Poste receipt);
	Boolean deleteReceipt(int id);
	Poste findReceiptById(int id);
	Poste findReceiptByCin(int cin);
	

}
