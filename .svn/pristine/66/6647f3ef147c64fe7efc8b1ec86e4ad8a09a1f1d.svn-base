package br.com.facens.aluguel.services;


import java.util.List;



import br.com.facens.aluguel.model.Companhia;
import br.com.facens.aluguel.persistence.CompanhiaDAO;
import br.com.facens.aluguel.persistence.MyEntityManager;

public class CompanhiaService {
	
	private CompanhiaDAO companhiaDAO;
	private MyEntityManager myEntityManager;
	
	
	public CompanhiaService()
	{
		this.myEntityManager = new MyEntityManager();
		companhiaDAO = new CompanhiaDAO(myEntityManager.getEntityManager());
		
	}
	
	 public boolean save(Companhia companhia){
		    boolean retorno = false;
		    
	        try{
	            myEntityManager.beginTransaction();
	            companhiaDAO.save(companhia);
	            myEntityManager.commit();
	            retorno = true;
	        }catch(Exception e){
	            e.printStackTrace();
	            myEntityManager.rollBack();
	        }
	        finally
	        {
	        	myEntityManager.close();
	        }
	        
	        return retorno;
	    }
	 public boolean delete(Companhia cli)
	 {
		 boolean retorno = false;
		 
		 try{
	            myEntityManager.beginTransaction();
	            cli = companhiaDAO.getById(cli.getId(), Companhia.class);
	            companhiaDAO.delete(cli);
	            myEntityManager.commit();
	            retorno = true;
	        }catch(Exception e){
	            e.printStackTrace();
	            myEntityManager.rollBack();
	        }
	        finally
	        {
	        	myEntityManager.close();
	        }
		 return retorno;
	 }
	 
	public List<Companhia> getAllCompanhias() {
		
		return companhiaDAO.findAll(Companhia.class);
	}

	public Companhia pesquisar(int id) {

		Companhia c = new Companhia();
		try{
            myEntityManager.beginTransaction();
            c = companhiaDAO.getById(id, Companhia.class);
        }catch(Exception e){
            e.printStackTrace();
            myEntityManager.rollBack();
        }
        finally
        {
        	myEntityManager.close();
        }
		return c;
	}
	
	public boolean atualizar(Companhia companhia)
	{
		boolean retorno = false;
		try{
            myEntityManager.beginTransaction();
            companhiaDAO.update(companhia);
            myEntityManager.commit();
            retorno = true;
        }catch(Exception e){
            e.printStackTrace();
            myEntityManager.rollBack();
        }
        finally
        {
        	myEntityManager.close();
        }
		return retorno;
	}
	
}
