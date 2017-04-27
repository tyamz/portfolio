package Lab6;

public class Testing {
	public static boolean validParentheses(String expr) {
		MyLinkedStack<String> stack = new MyLinkedStack<>();
		for (int i = 0; i < expr.length(); i++) {
			String ch = expr.substring(i,  i+1);
			if (ch.equals("(")) stack.push("(");
			else if (ch.equals(")")) {
				if (stack.isEmptyStack()) return false;
				else stack.pop();
			}
		}
		return stack.isEmptyStack();
	}
	public static boolean validParentheses2(String expr) {
		MyArrayStack<String> stack = new MyArrayStack<>();
		for (int i = 0; i < expr.length(); i++) {
			String ch = expr.substring(i,  i+1);
			if (ch.equals("(")) stack.push("(");
			else if (ch.equals(")")) {
				if (stack.isEmptyStack()) return false;
				else stack.pop();
			}
		}
		return stack.isEmptyStack();
	}
	public static void main(String...strings) {
		System.out.println(validParentheses("(((1234)"));
		System.out.println(validParentheses("(((1234)))"));
		System.out.println(validParentheses2("(((1234)"));
		System.out.println(validParentheses2("(((1234)))"));
	}
}
