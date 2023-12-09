import java.lang.*;

public class Start
{
	public static void main(String args[])
	{
		//Account a = new Account(); // this is an error
		
		
		Customer c = new Customer(10);
		//Customer c = new Customer();
		
		SavingsAccount sa1 = new SavingsAccount();
		sa1.setAccountHolderName("QWE");
		sa1.setAccountNumber(1111);
		sa1.setBalance(21000.0);
		sa1.setInterestRate(10.5);

		SavingsAccount sa2 = new SavingsAccount();
		sa2.setAccountHolderName("ASD");
		sa2.setAccountNumber(1112);
		sa2.setBalance(21000.0);
		sa2.setInterestRate(10.5);		
		
		FixedAccount fa1 = new FixedAccount();
		fa1.setAccountHolderName("MNO");
		fa1.setAccountNumber(1113);
		fa1.setBalance(22000.0);
		fa1.setTenureYear(10);

		FixedAccount fa2 = new FixedAccount();
		fa2.setAccountHolderName("XYZ");
		fa2.setAccountNumber(1114);
		fa2.setBalance(22000.0);
		fa2.setTenureYear(5);

		c.addAccount(sa1);
		c.addAccount(sa2);
		c.addAccount(fa1);
		
		c.showAllAccounts();
		
		c.removeAccount(sa2);
		c.addAccount(fa2);
		
		c.showAllAccounts();
	}
}
