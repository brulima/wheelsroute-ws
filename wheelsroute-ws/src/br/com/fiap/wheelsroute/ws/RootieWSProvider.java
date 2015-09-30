package br.com.fiap.wheelsroute.ws;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.wheelsroute.dao.RootieDAO;
import br.com.fiap.wheelsroute.dao.impl.RootieDAOImpl;
import br.com.fiap.wheelsroute.entity.ClassificacaoRootie;
import br.com.fiap.wheelsroute.entity.Rootie;

public class RootieWSProvider {
	
	EntityManagerFactory emfactory = Persistence
			.createEntityManagerFactory("CLIENTE_ORACLE");
	EntityManager em = emfactory.createEntityManager();
	
	RootieDAO rootieDAO = new RootieDAOImpl(em);
	
	
	public void salvarRootie(int estado, String cidade, String bairro, String logradouro, int cep, int numero, int tipoLogradouro, String nome, int tipoRootie, String latitude, String longitude) {		
		rootieDAO.salvarRootie(estado, cidade, bairro, logradouro, cep, numero, tipoLogradouro, nome, tipoRootie, latitude, longitude);		
	}
	
	public List<Rootie> recuperarRooties () {
		return rootieDAO.recuperarRooties();
	}
	
	public List<Rootie> recuperarRooties (String cidade) {
		return rootieDAO.recuperarRooties(cidade);
	}

	public List<Rootie> recuperarRootiesPorTipo (int tipoRootie) {
		return rootieDAO.recuperarRootiesPorCategoria(tipoRootie);	
	}

	public void classificarRootie(Rootie rootie, ClassificacaoRootie classificacaoRootie) throws Exception {
		rootieDAO.classificarRootie(rootie, classificacaoRootie);
	}
	
	public Rootie detalharRootie(int id) {
		return rootieDAO.findById(id);
	}
	
}
