/**
 * 
 */
package com.gautam.hibernate;

import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
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
 
		vehicle.setName("Jaguar");
		vehicle.setModel("XF");
 
		VehicleDetails vehicleDetail = new VehicleDetails();
		vehicleDetail.setType(VehicleType.CAR);
		vehicleDetail.setNumberOfTyres(4);
		
		vehicle.setDetails(vehicleDetail);
		vehicleDetail.setVehicle(vehicle);
		
		session.save(vehicle);
		session.getTransaction().commit();

		session.beginTransaction();
		 
		vehicle = new Vehicle();
 
		vehicle.setName("F22");
		vehicle.setModel("Raptor");
 
		vehicleDetail = new VehicleDetails();
		vehicleDetail.setType(VehicleType.AIRCRAFT);
		vehicleDetail.setNumberOfTyres(3);
		
		vehicle.setDetails(vehicleDetail);
		vehicleDetail.setVehicle(vehicle);
		
		session.save(vehicle);
		session.getTransaction().commit();

		Criteria criteria = session.createCriteria(Vehicle.class);
		List<Vehicle> vehicles = criteria.list();
		Iterator<Vehicle> iterator = vehicles.iterator();
		
		StringBuilder return_ = new StringBuilder();
		
		return_.append("<html><head><title>Success</title></head><body><table border=\"1\" style=\"width:300px\">");
		
		return_.append("<h1><tr>");
		return_.append("<th>");
		return_.append("ID");
		return_.append("</th>");
		return_.append("<th>");
		return_.append("Name");
		return_.append("</th>");
		return_.append("<th>");
		return_.append("Model");
		return_.append("</th>");
		return_.append("<th>");
		return_.append("Number of tyres");
		return_.append("</th>");
		return_.append("<th>");
		return_.append("Type");
		return_.append("</th>");
		return_.append("</tr></h1>");
		
		while (iterator.hasNext()) { 
			return_.append("<tr>");
			Vehicle next = iterator.next();
			return_.append("<td>");
			return_.append(next.getId());
			return_.append("</td>");
			return_.append("<td>");
			return_.append(next.getName());
			return_.append("</td>");
			return_.append("<td>");
			return_.append(next.getModel());
			return_.append("</td>");
			return_.append("<td>");
			return_.append(next.getDetails().getNumberOfTyres());
			return_.append("</td>");
			return_.append("<td>");
			return_.append(next.getDetails().getType());
			return_.append("</td>");
			return_.append("</tr>");
        } 
		
		return_.append("</body></html>");
		
		return return_.toString();
	}
	
}
