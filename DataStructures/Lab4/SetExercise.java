package Lab4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class SetExercise {
	HashSet<String> hs = new HashSet<>(Arrays.asList("New York", "Los Angeles", "Boston"));
	
	TreeSet<String> getTreeSet() {
		TreeSet<String> ts = new TreeSet<String>(this.hs);
		return ts;
	}
	
	public static void main(String...strings) {
		SetExercise se = new SetExercise();
		TreeSet<String> ts = se.getTreeSet();
		for (String s: ts) {
			System.out.println(s);
		}
		
		HashSet<GeometricObject> hsgo = new HashSet<>();
		hsgo.add(new GeometricObject(6.9));
		hsgo.add(new GeometricObject(5.8));
		hsgo.add(new GeometricObject(4.0));
		TreeSet<GeometricObject> ts2 = new TreeSet<GeometricObject>(GeometricObject.mycompA);
		ts2.addAll(hsgo);
		
		for (GeometricObject s: ts2) {
			System.out.println(s);
		}
	}
}
