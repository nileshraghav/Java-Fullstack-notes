package Bank;
import java.util.*;
class Customer{
	int acc_no;
	String fname;
	String lname;
	long balance;
	double roi;
	Customer(){
		this.acc_no=0;
		this.fname="";
		this.lname="";
		this.balance=0;
		this.roi=0.06;
	}
	public int getAcc_no() {
		return acc_no;
	}
	public String getFname() {
		return fname;
	}
	public String getLname() {
		return lname;
	}
	public long getBalance() {
		return balance;
	}
	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public void setDetails(int count) {
		long amount;
		String ch;
		Scanner sc=new Scanner(System.in);
		System.out.println("To create a new account please enter the following details: ");
		System.out.println("Enter your first name: ");
		this.setFname(sc.next());
		System.out.println("Enter your last name: ");
		this.setLname(sc.next());
		System.out.println("Mininum amount to be deposited is Rs 10,000, do you still want to continue?(Y/N)");
		ch=(sc.next());
		if(ch.equals("N")||ch.equals("n")) {
			System.out.println("Have a nice day");
			System.exit(0);
		}
		do {
			System.out.println("Please enter an amount greater than or equal to Rs 10,000");
			amount=sc.nextLong();
			if(amount>=10000)
			{
				this.setBalance(amount);
				break;
			}
		}while(true);
		this.setAcc_no(100+count);
		System.out.println("Congratulations, your account number is: "+ this.getAcc_no());
		System.out.println("\nPress any key to continue: ");
		sc.next();
//		sc.close();
	}
	
	public void getDetails() {
		System.out.println("Account number: "+ this.getAcc_no());
		System.out.println("Name: "+ this.getFname()+" "+ this.getLname());
		System.out.println("Balance: "+this.getBalance());
	}
	public void deposit() {
		Scanner sc=new Scanner(System.in);
		long dep;
		System.out.println("Enter amount to be deposited: ");
		dep=sc.nextLong();
		this.balance+=dep;
		System.out.println("Your new balance is: ");
		System.out.println(this.getBalance());
		System.out.println("\nPress any key to continue: ");
		sc.next();
	}
	
	public void withdraw() {
		Scanner sc=new Scanner(System.in);
		long with;
		System.out.println("Enter amount to be withdrawn: ");
		with=sc.nextLong();
		if(with>this.getBalance()) {
			System.out.println("Insufficient funds");
			return;
		}
		this.setBalance(this.balance-with);
		System.out.println("Remaining balance: "+ this.getBalance());
		System.out.println("\nPress any key to continue: ");
		sc.next();
	}
	public void getRateOfInterest() {
		System.out.println("Default bank roi is: "+this.roi);
	}
}
public class Bank {

	public static void main(String[] args) {
		Customer cust[]= new Customer[100];
		Customer currAcc= new Customer();
		int count=0;
		System.out.println("Welcome to XYZ Bank");
		System.out.println();
		int ch;
		Customer c1=new Customer();
		Axis a1 =  new Axis();
		Hdfc h1 = new Hdfc();
		Icici i1= new Icici();
		c1.getRateOfInterest();
		a1.getRateOfInterest();
		h1.getRateOfInterest();
		i1.getRateOfInterest();
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("1.Create a new account");
			System.out.println("2.Log in and check account details");
			System.out.println("3.Deposit into your account");
			System.out.println("4.Withdraw from your account");
			System.out.println("5.Exit");
			System.out.println("Enter your choice: ");
			ch=sc.nextInt();
			switch(ch) {
			
			case 1:

					cust[count]=new Customer();
					cust[count].setDetails(count);
					count++;
					break;
			
			case 2:	
					
					currAcc=checkAcc(cust);
					break;
			
			case 3:
					currAcc.deposit();
					break;
					
			case 4:
					currAcc.withdraw();
					break;
			}
			
		}while(ch<5 && ch>0);
		
		System.out.println("Have a nice day");
	}
	public static Customer checkAcc(Customer cust[]) {
		int acc;

		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("Enter a valid account number: ");
			acc=sc.nextInt();


					if(cust[acc-100]==null) {
						continue;
					}
					else {
						
					
					cust[acc-100].getDetails();
					
					System.out.println("\nPress any key to continue: ");
					sc.next();

					break;}

		}while(true);
		
		return cust[acc-100];

		
	}

}

class Axis extends Customer{
	Axis(){
		super();
		this.roi=0.08;
	}
	public void getRateOfInterest() {
		System.out.println("Axis bank roi is: "+this.roi);
	}
}
class Hdfc extends Customer{
	Hdfc(){
		super();
		this.roi=0.07;
	}
	public void getRateOfInterest() {
		System.out.println("Hdfc bank roi is: "+this.roi);
	}
}
class Icici extends Customer{
	Icici(){
		super();
		this.roi=0.04;
	}
	public void getRateOfInterest() {
		System.out.println("Icici bank roi is: "+this.roi);
	}
}


