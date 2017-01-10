package tn.esprit.services;

import javax.ejb.Local;

import tn.esprit.domain.Agent;
import tn.esprit.domain.Citizen;
import tn.esprit.domain.Request;

@Local
public interface AgentGestionLocal {
	public Agent Authentification(String login , String pwd);
	public Agent findAgentById(int id);
	void sauvegarderUtilisateur(Request citizen);

}
