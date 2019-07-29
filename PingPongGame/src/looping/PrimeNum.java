package looping;

import java.util.Scanner;

public class PrimeNum {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("enter a number");
		int num=sc.nextInt();
		int res=findAllPrimeSum(num);
		System.out.println(res);
		
	}

	public static int findAllPrimeSum(int num) {
		int sum=0;
		for(int i=2;i<=num;i++) {
			if(isPrime(i)) {
				sum+=i;
			}
		}
		return sum;
	}

	public static boolean isPrime(int num) {
		for(int i=2;i<num;i++) {
			if(num%i==0) return false;
		}
		return true;
	}
}
