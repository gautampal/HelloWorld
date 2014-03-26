/**
 * 
 */
package com.gautam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
}
