package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import model.Brano;
import utils.JPAUtils;

public class JPATest {

	@Test
	public void testEntityManager() {
		// sto cercando di testare se JPA funzioona o no
		// 1. Create un'entitymanagerfactory => se funziona allora la connessione funziona e persistence.xml è ok
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("esercizio-web-01");
		
		// 2. con l'entitymanagerfactory creo un'entitymanager (e poi, semmai proverò a fare una query)
		EntityManager em = emf.createEntityManager();
		
	}
	
	@Test
	public void testQuery() {
		
		// uso la mia classe di utilità che garantisce di avere un unico EntityManagerFactory
		// la classe mi consente di ottenere sempre un EntityManager fresco da questa unica factory
		EntityManager em = JPAUtils.getEntityManager();
		
		// con l'entitymanager faccio la query sui brani
		List<Brano> brani = em.createQuery("select b from Brano b", Brano.class).getResultList();
		for(Brano b : brani) {
			System.out.println(b.getTitolo());
		}
	}
}
