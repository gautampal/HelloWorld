/**
 * 
 */
package com.gautam.db;

import java.sql.SQLException;

import org.h2.tools.Server;

/**
 * @author Gautam Pal
 *
 */
public class Database {
	
    private Server webServer = null;
    private Server tcpServer = null;
    
    public Database() throws SQLException
    {
			webServer = Server.createWebServer();
			
			tcpServer = Server.createTcpServer(
				     new String[] { "-tcpPort", "9043", "-tcpAllowOthers", "-tcp" });
    }
    
    public void start() throws SQLException
    {
        print("STARTING GUI at default localhost:9082");
        webServer.start();
        
        print("STARTING TCP server at localhost:9043");
		tcpServer.start();
    	
    }
    
    public static void print(String str)
	{
		System.out.println( str);
	}
    
    public void stop()
    {
		print("EXITING GUI SERVER");
		if (webServer!=null)
			webServer.stop();
		
		print("EXITING DB");
		if (tcpServer!=null)
			tcpServer.stop();
    }

}
