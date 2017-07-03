package br.com.facens.aluguel.services;


import java.util.List;
import br.com.facens.aluguel.model.Contrato;
import br.com.facens.aluguel.persistence.ContratoDAO;
import br.com.facens.aluguel.persistence.MyEntityManager;

public class ContratoService {
	
	private ContratoDAO contratoDAO;
	private MyEntityManager myEntityManager;
	
	
	public ContratoService()
	{
		this.myEntityManager = new MyEntityManager();
		contratoDAO = new ContratoDAO(myEntityManager.getEntityManager());
		
	}

	public boolean atualizar(Contrato contrato)
	{
		boolean retorno = false;
		try{
            myEntityManager.beginTransaction();
            contratoDAO.update(contrato);
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
	
	 public boolean save(Contrato contrato){
		    boolean retorno = false;
		    
	        try{
	            myEntityManager.beginTransaction();
	            contratoDAO.save(contrato);
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
	 public boolean delete(Contrato cli)
	 {
		 boolean retorno = false;
		 
		 try{
	            myEntityManager.beginTransaction();
	            cli = contratoDAO.getById(cli.getId(), Contrato.class);
	            contratoDAO.delete(cli);
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
	 
	public List<Contrato> getAllContratos() {
		
		return contratoDAO.findAll(Contrato.class);
	}

	public Contrato pesquisar(int id) {

		Contrato c = new Contrato();
		try{
            myEntityManager.beginTransaction();
            c = contratoDAO.getById(id, Contrato.class);
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
	
	
}
