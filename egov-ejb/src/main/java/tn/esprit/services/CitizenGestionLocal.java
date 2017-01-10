package tn.esprit.services;



import java.util.List;

import javax.ejb.Local;

import tn.esprit.domain.Citizen;

@Local
public interface CitizenGestionLocal {
	public Citizen Authentification(String login , String pwd);
	public Boolean inscription(Citizen citizen);
	public Boolean update(Citizen citizen);
	public Citizen recuppererMotDePasse(String email);
}
