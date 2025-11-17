package br.senac.rj.backend.dao;

import br.senac.rj.backend.entity.Produtor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProdutorDao {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("backendPU");

	public Produtor salvar(Produtor produtor) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Produtor ProdutorSalvo = em.merge(produtor); // obter objeto completo salvo
			em.getTransaction().commit();
			return ProdutorSalvo;
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback(); // desfazer transações pendentes
			}
			e.printStackTrace(); // Para depuração
			return null;
		} finally {
			em.close();
		}
	}

	public Produtor buscarPorId(Long id) {
		EntityManager em = emf.createEntityManager();
		try {
			return em.find(Produtor.class, id);
		} finally {
			em.close();
		}
	}
}
