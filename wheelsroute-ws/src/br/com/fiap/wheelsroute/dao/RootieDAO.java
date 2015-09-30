package br.com.fiap.wheelsroute.dao;

import java.util.List;

import br.com.fiap.wheelsroute.entity.ClassificacaoRootie;
import br.com.fiap.wheelsroute.entity.Rootie;

public interface RootieDAO extends DAO<Rootie, Integer>{
	
	public void salvarRootie(int estado, String cidade, String bairro, String logradouro, int cep, int numero, int tipoLogradouro, String nome, int tipoRootie, String latitude, String longitude);
	
	public List<Rootie> recuperarRooties(String cidade);
	
	public List<Rootie> recuperarRooties();
	
	public List<Rootie> recuperarRootiesPorCategoria(int categoria);
	
	public void classificarRootie(Rootie rootie, ClassificacaoRootie classificacaoRootie) throws Exception;

	public Rootie detalharRootie(int id);
	
}
