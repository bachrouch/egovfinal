package tn.esprit.services;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.ejb3.annotation.Clustered;

import tn.esprit.domain.Agent;
import tn.esprit.domain.Citizen;
import tn.esprit.domain.Request;

@Stateful
@Clustered
@Remote(AgentGestionRemote.class)
@LocalBean

public class AgentGestion implements AgentGestionRemote, AgentGestionLocal {

	@PersistenceContext(name="egovernment")
    EntityManager entityManager;
	@Override
	public Agent Authentification(String login, String pwd) {
		String requete="select e from Agent e where e.login=:l and e.pwd=:p";
		Agent agent=null;
		try{
		Query query = entityManager.createQuery(requete).setParameter("l", login).setParameter("p",pwd);
		
		
		agent = (Agent) query.getSingleResult();
		System.out.println(agent.getLogin());
		return agent;
		}catch(NoResultException ex){
		 System.out.println("no result found for query");
	}
		return agent;
		
		
	}
	@Override
	public Agent findAgentById(int id) {
		Agent agent = null;
		try {
			Query queryBCbyCin = entityManager.createQuery("SELECT m FROM Agent m WHERE m.id= :id");
			queryBCbyCin.setParameter("id", id);
			agent = (Agent) queryBCbyCin.getSingleResult();
			return agent;
		} catch (Exception e) {
			System.out.println(e);
		}
		return agent;
	}
	@Override
	public void sauvegarderUtilisateur(Request citizen) {
		// TODO Auto-generated method stub
		
		entityManager.merge(citizen);
		
		
	}

}
