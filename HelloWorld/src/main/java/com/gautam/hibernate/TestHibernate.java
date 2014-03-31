/**
 * 
 */
package com.gautam.hibernate;

import java.util.Date;

import org.hibernate.Session;

import com.gautam.dbentities.DBUser;

/**
 * @author Gautam Pal
 *
 */
public class TestHibernate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + H2");
		Session session = HibernateUtil.getSessionFactory().openSession();
 
		session.beginTransaction();
		DBUser user = new DBUser();
 
		user.setUserId(100);
		user.setUsername("superman");
		user.setCreatedBy("system");
		user.setCreatedDate(new Date());
 
		session.save(user);
		session.getTransaction().commit();

	}

}
