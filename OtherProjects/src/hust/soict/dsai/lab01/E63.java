package hust.soict.dsai.lab01;

import java.util.Scanner;
public class E63 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Input n!");
		int n = keyboard.nextInt();
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print(' ');
			}
			for (int j = 1; j <= 2 * i - 1; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}

}
