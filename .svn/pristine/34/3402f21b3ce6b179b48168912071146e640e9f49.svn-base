package br.com.facens.aluguel.model;

import javax.persistence.Entity;



@Entity
//@DiscriminatorValue(value="Caminhao")
public class Caminhao extends Veiculo{
	
	private double capacidadeMaxima;

	public Caminhao()
	{
		this.setTipo("Caminhao");
	}
	
	public double getCapacidadeMaxima() {
		return capacidadeMaxima;
	}

	
	public void setCapacidadeMaxima(double capacidadeMaxima) {
		this.capacidadeMaxima = capacidadeMaxima;
	}

	@Override
	public String toString() {
		return "Caminhao [capacidadeMaxima=" + capacidadeMaxima
				+ ", toString()=" + super.toString() + "]";
	}

		
	

}
