/**
 * 
 */
package com.gautam;

import java.util.Date;

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
		
	    return "<html><head><title>Success</title></head><body><H1>Success</H1></body></html>";
	}
	
}
