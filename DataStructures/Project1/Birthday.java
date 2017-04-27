package Project1;

/**
 * Project #1 - Thomas Yamakaitis
 * October 7, 2016
 * Dr. Li - CPS 2232*01 ~ Data Structures
 * Kean University
 * 
 * The purpose of this program is to collect information from a .txt file and store
 * the information in such a way that it can be easily manipulated. This example uses
 * birthdays mapped to names.
 */

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Birthday implements Comparator<Birthday>{
	String fullName;
	int month;
	int day;
	int year;
	Student student;
	static LinkedHashMap<Student,Birthday> bdays = new LinkedHashMap<>();
	
	// Constructors
	Birthday() {}
	Birthday(String n, int m, int d, int y) {
		this.fullName = n;
		this.month = m;
		this.day = d;
		this.year = y;
	}
	
	// Setter & Getter
	void setMonth(int m) {
		this.month = m;
	}
	void setDay(int d) {
		this.day = d;
	}
	void setStudent(Student s) {
		this.student = s;
	}
	int getMonth() {
		return this.month;
	}
	int getDate() {
		return this.day;
	}
	String getName() {
		return this.fullName;
	}
	Student getStudent() {
		return this.student;
	}
	
	@Override
	public int compare(Birthday x, Birthday y) {
		int temp = ((((x.month*306 + 5) / 10) + (x.day - 1)) - (((y.month*306 + 5) / 10) + (y.day - 1)));
		if (temp > 0) {
			return 1;
		} else if (temp < 0) {
			return -1;
		} else {
			int result = (x.student.lastName).compareToIgnoreCase(y.student.lastName);
			if (result > 0) {
				return 1;
			} else if (result < 0) {
				return -1;
			} else {
				result = (x.student.firstName).compareToIgnoreCase(y.student.firstName);
				if (result > 0) {
					return 1;
				} else if (result < 0) {
					return -1;
				} else {
					return 0;
				}
			}
		}
	}

	
	public static void main(String...strings) {
		collectInfo(); // Collect all info from file
	}
	
	private static void collectInfo() {
		try {
			Scanner input = new Scanner(new FileReader("birthday.txt"));
			int totalClass = input.nextInt();
			for (int x = 0; x < totalClass; ++x) {
				ArrayList<Student> arrClass = new ArrayList<>();
				ArrayList<String> arrQuery = new ArrayList<>();
				System.out.println("Class #" + (x+1) + ":\n");
                if(input.hasNextInt()) {
                	int classPop = input.nextInt();
                	input.nextLine();
                	for (int i = 0; i < classPop; i++) {
                		String fn = input.next();
                		String ln = input.next();
                		String month = input.next();
                		int day = input.nextInt();
                		int year = input.nextInt();
                		int numMonth = 0;
						switch (month) {
							case "JANUARY":
								numMonth = 1;
								break;
							case "FEBRUARY":
								numMonth = 2;
								break;
							case "MARCH":
								numMonth = 3;
								break;
							case "APRIL":
								numMonth = 4;
								break;
							case "MAY":
								numMonth = 5;
								break;
							case "JUNE":
								numMonth = 6;
								break;
							case "JULY":
								numMonth = 7;
								break;
							case "AUGUST":
								numMonth = 8;
								break;
							case "SEPTEMBER":
								numMonth = 9;
								break;
							case "OCTOBER":
								numMonth = 10;
								break;
							case "NOVEMBER":
								numMonth = 11;
								break;
							case "DECEMBER":
								numMonth = 12;
								break;
							default:
								break;
                		}
						String name = fn + " " + ln;
						Birthday bday = new Birthday(name, numMonth, day, year);
						Student stu1 = new Student(fn, ln, bday);
						bday.setStudent(stu1);
						bdays.put(stu1, bday);
						arrClass.add(stu1);
                	}
                }
                if(input.hasNextInt()) {
                    int queryPop = input.nextInt();
                    input.nextLine();
                    for (int i = 0; i < queryPop; i++) {
                   		arrQuery.add(input.nextLine());
                   	}
                    printCheckQuery(arrQuery, arrClass);
                }
                System.out.println();
			}
            input.close();
		} catch (Exception ex) {
	            ex.printStackTrace();
	    }
	}
	private static void printCheckQuery(ArrayList<String> query, ArrayList<Student> aClass) {
		ArrayList<Student> sortedClass = new ArrayList<>(sortClass(aClass));
		Student student = sortedClass.get(0);
		for (int i = 0; i < query.size(); i++) {
			String name = query.get(i);
			for(int j = 0; j < sortedClass.size(); j++) {
				if(name.equals(sortedClass.get(j).fullName)) {
					student = sortedClass.get(j);
				}
			}
			Birthday bday = bdays.get(student);
			if (sortedClass.contains(student)) {
				int nameIn = sortedClass.indexOf(student);
				if (sortedClass.size() > 2 && nameIn > 0 && nameIn < sortedClass.size()-1) {
					Student student2 = sortedClass.get(nameIn + 1);
					Birthday bday2 = bdays.get(student2);
					Student student3 = sortedClass.get(nameIn - 1);
					Birthday bday3 = bdays.get(student3);
					int result2 = compareBD(bday2, bday);
					int result3 = compareBD(bday3, bday);
					if (result2 < result3) {
						System.out.println(student2.fullName + " has the closest birthday to " + student.fullName);
					} else if (result3 < result2) {
						System.out.println(student3.fullName + " has the closest birthday to " + student.fullName);
					} else {
						System.out.println(student2.fullName + " has the closest birthday to " + student.fullName);
					}	
				} else if (sortedClass.size() > 2 && (nameIn == 0 || nameIn == sortedClass.size()-1)) {
					if(nameIn == 0) {
						Student student2 = sortedClass.get(nameIn + 1);
						Birthday bday2 = bdays.get(student2);
						Student student3 = sortedClass.get(sortedClass.size()-1);
						Birthday bday3 = bdays.get(student3);
						int result2 = compareBD(bday2, bday);
						int result3 = compareBD(bday3, bday);
						if (result2 < result3) {
							System.out.println(student2.fullName + " has the closest birthday to " + student.fullName);
						} else if (result3 < result2) {
							System.out.println(student3.fullName + " has the closest birthday to " + student.fullName);
						} else {
							System.out.println(student2.fullName + " has the closest birthday to " + student.fullName);
						}	
					} else {
						Student student2 = sortedClass.get(nameIn - 1);
						Birthday bday2 = bdays.get(student2);
						Student student3 = sortedClass.get(0);
						Birthday bday3 = bdays.get(student3);
						int result2 = compareBD(bday2, bday);
						int result3 = compareBD(bday3, bday);
						if (result2 < result3) {
							System.out.println(student2.fullName + " has the closest birthday to " + student.fullName);
						} else if (result3 < result2) {
							System.out.println(student3.fullName + " has the closest birthday to " + student.fullName);
						} else {
							System.out.println(student3.fullName + " has the closest birthday to " + student.fullName);
						}	
					}
				} else if (sortedClass.size() == 2) {
					if (nameIn == 0) {
						Student student2 = sortedClass.get(nameIn + 1);
						System.out.println(student2.fullName + " has the closest birthday to " + student.fullName);
					} else {
						Student student2 = sortedClass.get(nameIn - 1);
						System.out.println(student2 + " has the closest birthday to " + student.fullName);
					}
				} else {
					System.out.println("Error! " + name + " is the only person in the class!");
				}
			}
		}
	}
	private static int compareBD(Birthday x, Birthday y) {
		int temp1 = Math.abs((((x.month*306 + 5) / 10) + (x.day - 1)) - (((y.month*306 + 5) / 10) + (y.day - 1)));
		int temp2 = Math.abs((365*2000 + 2000/4 - 2000/100 + 2000/400 + (((x.month*306 + 5) / 10) + (x.day - 1))) - (365*2001 + 2001/4 - 2001/100 + 2001/400 + (((y.month*306 + 5) / 10) + (y.day - 1))));
		int temp3 = Math.abs((365*2001 + 2001/4 - 2001/100 + 2001/400 + (((x.month*306 + 5) / 10) + (x.day - 1))) - (365*2000 + 2000/4 - 2000/100 + 2000/400 + (((y.month*306 + 5) / 10) + (y.day - 1))));
		int[] temp = {temp1, temp2, temp3};
		int min = temp1;
		for (int i = 0; i < 3; i++) {
			 if (temp[i] < min) {
				 min = temp[i];
			 }
		}
		if(x.month != 2 && y.month == 2) { // This will account for February
			switch(y.day) {
				case 28:
					min = min - 3;
					break;
				case 29:
					min = min - 2;
					break;
				default:
					break;
			}
		} else if(x.month == 2 && y.month != 2) {
			switch(x.day) {
			case 28:
				min = min - 3;
				break;
			case 29:
				min = min - 2;
				break;
			default:
				break;
			}
		}
		return Math.abs(min);
	}
	private static ArrayList<Student> sortClass(ArrayList<Student> c) {
		ArrayList<Student> sc = new ArrayList<>();
		int size = c.size();
		Student minC = c.get(0);
		int minIndex = 0;
		for (int x = 0; x < size; x++) {
			for (int i = 0; i < c.size(); i++) {
				Birthday minBD = bdays.get(minC);
				Student student1 = c.get(i);
				Birthday bday1 = bdays.get(student1);
				if(student1.fullName != minC.fullName) {
					if (bday1.month < minBD.month) {
						minC = student1;
						minIndex = i;
					} else if (bday1.month == minBD.month) {
						int result = minBD.compare(minBD, bday1);
						if (result > 0) {
							minC = student1;
							minIndex = i;
						} else if (result == 0 && i > minIndex){
							minC = student1;
							minIndex = i;
						}
					}
				}
			}
			sc.add(c.remove(minIndex));
			if(c.size() > 0) {
			minC = c.get(0);
			minIndex = 0;
			}
		}
		return sc;
	}
	
}

