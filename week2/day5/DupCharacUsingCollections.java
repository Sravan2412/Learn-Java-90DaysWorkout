package week2.day5;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class DupCharacUsingCollections {
	
	/* PROGRAM:
	 * 1. Write a java program to print the duplicate character using Collections Framework. 
	 * Input: "When life gives you lemons, make lemonade"
	 */

	public static void main(String[] args) {
		
		String input = "When life gives you lemons, make lemonade";
		
	  // 1st Approach using Set Interface
	    /* Set<Character> set = new HashSet<Character>(); 
	     * for (int i = 0; i < input.length(); i++) { 
	     * if(!set.add(input.charAt(i))) {
		 * System.out.print(input.charAt(i)+","); } }
		 */
		
	  // 2nd Approach using List Interface
		/*
		 * ArrayList<Character> list = new ArrayList<>(); 
		 * for (int i = 0; i < input.length(); i++) { 
		 * if(!list.contains(input.charAt(i))) {
		 * list.add(input.charAt(i)); } 
		 * else { System.out.print(input.charAt(i)); 
		 * } }
		 */
		
	  // 3rd Approach
		ArrayList<Character> list = new ArrayList<>();
		ArrayList<Character> dupList = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			if(!list.contains(input.charAt(i))) {
				list.add(input.charAt(i)); }
				else {
					dupList.add(input.charAt(i));
				}
		} System.out.println(list);
	}}
