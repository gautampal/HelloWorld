/**
 * 
 */
package com.gautam;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gautam.helpers.Superhero;
import com.gautam.hibernate.DBUser;
import com.gautam.hibernate.HibernateUtil;

/**
 * @author Gautam Pal
 *
 */

@Controller
public class HelloWorld {
	
	@RequestMapping("gautam")
	@ResponseBody
	public String printHello() {

	    return "<html><head><title>Gautam test</title></head><body><H1>Hello World</H1></body></html>";
	}
	
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
		
	    return "<html><head><title>Success</title></head><body><H1>Rows added- " + list.size() + "</H1><br>" + list.toArray() + "</body></html>";
	}
	
}
