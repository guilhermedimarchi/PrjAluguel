package br.com.facens.aluguel.view;


import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.facens.aluguel.business.ClienteBusiness;
import br.com.facens.aluguel.business.ClienteBusiness.MensagemEnum;
import br.com.facens.aluguel.model.Cliente;
import br.com.facens.aluguel.model.Contrato;
import br.com.facens.aluguel.util.JSFUtil;

@ManagedBean
@ViewScoped
public class ClienteMB implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id = 1;
	private Cliente cliente = new Cliente();
	ClienteBusiness cb = new ClienteBusiness();
	

	public ClienteMB()
	{
		this.atualizaId();
	}
	
	public void atualizaId()
	{
		List<Cliente> lista =cb.getAllClientes() ;
		int tam = lista.size();
		
		if(tam==0)
		{
			cliente.setId(id++);
		}
		else
		{
			id = lista.get(tam-1).getId()+1;
			cliente.setId(id);
		}
	}

	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void salvar() {
		//addContrato();
		if(cb.salvarCliente(cliente) == MensagemEnum.SUCESSO){
			System.out.println("Sucesso!");
			
			cliente = new Cliente();
			this.atualizaId();
		}
		else{
			System.out.println("Erro!");
		}
		
		JSFUtil.addMessage("br.com.facens.aluguel.controller.ClienteMB.idMensagem",cb.getMsg());
	}
	
	public void deletar(Cliente cli){
		if(cb.deletarCliente(cli) == MensagemEnum.SUCESSO){
			System.out.println("Sucesso!");	
			cliente = new Cliente();
			this.atualizaId();
		}
		else{
			System.out.println("Erro!");
		}
		JSFUtil.addMessage("br.com.facens.aluguel.controller.ClienteMB.idMensagem",cb.getMsg());
	}
	
	public void pesquisar()
	{
		 Cliente cli = cb.pesquisar(cliente.getId());
		 if(cli != null)
			 cliente = cli;
	}
	
	public List<Cliente> getClientes()
	{
		 return cb.getAllClientes();
	}
	
	public void atualizar()
	{
		if(cb.atualizar(cliente) == MensagemEnum.SUCESSO){
			System.out.println("Sucesso!");	
			cliente = new Cliente();
			this.atualizaId();
		}
		else{
			System.out.println("Erro!");
		}
		
		JSFUtil.addMessage("br.com.facens.aluguel.controller.ClienteMB.idMensagem",cb.getMsg());
	}
	/*
	public void addContrato()
	{
		Contrato contrato = new Contrato();
		contrato.setId(1);
		contrato.setCliente(cliente);
		cliente.addContrato(contrato);
		
		Contrato contrato2 = new Contrato();
		contrato2.setId(2);
		contrato2.setCliente(cliente);
		cliente.addContrato(contrato2);
		
		
		System.out.println(contrato);
		
		
	}
	*/

	public void atualizarContrato(Cliente cli,Contrato contrato) {
		cliente = cli;
		cliente.addContrato(contrato);
		atualizar();
		cliente = new Cliente();
		atualizaId();
	}

}
