package util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class Conexion<T> {
	private Class<T> c;
	private static EntityManager em = null;
	
	public Conexion() {
		em = this.getEm();
	}
	
	public Conexion(Class<T> c) {
		em = this.getEm();
		this.c = c;
	}
	

	
	public Class<T> getC() {
		return c;
	}

	public void setC(Class<T> c) {
		this.c = c;
	}

	public static void setEm(EntityManager em) {
		Conexion.em = em;
	}

	public static EntityManager getEm(){
		if ( em == null ) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("asesorame");
            em = emf.createEntityManager();
        }
		return em;
	}
	
	public <E> T find(E nickname){
		T object = (T) em.find(c, nickname);
		return object;
	}
	
	public List<T> list(){
		TypedQuery<T> consulta= em.createNamedQuery(c.getSimpleName()+".findAll", c);
		List<T> lista = (List<T>) consulta.getResultList();
		return lista;
	}
	
	public List<T> listQuery(T o,String query){
		TypedQuery<T> consulta=em.createNamedQuery(query,c);
		List<T> Lista=(List<T>)consulta.getResultList();
		return Lista;
	}
	
	
	
	public void insert(T o){
		try {
			em.getTransaction().begin();
			em.persist(o);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//em.close();
		}
		
		
	}
	
	public void update(T o){
		try {
			em.getTransaction().begin();
			em.merge(o);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//em.close();
		}
		
	}
	
	public void delete(T o){
		try {
			em.getTransaction().begin();
			em.remove(o);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//em.close();
		}
		
	}
}
