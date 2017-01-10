package edu.esprit.managedBeans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.domain.Agent;
import tn.esprit.domain.Request;
import tn.esprit.services.AgentGestionLocal;

@ManagedBean
@SessionScoped
public class GestionAgentBean {
	private static String login;
	private static String password;
	public static int idAgent;
	private static Agent agent;
	@EJB
	static
	AgentGestionLocal agentService;
	
	
	@PostConstruct
	public void init() {
		agent = new Agent();
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	
	public static String doLogin(String login1,String password1) {

		String navigateTo = null;
		if(	 agentService.Authentification(login1, password1)!=null)
			agent = agentService.Authentification(login1, password1);

		if(agent!=null)
				navigateTo = "/agent/dashboard?faces-redirect=true";
			idAgent = agent.getId();

		
		return navigateTo ;
	}
	
}
