package CPS_3962;

public class VendingMachine {
	private String VendingState = "";
	
	VendingMachine() {
		
	}
	public void pay() {
		this.VendingState = "Paid";
	}
	public void choose() {
		this.VendingState = "Chosen";
	}
	public void dispense() {
		this.VendingState = "Ready";
	}
	
	public static void main(String[] args) {
		VendingMachine vm = new VendingMachine();
		
		vm.pay();
		System.out.println(vm.VendingState);
		vm.choose();
		System.out.println(vm.VendingState);
		vm.dispense();
		System.out.println(vm.VendingState);
	}
}
