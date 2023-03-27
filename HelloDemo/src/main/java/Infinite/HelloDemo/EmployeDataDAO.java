package Infinite.HelloDemo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;



@ManagedBean
@SessionScoped
public class EmployeDataDAO {
	SessionFactory sessionFactory;

	List<EmployeData> empList = new ArrayList<>();


	public List<EmployeData> getEmpList() {
		return empList;
	}

	public void setEmpList(List<EmployeData> empList) {
		this.empList = empList;
	}





	public String addEmploye(EmployeData e) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		session.save(e);
		t.commit();
		return "showEmploye";
	}

	public List<EmployeData> showEdata(){
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(EmployeData.class);
		List<EmployeData> eList = cr.list();    
		return eList;
	}


		public List<EmployeData> searchEmploy(int empId) throws IOException {
			sessionFactory = SessionHelper.getConnection();
			Session session = sessionFactory.openSession();
			Criteria cr = session.createCriteria(EmployeData.class);
			cr.add(Restrictions.eq("empId", empId));
	
			List<EmployeData> eList = cr.list();
	
			setEmpList(eList);
	
			return getEmpList();
		}
		
		

	//	public List<EmployeData> searchEmploy(int empId) throws IOException {
	//		sessionFactory = SessionHelper.getConnection();
	//		Session session = sessionFactory.openSession();
	//		Criteria cr = session.createCriteria(EmployeData.class);
	//		cr.add(Restrictions.eq("empId", empId));
	//
	//		List<EmployeData> eList = cr.list();
	//		FacesContext context = FacesContext.getCurrentInstance();
	//        ExternalContext externalContext = context.getExternalContext();
	//
	//		if (eList.isEmpty()) {
	//        	externalContext.redirect("Search.xhtml?exists=No Record Found");
	//		} else {
	//			setEmpList(eList);
	//		}
	//
	//		return getEmpList();
	//	}

//	public List<EmployeData> searchEmploy(int empId) throws IOException {
//		sessionFactory = SessionHelper.getConnection();
//		Session session = sessionFactory.openSession();
//		Criteria cr = session.createCriteria(EmployeData.class);
//		cr.add(Restrictions.eq("empId", empId));
//		List<EmployeData> eList = cr.list();
//		FacesContext context = FacesContext.getCurrentInstance();
//		ExternalContext externalContext = context.getExternalContext();
//
//		if (eList.) {
//			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No record found for employee ID " + empId, null));
//		} else {
//			setEmpList(eList);
//		}
//		return getEmpList();
//	}

		public String updateEmploy(EmployeData employ){
	        sessionFactory = SessionHelper.getConnection();
	        Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.update(employ);
	        transaction.commit();
	        return " Student Details Updated";
	    }



}



