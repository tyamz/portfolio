package Project1;

public class Student {
	String firstName;
	String lastName;
	String fullName;
	Birthday bday;
	
	Student() {}
	Student(String f, String l, Birthday b) {
		this.firstName = f;
		this.lastName = l;
		this.fullName = f + " " + l;
		this.bday = b;
	}
	
	void setName(String f, String l) {
		this.firstName = f;
		this.lastName = l;
		this.fullName = f + " " + l;
	}
	void setBday(Birthday b) {
		this.bday = b;
	}
	String getName() {
		return this.fullName;
	}
	String getFirstName() {
		return this.firstName;
	}
	String getLastName() {
		return this.lastName;
	}
	Birthday getBday() {
		return this.bday;
	}
}
