/**
 * 
 */
package com.gautam;

import java.util.Date;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

	    return "<html><body><H1>Hello World</H1></body></html>";
	}
	
	@RequestMapping("pushdata")
	@ResponseBody
	public String testHibernate() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		 
		session.beginTransaction();
		DBUser user = new DBUser();
 
		user.setUserId(100);
		user.setUsername("superman");
		user.setCreatedBy("system");
		user.setCreatedDate(new Date());
 
		session.save(user);
		session.getTransaction().commit();
		
	    return "Success";
	}
	
}
