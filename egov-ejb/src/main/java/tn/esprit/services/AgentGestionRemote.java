package tn.esprit.services;

import javax.ejb.Remote;

import tn.esprit.domain.Agent;

@Remote
public interface AgentGestionRemote {
	public Agent Authentification(String login , String pwd);
	public Agent findAgentById(int id);
}
