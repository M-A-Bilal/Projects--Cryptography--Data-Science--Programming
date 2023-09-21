package wk1;

public class BigO {

	public static void main(String[] args) {
		compareFunctions(-100,120);

	}

	// this method represents n^2 (ignoring the constant)
	private static double quadratic(int n) {
		return Math.pow(n, 2) + 500;

	}

	// this method represents 2^n
	private static double exponential(int n) {
		return Math.pow(2, n - 100);
	}

	public static void compareFunctions(int start, int stop) {
		
		for (int i = start; i < stop; i++) {
			
			System.out.printf("n: %d quadratic: %.1f exponential %f ", i, quadratic(i), exponential(i));
			if (exponential(i) > quadratic(i)) {
					System.out.print("f1 < f2\n");
					
			} else {
					System.out.print("f1 > f2\n");
			}
		}
	}
}
