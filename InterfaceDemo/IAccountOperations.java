import java.lang.*;

public interface IAccountOperations
{
	public abstract void addAccount(Account a);
	void removeAccount(Account a);
	Account getAccount(int accountNumber);
	void showAllAccounts();
}