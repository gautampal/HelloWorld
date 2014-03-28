/**
 * 
 */
package com.gautam.db;

import java.sql.SQLException;

import org.h2.tools.Server;

import com.gautam.helpers.Util;

/**
 * @author Gautam Pal
 * 
 * Starts H2 DB on default ports
 * Adds a blocking stop functionality avoiding server restart port binding issues
 *  
 * UI - http://localhost:9082/
 * Connection URL - jdbc:h2:tcp://localhost:9043/mem:dataSource
 * User - sa
 * Pass <blank>
 */
public class Database {
	
    private static final Integer TCPPORT = 9043;
	private static final Integer WEBPORT = 9082;
	
	//45 secs
	private static final Long TIMEOUT = 45000000000l;
	
	private Server webServer = null;
    private Server tcpServer = null;
    
    public Database() throws SQLException
    {
			webServer = Server.createWebServer(
					new String[] { "-web", "-webAllowOthers", "-webPort", WEBPORT.toString() });
			
			tcpServer = Server.createTcpServer(
				     new String[] { "-tcpPort", TCPPORT.toString(), "-tcpAllowOthers", "-tcp" });
    }
    
    public void start() throws SQLException
    {
        print("STARTING GUI at localhost:" + WEBPORT);
        webServer.start();
        
        print("STARTING TCP server at localhost:" + TCPPORT);
		tcpServer.start();
    	
    }
    
    private void print(String str)
	{
		System.out.println( str);
	}
    
    /**
     * Blocking call to stop both Web and the TCP H2 server
     */
    public void stop()
    {
		
		if (webServer!=null)
		{
			print("EXITING GUI SERVER");
			webServer.stop();
		}
		
		
		if (tcpServer!=null)
		{
			print("EXITING DB");
			tcpServer.stop();
		}
		
		long startTime = System.nanoTime();
		long timeWaited = 0l;
		
		boolean webportAlive = !Util.available(WEBPORT);
		boolean tcpportAlive = !Util.available(TCPPORT);
		
		while ((webportAlive || tcpportAlive) && timeWaited < TIMEOUT)
		{
			print("webportAlive " + String.valueOf(webportAlive));
			print("tcpportAlive " + String.valueOf(tcpportAlive));
			print("webportAlive || tcpportAlive " + String.valueOf(webportAlive || tcpportAlive));
			
			try {
				Thread.sleep(11);
				timeWaited = System.nanoTime() - startTime;
				print("timeWaited " + timeWaited);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			webportAlive = !Util.available(WEBPORT);
			tcpportAlive = !Util.available(TCPPORT);
		}
		
		if (webportAlive)
		{
			print("Unable to stop WebServer within time");
		}
		
		if (tcpportAlive)
		{
			print("Unable to stop TcpServer within time");
		}
    }

}
