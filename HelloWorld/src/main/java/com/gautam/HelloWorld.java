/**
 * 
 */
package com.gautam;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gautam.dbentities.DBUser;
import com.gautam.helpers.Superhero;
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
	
}
