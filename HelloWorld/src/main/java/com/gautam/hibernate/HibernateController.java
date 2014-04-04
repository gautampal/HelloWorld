/**
 * 
 */
package com.gautam.hibernate;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gautam.dbentities.DBUser;
import com.gautam.dbentities.Vehicle;
import com.gautam.dbentities.VehicleDetails;
import com.gautam.helpers.Superhero;
import com.gautam.helpers.VehicleType;

/**
 * @author Gautam Pal
 *
 */
@Controller
public class HibernateController {

	@RequestMapping("pushdata")
	@ResponseBody
	public String testHibernate() {

		Session session = HibernateUtil.getSession();
		 
		session.beginTransaction();
		DBUser user = new DBUser();
 
		user.setUsername(Superhero.get());
		user.setCreatedBy("StanLee");
		user.setCreatedDate(new Date());
 
		session.save(user);
		session.getTransaction().commit();
		
		session.beginTransaction();
		List list = session.createCriteria(DBUser.class).list();
		session.getTransaction().commit();
		
	    return "<html><head><title>Success</title></head><body><H1>Rows added- " + list.size() + "</H1><br>" + Arrays.toString(list.toArray()) + "</body></html>";
	}
	
	@RequestMapping("onetoone")
	@ResponseBody
	public String testOneToOne() {
		System.out.println("Hibernate one to one (Annotation)");
		Session session = HibernateUtil.getSession();
 
		session.beginTransaction();
 
		Vehicle vehicle = new Vehicle();
 
		vehicle.name = "Jaguar";
 
		VehicleDetails vehicleDetail = new VehicleDetails();
		vehicleDetail.type = VehicleType.CAR;
		vehicleDetail.numberOfTyres = 4;
 
		vehicle.details = vehicleDetail;
 
		session.save(vehicle);
		session.getTransaction().commit();
 
		return "<html><head><title>Success</title></head><body><H1>Done</H1></body></html>";
	}
	
}
