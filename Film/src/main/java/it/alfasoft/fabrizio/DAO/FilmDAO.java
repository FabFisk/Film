package it.alfasoft.fabrizio.DAO;

import java.util.ArrayList;
import java.util.List;

import it.alfasoft.fabrizio.bean.Film;
import it.alfasoft.fabrizio.utility.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FilmDAO {

	//1- Create
	public boolean create(Film f) {
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.persist(f);
			tx.commit();
			res = true;
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}

	//2- Read
	public Film read(long id) {
		Film f = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			tx.begin();
			f = session.get(Film.class, id);
			tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return f;
	}
	
	public List<Film> getAll() {
		List<Film> film = new ArrayList<Film>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try{
			tx = session.getTransaction();
			tx.begin();
			Query query = session
					.createQuery("from Film");
			film = query.list();		
			tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}	
		return film;
	}

	//3- Update
	public boolean update(Film f) {
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.update(f);
			tx.commit();
			res = true;
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}

	//4- Delete
	public boolean delete(Film f) {
		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.delete(f);
			tx.commit();
			res = true;
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}
}
