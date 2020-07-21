package Services;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import Interfaces.GenericServiceRemote;
import Interfaces.IBaseEntity;

@Stateless
@LocalBean
public class GenericService implements GenericServiceRemote {

	@PersistenceContext
	EntityManager em;


	@Override
	public <T extends IBaseEntity> int add(T t) {
		em.persist(t);
		return t.getId();
	}

	@Override
	public <T extends IBaseEntity> T update(T t) {
		return em.merge(t);

	}

	@Override
	public <T extends IBaseEntity> void delete(T t, Class<T> type) {

	 em.createQuery("delete from " + type.getName() + " a where a.id=:i").setParameter("i", t.getId()).executeUpdate();
	}

	@Override
	public <T extends IBaseEntity> T get(int id,  Class<T> type) {
		return em.find(type, id);
	}

	@Override
	public <T extends IBaseEntity> List<T> getAll(Class<T> type) {
		return em.createQuery("from " + type.getName()).getResultList();
	}

	@Override
	public <T extends IBaseEntity> List<T> getFiltered(Predicate<? super T> condition, Class<T> type) {
		List<T> list = getAll(type);
		return list.stream().filter(condition).collect(Collectors.toList());
	}

}
