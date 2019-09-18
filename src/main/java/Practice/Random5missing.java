package Practice;

import java.util.Scanner;



public class Random5missing {

	public static void main(String[] args) {
		
		int temp;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Length of the Array : ");
		
		int n = sc.nextInt();
		
		System.out.println("Enter "+n+" Elements : ");
				
		int[] a = new int[n];
		
		int len = a.length;
		
		for (int i = 0; i < n; i++) {
			
			a[i] = sc.nextInt();
			
		}
		
		for (int i = 0; i < len; i++) {
			
			for (int j = i+1; j <len; j++) {
				
				if (a[i]>a[j]) {
					
					temp = a[i];
					a[i]=a[j];
					a[j] = temp;
					
				}
				
			}
			
		}
		
		
		System.out.println("Ascending order is :");
		
		for (int i = 0; i <= n-1; i++) {
			
			//System.out.println(a[i]+",");
			
			for (int j = 0; j < a.length; j++) {
				
				
				for (int j2 = j+1; j2 < a.length; j2++) {
						
					System.out.println(a[j] + " Between numbers "+a[j2]);
					for (int k = a[j]+1; k < a[j2]; k++) {
						
						System.out.println(k);
						
					}
						break;
				}
			}
		}
		
	}

}
