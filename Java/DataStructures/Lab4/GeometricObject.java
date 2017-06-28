package Lab4;

import java.util.Comparator;

public class GeometricObject {
	double area = 0;
	double circum = 0;
	
	public static Comparator<GeometricObject> mycompA = new Comparator<GeometricObject>() {
		public int compare(GeometricObject o1, GeometricObject o2) {
			return (int) (o1.area - o2.area);
		}
	};
	public static Comparator<GeometricObject> mycompC = new Comparator<GeometricObject>() {
		public int compare(GeometricObject o1, GeometricObject o2) {
			return (int) (o1.circum - o2.circum);
		}
	};
	
	GeometricObject() { }
	GeometricObject(double a) {
		this.area = a;
	}
	GeometricObject(double a, double c) {
		this.area = a;
		this.circum = c;
	}
	public String toString() {
		return this.area+" ";
	}
}
