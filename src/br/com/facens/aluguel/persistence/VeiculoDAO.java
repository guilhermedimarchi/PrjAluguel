package br.com.facens.aluguel.persistence;

import javax.persistence.EntityManager;

import br.com.facens.aluguel.model.Veiculo;

public class VeiculoDAO extends GenericDAO<Integer, Veiculo>{

	public VeiculoDAO(EntityManager entityManager) {
	    super(entityManager);
	}

}




