package tn.esprit.services;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.faces.flow.builder.ReturnBuilder;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.domain.Agent;
import tn.esprit.domain.Citizen;

@Stateful
public class CitizenGestion implements CitizenGestionLocal {
	@PersistenceContext(name = "egovernment")
	EntityManager entityManager;

	@Override
	public Citizen Authentification(String login, String pwd) {

		String requete = "select e from Citizen e where e.login=:l and e.pwd=:p";
		Citizen citizen = null;
		try {
			Query query = entityManager.createQuery(requete).setParameter("l", login).setParameter("p", pwd);

			citizen = (Citizen) query.getSingleResult();
			System.out.println(citizen.getLogin());
			return citizen;
		} catch (NoResultException ex) {
			System.out.println("no result found for query");
		}
		return citizen;
	}

	@Override
	public Boolean inscription(Citizen citizen) {
		try {
			entityManager.persist(citizen);
			return true;
		} catch (NoResultException ex) {
			System.out.println("false");
		}
		return true;
	}

	@Override
	public Boolean update(Citizen citizen) {
		try {	entityManager.merge(citizen);return true;}catch (NoResultException ex) {
			System.out.println("false");
		}
		return true;
	}

	@Override
	public Citizen recuppererMotDePasse(String email) {
		String requete = "select e from Citizen e where e.email=:email";
		Citizen citizen = null;
		try {
			Query query = entityManager.createQuery(requete).setParameter("email", email);

			citizen = (Citizen) query.getSingleResult();
			System.out.println(citizen.getLogin());
			return citizen;
		} catch (NoResultException ex) {
			System.out.println("no result found for query");
		}
		return citizen;
	}
}
