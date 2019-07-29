package looping;

import java.util.Random;
import java.util.Scanner;

public class Guessing {

	public static void main(String[] args) {
		System.out.print("Enter a number: ");
		Scanner sc= new Scanner(System.in);
		int num=sc.nextInt();
		System.out.println("number entered= "+ num);
		Random rand =new Random();
		int val=rand.nextInt(100);
		System.out.println(val);
		
	}
	
}
