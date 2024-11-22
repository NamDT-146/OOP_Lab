package hust.soict.dsai.lab01;

import java.util.Scanner;

public class E64 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				String[] ValidMonth = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
						"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December",
						"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec",
						"Jan.", "Feb.", "Mar.", "Apr.", "May.", "Jun.", "Jul.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec."};
				
				int[] Days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
				Scanner keyboard = new Scanner(System.in);
				int month = -1;
				do {
					System.out.println("Input month!");
					String strMonth = keyboard.nextLine();
					strMonth.replaceAll("\n", "");
					for (int i = 0; i < 48; i ++) {
						if (strMonth.equals(ValidMonth[i])) {
							month = i % 12;
						}
					}
				} while (month == -1);
				
				boolean notValidYear = true;
				int year;
				do {
					System.out.println("Input year!");
					notValidYear = false;
					year = 0;
					String strYear = keyboard.nextLine();
					strYear.replaceAll("\n", "");
					for (int i = 0; i < strYear.length(); i ++) {
						if (strYear.charAt(i) < '0' || strYear.charAt(i) > '9') {
							notValidYear = true;
						}
						year = year * 10 + (strYear.charAt(i) - '0');
					}
				} while (notValidYear);
				
				if (month == 1) {
					if (year % 4 == 0) {
						if (year % 100 == 0) {
							if (year % 400 == 0) {
								System.out.println(29);
							}
							else System.out.println(28);
						}
						else System.out.println(29);
					}
					else System.out.println(28);
				}
				else System.out.println(Days[month]);
				
				
	}

}
