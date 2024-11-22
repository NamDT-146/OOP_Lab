package hust.soict.dsai.lab01;

import java.util.Scanner;

public class E65 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Input size N of array!");
		int n = keyboard.nextInt();

		
		double[] a = new double[200010];
		
		int sum = 0;
		int average = 0;
		
		for (int i = 1; i <= n; i++) {
			
			a[i] = keyboard.nextDouble();
			sum += a[i];
			
		}
		
		average = sum / n;
		double t;
		for (int i = 1; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				if (a[i] > a[j]) {
					t = a[i];
					a[i] = a[j];
					a[j] = t;
				}
			}
		}
		
		System.out.print("Sorted array: ");
		for (int i = 1; i <= n; i++) {	
			System.out.print(a[i] + " ");
		}
		System.out.println();
		System.out.println("Sum: " + sum);
		System.out.println("Average: " + average);


		
	}

}
