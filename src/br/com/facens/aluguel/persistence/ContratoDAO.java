package br.com.facens.aluguel.persistence;

import javax.persistence.EntityManager;

import br.com.facens.aluguel.model.Contrato;

public class ContratoDAO extends GenericDAO<Integer, Contrato>{

	public ContratoDAO(EntityManager entityManager) {
	    super(entityManager);
	}

}




