package br.com.facens.aluguel.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIData;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.com.facens.aluguel.business.VeiculoBusiness;
import br.com.facens.aluguel.business.VeiculoBusiness.MensagemEnum;
import br.com.facens.aluguel.model.CarroSport;
import br.com.facens.aluguel.model.Veiculo;
import br.com.facens.aluguel.model.Caminhao;
import br.com.facens.aluguel.model.CarroPasseio;
import br.com.facens.aluguel.util.JSFUtil;

@ManagedBean
@ViewScoped
@SessionScoped
public class VeiculoMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idCarroPasseio = 1;
	private int idCarroSport = 1;
	private int idCaminhao = 1;
	private int posCarroPasseio = -1;
	private int posCarroSport = -1;
	private int posCaminhao = -1;
	
	private CarroSport carrosport = new CarroSport();
	private CarroPasseio carropasseio = new CarroPasseio();
	private Caminhao caminhao = new Caminhao();
	VeiculoBusiness vb = new VeiculoBusiness();
	
	private List<Veiculo> veiculos = null;

	public VeiculoMB()
	{
		atualizaId();
	}
	
	public CarroSport getCarrosport() {
		return carrosport;
	}

	public void setCarrosport(CarroSport carrosport) {
		this.carrosport = carrosport;
	}

	public CarroPasseio getCarropasseio() {
		return carropasseio;
	}

	public void setCarropasseio(CarroPasseio carropasseio) {
		this.carropasseio = carropasseio;
	}

	public Caminhao getCaminhao() {
		return caminhao;
	}

	public void setCaminhao(Caminhao caminhao) {
		this.caminhao = caminhao;
	}


	public void atualizaId() {
		List<Veiculo> lista = vb.getAllVeiculos();
		int tam = lista.size();

		for (int i = 0; i < tam; i++)
		{
			if (lista.get(i).getTipo().compareTo("Caminhao") == 0) {
				posCaminhao = i;
			}
			if (lista.get(i).getTipo().compareTo("CarroPasseio") == 0) {
				posCarroPasseio = i;
			}
			if (lista.get(i).getTipo().compareTo("CarroSport") == 0) {
				posCarroSport = i;
			}
		}

		if(posCaminhao==-1)
			caminhao.setId(1);
		else
		{
			idCaminhao = lista.get(posCaminhao).getId() + 1;
			caminhao.setId(idCaminhao);
		}
		
		if(posCarroPasseio==-1)
			carropasseio.setId(1);
		else
		{
			idCarroPasseio = lista.get(posCarroPasseio).getId() + 1;
			carropasseio.setId(idCarroPasseio);
		}
		
		if (posCarroSport == -1) 
			carrosport.setId(1);
		else
		{
			idCarroSport = lista.get(posCarroSport).getId() + 1;
			carrosport.setId(idCarroSport);
		}
		
	}

	public void salvarCarroSport() {

		if (vb.salvarVeiculo(carrosport) == MensagemEnum.SUCESSO) {
			System.out.println("Sucesso!");
			int idanterior = carrosport.getId() + 1;
			carrosport = new CarroSport();
			carrosport.setId(idanterior);
			veiculos = vb.getAllVeiculos();
		} else {
			System.out.println("Erro!");
		}
		JSFUtil.addMessage(
				"br.com.facens.aluguel.controller.ClienteMB.idMensagem",
				vb.getMsg());
	}

	public void salvarCarroPasseio() {

		if (vb.salvarVeiculo(carropasseio) == MensagemEnum.SUCESSO) {
			System.out.println("Sucesso!");
			int idanterior = carropasseio.getId() + 1;
			carropasseio = new CarroPasseio();
			carropasseio.setId(idanterior);
			veiculos = vb.getAllVeiculos();
		} else {
			System.out.println("Erro!");
		}

		JSFUtil.addMessage(
				"br.com.facens.aluguel.controller.ClienteMB.idMensagem",
				vb.getMsg());
	}

	public void salvarCaminhao() {
		if (vb.salvarVeiculo(caminhao) == MensagemEnum.SUCESSO) {
			System.out.println("Sucesso!");
			int idanterior = caminhao.getId() + 1;
			caminhao = new Caminhao();
			caminhao.setId(idanterior);
			veiculos = vb.getAllVeiculos();
		} else {
			System.out.println("Erro!");
		}
		JSFUtil.addMessage(
				"br.com.facens.aluguel.controller.ClienteMB.idMensagem",
				vb.getMsg());
	}
	
	public List<Veiculo> getVeiculos() {
		if(veiculos == null)
			veiculos = vb.getAllVeiculos();
		return veiculos;
	}
    /*public void onRowEdit(RowEditEvent event) {
        //atualizaId();
    	atualizar((Veiculo)event.getObject());
        System.out.println((Veiculo)event.getObject());
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO, "rowEdit event", ""));
    }
     
    public void onRowCancel(RowEditEvent event) {
    	System.out.println("CANCELAR");
    }*/
	
	public void onRowEdit(RowEditEvent event) {
		Veiculo veiculo = (Veiculo)event.getObject();
		System.out.println(veiculo);
		atualizar(veiculo);
		veiculos = null;
    }
    public void onRowCancel(RowEditEvent event) {
    	System.out.println((Veiculo)event.getObject());
    }
	public void atualizar(Veiculo c) {
		System.out.println("ATUALIZA");
		//veiculo.setModelo("FOI ALTERADO");
		System.out.println(c);
		if(c.getClass() == CarroPasseio.class) {
			if (vb.atualizar((CarroPasseio)c) == MensagemEnum.SUCESSO) {
				System.out.println("Sucesso!");
				//carropasseio = new CarroPasseio();
				atualizaId();
				veiculos = vb.getAllVeiculos();
			} else {
				System.out.println("Erro!");
			}

			JSFUtil.addMessage(
					"br.com.facens.aluguel.controller.ClienteMB.idMensagem",
					vb.getMsg());
		}
		if(c.getClass() == Caminhao.class) {
			if (vb.atualizar((Caminhao)c) == MensagemEnum.SUCESSO) {
				System.out.println("Sucesso!");
				//caminhao = new Caminhao();
				atualizaId();
				veiculos = vb.getAllVeiculos();
			} else {
				System.out.println("Erro!");
			}

			JSFUtil.addMessage(
					"br.com.facens.aluguel.controller.ClienteMB.idMensagem",
					vb.getMsg());
		}
		if(c.getClass() == CarroSport.class) {
			if (vb.atualizar((CarroSport)c) == MensagemEnum.SUCESSO) {
				System.out.println("Sucesso!");
				//carrosport = new CarroSport();
				atualizaId();
				veiculos = vb.getAllVeiculos();
			} else {
				System.out.println("Erro!");
			}

			JSFUtil.addMessage(
					"br.com.facens.aluguel.controller.ClienteMB.idMensagem",
					vb.getMsg());
		}

	}
	
	public void deletar(Veiculo veiculo) {
	
		if(veiculo.getClass() == CarroPasseio.class) {
			if (vb.deletarVeiculo((CarroPasseio)veiculo) == MensagemEnum.SUCESSO) {
				System.out.println("Sucesso!");
				carropasseio = new CarroPasseio();
				atualizaId();
				veiculos = vb.getAllVeiculos();
			} else {
				System.out.println("Erro!");
			}

			JSFUtil.addMessage(
					"br.com.facens.aluguel.controller.ClienteMB.idMensagem",
					vb.getMsg());
		}
		if(veiculo.getClass() == Caminhao.class) {
			if (vb.deletarVeiculo((Caminhao)veiculo) == MensagemEnum.SUCESSO) {
				System.out.println("Sucesso!");
				caminhao = new Caminhao();
				atualizaId();
				veiculos = vb.getAllVeiculos();
			} else {
				System.out.println("Erro!");
			}

			JSFUtil.addMessage(
					"br.com.facens.aluguel.controller.ClienteMB.idMensagem",
					vb.getMsg());
		}
		if(veiculo.getClass() == CarroSport.class) {
			if (vb.deletarVeiculo((CarroSport)veiculo) == MensagemEnum.SUCESSO) {
				System.out.println("Sucesso!");
				carrosport = new CarroSport();
				atualizaId();
				veiculos = vb.getAllVeiculos();
			} else {
				System.out.println("Erro!");
			}

			JSFUtil.addMessage(
					"br.com.facens.aluguel.controller.ClienteMB.idMensagem",
					vb.getMsg());
		}
	}
}

