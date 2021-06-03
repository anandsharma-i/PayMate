package pay_mate;

import java.util.*;

public class Pay_Mate//Main-Class(contains main method). 
{
	public static void main(String[] args) 
	{		
		Scanner sc=new Scanner(System.in);
		Bank b=new Bank();//Object of Class bank. 
		String choice=null;						
		do
		{	//Main-Menu
			System.out.println("\n::WELCOME TO PAY-MATE::");
			System.out.println("1.Add money.");			
			System.out.println("2.Send Money.");
			System.out.println("3.Check Balance.");
			System.out.println("4.Check Bank-Statement.");
			System.out.println("\nEnter your choice(1,2,3,4) :");
			int ch=sc.nextInt();
			switch(ch)
			{			
			case 1:b.add_bal();//Add Money.
				break;
			case 2:b.send_money();//Send Money.
				break;
			case 3:b.check_bal();//Check Balance.
				break;
			case 4:b.bank_stat();//Print Transaction History.
				break;
			default :System.out.println("\nInvalid Choice.");
			}
			System.out.println("\nPress 'Y' for Main-Menu and 'N' for exit.");
			choice=sc.next();
		}while(choice.equals("Y")||choice.equals("y"));
		System.out.println("\nThank-You!");
		sc.close();
	}
}
