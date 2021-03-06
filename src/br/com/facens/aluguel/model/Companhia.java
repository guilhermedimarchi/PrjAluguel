package br.com.facens.aluguel.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Companhia {
	@Id
	private int id;
	private String nome;
	@OneToMany(cascade=CascadeType.REMOVE)
	private Collection <Contrato> contratos = new ArrayList<Contrato>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	

	
	public Collection<Contrato> getContratos() {
		return contratos;
	}
	public void setContratos(Collection<Contrato> contratos) {
		this.contratos = contratos;
	}
	public void addContrato(Contrato contrato)
	{
		contratos.add(contrato);
	}
	@Override
	public String toString() {
		return "Compania [id=" + id + ", nome=" + nome + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Companhia other = (Companhia) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
    
	
	
	

}
