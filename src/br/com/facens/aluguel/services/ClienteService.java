package br.com.facens.aluguel.services;


import java.util.List;



import br.com.facens.aluguel.model.Cliente;
import br.com.facens.aluguel.persistence.ClienteDAO;
import br.com.facens.aluguel.persistence.MyEntityManager;

public class ClienteService {
	
	private ClienteDAO clienteDAO;
	private MyEntityManager myEntityManager;
	
	
	public ClienteService()
	{
		this.myEntityManager = new MyEntityManager();
		clienteDAO = new ClienteDAO(myEntityManager.getEntityManager());
		
	}
	
	 public boolean save(Cliente cliente){
		    boolean retorno = false;
		    
	        try{
	            myEntityManager.beginTransaction();
	            clienteDAO.save(cliente);
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
	 public boolean delete(Cliente cli)
	 {
		 boolean retorno = false;
		 
		 try{
	            myEntityManager.beginTransaction();
	            cli = clienteDAO.getById(cli.getId(), Cliente.class);
	            clienteDAO.delete(cli);
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
	 
	public List<Cliente> getAllClientes() {
		
		return clienteDAO.findAll(Cliente.class);
	}

	public Cliente pesquisar(int id) {

		Cliente c = new Cliente();
		try{
            myEntityManager.beginTransaction();
            c = clienteDAO.getById(id, Cliente.class);
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
	
	public boolean atualizar(Cliente cliente)
	{
		boolean retorno = false;
		try{
            myEntityManager.beginTransaction();
            clienteDAO.update(cliente);
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
