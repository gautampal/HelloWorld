/**
 * 
 */
package com.gautam.threads;

/**
 * @author Gautam Pal
 *
 */
public class TestRunnable {
	
	public static TestRunnable testRunnable;
	
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		testRunnable = new TestRunnable();
		
		testRunnable.initAndExecute();
		testRunnable.initAndExecute();
		testRunnable.initAndExecute();

	}
	
	public void initAndExecute() throws InterruptedException
	{
		Runnable runnable = new Runnable(testRunnable);
		Runnable.print("STARTING " + runnable.getName());
		runnable.start();
		
		(new Thread() {
			  public void run() {
				  	try {
						Thread.sleep(1000l + (long)(Math.random()*2000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("");
					System.out.println("RESUMING ONE WAITING");
					synchronized (testRunnable)
					{
						testRunnable.notify();
					}
			  }
			 }).start();
		
	}

}
