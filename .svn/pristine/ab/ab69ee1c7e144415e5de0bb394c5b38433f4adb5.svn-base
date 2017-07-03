package br.com.facens.aluguel.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.facens.aluguel.model.Veiculo;

public class MyEntityManager {

	private EntityManager entityManager;
    private static EntityManagerFactory factory;
     
     
    public MyEntityManager(){
      if(factory ==null)
           factory = Persistence.createEntityManagerFactory("PrAluguel");    //Isso deve ser melhorado!!!!
    }
 
    
    
    public void beginTransaction(){
       
        entityManager.getTransaction().begin();
    }
     
    public void commit(){
        entityManager.getTransaction().commit();
    }
    
    public void close(){
        entityManager.close();
    }
    
    public void closeFactory()
    {
    	factory.close();
    }
     
    public void rollBack(){
        entityManager.getTransaction().rollback();
    }
    
    public void merge(Veiculo v){
        entityManager.merge(v);
    }
      
    public EntityManager getEntityManager(){
    	this.entityManager = factory.createEntityManager();
        return entityManager;
    }
    
}