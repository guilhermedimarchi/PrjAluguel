package br.com.facens.aluguel.view;


import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Convert;

import org.primefaces.event.FlowEvent;



import br.com.facens.aluguel.business.ContratoBusiness;
import br.com.facens.aluguel.business.ContratoBusiness.MensagemEnum;
import br.com.facens.aluguel.model.Caminhao;
import br.com.facens.aluguel.model.CarroPasseio;
import br.com.facens.aluguel.model.CarroSport;
import br.com.facens.aluguel.model.Cliente;
import br.com.facens.aluguel.model.Companhia;
import br.com.facens.aluguel.model.Contrato;
import br.com.facens.aluguel.model.Veiculo;
import br.com.facens.aluguel.util.JSFUtil;

@ManagedBean
@ViewScoped
public class ContratoMB implements Serializable{

	
	private Contrato contrato = new Contrato();
	private Cliente cliente = new Cliente();
	private Companhia companhia = new Companhia();
	/*private CarroSport carrosport = new CarroSport();
	private CarroPasseio carropasseio = new CarroPasseio();
	private Caminhao caminhao = new Caminhao();*/
	ContratoBusiness cb = new ContratoBusiness();
	ClienteMB clientemb = new ClienteMB();
	CompanhiaMB companhiamb = new CompanhiaMB();
	private int qtdDias;
	private boolean validaBotao = false;
	private Date date;
	private double valorTotal;
	private int id = 1;
	private static final long serialVersionUID = 1L;
	
	public ContratoMB()
	{
		atualizaId();
	}

	
	public void selecionar(Cliente cli)
	{
		cliente = cli;
		contrato.setCliente(cliente);
		System.out.println(contrato);
		System.out.println("SELECIONOU CLIENTE");
		validaBotao = true;
		//SOMENTE PARA TESTES. ESTOU CRIANDO FUNCOES PARA IR ATRIBUINDO AS CARACTERISTICAS DO CONTRATO E SO NO BOTAL FINISH VIA EXECUTAR O SALVAR
		//salvar();
	}
	
	public void selecionarVeiculo(Veiculo vei)
	{
		if(vei.isDisponivel()==false)
		{
			System.out.println(vei);
			contrato.setVeiculo(vei);
			vei.setDisponivel(true);
			System.out.println("SELECIONOU VEICULO");
			validaBotao = true;
			
			//SOMENTE PARA TESTES. ESTOU CRIANDO FUNCOES PARA IR ATRIBUINDO AS CARACTERISTICAS DO CONTRATO E SO NO BOTAL FINISH VIA EXECUTAR O SALVAR
		}
		else
		{
			System.out.println("VEICULO NAO DISPONIVEL");
		}
	}

	
	public void selecionarCompanhia(Companhia comp)
	{
		companhia = comp;
		contrato.setCompania(companhia);
		System.out.println("SELECIONOU COMPANHIA");
		validaBotao = true;
		//salvar();
	}
	//FALTA FILTRAR SOMENTE CARROS AINDA NAO ALUGADOS!
	//OCULTAR BOTOES DE SELECIONAR QUANDO JA tiVER ESCOLHIDO
	//
	
	public void salvar() {
		
		//INCLUI O CONTRATO NA LISTA DO CLIENTE E COM ISSO JA ATUALIZA NO BD A TB CONTRATO
		clientemb.atualizarContrato(cliente, contrato);
		System.out.println(contrato);
		System.out.println("CONTRATO FEITO COM SUCESSO NO CLIENTE");
		
		
		companhiamb.atualizarContrato(companhia,contrato);
		System.out.println(companhia);
		System.out.println("CONTRATO FEITO COM SUCESSO NA COMPANHIA");
		
		VeiculoMB vb = new VeiculoMB();
		vb.atualizar(contrato.getVeiculo());
		
		contrato.setSituacao("FECHADO");
		cliente = new Cliente();
		companhia = new Companhia();
		contrato = new Contrato();

		atualizaId();
	}
	
	public void atualizaId()
	{
		List<Contrato> lista = cb.getAllContratos() ;
		int tam = lista.size();
		validaBotao = false;
		if(tam==0)
		{
			contrato.setId(id++);
		}
		else
		{
			id = lista.get(tam-1).getId()+1;
			contrato.setId(id);
		}
	}
	
	public String onFlowProcess(FlowEvent event) {
		validaBotao = false;
            return event.getNewStep();
        
            
    }
	public static Date addDays(Date date, int days) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
                 
        return cal.getTime();
    }
	public void valorTotal()
	{
		System.out.println(qtdDias);
		System.out.println(date);
	
		contrato.setDataInicio(date);
		
		contrato.setDataFim(addDays(date, qtdDias));
		
		
		System.out.println(contrato.getDataInicio());
		System.out.println(contrato.getDataFim());
		
	
		//System.out.println(contrato.getVeiculo().getValorDiaria());
		valorTotal = qtdDias * contrato.getVeiculo().getValorDiaria();
		
		
	}
	
	public void devolucao(Contrato c)
	{
		contrato = c;
		c.getVeiculo().setDisponivel(false);
		VeiculoMB vb = new VeiculoMB();
		vb.atualizar(c.getVeiculo());
		contrato.setSituacao("FECHADO");
		atualizar();
	}
	
	public void atualizar()
	{
		if(cb.atualizar(contrato) == MensagemEnum.SUCESSO){
			System.out.println("Sucesso!");	
			contrato = new Contrato();
			this.atualizaId();
		}
		else{
			System.out.println("Erro!");
		}
		
		JSFUtil.addMessage("br.com.facens.aluguel.controller.ClienteMB.idMensagem",cb.getMsg());
	}
	
	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public boolean isValidaBotao() {
		return validaBotao;
	}



	public void setValidaBotao(boolean validaBotao) {
		this.validaBotao = validaBotao;
	}



	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Companhia getCompanhia() {
		return companhia;
	}

	public void setCompanhia(Companhia companhia) {
		this.companhia = companhia;
	}

	public int getQtdDias() {
		return qtdDias;
	}

	public void setQtdDias(int qtdDias) {
		this.qtdDias = qtdDias;
		valorTotal();
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}	
	
	public List<Contrato> getContratos()
	{
		 return cb.getAllContratos();
	}
	
	
}
