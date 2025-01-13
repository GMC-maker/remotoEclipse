package Bol8;

public class b8_Ej12 {

	public static void main(String[] args) {
		int n = 5;
		
		System.out.println(" Factorial de "+ n + "! = " + factorial(n));

	}

	public static int factorial(int num) {

		if (num == 0) {
			return 1;
		} else {
			return num * factorial (num -1);
		}

	}
}
