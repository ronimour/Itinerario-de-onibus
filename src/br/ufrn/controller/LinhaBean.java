package br.ufrn.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.ufrn.controller.service.JSONUtil;
import br.ufrn.controller.service.LinhaService;
import br.ufrn.controller.service.PontoReferenciaService;
import br.ufrn.controller.service.PontoService;
import br.ufrn.exceptions.ServiceException;
import br.ufrn.model.entity.Linha;
import br.ufrn.model.entity.Ponto;
import br.ufrn.model.entity.PontoReferencia;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;  
import org.primefaces.model.map.LatLng;  
import org.primefaces.model.map.MapModel;  
import org.primefaces.model.map.Marker;  

import sun.org.mozilla.javascript.internal.Context;



@ManagedBean
@SessionScoped
public class LinhaBean {



	private Linha linha = new Linha();
	private List<Linha> linhasList;
	private DataModel<Linha> linhas;
	private DataModel<Linha> linhasResultadoPesquisa;
	private final LinhaService service = new LinhaService();
	private String linhaPesquisa;
	private final DataModel<Ponto> pontos = new ListDataModel<Ponto>(
			service.listarAllPontosOnibus());

	private MapModel simpleModel;
	private List<Ponto> pontosAtual = null;
	
	private String origem = null;
	private String destino = null;
	private List<Ponto> pontosList = null;
	
	
	private String title;  
    
    private double lat;  
      
    private double lng;
	
    public String getTitle() {  
        return title;  
    }  
  
    public void setTitle(String title) {  
        this.title = title;  
    }  
  
    public double getLat() {  
        return lat;  
    }  
  
    public void setLat(double lat) {  
        this.lat = lat;  
    }  
  
    public double getLng() {  
        return lng;  
    }  
  
    public void setLng(double lng) {  
        this.lng = lng;  
    }  
	
	
	public String pesquisarPorLinha(){	
		System.out.println("Metodo invocado!");
		this.linhas = new ListDataModel<Linha>(service.pesquisarPorLinha(linhaPesquisa));
		this.setLinhasResultadoPesquisa(null);
		this.linhaPesquisa = "";
		return null;
	}
	
	public void pesquisarPorLinhaAjax(ActionEvent actionEvent){	
		System.out.println("Metodo invocado!");
		this.linhas = new ListDataModel<Linha>(service.pesquisarPorLinha(linhaPesquisa));
		
	}
	
	public void prepararAdicionarLinha(ActionEvent actionEvent) {
		this.linha = new Linha();
	}

	public void prepararAlterarLinha(ActionEvent actionEvent) {
		this.linha = this.linhas.getRowData();
	}
	
