package Practice;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class BankDemo5 {
public static void main(String [] args) {
	
		
		
		Object[] accountDetails=new Object[8];
		Object[] text= {"Name","Email","contactNo","Address","Deposit Amount (Min 500)","Account Status","Account Type","Creation Time"};
		LocalDateTime txDateTime=LocalDateTime.now();
		String txType;
		double txAmount= 0.0;
		char txStatus='S';
		
		
		Object[] AllTxStatement=new Object[1];
		int txCounter=0;
		LocalDateTime Creation ;
	
		char repeatMenu='N';
		do {
		
		System.out.println("Select Your Choice");
		System.out.println("1. Create Account");
		System.out.println("2. withdraw Amount");
		System.out.println("3. Deposit Amount");
		System.out.println("4. View Statement");
		System.out.println("5. Exit");
		
		System.out.println("Enter Your Choice");
		
		Scanner sc= new Scanner(System.in);
		
		int option=sc.nextInt(); sc.nextLine();
		
		String msg=switch(option)
		{
		case 1->
		{	
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
			Creation=LocalDateTime.now();
					accountDetails[7]=Creation;
					txDateTime=Creation;
					txType="CR";
					txAmount=(double)accountDetails[4];
					txStatus='S';
					
					Object[] txStatement=new Object[4];
					txStatement[0]=txDateTime;
					txStatement[1]=txType;
					txStatement[2]=txAmount;
					txStatement[3]=txStatus;
					
					txCounter++;
					AllTxStatement[txCounter-1]=txStatement;
					
					
					System.out.println(Arrays.toString(accountDetails));
						
			yield"Account Create Successfully!";
		}
			
		
		case 2->{
			System.out.println("Enter the Amount For Withdraw");
			txAmount= sc.nextDouble();sc.nextLine();
			txType="DR";
			Creation=LocalDateTime.now();
			txDateTime=Creation;
						
			
			
			AllTxStatement =Arrays.copyOf(AllTxStatement,AllTxStatement.length+1);
			Object[] txStatement=new Object[4];
			txStatement[0]=txDateTime;
			txStatement[1]=txType;
			txStatement[2]=txAmount;
			txStatement[3]=txStatus;
			txCounter++;
			AllTxStatement[txCounter-1]=txStatement;
			
			accountDetails[4]=(double)accountDetails[4]-txAmount;
			System.out.println("Account Balance :"+accountDetails[4]);
			
			yield "Withdraw Amount is  Process under construction";
			
		}
		
//			System.out.println("Withdraw Amount is  Process under construction");
			
		
		case 3->{
			System.out.println("Enter the Amount For Deposit:");
			txAmount= sc.nextDouble();sc.nextLine();
			txType="CR";
			
			Creation=LocalDateTime.now();
			txDateTime=Creation;
			
	
			
			
			AllTxStatement =Arrays.copyOf(AllTxStatement,AllTxStatement.length+1);
			Object [] txStatement=new Object[4];
			txStatement[0]=txDateTime;
			txStatement[1]=txType;
			txStatement[2]=txAmount;
			txStatement[3]=txStatus;
			txCounter++;
			AllTxStatement[txCounter-1]=txStatement;
			
			accountDetails[4]=(double)accountDetails[4]-txAmount;
			System.out.println("Account Balanace"+accountDetails[4]);
		
		yield"Deposit Amount is Process under construction";
		
//			System.out.println("Deposit Amount is Process under construction");
		
		}
		case 4->{
			System.out.println(Arrays.deepToString(AllTxStatement));
			yield "Showing Statement of the Account";
		}
//		"View Statement is  Process under construction";
		
		
		
//			System.out.println("View Statement is  Process under construction");
		
		
		case 5->
		{
			System.exit(0);
			yield "System Exit";
		
		}
		default->"Invalid Input! Try Again!";
		
//			System.out.println("Invalid Input! Try Again!");
		
		
	};
	System.out.println(msg);
	System.out.println("Do you wish to continue(Y/N):");
	repeatMenu=(char)sc.nextLine().toUpperCase().charAt(0);
		}while(repeatMenu=='Y');
			
		
}
}
