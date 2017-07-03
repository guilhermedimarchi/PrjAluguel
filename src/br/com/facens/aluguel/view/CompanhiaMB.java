package br.com.facens.aluguel.view;


import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.facens.aluguel.business.CompanhiaBusiness;
import br.com.facens.aluguel.business.CompanhiaBusiness.MensagemEnum;
import br.com.facens.aluguel.model.Cliente;
import br.com.facens.aluguel.model.Companhia;
import br.com.facens.aluguel.model.Contrato;
import br.com.facens.aluguel.util.JSFUtil;

@ManagedBean
@ViewScoped
public class CompanhiaMB implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id = 1;
	private Companhia companhia = new Companhia();
	CompanhiaBusiness cb = new CompanhiaBusiness();
	

	public CompanhiaMB()
	{
		this.atualizaId();
	}
	
	public void atualizaId()
	{
		List<Companhia> lista =cb.getAllCompanhias() ;
		int tam = lista.size();
		
		if(tam==0)
		{
			companhia.setId(id++);
		}
		else
		{
			id = lista.get(tam-1).getId()+1;
			companhia.setId(id);
		}
		
	}

	
	public Companhia getCompanhia() {
		return companhia;
	}

	public void setCompanhia(Companhia companhia) {
		this.companhia = companhia;
	}

	public void salvar() {
		
		if(cb.salvarCompanhia(companhia) == MensagemEnum.SUCESSO){
			System.out.println("Sucesso!");	
			companhia = new Companhia();
			this.atualizaId();
		}
		else{
			System.out.println("Erro!");
		}
		
		JSFUtil.addMessage("br.com.facens.aluguel.controller.CompanhiaMB.idMensagem",cb.getMsg());
	}
	
	public void deletar(Companhia cli){
		if(cb.deletarCompanhia(cli) == MensagemEnum.SUCESSO){
			System.out.println("Sucesso!");	
			companhia = new Companhia();
			this.atualizaId();
		}
		else{
			System.out.println("Erro!");
		}
		JSFUtil.addMessage("br.com.facens.aluguel.controller.CompanhiaMB.idMensagem",cb.getMsg());
	}
	
	public void pesquisar()
	{
		 Companhia cli = cb.pesquisar(companhia.getId());
		 if(cli != null)
			 companhia = cli;
	}
	
	public List<Companhia> getCompanhias()
	{
		 return cb.getAllCompanhias();
	}
	
	public void atualizar()
	{
		if(cb.atualizar(companhia) == MensagemEnum.SUCESSO){
			System.out.println("Sucesso!");	
			companhia = new Companhia();
			this.atualizaId();
		}
		else{
			System.out.println("Erro!");
		}
		
		JSFUtil.addMessage("br.com.facens.aluguel.controller.CompanhiaMB.idMensagem",cb.getMsg());
	}
	
	public void atualizarContrato(Companhia comp,Contrato contrato) {
		companhia = comp;
		companhia.addContrato(contrato);
		atualizar();
		companhia = new Companhia();
		atualizaId();
	}

}
