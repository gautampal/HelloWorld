/**
 * 
 */
package com.gautam.stringperformance;

import com.gautam.dbentities.Vehicle;

/**
 * @author Gautam Pal
 *
 */
public class testString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int iterations = 1;
		test(iterations);
		System.out.println();
		
		iterations = 100;
		test(iterations);
		System.out.println();
		
		iterations = 10000;
		test(iterations);
		System.out.println();
		
		iterations = 100000;
		test(iterations);
		System.out.println();
	}

	private static void test(int iterations) {
		long startTime = System.nanoTime();
		
		String return_;
		
		for(long i = 0; i < iterations ;++i)
		{
			return_ = "<html><head><title>Success</title></head><body><table border=\"1\" style=\"width:300px\">";
			
			return_ += ("<h1><tr>");
			return_ += "<th>";
			return_ += "ID";
			return_ += "</th>";
			return_ += "<th>";
			return_ += "Name";
			return_ += "</th>";
			return_ += "<th>";
			return_ += "Model";
			return_ += "</th>";
			return_ += "<th>";
			return_ += "Number of tyres";
			return_ += "</th>";
			return_ += "<th>";
			return_ += "Type";
			return_ += "</th>";
			return_ += ("</tr></h1>");
			
			return_ += ("<tr>");
			return_ += ("<td>");
			return_ += (1);
			return_ += ("</td>");
			return_ += ("<td>");
			return_ += ("Jaguar");
			return_ += ("</td>");
			return_ += ("<td>");
			return_ += ("XF");
			return_ += ("</td>");
			return_ += ("<td>");
			return_ += (4);
			return_ += ("</td>");
			return_ += ("<td>");
			return_ += ("CAR");
			return_ += ("</td>");
			return_ += ("</tr>");
			
			return_ += "</body></html>";
		}
		
		long endTime = System.nanoTime();
		
		long time1 = endTime - startTime;
		System.out.println("Time taken String: " + time1 / 1000000000.0);

		long startTime2 = System.nanoTime();
		
		StringBuffer return2 = new StringBuffer();
		
		for(long i = 0; i < iterations ;++i)
		{
			return2.append("<html><head><title>Success</title></head><body><table border=\"1\" style=\"width:300px\">");
			
			return2.append("<h1><tr>");
			return2.append("<th>");
			return2.append("ID");
			return2.append("</th>");
			return2.append("<th>");
			return2.append("Name");
			return2.append("</th>");
			return2.append("<th>");
			return2.append("Model");
			return2.append("</th>");
			return2.append("<th>");
			return2.append("Number of tyres");
			return2.append("</th>");
			return2.append("<th>");
			return2.append("Type");
			return2.append("</th>");
			return2.append(("</tr></h1>"));
			
			return2.append("<tr>");
			return2.append("<td>");
			return2.append(1);
			return2.append("</td>");
			return2.append("<td>");
			return2.append("Jaguar");
			return2.append("</td>");
			return2.append("<td>");
			return2.append("XF");
			return2.append("</td>");
			return2.append("<td>");
			return2.append(4);
			return2.append("</td>");
			return2.append("<td>");
			return2.append("CAR");
			return2.append("</td>");
			return2.append("</tr>");
			
			return2.append("</body></html>");
		}
		
		long endTime2 = System.nanoTime();
		
		long time2 = endTime2 - startTime2;
		System.out.println("Time taken StringBuffer: " + time2 / 1000000000.0);
		System.out.println("StringBuffer is " + (long)((double)(time1 - time2) / time1 * 100) + "% faster for " + iterations + " iterations");
		
		long startTime3 = System.nanoTime();
		
		StringBuilder return3 = new StringBuilder();
		
		for(long i = 0; i < iterations ;++i)
		{
			return2.append("<html><head><title>Success</title></head><body><table border=\"1\" style=\"width:300px\">");
			
			return2.append("<h1><tr>");
			return2.append("<th>");
			return2.append("ID");
			return2.append("</th>");
			return2.append("<th>");
			return2.append("Name");
			return2.append("</th>");
			return2.append("<th>");
			return2.append("Model");
			return2.append("</th>");
			return2.append("<th>");
			return2.append("Number of tyres");
			return2.append("</th>");
			return2.append("<th>");
			return2.append("Type");
			return2.append("</th>");
			return2.append(("</tr></h1>"));
			
			return2.append("<tr>");
			return2.append("<td>");
			return2.append(1);
			return2.append("</td>");
			return2.append("<td>");
			return2.append("Jaguar");
			return2.append("</td>");
			return2.append("<td>");
			return2.append("XF");
			return2.append("</td>");
			return2.append("<td>");
			return2.append(4);
			return2.append("</td>");
			return2.append("<td>");
			return2.append("CAR");
			return2.append("</td>");
			return2.append("</tr>");
			
			return2.append("</body></html>");
		}
		
		long endTime3 = System.nanoTime();
		
		long time3 = endTime3 - startTime3;
		System.out.println("Time taken StringBuilder: " + time3 / 1000000000.0);
		System.out.println("StringBuilder is " + (long)((double)(time1 - time3) / time1 * 100) + "% faster for " + iterations + " iterations");
	}

}