	public void setarLinha(ValueChangeEvent e){
		Long id = (Long) e.getNewValue();
		
		try {
			linha = service.retrieve(new Long(id));
		} catch (ServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("linha setada "+linha.getCodigoLinha());
	}

	public void adicionarLinha(ActionEvent actionEvent) {
		try {

			service.create(linha);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("finally")
	public String adicionar() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = null;
		try {

			service.create(linha);
			message = new FacesMessage("Linha salva com sucesso!");
			message.setSeverity(FacesMessage.SEVERITY_INFO);
		} catch (ServiceException e) {

			message = new FacesMessage("Nao foi possivel salvar a linha! "
					+ e.getMessage());
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			e.printStackTrace();
		} finally {
			context.addMessage("addLinha", message);
			this.linha = new Linha();
			return null;
		}
	}

	public void alterarLinha(ActionEvent actionEvent) {
		try {
			service.update(linha);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addPontoOnibusIda(ValueChangeEvent event) {
		Boolean bo = (Boolean) event.getNewValue();

		Ponto p = pontos.getRowData();

		if (bo) {
			System.out.println("INSERINDO " + p.getId());
			linha.getPontosIda().add(p);
		} else {
			System.out.println("removendo " + p.getId());
			linha.getPontosIda().remove(p);
		}

	}

	public void excluirLinha(ActionEvent actionEvent) {
		try {
			Linha linhaTemp = this.linhas.getRowData();
			service.destroy(linhaTemp);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String gerenciarLinha() {
		return "linha";
	}

	public Linha getLinha() {
		return linha;
	}

	public void setLinha(Linha linha) {
		this.linha = linha;
	}

	public DataModel<Linha> getLinhas(){
		return this.linhas;
	}
	
	public DataModel<Linha> getTodaslinhas() {
		List<Linha> linhaList = null;
		try {
			/*
			 * if(service == null){ System.out.println("Service null"); service
			 * = new LinhaService(); }
			 */
			linhaList = service.list();

			this.linhas = new ListDataModel<Linha>(linhaList);

		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.linhas;
	}

	public DataModel<Ponto> getPontos() {
		return pontos;
	}
	
	
	 public List<String> complete(String query) {  
	        List<String> results = new ArrayList<String>(); 
	        	        
	        if(this.linhasList == null){	        	
	        	try {
					linhasList = service.list();
					
				} catch (ServiceException e) {
					e.printStackTrace();
				}
	        }        
	        for (Iterator<Linha> iterator = linhasList.iterator(); iterator.hasNext();) {
				Linha l = iterator.next();
				if(l.getCodigoLinha().contains(query)){
					results.add(l.getCodigoLinha());
				}
			}
	        
	        this.linhaPesquisa = query;  
	        return results;  
	    }
	 
	 public List<String> completeO(String query){
		 this.setOrigem(query);
		 return completeOD(query);
	 }
	
	 public List<String> completeD(String query){
		 this.setDestino(query);
		 return completeOD(query);
	 }
	 
	 public List<String> completeOD(String query){
		 List<String> results = new ArrayList<String>();
		 
		 if(this.pontosList == null){
			 PontoService ps = new PontoService();
			 try {
				this.pontosList = ps.list();
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		 }
		 
		 for (Iterator<Ponto> iterator = this.pontosList.iterator(); iterator.hasNext();) {
			Ponto p = iterator.next();
			if(p.getDescricao().contains(query)){
				results.add(p.getDescricao());
			}
			for (Iterator<PontoReferencia> iterator2 = p.getPontosReferencia().iterator(); iterator2.hasNext();) {
				PontoReferencia pr = iterator2.next();
				if(pr.getNome().contains(query)){
					results.add(pr.getNome());
				}
				
			}
			
		}
		 
		 
		 return results;
	 }
	 
	 
	 public void pesquisarPorOrigemDestino(ActionEvent actionEvent){
		FacesContext.getCurrentInstance().addMessage(
				"messages",
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso! ",
						"Origem: " + this.getOrigem() + " / Destino: "
								+ this.getDestino()));
		

		atualizarPontos();
		//HashMap<String, Long> mapa = criarMapaPontos();
		//System.out.println(mapa);

		atualizarLinhas();

		List<Linha> linhasResultado = new ArrayList<Linha>();

		for (Iterator<Linha> iterator = this.getLinhasList().iterator(); iterator
				.hasNext();) {
			Linha linha = iterator.next();

			Ponto pontoOrigem = null;
			Ponto pontoDestino = null;

			int pontoOrigemIdx = -1;

			int pontoDestinoIdx = -1;

			int index = 0;

			// pesquisa nas linhas de ida
			for (Iterator<Ponto> iterator2 = linha.getPontosIda().iterator(); iterator2
					.hasNext(); index++) {
				Ponto ponto = iterator2.next();
				if (this.getOrigem().equalsIgnoreCase(ponto.getDescricao())) {
					pontoOrigem = ponto;
					pontoOrigemIdx = index;
				} else {
					for (Iterator<PontoReferencia> iterator3 = ponto
							.getPontosReferencia().iterator(); iterator3
							.hasNext();) {
						PontoReferencia pontoRef = iterator3.next();
						if (this.getOrigem().equalsIgnoreCase(
								pontoRef.getNome())) {
							pontoOrigem = ponto;
							pontoOrigemIdx = index;
						}

					}
				}

				if (this.getDestino().equalsIgnoreCase(ponto.getDescricao())) {
					pontoDestino = ponto;
					pontoDestinoIdx = index;
				} else {
					for (Iterator<PontoReferencia> iterator3 = ponto
							.getPontosReferencia().iterator(); iterator3
							.hasNext();) {
						PontoReferencia pontoRef = iterator3.next();
						if (this.getDestino().equalsIgnoreCase(
								pontoRef.getNome())) {
							pontoDestino = ponto;
							pontoDestinoIdx = index;
						}

					}
				}

			}
			if (pontoOrigem != null && pontoDestino != null) {
				if (pontoOrigemIdx < pontoOrigemIdx) {
					linhasResultado.add(linha);
				}
				pontoOrigem = pontoDestino = null;
				pontoOrigemIdx = pontoDestinoIdx = -1;
			}
			
			index = 0;

			// pesquisa nas linhas de volta
			for (Iterator<Ponto> iterator2 = linha.getPontosVolta().iterator(); iterator2
					.hasNext(); index++) {
				Ponto ponto = iterator2.next();
				if (this.getOrigem().equalsIgnoreCase(ponto.getDescricao())) {
					pontoOrigem = ponto;
					pontoOrigemIdx = index;
				} else {
					for (Iterator<PontoReferencia> iterator3 = ponto
							.getPontosReferencia().iterator(); iterator3
							.hasNext();) {
						PontoReferencia pontoRef = iterator3.next();
						if (this.getOrigem().equalsIgnoreCase(
								pontoRef.getNome())) {
							pontoOrigem = ponto;
							pontoOrigemIdx = index;
						}

					}
				}

				if (this.getDestino().equalsIgnoreCase(ponto.getDescricao())) {
					pontoDestino = ponto;
					pontoDestinoIdx = index;
				} else {
					for (Iterator<PontoReferencia> iterator3 = ponto
							.getPontosReferencia().iterator(); iterator3
							.hasNext();) {
						PontoReferencia pontoRef = iterator3.next();
						if (this.getDestino().equalsIgnoreCase(
								pontoRef.getNome())) {
							pontoDestino = ponto;
							pontoDestinoIdx = index;
						}

					}
				}

			}
			if (pontoOrigem != null && pontoDestino != null) {
				if (pontoOrigemIdx < pontoOrigemIdx) {
					linhasResultado.add(linha);
				}
				pontoOrigem = pontoDestino = null;
				pontoOrigemIdx = pontoDestinoIdx = -1;
			}

		}
		
		this.setLinhasResultadoPesquisa(new ListDataModel<Linha>(linhasResultado));
		 
	 }
	 

/*
	private HashMap<String, Long> criarMapaPontos() {
		 
		HashMap<String, Long> mapa = new HashMap<String, Long>() ;
		for (Iterator<Ponto> iterator = this.getPontosList().iterator(); iterator.hasNext();) {
			Ponto p = iterator.next();
			mapa.put(p.getDescricao(), p.getId());
			for (Iterator<PontoReferencia> iterator2 = p.getPontosReferencia().iterator(); iterator2.hasNext();) {
				PontoReferencia pr = iterator2.next();
				mapa.put(pr.getNome(), p.getId());
				
			}
			
		}
		return mapa;
	}

*/

	public void pesquisarPorLinha(ActionEvent actionEvent){
		 System.out.println("Metodo foi chamado! com parametro de pesquisa : "+this.linhaPesquisa);
		 if(this.linhasList == null){	        	
	        	try {
					this.linhasList = service.list();
					
				} catch (ServiceException e) {
					e.printStackTrace();
				}
	        } 
		 List<Linha> resultado = new ArrayList<Linha>();
		 for (Iterator<Linha> iterator = this.linhasList.iterator(); iterator.hasNext();) {
				Linha l = iterator.next();
				if(l.getCodigoLinha().equalsIgnoreCase(this.linhaPesquisa)){					
					
					resultado.add(l);
					
				}
		 }
		 this.setLinhasResultadoPesquisa(new ListDataModel<Linha>(resultado));
		 
		 
	 }
	 
	public void markMapIda(ActionEvent event) {
		simpleModel = new DefaultMapModel();

		List<Ponto> pontos = getLinhasResultadoPesquisa().getRowData()
				.getPontosIda();

		markMap(pontos);

	}	
	
	public void markMapVolta(ActionEvent event) {
		simpleModel = new DefaultMapModel();

		List<Ponto> pontos = getLinhasResultadoPesquisa().getRowData()
				.getPontosVolta();

		markMap(pontos);

	}
	
	
	private void markMap(List<Ponto> pontos) {
		if (pontos != null && pontos.size() > 0) {
			for (Iterator<Ponto> iterator = pontos.iterator(); iterator
					.hasNext();) {
				Ponto p = iterator.next();
				if (p.getLatitude() != null && p.getLongitude() != null) {
					LatLng coordenada = new LatLng(p.getLatitude(),
							p.getLongitude());
					Marker marker = new Marker(coordenada, p.getDescricao());
					marker.setIcon("http://localhost:8080/Itinerario-de-onibus/img/stop-bus.png");
					simpleModel.addOverlay(marker);
					System.out.println(coordenada + " adicionada com sucesso!");
				}
			}
			
			setPontosAtual(pontos);
		
		}
		else{
			System.out.println("Nao ha pontos!");
			FacesContext.getCurrentInstance()
			.addMessage("messages", 
					new FacesMessage(
							FacesMessage.SEVERITY_INFO,
							"Aviso! ","Nao foi encontrado itinerario")
						);
		}
	}

	
	 public void onMarkerSelect(OverlaySelectEvent event) { 
		 System.out.println("Metodo Ajax Invocado!");
	        Marker marker = (Marker) event.getOverlay();  
	        setLat(marker.getLatlng().getLat());
	        setLng(marker.getLatlng().getLng());
	        /*
	        FacesContext.getCurrentInstance()
			.addMessage("messages", 
					new FacesMessage(
							FacesMessage.SEVERITY_INFO,
							"Marker! ","Lat: "+this.lat+" Lng: "+this.lng)
						);
	        */
	    }  
	
	 public void addRef(ActionEvent event){

		// Adicionando pontos de referencia para o ponto de onibus selecionado
		Ponto ponto = getPontoByLatLng(this.lat, this.lng);

		if (ponto != null) {

			PontoReferencia ref = new PontoReferencia();

			ref.setDescricao(this.title);
			ref.setNome(this.title);
			ref.setPonto(ponto);

			PontoReferenciaService servicePR = new PontoReferenciaService();
			
						
			List<PontoReferencia> listaPR = null;
			try {
				listaPR = servicePR.list();
			} catch (ServiceException e) {
				FacesContext.getCurrentInstance().addMessage(
						"messages",
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Erro ao listar referencias! ", e.getMessage()));
				setTitle("");
				return;
			}
			
			for (Iterator<PontoReferencia> iterator = listaPR.iterator(); iterator.hasNext();) {
				PontoReferencia pr = iterator.next();
				if(pr.getNome().equalsIgnoreCase(this.title)){
					FacesContext.getCurrentInstance().addMessage(
							"messages",
							new FacesMessage(FacesMessage.SEVERITY_WARN,
									"Alerta! ","Ja existe um ponto de referencia com esse nome" ));
					setTitle("");
					return;
				}
				
			}

			try {
				servicePR.create(ref);
			} catch (ServiceException e) {
				FacesContext.getCurrentInstance().addMessage(
						"messages",
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Erro ao salvar referencia! ", e.getMessage()));
				setTitle("");
				return;
			}	
			
			

			System.out.println("Referencia adicionada: " + this.title);
			FacesContext.getCurrentInstance().addMessage(
					"messages",
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Referencia adicionada com sucesso! ", this.title));
		} else{			
			FacesContext.getCurrentInstance().addMessage(
					"messages",
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Erro! ", "Nao foi possivel encontrar o ponto"));
		}
		setTitle("");
	 }

	private Ponto getPontoByLatLng(double lat2, double lng2) {
		Ponto retorno = null;
		for (Iterator<Ponto> iterator = this.pontosAtual.iterator(); iterator.hasNext();) {
			Ponto p = iterator.next();
			if(p.getLatitude().doubleValue() == lat2 && p.getLongitude().doubleValue() == lng2){
				retorno = p;
			}
			
		}
		return retorno;
	}

	public DataModel<Linha> getLinhasResultadoPesquisa() {
		return linhasResultadoPesquisa;
	}

	public void setLinhasResultadoPesquisa(DataModel<Linha> linhasResultadoPesquisa) {
		this.linhasResultadoPesquisa = linhasResultadoPesquisa;
	}


	public MapModel getSimpleModel() {
		return simpleModel;
	}

	public void setSimpleModel(MapModel simpleModel) {
		this.simpleModel = simpleModel;
	}

	public List<Ponto> getPontosAtual() {
		return pontosAtual;
	}

	public void setPontosAtual(List<Ponto> pontosAtual) {
		this.pontosAtual = pontosAtual;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public List<Ponto> getPontosList() {
		return pontosList;
	}

	public void setPontosList(List<Ponto> pontosList) {
		this.pontosList = pontosList;
	}
	
	public List<Linha> getLinhasList() {
		return linhasList;
	}

	public void setLinhasList(List<Linha> linhasList) {
		this.linhasList = linhasList;
	}

	public String getLinhaPesquisa() {
		return linhaPesquisa;
	}

	public void setLinhaPesquisa(String linhaPesquisa) {
		this.linhaPesquisa = linhaPesquisa;
	}
	
	
	
	private void atualizarPontos(){
		PontoService ps = new PontoService();
		 try {
			this.setPontosList(ps.list());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	private void atualizarLinhas() {
		try {
			this.setLinhasList(this.service.list());
		} catch (ServiceException e) {
			mensagemDeErro("Erro ao listar linhas: "+e.getMessage());
		}		
	}	
	
	
	
	public void mensagemDeErro(String message){
		FacesContext.getCurrentInstance().addMessage(
				"messages",
				new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Erro! ", message));
	}
	
	public void mensagemDeAlerta(String message){
		FacesContext.getCurrentInstance().addMessage(
				"messages",
				new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Erro! ", message));
	}
	
	public void mensagemDeInformacao(String message){
		FacesContext.getCurrentInstance().addMessage(
				"messages",
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Erro! ", message));
	}

}
