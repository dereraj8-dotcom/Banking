package Practice;

import java.util.Arrays;
import java.util.Scanner;



public class BankApplication {
	
	public static void main(String[] args) {
		Object[] allCustomer=new Object[1];
		
		Scanner sc=new Scanner (System.in);
		char repeatMenu='Y';
		
		do
		{
			System.out.println("Select Your Choice");
			System.out.println("1. Create Account");
			System.out.println("2. withdraw Amount");
			System.out.println("3. Deposit Amount");
			System.out.println("4. View Statement");
			System.out.println("5. Exit");
			
			System.out.println("Enter Your Choice");
			int option=sc.nextInt(); sc.nextLine();
			
			String msg = switch(option) {
		    case 1 -> {
		    	BankCustomer customer=new BankCustomer();
		        long accID=customer.addAccount();
		        
		        if(accID>1) {
		        allCustomer=Arrays.copyOf(allCustomer, (int)accID);
		        
		        }
		        
		        allCustomer[(int)accID-1]=customer;
		        yield "your Account Created successfully! Account"+accID;
		    }
		    case 2 ->{
		    	System.out.println("Enter Your Account ID :");
		    	long accountID=sc.nextLong(); sc.nextLine();
		    	
		    	BankCustomer customer=new BankCustomer();
		    	customer=(BankCustomer) allCustomer[(int)accountID-1];
		    	customer.allTransaction=	Arrays.copyOf(customer.allTransaction, customer.allTransaction.length+1);
		    	customer.txObj.addTransaction("DR",accountID);
		    	
		     BankTransaction result=new BankTransaction();
		     result=customer.txObj.addTransaction("DR", accountID);
		    	customer.allTransaction[customer.allTransaction.length-1]=result;
		    	customer.setAccountBalance(result.getTxAmount(),"DR");
		    	
		    	for(Object data:customer.allTransaction)
		    	{
		    		System.out.println(data.toString());
		    	}
		    	yield "Success";
		    }
		    
		    case 3 ->{

		    	
		    System.out.println("Enter Your Account ID :");
		    	long accountID=sc.nextLong(); sc.nextLine();
		    	
		    	BankCustomer customer=new BankCustomer();
		    	customer=(BankCustomer) allCustomer[(int)accountID-1];
		    	customer.allTransaction=	Arrays.copyOf(customer.allTransaction, customer.allTransaction.length+1);
		    	customer.txObj.addTransaction("CR",accountID);
		    	
		    BankTransaction result=new BankTransaction();
		    result=customer.txObj.addTransaction("CR", accountID);
		    	customer.allTransaction[customer.allTransaction.length-1]=result;
		    	customer.setAccountBalance(result.getTxAmount(),"CR");
		    	
		    	for(Object data:customer.allTransaction)
		    	{
		    		System.out.println(data.toString());
		    	}
		    	
		    
		    	yield "Success";
		    }
		    case 4->{
		    	System.out.println("Enter Your Account ID");
		    	long accID=sc.nextLong(); sc.nextLine();
		    	
		    	BankCustomer customer=new BankCustomer();
		    	customer=(BankCustomer)allCustomer[(int)accID-1];
		    	
		  
				for(Object tx: customer.allTransaction) {
					System.out.println(tx.toString());
				}
					System.out.println(customer.toString());
		    	
		    	
		    	yield "Success!";
		    	
		    }
		    
		    
		    default->"Under Contruction";
		};
		
		System.out.println(msg);
		
		
					
			System.out.println("Do you wish to continue(Y/N):");
			repeatMenu=(char)sc.nextLine().toUpperCase().charAt(0);
		}while(repeatMenu =='Y');
		
		
	}
}
