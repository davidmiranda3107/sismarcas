package portal.sessions;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Session Bean implementation class BusinessSBSL
 */
@Stateless
@LocalBean
public class BusinessSBSL implements BusinessSBSLLocal {

	@PersistenceUnit
	protected EntityManagerFactory emf;

	protected EntityManager entityManager;

	public BusinessSBSL() {

	}

	@Override
	public Serializable findByPk(Class<? extends Serializable> entity,
			Serializable pk) throws Exception {
		Serializable registro = null;
		try {
			registro = getEntityManager().find(entity, pk);
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			if (getEntityManager() != null) {
				getEntityManager().clear();
				getEntityManager().close();
			}
		}
		return registro;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<? extends Serializable> findAll(
			Class<? extends Serializable> entity) throws Exception {
		List<Serializable> registros = null;
		try {
			CriteriaBuilder qb = getEntityManager().getCriteriaBuilder();
			CriteriaQuery<? extends Serializable> cq = qb.createQuery(entity);
			Query q = getEntityManager().createQuery(cq);

			registros = q.getResultList();
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			if (getEntityManager() != null) {
				getEntityManager().clear();
				getEntityManager().close();
			}
		}
		return registros;
	}

	@Override
	public Serializable update(Serializable registro) throws Exception {
		EntityTransaction tx = null;
		try {
			tx = getEntityManager().getTransaction();
			tx.begin();
			registro = getEntityManager().merge(registro);
			getEntityManager().flush();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			if (getEntityManager() != null) {
				getEntityManager().clear();
				getEntityManager().close();
			}
		}
		return registro;
	}

	@Override
	public Serializable insert(Serializable registro) throws Exception {
		EntityTransaction tx = null;
		try {
			tx = getEntityManager().getTransaction();
			tx.begin();
			getEntityManager().persist(registro);
			getEntityManager().flush();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			if (getEntityManager() != null) {
				getEntityManager().clear();
				getEntityManager().close();
			}
		}
		return registro;
	}

	@Override
	public void delete(Serializable registro) throws Exception {
		long pk = 0;
		EntityTransaction tx = null;
		try {
			tx = getEntityManager().getTransaction();
			tx.begin();
			PersistenceUnitUtil util = getEntityManager()
					.getEntityManagerFactory().getPersistenceUnitUtil();
			pk = (Long) util.getIdentifier(registro);
			registro = getEntityManager().find(registro.getClass(), pk);
			getEntityManager().remove(registro);
			getEntityManager().flush();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			if (getEntityManager() != null) {
				getEntityManager().clear();
				getEntityManager().close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<? extends Serializable> findByProperty(
			Class<? extends Serializable> entity, String property,
			Serializable value) {
		List<? extends Serializable> lst = null;
		try {
			CriteriaBuilder qb = getEntityManager().getCriteriaBuilder();
			CriteriaQuery<? extends Serializable> cq = qb.createQuery(entity);

			Root<? extends Serializable> registro = cq.from(entity);

			cq.where(qb.equal(registro.get(property), value));
			Query q = getEntityManager().createQuery(cq);

			lst = q.getResultList();
			// em.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (getEntityManager() != null) {
				getEntityManager().clear();
				getEntityManager().close();
			}
		}
		return lst;
	}

	@Override
	public Serializable findByPropertyUnique(
			Class<? extends Serializable> entity, String property,
			Serializable value) {
		Serializable registros = null;
		try {

			CriteriaBuilder qb = getEntityManager().getCriteriaBuilder();
			CriteriaQuery<? extends Serializable> cq = qb.createQuery(entity);

			Root<? extends Serializable> registro = cq.from(entity);
			cq.where(qb.equal(registro.get(property), value));
			Query q = getEntityManager().createQuery(cq);

			registros = (Serializable) q.getSingleResult();
			// //em.flush();
		} catch (NoResultException e) {
			// e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (getEntityManager() != null) {
				getEntityManager().clear();
				getEntityManager().close();
			}
		}
		return registros;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Serializable> findByNativeQuery(
			Class<? extends Serializable> entity, String query,
			Serializable[] params) {
		List<Serializable> lista = null;
		try {
			Query q = getEntityManager().createNativeQuery(query, entity);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					q.setParameter(i + 1, params[i]);
				}
			}
			lista = q.getResultList();
			// em.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (getEntityManager() != null) {
				getEntityManager().clear();
				getEntityManager().close();
			}
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Serializable> findByNativeQuery(String query,
			Serializable[] params) {
		List<Serializable> lista = null;
		try {
			Query q = getEntityManager().createNativeQuery(query);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					q.setParameter(i + 1, params[i]);
				}
			}
			lista = q.getResultList();
			// em.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (getEntityManager() != null) {
				getEntityManager().clear();
				getEntityManager().close();
			}
		}
		return lista;
	}

	@Override
	public int yaExiste(String tablas, String condicion) {
		int count = 0;
		try {
			String sql = "select count(1) from " + tablas;
			if (condicion != null)
				sql += " where " + condicion;
			Query q = getEntityManager().createNativeQuery(sql);
			count = Integer.parseInt(q.getSingleResult().toString());
			// em.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (getEntityManager() != null) {
				getEntityManager().clear();
				getEntityManager().close();
			}
		}
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Serializable> findByNamedQuery(
			Class<? extends Serializable> entity, String name,
			Map<String, Serializable> param) {
		List<Serializable> lista = null;
		try {
			Query q = getEntityManager().createNamedQuery(name, entity);
			if (param != null && param.size() > 0) {
				for (Entry<String, Serializable> e : param.entrySet()) {
					q.setParameter(e.getKey(), e.getValue());
				}
			}
			lista = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (getEntityManager() != null) {
				getEntityManager().clear();
				getEntityManager().close();
			}
		}
		return lista;
	}

	@Override
	public Serializable findReference(Class<? extends Serializable> entity,
			Serializable pk) {
		Serializable registro = null;
		try {
			registro = getEntityManager().getReference(entity, pk);
			// em.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (getEntityManager() != null) {
				getEntityManager().clear();
				getEntityManager().close();
			}
		}
		return registro;
	}

	@Override
	public boolean executeQuery(Class<? extends Serializable> entity,
			String query, Map<String, Serializable> params) {
		boolean resultado = false;
		try {
			Query qry = getEntityManager().createQuery(query);
			if (params != null && params.size() > 0) {
				for (Entry<String, Serializable> e : params.entrySet()) {
					qry.setParameter(e.getKey(), e.getValue());
				}
			}
			qry.executeUpdate();
			// em.flush();
			resultado = true;
		} catch (Exception e) {
			e.printStackTrace();
			resultado = false;
		} finally {
			if (getEntityManager() != null) {
				getEntityManager().clear();
				getEntityManager().close();
			}
		}
		return resultado;
	}

	@Override
	public Serializable refresh(Class<? extends Serializable> entity,
			Serializable pk) {
		Serializable Serializable = null;
		if (pk != null) {
			Serializable = getEntityManager().find(entity, pk);
			getEntityManager().refresh(Serializable);
			getEntityManager().clear();
			getEntityManager().close();
		}

		return Serializable;
	}

	public EntityManager getEntityManager() {
		if (entityManager == null || !entityManager.isOpen()) {
			entityManager = emf.createEntityManager();
		}
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<? extends Serializable> menuByUser(
			Class<? extends Serializable> entity, long usuId) {
		entityManager = emf.createEntityManager();
		try {
			Query q = entityManager
					.createNativeQuery(
							"SELECT A.* FROM \"ADM_MENU\" A  "
									+ "WHERE EXISTS ( SELECT 1 FROM \"ADM_MENU_ROLES\" B, \"ADM_USUARIOS_PERMISOS\" C "
									+ "WHERE A.\"MNU_ID\" = B.\"MNR_MNU_ID\" AND B.\"MNR_ROL_ID\" = C.\"UPR_ROL_ID\" AND B.\"REG_ACTIVO\" = 1 "
									+ "AND C.\"REG_ACTIVO\" = 1 AND C.\"UPR_USU_ID\" = ?) "
									+ "AND A.\"REG_ACTIVO\" = 1 ORDER BY A.\"MNU_ID_PADRE\", A.\"MNU_ORDEN\";",
							entity);
			q.setHint("javax.persistence.cache.storeMode", "REFRESH");
			q.setParameter(1, usuId);
			List<? extends Serializable> lista = q.getResultList();
			return lista;
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}

}
