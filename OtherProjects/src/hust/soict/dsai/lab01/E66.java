package hust.soict.dsai.lab01;
import java.util.Scanner;

public class E66 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Input size NxM of 2 matrix!");
		System.out.print("Input N: ");
		int n = keyboard.nextInt();
		System.out.print("Input M: ");
		int m = keyboard.nextInt();

		
		double[][] A = new double[1010][1010];
		double[][] B = new double[1010][1010];
		double[][] Result = new double[1010][1010];
	
		System.out.println("Input first matrix!");
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				A[i][j] = keyboard.nextDouble();
			}
		}
		
		System.out.println("Input second matrix!");
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				B[i][j] = keyboard.nextDouble();
				Result[i][j] = A[i][j] + B[i][j];
			}
		}

		System.out.println("Result Matrix:");
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				System.out.printf("%10.3f", Result[i][j]);
			}
			System.out.println();
		}
		
		
	}
}
