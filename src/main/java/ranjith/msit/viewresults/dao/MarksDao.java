package ranjith.msit.viewresults.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import ranjith.msit.viewresults.model.Marks;

public class MarksDao {
	SessionFactory sessionFactory = null;
	Session session = null;
	public MarksDao(){
		System.out.println("Test 1");
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	@SuppressWarnings("unchecked")
	public List<Marks> getAllMarks(){
		System.out.println("Test here");
		List<Marks> marks= new ArrayList<Marks>();
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			//Query<Marks> query = session.createQuery("from marks");
			//marks = query.getResultList();
			System.out.println("Test in query");
			marks = session.createQuery("FROM marks").list(); 
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return marks;
	}
}
