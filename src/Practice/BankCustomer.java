package Practice;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class BankCustomer 
{
	//customer details properties
	private String customerName;
	private String customerEmail;
	private long customerContact;
	
	
	//customer account details properties
	private long accountID;
	private String accountType;
	private String accountStatus = "Active";
	private double accountBalance;
	private LocalDateTime accountCreatedAt;
	
	//static account counter variable
	static long accountCounter=0;
	long txCounter=0;
	
	Object[] allTransaction=new Object[1];
	BankTransaction txObj=new BankTransaction();
	
	long txRecordID;
	
	//Customer account creation process
	
//	access_specifier return_type method_name(para_list);
	// returnType->Either Data type or Void
	
	
	Scanner sc=new Scanner(System.in);
	public long addAccount()
	{
		System.out.println("Enter Your Name :");
		customerName=sc.nextLine();
		
		System.out.println("Enter Your Email :");
		customerEmail=sc.nextLine();
		
		System.out.println("Enter Your Contact No:");
		customerContact=sc.nextLong(); sc.nextLine();
		
		
		//Account Details
		System.out.println("Enter Account Type (SB/CA):");
		accountType=sc.nextLine();
		
		System.out.println("Enter Your Deposit Amount :");
		accountBalance=sc.nextDouble(); sc.nextLine();
		
		//Account Creation Date And Time
		accountCreatedAt=LocalDateTime.now();
		
		//Initialization the counter and initialization the account id
		accountID=++accountCounter;
		
		
		txRecordID=txObj.addTransaction(accountID,accountBalance );
		++txCounter;
//		txCounter=txRecordID;
		allTransaction[(int)txCounter-1]=txObj;
		
		System.out.println(Arrays.toString(allTransaction));
		
		return accountID;
		
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double amount, String type) {
		if(type=="CR") {
			this.accountBalance = accountBalance+ amount;
		}else
		{
		this.accountBalance = accountBalance-amount;
		}
	}
	@Override
	public String toString() {
		return "BankCustomer [customerName=" + customerName + ", customerEmail=" + customerEmail + ", customerContact="
				+ customerContact + ", accountID=" + accountID + ", accountType=" + accountType + ", accountStatus="
				+ accountStatus + ", accountBalance=" + accountBalance + ", accountCreatedAt=" + accountCreatedAt + "]";
	}
}
