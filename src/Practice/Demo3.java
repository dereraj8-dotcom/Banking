package Practice;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Demo3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Object[] accountDetails=new Object[8];
		
		Object[] text= {"Name","Email","contactNo","Address","Deposit Amount (Min 500)","Account Status","Account Type","Creation Time"};
		
		for(int i=0;i<text.length;i++) {
			if(i==5 || i==7)
			{
				continue;
			}
			System.out.println("Enter Your "+text[i]);
			if(i==2) {
				accountDetails[i]=sc.nextLong(); sc.nextLine();
			}
			else if(i==4) {
				accountDetails[i]=sc.nextDouble();sc.nextLine();
			}
			else {
				accountDetails[i]=sc.nextLine();
			}
		}
		
		accountDetails[5]="Active";
		LocalDateTime Creation =LocalDateTime.now();
				accountDetails[7]=Creation;
				
				System.out.println(Arrays.toString(accountDetails));
		
		
	}

}
