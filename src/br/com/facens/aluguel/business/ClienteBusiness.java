package br.com.facens.aluguel.business;


import java.util.List;

import br.com.facens.aluguel.business.ClienteBusiness.MensagemEnum;
import br.com.facens.aluguel.model.Cliente;
import br.com.facens.aluguel.services.ClienteService;

public class ClienteBusiness {
	
	
	public enum MensagemEnum { SUCESSO, ERROR };
	private String msg;

	public MensagemEnum salvarCliente(Cliente cliente)
	{
	    MensagemEnum retorno;
		
		if(cliente == null){
			msg= "br.com.facens.aluguel.business.clienteNullError";
			retorno = MensagemEnum.ERROR;
		}
		else
		{
			if(cliente.getNome().length() < 5)
			{
				msg = "br.com.facens.aluguel.business.clienteSizeError";
				retorno = MensagemEnum.ERROR;
			}
			else
			{
				if(cliente.getNome().split(" ").length < 2)
				{
					msg = "br.com.facens.aluguel.business.clienteSobrenomeError";
					retorno = MensagemEnum.ERROR;
				}
				else
				{
					   ClienteService clienteService = new ClienteService();
					   if(clienteService.save(cliente))
					   {
					      retorno = MensagemEnum.SUCESSO;
					      msg =  "br.com.facens.aluguel.business.clienteSucesso";
					   }
					   else
					   {
						  retorno = MensagemEnum.ERROR;
						  msg =  "br.com.facens.aluguel.business.erroBanco";
					   }
				}
			}
		}
	   return retorno;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<Cliente> getAllClientes() {
		 
		ClienteService clienteService = new ClienteService();
		return clienteService.getAllClientes();
	}

	public MensagemEnum deletarCliente(Cliente cli) {
		MensagemEnum retorno;
		ClienteService clienteService = new ClienteService();
		if(clienteService.delete(cli))
			retorno = MensagemEnum.SUCESSO;
		else
			retorno = MensagemEnum.ERROR;
		return retorno;
	}

	public Cliente pesquisar(int id) {
		
		ClienteService clienteService = new ClienteService();
		Cliente cli = new Cliente();
		cli = clienteService.pesquisar(id);
		return cli;
	}

	public MensagemEnum atualizar(Cliente cliente)
	{
		MensagemEnum retorno;
				
				if(cliente == null){
					msg= "br.com.facens.aluguel.business.clienteNullError";
					retorno = MensagemEnum.ERROR;
				}
				else
				{
					   ClienteService clienteService = new ClienteService();
					   if(clienteService.atualizar(cliente))
					   {
					      retorno = MensagemEnum.SUCESSO;
					      msg =  "br.com.facens.aluguel.business.clienteSucesso";
					   }
					   else
					   {
						  retorno = MensagemEnum.ERROR;
						  msg =  "br.com.facens.aluguel.business.erroBanco";
					   }
				}
			   return retorno;
	}
	
}
