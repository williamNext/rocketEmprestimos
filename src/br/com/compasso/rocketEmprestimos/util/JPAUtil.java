package br.com.compasso.rocketEmprestimos.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

//	private static SessionFactory sessionFactory;
//
//	static {
//		Configuration configuration = new Configuration().configure();
//		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
//				.applySettings(configuration.getProperties());
//		sessionFactory = configuration.buildSessionFactory(builder.build());
//	}
//
//	public static SessionFactory getSessionFactory() {
//		return sessionFactory;
//	}

	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("emprestimo-mysql");

	public EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

}
