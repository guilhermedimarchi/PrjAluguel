package br.com.facens.aluguel.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.facens.aluguel.util.JSFUtil;


@SuppressWarnings("unchecked")
public class GenericDAO <PK, T>{

    private EntityManager entityManager;
    
 
    public GenericDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
 
   
	public T getById(PK pk, Class <T> classe) {
        return (T) entityManager.find(classe, pk);
    }
 
    public void save(T entity) {
        entityManager.persist(entity);
    }
 
    public void update(T entity) {
        entityManager.merge(entity);
    }
 
    public void delete(T entity) {
        entityManager.remove(entity);
    }
 
    public List<T> findAll(Class <T> classe) {
    	return entityManager.createQuery("Select obj FROM " + classe.getSimpleName() + " as obj").getResultList();
    }
	
}