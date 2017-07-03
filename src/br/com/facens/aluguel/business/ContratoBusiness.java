package br.com.facens.aluguel.business;


import java.util.List;

import br.com.facens.aluguel.model.Contrato;
import br.com.facens.aluguel.services.ContratoService;

public class ContratoBusiness {
	
	
	public enum MensagemEnum { SUCESSO, ERROR };
	private String msg;

	public MensagemEnum atualizar(Contrato contrato)
	{
		MensagemEnum retorno;
				
			  ContratoService contratoService = new ContratoService();
					   if(contratoService.atualizar(contrato))
					   {
					      retorno = MensagemEnum.SUCESSO;
					      msg =  "br.com.facens.aluguel.business.contratoSucesso";
					   }
					   else
					   {
						  retorno = MensagemEnum.ERROR;
						  msg =  "br.com.facens.aluguel.business.erroBanco";
					   }
			
			   return retorno;
	}
	
	
	
	public MensagemEnum salvarContrato(Contrato contrato)
	{ 
		MensagemEnum retorno;
	
		   ContratoService contratoService = new ContratoService();
		   if(contratoService.save(contrato))
		   {
		      retorno = MensagemEnum.SUCESSO;
		      msg =  "br.com.facens.aluguel.business.contratoSucesso";
		   }
		   else
		   {
			  retorno = MensagemEnum.ERROR;
			  msg =  "br.com.facens.aluguel.business.erroBanco";
		   }
			
	   return retorno;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<Contrato> getAllContratos() {
		 
		ContratoService contratoService = new ContratoService();
		return contratoService.getAllContratos();
	}

	public MensagemEnum deletarContrato(Contrato cli) {
		MensagemEnum retorno;
		ContratoService contratoService = new ContratoService();
		if(contratoService.delete(cli))
			retorno = MensagemEnum.SUCESSO;
		else
			retorno = MensagemEnum.ERROR;
		return retorno;
	}

	public Contrato pesquisar(int id) {
		
		ContratoService contratoService = new ContratoService();
		Contrato cli = new Contrato();
		cli = contratoService.pesquisar(id);
		return cli;
	}


	
}
