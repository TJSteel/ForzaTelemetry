package main;

import java.text.DecimalFormat;
import projectEuler.*;


public class Main {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		
		/*
		checkAnswer(System.nanoTime(), Problem0001.problem0001(), "233168");
		checkAnswer(System.nanoTime(), Problem0002.problem0002(), "4613732");
		checkAnswer(System.nanoTime(), Problem0003.problem0003(), "6857");
		checkAnswer(System.nanoTime(), Problem0004.problem0004(), "906609");
		checkAnswer(System.nanoTime(), Problem0005.problem0005(), "232792560");
		checkAnswer(System.nanoTime(), Problem0006.problem0006(), "25164150");
		checkAnswer(System.nanoTime(), Problem0007.problem0007(), "104743");
		checkAnswer(System.nanoTime(), Problem0008.problem0008(), "23514624000");
		checkAnswer(System.nanoTime(), Problem0009.problem0009(), "31875000");
		checkAnswer(System.nanoTime(), Problem0010.problem0010(), "142913828922");
		checkAnswer(System.nanoTime(), Problem0011.problem0011(), "70600674");
		checkAnswer(System.nanoTime(), Problem0012.problem0012(), "76576500");
		checkAnswer(System.nanoTime(), Problem0013.problem0013(), "5537376230");
		checkAnswer(System.nanoTime(), Problem0014.problem0014(), "837799");
		checkAnswer(System.nanoTime(), Problem0015.problem0015(), "137846528820");
		checkAnswer(System.nanoTime(), Problem0016.problem0016(), "1366");
		*/
		checkAnswer(System.nanoTime(), Problem0017.problem0017(), "21124");
		//checkAnswer(System.nanoTime(), Problem0018.problem0018(), "");
		//checkAnswer(System.nanoTime(), Problem0019.problem0019(), "");
		//checkAnswer(System.nanoTime(), Problem0020.problem0020(), "");
		
		System.out.println("Program took " + nanoToSeconds(System.nanoTime()-startTime) + " seconds to complete");
	}


	private static void checkAnswer(long startTime, String s1, String s2) {
		System.out.println("Test success = " + (s1.contentEquals(s2)) + ", test produced = " + s1 + ", Answer = " + s2 + ", test took " + nanoToSeconds(System.nanoTime()-startTime) + " seconds to complete");
	}
	
	public static String nanoToSeconds(long i) {
		DecimalFormat df3 = new DecimalFormat("0.########################");
		return df3.format(i / 1000000000d);
	}
	

}
