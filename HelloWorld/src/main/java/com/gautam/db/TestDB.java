package com.gautam.db;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import sun.misc.Signal;
import sun.misc.SignalHandler;

public class TestDB {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		Database database = null;
		
		try {
			try {
				database = new Database();
				database.start();
			} catch (SQLException e1) {
				print("Unable to start DB");
				e1.printStackTrace();
			}
		} catch (Throwable e) {
			e.printStackTrace();
			dbStop(database);
		}
		
		handleSignals(database);
		
        String exit = readLine("Enter text to exit : ");
        System.out.println("You entered : " + exit);
        
        dbStop(database);
	}
	
	private static String readLine(String format, Object... args) throws IOException {
	    if (System.console() != null) {
	        return System.console().readLine(format, args);
	    }
	    System.out.print(String.format(format, args));
	    BufferedReader reader = new BufferedReader(new InputStreamReader(
	            System.in));
	    return reader.readLine();
	}

	private static void dbStop(Database database) {
		print("Shutting down DB");
		if (database != null)
		{
			database.stop();
		}
	}
	
	//Eclipse stop sends a Hangup which is not handled on Windows
	private static void handleSignals(final Database database) {
		try {

			Signal.handle(new Signal("TERM"), new SignalHandler() {
				// Signal handler method for CTRL-C and simple kill command.
				public void handle(Signal signal) {
					dbStop(database);
				}
			});
		} catch (final IllegalArgumentException e) {
			print("No SIGTERM handling in this instance.");
		}
		try {
			Signal.handle(new Signal("INT"), new SignalHandler() {
				// Signal handler method for kill -INT command
				public void handle(Signal signal) {
					dbStop(database);
				}
			});
		} catch (final IllegalArgumentException e) {
			print("No SIGINT handling in this instance.");
		}
		try {

			Signal.handle(new Signal("HUP"), new SignalHandler() {
				// Signal handler method for kill -HUP command
				public void handle(Signal signal) {
					dbStop(database);
				}
			});
		} catch (final IllegalArgumentException e) {
			print("No SIGHUP handling in this instance.");
		}
	}
	
	public static void print(String str)
	{
		System.out.println(str);
	}

}
