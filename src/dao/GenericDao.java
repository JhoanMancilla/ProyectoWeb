package dao;

import java.util.List;

public interface GenericDao<T> {
	public List<T> list();
	public <E> T find(E nickname);
	public void insert(T o);
	public void update(T o);
	public void delete(T o);
}