package hibernatesetup;

import flyaway.models.*;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
//import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



public class dbfunctions {

 //private static SessionFactory factory = hibernateconnection.getSessionFactory();
	


	public static airlinedetails airlinedetailsById(String airlineindex)
	{
		
		airlinedetails data = new airlinedetails();
		Session session = hibernateconnection.getSessionFactory().openSession();
		data = session.load(airlinedetails.class, airlineindex);
		System.out.println(data);
		session.close();
		return data;
	}
	
	public static String saveairlinedetails(airlinedetails data) 
	{
		Session session = hibernateconnection.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		String id = (String) session.save(data);
		tx.commit();
		session.close();
		return id;
	}
	
	public static airlinedetails getairlinedetailsById(String airlineindex)
	{
		Session session = hibernateconnection.getSessionFactory().openSession();
		airlinedetails data = session.get(airlinedetails.class,airlineindex);
		session.close();
		return data;
	}
	
	
	public static void updateairlinedetails(airlinedetails data) 
	 {
		Session session = hibernateconnection.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.update(data);
		tx.commit();
		session.close();

	}
	
	public static void deleteairlinedetails(airlinedetails data) 
	{
		Session session = hibernateconnection.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.delete(data);
		tx.commit();
		session.close();

	}
	
	public static List<airlinedetails> getAllairlinedetails()
	{
		Session session = hibernateconnection.getSessionFactory().openSession();
		CriteriaQuery<airlinedetails> cq = session.getCriteriaBuilder().createQuery(airlinedetails.class);
		cq.from(airlinedetails.class);
		List<airlinedetails> airlinedetailslist = session.createQuery(cq).getResultList();
		return airlinedetailslist;
	}

	
	public static masterlist masterlistById(String flightid)
	{
		masterlist data = new masterlist();
		Session session = hibernateconnection.getSessionFactory().openSession();
		data = session.load(masterlist.class, flightid);
		System.out.println(data);
		session.close();
		return data;
	}
	
	public static String savemasterlist(masterlist data) 
	{
		Session session = hibernateconnection.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		String flightid = (String) session.save(data);
		tx.commit();
		session.close();
		return flightid;
	}
	
	public static masterlist getmasterlistById(String flightid)
	{
		Session session = hibernateconnection.getSessionFactory().openSession();
		masterlist data = session.get(masterlist.class, flightid);
		session.close();
		return data;
	}
	
	
	public static void updatemasterlist(masterlist data) 
	 {
		Session session = hibernateconnection.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.update(data);
		tx.commit();
		session.close();

	}
	
	public static void deletemasterlist(masterlist data) 
	{
		Session session = hibernateconnection.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.delete(data);
		tx.commit();
		session.close();

	}
	
	public static List<masterlist> getmasterlist()
	{
		Session session = hibernateconnection.getSessionFactory().openSession();
		CriteriaQuery<masterlist> cq = session.getCriteriaBuilder().createQuery(masterlist.class);
		cq.from(masterlist.class);
		List<masterlist> masterlistlist = session.createQuery(cq).getResultList();
		return masterlistlist;
	}

	public static reservation reservationById(int id)
	{
		reservation data = new reservation();
		Session session = hibernateconnection.getSessionFactory().openSession();
		data = session.load(reservation.class, id);
		System.out.println(data);
		session.close();
		return data;
	}
	
	public static Integer savereservation(reservation data) 
	{
		Session session = hibernateconnection.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Integer id = (Integer) session.save(data);
		tx.commit();
		session.close();
		return id;
	}
	
	public static reservation getreservationById(int id)
	{
		Session session = hibernateconnection.getSessionFactory().openSession();
		reservation data = session.get(reservation.class, id);
		session.close();
		return data;
	}
	
	
	public static void updatereservation(reservation data) 
	 {
		Session session = hibernateconnection.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.update(data);
		tx.commit();
		session.close();

	}
	
	public static void deletereservation(reservation data) 
	{
		Session session = hibernateconnection.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.delete(data);
		tx.commit();
		session.close();

	}
	
	public static List<reservation> getreservation()
	{
		Session session = hibernateconnection.getSessionFactory().openSession();
		CriteriaQuery<reservation> cq = session.getCriteriaBuilder().createQuery(reservation.class);
		cq.from(reservation.class);
		List<reservation> reservationlist = session.createQuery(cq).getResultList();
		return reservationlist;
	}

	

public static routeinfo routeinfoById(String routeindex)
	{
		routeinfo data = new routeinfo();
		Session session = hibernateconnection.getSessionFactory().openSession();
		data = session.load(routeinfo.class, routeindex);
		session.close();
		return data;
	}
	
	public static String saverouteinfo(routeinfo data) 
	{
		Session session = hibernateconnection.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		String id = (String) session.save(data);
		tx.commit();
		session.close();
		return id;
	}
	
	public static routeinfo getrouteinfoById(String routeindex)
	{
		Session session = hibernateconnection.getSessionFactory().openSession();
		routeinfo data = session.get(routeinfo.class, routeindex);
		session.close();
		return data;
	}
	
	
	public static void updaterouteinfo (routeinfo data) 
	 {
		Session session = hibernateconnection.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.update(data);
		tx.commit();
		session.close();

	}
	
	public static void deleterouteinfo(routeinfo data) 
	{
		Session session = hibernateconnection.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.delete(data);
		tx.commit();
		session.close();

	}
	
	public static List<routeinfo> getrouteinfo()
	{
		Session session = hibernateconnection.getSessionFactory().openSession();
		CriteriaQuery<routeinfo> cq = session.getCriteriaBuilder().createQuery(routeinfo.class);
		cq.from(routeinfo.class);
		List<routeinfo> routeinfolist = session.createQuery(cq).getResultList();
		return routeinfolist;
	}

	
	public static userdetails userdetailsById(String id)
	{
		
		System.out.println("userdetailsById called");
		userdetails data = new userdetails();
		Session session = hibernateconnection.getSessionFactory().openSession();;
		data = session.load(userdetails.class, id);
		System.out.println(data);
		session.close();
		return data;
	}
	
	public static String saveuserdetails(userdetails data) 
	{
		Session session = hibernateconnection.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		String id = (String) session.save(data);
		tx.commit();
		session.close();
		return id;
	}
	
	public static userdetails getuserdetailsById(String id)
	{
		Session session = hibernateconnection.getSessionFactory().openSession();
		userdetails data = session.get(userdetails.class, id);
		session.close();
		return data;
	}
	
	
	public static void updateuserdetails (userdetails data) 
	 {
		Session session = hibernateconnection.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.update(data);
		tx.commit();
		session.close();

	}
	
	public static void deleteuserdetails(userdetails data) 
	{
		Session session = hibernateconnection.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.delete(data);
		tx.commit();
		session.close();

	}
	
	public static List<userdetails> getuserdetails()
	{
		Session session = hibernateconnection.getSessionFactory().openSession();
		CriteriaQuery<userdetails> cq = session.getCriteriaBuilder().createQuery(userdetails.class);
		cq.from(userdetails.class);
		List<userdetails> userdetailslist = session.createQuery(cq).getResultList();
		return userdetailslist;
	}
	
	
}
