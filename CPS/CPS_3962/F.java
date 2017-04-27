package CPS_3962;

/**
 * @author Thomas Yamakaitis
 * @category Homework #1 - CPS 3962
 * @professor Mr. Houshing Shu
 */

public class F {
	int m;
	int n;
	char op;
	
	F() { }
	F(int mx, int nx, char opr) {
		this.m = mx;
		this.n = nx;
		this.op = opr;
	}
}

class fsum extends F {
	fsum(int mx, int nx) {
		this.m = mx;
		this.n = nx;
	}
	int calculate() {
		return this.m + this.n;
	}
}

class fdifference extends F {
	fdifference(int mx, int nx) {
		this.m = mx;
		this.n = nx;
	}
	int calculate() {
		return this.m - this.n;
	}
}

class fmultiply extends F {
	fmultiply(int mx, int nx) {
		this.m = mx;
		this.n = nx;
	}
	int calculate() {
		return this.m * this.n;
	}
}