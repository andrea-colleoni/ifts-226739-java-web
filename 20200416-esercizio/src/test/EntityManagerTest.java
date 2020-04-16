/**
 * 
 */
package test;

import javax.persistence.EntityManager;

import org.junit.Test;

import utils.JpaUtils;

/**
 * @author andre
 *
 */
public class EntityManagerTest {

	@Test
	public void test() {
		EntityManager em = JpaUtils.getEntityManagerFactory().createEntityManager();
		em.close();
	}

}
