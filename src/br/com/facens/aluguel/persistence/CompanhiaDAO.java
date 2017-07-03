package br.com.facens.aluguel.persistence;

import javax.persistence.EntityManager;

import br.com.facens.aluguel.model.Companhia;

public class CompanhiaDAO extends GenericDAO<Integer, Companhia>{

	public CompanhiaDAO(EntityManager entityManager) {
	    super(entityManager);
	}

}




