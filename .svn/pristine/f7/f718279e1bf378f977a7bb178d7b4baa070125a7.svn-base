package br.com.facens.aluguel.business;

import java.util.List;

import br.com.facens.aluguel.business.CompanhiaBusiness.MensagemEnum;
import br.com.facens.aluguel.model.Companhia;
import br.com.facens.aluguel.services.CompanhiaService;

public class CompanhiaBusiness {

	public enum MensagemEnum {
		SUCESSO, ERROR
	};

	private String msg;

	public MensagemEnum salvarCompanhia(Companhia companhia) {
		MensagemEnum retorno;

		if (companhia == null) {
			msg = "br.com.facens.aluguel.business.companhiaNullError";
			retorno = MensagemEnum.ERROR;
		} else {
			CompanhiaService companhiaService = new CompanhiaService();
			if (companhiaService.save(companhia)) {
				retorno = MensagemEnum.SUCESSO;
				msg = "br.com.facens.aluguel.business.companhiaSucesso";
			} else {
				retorno = MensagemEnum.ERROR;
				msg = "br.com.facens.aluguel.business.erroBanco";
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

	public List<Companhia> getAllCompanhias() {

		CompanhiaService companhiaService = new CompanhiaService();
		return companhiaService.getAllCompanhias();
	}

	public MensagemEnum deletarCompanhia(Companhia cli) {
		MensagemEnum retorno;
		CompanhiaService companhiaService = new CompanhiaService();
		if (companhiaService.delete(cli))
			retorno = MensagemEnum.SUCESSO;
		else
			retorno = MensagemEnum.ERROR;
		return retorno;
	}

	public Companhia pesquisar(int id) {

		CompanhiaService companhiaService = new CompanhiaService();
		Companhia cli = new Companhia();
		cli = companhiaService.pesquisar(id);
		return cli;
	}

	public MensagemEnum atualizar(Companhia companhia) {
		MensagemEnum retorno;

		if (companhia == null) {
			msg = "br.com.facens.aluguel.business.companhiaNullError";
			retorno = MensagemEnum.ERROR;
		} else {
			CompanhiaService companhiaService = new CompanhiaService();
			if (companhiaService.atualizar(companhia)) {
				retorno = MensagemEnum.SUCESSO;
				msg = "br.com.facens.aluguel.business.companhiaSucesso";
			} else {
				retorno = MensagemEnum.ERROR;
				msg = "br.com.facens.aluguel.business.erroBanco";
			}

		}
		return retorno;
	}

}
