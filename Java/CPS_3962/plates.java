package CPS_3962;

import java.util.Stack;

public class plates {
	static Stack<ind_plate> plates = new Stack<>();
	static int i = 1;
	
	public static void main(String[] args) {
		while(i <= 10) {
			i++;
			if(i == 8) {
				ind_plate iplate = new ind_plate("Rose",i);
				System.out.println("Plate " + i + " has Rose as its mark.");
				plates.push(iplate);
			} else if(i == 7) {
				ind_plate iplate = new ind_plate("Mary",i);
				System.out.println("Plate " + i + " has Mary as its mark.");
				plates.push(iplate);
			} else if(i == 6) {
				ind_plate iplate = new ind_plate("Ms",i);
				System.out.println("Plate " + i + " has Ms as its mark.");
				plates.push(iplate);
			} else {
				ind_plate iplate = new ind_plate("Any",i);
				plates.push(iplate);
			}
		}
	}
}
class ind_plate {
	String mark;
	int num_plate;
	
	ind_plate() {}
	ind_plate(int n) {
		this.num_plate = n;
	}
	ind_plate(String m, int n) {
		this.mark = m;
		this.num_plate = n;
	}
	
	void setMark(String m) {
		this.mark = m;
	}
	
	String getMark() {
		return this.mark;
	}
}