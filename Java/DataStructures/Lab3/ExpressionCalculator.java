package Lab3;

/**
 * Lab #3 - Thomas Yamakaitis
 * September 29, 2016
 * Dr. Li - CPS 2232*01 ~ Data Structures
 * Kean University
 * 
 * The purpose of this program is to use a Stack algorithm for a "complex"
 * calculation that properly uses the order of operations to calculate the
 * result of the example problem.
 */

import java.util.Stack;

public class ExpressionCalculator {
	String expression = "";
	Stack<Integer> operandStack = new Stack<>();
	Stack<Character> operatorStack = new Stack<>();
	
	ExpressionCalculator(String s) {
		expression = s;
	}
	
	private int readOperand(String exp, int i) {
		int value = exp.charAt(i)-'0';
		i++;
		while ((i<exp.length())&&(Character.isDigit(exp.charAt(i)))) {
			value = value*10+exp.charAt(i)-'0';
			i++;
		}
		this.operandStack.push(value);
		return i;
	}

	private void processAll() {
		if (this.operandStack.empty() || this.operatorStack.empty() || this.operandStack.size()==1) { return; }
		char c = this.operatorStack.peek();
		while ((!this.operandStack.empty()) && (c!='(')) {
			int operand2 = this.operandStack.pop();
			int operand1 = this.operandStack.pop();
			c = this.operatorStack.pop();
			switch (c) {
			case '+':
				int n = operand1 + operand2;
				this.operandStack.push(n);
				break;
			case '-':
				n = operand1 - operand2;
				this.operandStack.push(n);
				break;
			case '*':
				n = operand1 * operand2;
				this.operandStack.push(n);
				break;
			case '/':
				n = operand1 / operand2;
				this.operandStack.push(n);
				break;
			case '%':
				n = operand1 % operand2;
				this.operandStack.push(n);
				break;
			default:
				System.out.println("Error!");
			}
			if(this.operatorStack.empty()) { return; } else { c = this.operatorStack.peek(); }
		}
	}
	
	private void processMD() {
		if (this.operandStack.empty() || this.operatorStack.empty() || this.operandStack.size()==1) { return; }
		char c = this.operatorStack.peek();
		while (c=='*'||c=='/'||c=='%') {
			int operand2 = this.operandStack.pop();
			int operand1 = this.operandStack.pop();
			c = this.operatorStack.pop();
			switch (c) {
			case '*':
				int n = operand1 * operand2;
				this.operandStack.push(n);
				break;
			case '/':
				n = operand1 / operand2;
				this.operandStack.push(n);
				break;
			case '%':
				n = operand1 % operand2;
				this.operandStack.push(n);
				break;
			default:
				System.out.println("Error!");
			}
			c = this.operatorStack.peek();
		}
	}
	
	private void process2LeftPar() {
		if (this.operandStack.empty() || this.operatorStack.empty() || this.operandStack.size()==1) { return; }
		int operand2 = this.operandStack.pop();
		int operand1 = this.operandStack.pop();
		char c = this.operatorStack.pop();
		while (c != '(') {
			switch (c) {
			case '+':
				int n = operand1 + operand2;
				this.operandStack.push(n);
				break;
			case '-':
				n = operand1 - operand2;
				this.operandStack.push(n);
				break;
			case '*':
				n = operand1 * operand2;
				this.operandStack.push(n);
				break;
			case '/':
				n = operand1 / operand2;
				this.operandStack.push(n);
				break;
			case '%':
				n = operand1 % operand2;
				this.operandStack.push(n);
				break;
			default:
				System.out.println("Error!");
			}
			c = this.operatorStack.pop();
		}
	}
	
	private int evaluate() {
		int i = 0;
		String exp = this.expression;
		while (i < exp.length()) {
			char c = exp.charAt(i);
			if(Character.isDigit(c)) {
				i = readOperand(exp, i);
			} else {
				switch (c) {
				case '+':
				case '-':
					processAll();
					this.operatorStack.push(c);
					break;
				case '*':
				case '/':
				case '%':
					processMD();
					this.operatorStack.push(c);
					break;
				case '(':
					this.operatorStack.push(c);
					break;
				case ')':
					process2LeftPar();
					break;
				default:
					System.out.println("Error!");
				}
				i++;
			}
		}
		processAll();
		return this.operandStack.pop();
	}

	public static void main(String...strings) {
		String s = "51+(54*(3+2))";
		ExpressionCalculator ec = new ExpressionCalculator(s);
		System.out.println(s+" = " + ec.evaluate());
	}
}
