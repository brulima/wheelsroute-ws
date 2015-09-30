package br.com.fiap.wheelsroute.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.wheelsroute.dao.ClassificacaoRootieDAO;
import br.com.fiap.wheelsroute.entity.ClassificacaoRootie;

public class ClassificacaoRootieDAOImpl extends DAOImpl<ClassificacaoRootie, Integer> implements ClassificacaoRootieDAO {

	public ClassificacaoRootieDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
