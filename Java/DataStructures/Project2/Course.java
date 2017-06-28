package Project2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Course {
	static HashMap<Integer,Integer> courseList = new HashMap<>();
	public static void suggestCourse(int wantedCredit, ArrayList<Integer> courseCredits) {
		int max = courseCredits.get(courseCredits.size()-1);
		int count = 0;
		while (wantedCredit >= max) {
			wantedCredit = wantedCredit - max;
			count++;
		}
		if(max > wantedCredit) {
			courseCredits.remove(courseCredits.size()-1);
		}
		courseList.put(max, count);
		if (courseCredits.isEmpty() || wantedCredit <= 0) {
			return;
		}
		suggestCourse(wantedCredit,courseCredits);
	}
	public static void nonRecSuggestCourse(int wantedCredit, ArrayList<Integer> courseCredits) {
		int max = courseCredits.get(courseCredits.size()-1);
		int count = 0;
		while (!(courseCredits.isEmpty())) {
			if(max > wantedCredit) {
				courseCredits.remove(courseCredits.size()-1);
				courseList.put(max, count);
				if(!courseCredits.isEmpty()) { max = courseCredits.get(courseCredits.size()-1); }
				count = 0;
			}
			if (wantedCredit > 0) {
				wantedCredit = wantedCredit - max;
				count++;
			}
		}
	}
	public static void main(String[] args) {
		int totalCredits;
		ArrayList<Integer> possibleCredits = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of credits you want to take next semester:");
		totalCredits = input.nextInt();
		System.out.println("Enter the list of possible course credits:");
		System.out.println("(Enter a letter or non-integer character when you are done.)");
		while(input.hasNextInt()) {
			possibleCredits.add(input.nextInt());
		}
		Collections.sort(possibleCredits);
		nonRecSuggestCourse(totalCredits,possibleCredits);
		System.out.println("The shortest possible list of credits is:");
		for(int key : courseList.keySet()) {
			System.out.println(courseList.get(key) + " " + key + "-credit courses");
		}
	}
}
