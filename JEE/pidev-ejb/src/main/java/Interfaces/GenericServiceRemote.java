package Interfaces;

import java.util.List;
import java.util.function.Predicate;

import javax.ejb.Remote;

@Remote
public interface GenericServiceRemote {
	public <T extends IBaseEntity> int add(T t);
	public <T extends IBaseEntity> T update(T t);
	public <T extends IBaseEntity> void delete(T t, Class<T> type);
	public <T extends IBaseEntity> T get(int id, Class<T> type);
	public <T extends IBaseEntity> List<T> getAll(Class<T> type);
	public <T extends IBaseEntity> List<T> getFiltered(Predicate<? super T> condition, Class<T> type);
}
