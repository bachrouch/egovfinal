package tn.esprit.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.domain.Agent;
import tn.esprit.domain.Reclamation;

@Remote
public interface AdminGestionRemote {
	 public List<Reclamation> findReclamationByType();
	 boolean deleteClaim(int id);
	 public List<Agent> findAgent();
	 boolean deleteAgent(int id);
	 boolean updateAgent(int id, String login, String pwd, String role);
	 boolean addAgent(Agent agent);
	 Agent findAgentById(int id);
	 Reclamation findClaimById(int id);
	 List<Agent> findAgentByRole(String role);
}

