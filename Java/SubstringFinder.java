package CodingChallenges;

/**
 * Coding Challenge:
 * Accept an inputted string, a lower bound and upper bound.
 * Print a substring using the lower and upper bound as indices.
 * 
 * @author Thomas Yamakaitis
 * @date April 18, 2017
 * @origin HackerRank.com
 * @score 5.0/5.0 Points
 */

import java.util.Scanner;

public class SubstringFinder {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
        System.out.println("Enter a string:");
        String S = in.nextLine();
        System.out.println("Enter the lower bound:");
        int start = in.nextInt();
        System.out.println("Enter the upper bound:");
        int end = in.nextInt();
        
        /** 
         * Make sure `start` is less than string length, and `end` is less than string length + 1.
         *  And make sure end is greater than start
         */
        if((start < S.length() && end < S.length()+1) && (end > start) && (start >= 0)) {
        	System.out.println(S.substring(start, end));
        } else {
        	System.out.println("Error: Inputs are invalid. \n"
        			+ "Lower Bound must be >= 0 and Upper Bound must be < length of string. \n"
        			+ "Upper Bound must be > Lower Bound"); // Print error message
        }
    }
}