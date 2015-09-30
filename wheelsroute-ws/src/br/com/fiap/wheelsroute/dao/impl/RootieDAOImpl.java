package br.com.fiap.wheelsroute.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

import br.com.fiap.wheelsroute.dao.ClassificacaoRootieDAO;
import br.com.fiap.wheelsroute.dao.RootieDAO;
import br.com.fiap.wheelsroute.entity.ClassificacaoRootie;
import br.com.fiap.wheelsroute.entity.Rootie;

public class RootieDAOImpl extends DAOImpl<Rootie, Integer> implements RootieDAO{

	public RootieDAOImpl(EntityManager em) {
		super(em);
		
	}
	
	@Override
	public void salvarRootie( int estado, String cidade, String bairro, String logradouro, int cep, int numero, int tipoLogradouro, String nome, int tipoRootie, String latitude, String longitude) {
		
		StoredProcedureQuery query2 = em.createNamedStoredProcedureQuery("insereRootie");
		
		query2.setParameter("P_ESTADO", estado);
		query2.setParameter("P_CIDADE", cidade);
		query2.setParameter("P_BAIRRO", bairro);
		query2.setParameter("P_LOGRADOURO", logradouro);
		query2.setParameter("P_CEP", cep);
		query2.setParameter("P_NUMERO", numero);
		query2.setParameter("P_TIPO_LOGRADOURO", tipoLogradouro);
		query2.setParameter("P_NOME_ROOTIE", nome);
		query2.setParameter("P_TIPO_ROOTIE", tipoRootie);
		query2.setParameter("P_LATITUDE", latitude);
		query2.setParameter("P_LONGITUDE", longitude);
		
		query2.execute();
		
		em.close();
		
	}

	@Override
	public List<Rootie> recuperarRooties(String cidade) {
		return em.createQuery("from Rootie r where "
				+ "r.endereco.logradouro.bairro.cidade = :c", Rootie.class)
				.setParameter("c", cidade)
				.getResultList();
	}

	@Override
	public List<Rootie> recuperarRooties() {
		return em.createQuery("from Rootie", Rootie.class)
				.getResultList();
	}

	@Override
	public List<Rootie> recuperarRootiesPorCategoria(int categoria) {
		return em.createQuery("from Rootie r where "
				+ "r.tipoRootie = :c", Rootie.class)
				.setParameter("c", categoria)
				.getResultList();
	}

	@Override
	public void classificarRootie(Rootie rootie, ClassificacaoRootie classificacaoRootie) throws Exception {
		classificacaoRootie.setRootie(rootie);
		ClassificacaoRootieDAO classificacaoRootieDAO = new ClassificacaoRootieDAOImpl(em);
		classificacaoRootieDAO.insert(classificacaoRootie);
	}

	@Override
	public Rootie detalharRootie(int id) {
		return em.createQuery("from Rootie r where "
				+ "r.codigo = :i", Rootie.class)
				.setParameter("i", id)
				.getResultList().get(0);
	}
	
	

}
