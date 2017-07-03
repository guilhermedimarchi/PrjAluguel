package br.com.facens.aluguel.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Contrato {
	
	@Id
	private int id;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Cliente cliente;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Companhia compania;

	@OneToOne(cascade=CascadeType.PERSIST)
	private Veiculo veiculo;
	
	private String situacao;
	
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	@Temporal(TemporalType.DATE)
	private Date dataFim;
	
	
	public Contrato()
	{
		situacao = "ABERTO";
		
	}
	public Contrato(Cliente cliente, Companhia compania)
	{
		situacao = "ABERTO";
		this.cliente  = cliente;
		this.compania = compania;
	}
	
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Companhia getCompania() {
		return compania;
	}
	public void setCompania(Companhia compania) {
		this.compania = compania;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	@Override
	public String toString() {
		return "Contrato [cliente=" + cliente + ", compania=" + compania
				+ ", veiculo=" + veiculo + "]";
	}
	
	
	

}
