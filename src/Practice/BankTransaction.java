package Practice;

import java.time.LocalDateTime;
import java.util.Scanner;

public class BankTransaction {

	static long txCounter=0;
	private long txID=0;
	private long accID;
	private LocalDateTime txDateTime;
	private String txType;
	private double txAmount;
	private char txStatus='S';
	
	
	
	public BankTransaction addTransaction(String type, long id)
	{
		txObj:txID=++txCounter;
		Scanner sc=new Scanner(System.in);
		
		String txPrint=(type=="CR")? "Deposit" : "withdraw";
		System.out.println("Enter" +txPrint +"Amount:");
		txObj:txAmount=sc.nextDouble(); sc.nextLine();
		
		txType=type;
		txObj:txDateTime=LocalDateTime.now();
		txObj:txStatus='S';
		BankTransaction txObj=new BankTransaction();
		
		txObj.accID=id;
		txObj.txAmount=txAmount;
		txObj.txType=txType;
		txObj.txDateTime=txDateTime;
		txObj.txStatus=txStatus;
		
		return txObj;
		
	}
	public long addTransaction(long ID, double amount)
	{
		++txCounter;
		txType="CR";
		txID=txCounter;
		txDateTime=LocalDateTime.now();
		txStatus='S';
		txAmount=amount;
		accID=ID;
		return txID;
		
		
		
	}
	
	
	@Override
	public String toString() {
		return "BankTransaction [txID=" + txID + ", accID=" + accID + ", txDateTime=" + txDateTime + ", txType="
				+ txType + ", txAmount=" + txAmount + ", txStatus=" + txStatus + "]";
		
	}
	public double getTxAmount() {
		return txAmount;
	}
	public void setTxAmount(double txAmount) {
		this.txAmount = txAmount;
	}
}
