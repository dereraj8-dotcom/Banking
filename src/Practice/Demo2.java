package Practice;

import java.util.Arrays;
import java.util.Scanner;

public class Demo2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int totalSubjects;
		System.out.println("Enter Your  Total Subjects");
		totalSubjects=sc.nextInt();
		sc.nextLine();
		
		double[] marks= new double [totalSubjects];
		double totalmarks=0;
		
		for(int i=0; i<totalSubjects;i++) {
			System.out.println("Enter Marks for Subject"+(i+1));
			marks[i]=sc.nextDouble();
			sc.nextLine();
			totalmarks=totalmarks+marks[i];
		}
		
		System.out.println(Arrays.toString(marks));
		System.out.println("Average Marks : "+(totalmarks/totalSubjects));
		
	}

}
