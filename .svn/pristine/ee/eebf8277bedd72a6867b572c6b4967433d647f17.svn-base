package br.com.facens.aluguel.model;

import javax.persistence.*;


@Entity
//@DiscriminatorValue(value="CarroSport")
public class CarroSport extends Veiculo{
	private String potencia;
	
	public CarroSport()
	{
		this.setTipo("CarroSport");
	}
	public String getPotencia() {
		return potencia;
	}

	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}

	@Override
	public String toString() {
		return "CarroPasseio [potencia=" + potencia + ", toString()="
				+ super.toString() + "]";
	}


	

}
