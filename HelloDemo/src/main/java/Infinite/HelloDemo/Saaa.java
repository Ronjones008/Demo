package Infinite.HelloDemo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Saaa {
	public static void main(String[] args) {
		SessionFactory sessionFactory;
		sessionFactory=SessionHelper.getConnection();
		Session session=sessionFactory.openSession();
		Query q = session.createQuery("from EmployeData");
		Transaction t = session.beginTransaction();
		List<EmployeData> employeList  =session.createCriteria(EmployeData.class).list();
		System.out.println(employeList);
	}

}
