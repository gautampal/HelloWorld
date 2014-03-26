/**
 * 
 */
package com.gautam.threads;

import java.util.Arrays;


/**
 * @author Gautam Pal
 *
 */
public class Runnable extends Thread {
	
	private volatile long delay = 10l;
	private Object waitOn;
	
	public Runnable(Object waitOn) {
		this.waitOn = waitOn;
	}

	public void run()
	{
		for (int i = 0 ; i < 10 ; i++)
		{
			print(String.valueOf(i));
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (i==4)
			{
				synchronized (waitOn)
				{
					try {
						print("SUSPENDING MYSELF");
						waitOn.wait();
					} catch (InterruptedException e) {
						print("RESUMING");
					}
				}
			}
		}
		print("DONE");
	}
	
	public static void print(String str)
	{
		System.out.println(spaces(Thread.currentThread().getName()) + Thread.currentThread().getName() + " :: " + str);
		
	}
	
	public static String spaces(String str)
	{
		int spaces;
		
		try {
			String[] split = str.split("-");
			spaces = Integer.parseInt(split[1]);
		} catch (NumberFormatException | ArrayIndexOutOfBoundsException e2) {
			spaces = 0;
		}
		
		String retStr = "";
		for (int i=0 ; i<spaces*2 ; i++)		{
			retStr += " ";
		}
		
		return retStr;
	}

	public long getDelay() {
		return delay;
	}

	public void setDelay(long delay) {
		this.delay = delay;
	}

}
