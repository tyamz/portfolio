package CPS_3962;

public class Department {
	public String dep_name;
	public int dep_id;

	Department() {}
	public Department(String dep, int id) {
		this.dep_name = dep;
		this.dep_id = id;
	}
	public static void main(String[] args) {
		Employee new_hire = new Employee("Tommy Yamakaitis", "1000 Morris Ave., Union, New Jersey", 1, "Software Engineering", 1);
		System.out.println(new_hire+"\n");
		new_hire.changeDep("Web Development", 2);
		System.out.println(new_hire);
   }
}

class Employee extends Department {
	   private String name;
	   private String address;
	   private int number;
	   
	   Employee() {}
	   Employee(String name, String address, int number, String dep, int id) {
	      this.name = name;
	      this.address = address;
	      this.number = number;
	      this.dep_name = dep;
	      this.dep_id = id;
	   }
	   void changeDep(String dep, int id) {
		   this.dep_name = dep;
		   this.dep_id = id;
	   }
	   public String toString() {
		   return "Name: " + this.name + "\nAddress: " + this.address + "\nEmployee #: " + this.number + "\nDepartment: " +  this.dep_name + "\nDepartment #: " + this.dep_id;
	   }
}