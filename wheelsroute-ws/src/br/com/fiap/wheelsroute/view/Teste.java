package br.com.fiap.wheelsroute.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;


public class Teste {

	public static void main(String[] args) {

		EntityManagerFactory emfactory = Persistence
				.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = emfactory.createEntityManager();
		
		StoredProcedureQuery query2 = em.createNamedStoredProcedureQuery("insereRootie");
		query2.setParameter("P_ESTADO", 25);
		query2.setParameter("P_CIDADE", "S�o Paulo");
		query2.setParameter("P_BAIRRO", "Cambuci");
		query2.setParameter("P_LOGRADOURO", "Lins de Vasconcelos");
		query2.setParameter("P_CEP", 05145000);
		query2.setParameter("P_NUMERO", 1222);
		query2.setParameter("P_TIPO_LOGRADOURO", 1);
		query2.setParameter("P_NOME_ROOTIE", "TESTE123");
		query2.setParameter("P_TIPO_ROOTIE", 1);
		query2.setParameter("P_LATITUDE", "12154");
		query2.setParameter("P_LONGITUDE", "564645");
		
		query2.execute();
		
		em.close();
		
		
	}
}
