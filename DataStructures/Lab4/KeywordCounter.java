package Lab4;

/**
 * Lab #4 - Thomas Yamakaitis
 * October 13, 2016
 * Dr. Li - CPS 2232*01 ~ Data Structures
 * Kean University
 * 
 * The purpose of this program is to scan a file and search
 * for particular keywords that are usually found in a java program.
 * The number of each keywords found will be stored in a linked hash map.
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class KeywordCounter {
	LinkedHashMap<String, Integer> lhm = new LinkedHashMap<String, Integer>();
	ArrayList<String> kw = new ArrayList<>(Arrays.asList("package","import","public","class","this","void","private","new","static","try","catch","if","while","switch","for"));
	LinkedHashMap<String, Integer> lhmSort = new LinkedHashMap<String, Integer>();
	String filename;
	
	KeywordCounter() { }
	KeywordCounter(String inputfile) {
		this.filename = inputfile;
	}
	
	private void scanFile() {					// Dr. Li, I'm not sure why, but it seems like there is an issue
		for (int i = 0; i < kw.size(); i++) {	// with the scanning. It is not picking up words like "this" or "for".
			lhm.put(kw.get(i), 0);				// I think it is because they are usually next to symbols like "()" or "."
		}										// For example, "this." or "for(" or "while(". Besides that, it
		File f = new File(this.filename);		// seems to be working correctly. I was thinking of using wildcards,
		try {									// but I don't think there is any simple way to use wildcards with a switch.
			Scanner input = new Scanner(f);		// One of the things I tried was to print all the inputs to check why they were
												// being missed, but it seems to be picking up for() and this. as one whole statement.
			System.out.println("Keywords:");	// I left the print statements, so that you can see.
			while (input.hasNext()) {
				String next = input.next();
				System.out.print(next + " ");
				switch (next) {
					case "package":
					case "import":
					case "public":
					case "class":
					case "this":
					case "void":
					case "private":
					case "new":
					case "static":
					case "try":
					case "catch":
					case "if":
					case "while":
					case "switch":
					case "for":
						lhm.put(next, (lhm.get(next))+1);
						break;
					default:
						break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void sortByValue() {
		for (int i = 0; i < lhm.size(); i++) {
			int min = findIndexOfMin();
			lhmSort.put(kw.get(min), lhm.remove(kw.get(min)));
			kw.remove(min);
			i--;
		}
	}
	private int findIndexOfMin() {
		int min = lhm.get(kw.get(0));
		int mIndex = 0;
		for (int i = 0; i < kw.size(); i++) {
			if (lhm.get(kw.get(i)) < min) {
				min = lhm.get(kw.get(i));
				mIndex = i;
			}
		}
		return mIndex;
	}
	private void printCount() {
		for (String key: lhmSort.keySet()) {
			System.out.println(key + ": " + lhmSort.get(key));
		}
	}
	
	public static void main(String...string) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the file name:");
		String newFile = input.nextLine();
		KeywordCounter kc = new KeywordCounter(newFile);
		kc.scanFile();
		kc.sortByValue();
		kc.printCount();
	}
}
