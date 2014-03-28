/**
 * 
 */
package com.gautam.helpers;

import java.io.IOException;
import java.net.Socket;

/**
 * @author Gautam Pal
 *
 */
public class Util {
	
	/**
	 * Checks if a port is available
	 * 
	 * @param port
	 * @return
	 */
	public static boolean available(int port) {
	    Socket s = null;
	    try {
	        s = new Socket("localhost", port);

	        // If the code makes it this far without an exception it means
	        // application exists and responded.
	        return false;
	    } catch (IOException e) {
	        return true;
	    } finally {
	        if( s != null){
	            try {
	                s.close();
	            } catch (IOException e) {
	                throw new RuntimeException("You should handle this error." , e);
	            }
	        }
	    }
	}
}
