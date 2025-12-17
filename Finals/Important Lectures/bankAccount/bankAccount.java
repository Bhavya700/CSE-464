
import java.lang.*;

public class bankAccount {
	private String firstName, lastName;
	private double initial_balance, balance;
	private double[] deposits = new double[10]; // store last 10 deposits
	private int depositCount;
	
	public bankAccount(String fName, String lName, double iniBalance)
	{
		firstName=fName;
		lastName=lName;
		initial_balance=iniBalance;
		balance = iniBalance;
		depositCount=0;
			
	}
	
	public boolean deposit(double depositAmount)
	{
		if(depositAmount>=0)
		{
		balance=balance+depositAmount;
			if(depositCount<10)
				deposits[depositCount++]=depositAmount;
			else
			{
				depositCount=0;
				deposits[depositCount++]=depositAmount;
			}
		return true;
		}
		else
		{
		return false;
		}
		
	}
	
	public boolean withdraw(double withdrawAmount)
	{
		if(withdrawAmount<= balance)
		{
		balance=balance-withdrawAmount;
		return true;
		}
		else
		{
		return false;
		}
		
	}

	public double getBalance()
	{
		return balance;
	}
	
	public double[] getLastTenDeposits()
	{
	   return deposits;
	}
}
