package br.com.facens.aluguel.services;


import java.util.List;



import br.com.facens.aluguel.model.Veiculo;
import br.com.facens.aluguel.persistence.VeiculoDAO;
import br.com.facens.aluguel.persistence.MyEntityManager;

public class VeiculoService {
	
	private VeiculoDAO VeiculoDAO;
	private MyEntityManager myEntityManager;
	
	
	public VeiculoService()
	{
		this.myEntityManager = new MyEntityManager();
		VeiculoDAO = new VeiculoDAO(myEntityManager.getEntityManager());
		
	}
	
	 public boolean save(Veiculo Veiculo){
		    boolean retorno = false;
		    
	        try{
	            myEntityManager.beginTransaction();
	            VeiculoDAO.save(Veiculo);
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
	 public List<Veiculo> getAllVeiculos() {
			
			return VeiculoDAO.findAll(Veiculo.class);
		}

	 /*
	 
	
	public Veiculo pesquisar(int id) {

		Veiculo c = new Veiculo();
		try{
            myEntityManager.beginTransaction();
            c = VeiculoDAO.getById(id, Veiculo.class);
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
	
	}*/
	 public boolean atualizar(Veiculo veiculo)
		{
		 
			boolean retorno = false;
			try{
	            myEntityManager.beginTransaction();
//	            myEntityManager.merge(veiculo);
	            VeiculoDAO.update(veiculo);
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
	 
	 public boolean delete(Veiculo veiculo)
	 {
		 boolean retorno = false;
		 
		 try{
	            myEntityManager.beginTransaction();
	            veiculo = VeiculoDAO.getById(veiculo.getId(), Veiculo.class);
	            VeiculoDAO.delete(veiculo);
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
