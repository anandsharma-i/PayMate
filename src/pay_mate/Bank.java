package pay_mate;

import java.util.Scanner;

class Bank//Class the handles all the bank related tasks except storing transaction history.
{	
	private float main_bal=0.0F,wallet_bal=0.0F;
	String choice=null;float temp_bal=0;int ch=0,flag=0;
	Mon_Hist m1=new Mon_Hist(3);//Object-1 Of class Mon_Hist to store money history of Bank-Account.
	Mon_Hist m2=new Mon_Hist(3);//Object-2 Of class Mon_Hist to store money history of Bank-Account.
	Scanner sc=new Scanner(System.in);
	//Add Money to Bank(directly/UPI)/Wallet Account.
	void add_bal()
	{		
		System.out.println("1.Add money directly to bank.");
		System.out.println("2.Add money to Online-wallet.");
		System.out.println("3.Add money to bank through UPI.");
		System.out.println("\nEnter your choice(1,2,3) :");
		ch=sc.nextInt();
		if(ch==1||ch==3)//Condition for only direct/UPI payments.
		{	
			if(ch==3)//Condition for only UPI payments.
				flag=1;//Updating flag variable.
			this.bank_acc();//Adding money directly Or through UPI to the Bank Account.
		}
		else if(ch==2)//Condition for only Wallet payments			
			this.wallet_acc();//Adding money to the Wallet Account.
		else
			System.out.println("\nInvalid Choice.");
	}
	void bank_acc()//Main-Bank Account
	{
		do
		{
			//Temporary variable to store current amount entered.
			temp_bal=0;
			System.out.println("\nEnter Amount to be added : ");						
			temp_bal=sc.nextFloat();			
			/*Copying the content of the temporary variable to the main_bal variable.
			 * and updating the main_bal variable.*/
			main_bal+=temp_bal;						
			if(flag==1)//Condition for only UPI payments.
			{
				/*!!!Pay-Attention!!!
				 * Updating the transaction history for the UPI payments.
				 * The temp_bal is of float type and is converted to String type.				 
				*/
				m1.push("Rs."+Float.toString(temp_bal)+" added successfully through UPI. ");//(Class Mon_Hist)	
			}
			else//Condition for only direct payments.
			{
				/*!!!Pay-Attention!!!
				 * Updating the transaction history for the direct payments.
				 * The temp_bal is of float type and is converted to String type.				 
				*/
				m1.push("Rs."+Float.toString(temp_bal)+" added successfully. ");//(Class Mon_Hist)			
			}
			System.out.println("\nDo you want to add more money?(Y/N)");
			choice=sc.next();
		}while(choice.equals("Y")||choice.equals("y"));			
			//Printing the receipt if needed. 
			System.out.println("\nDo you want the receipt?(Y/N)");
			choice=sc.next();
			if(choice.equals("Y")||choice.equals("y"))
			{
				System.out.println("\t\t::RECEIPT::");
				//Displaying the current total Bank-Balance.
				System.out.println("Curent total Bank-Balance : Rs."+main_bal+"/-");
				System.out.println("Last Transaction :");
				//Displaying the last Bank transaction.
				m1.display_last();//(Class Mon_Hist)
			}
		flag=0;//Resetting the flag variable.
	}
	void wallet_acc()//Wallet Account.
	{
		do
		{
			//Temporary variable to store current amount entered.
			temp_bal=0;
			System.out.println("\nEnter Amount to be added : ");						
			temp_bal=sc.nextFloat();					 					
			/*Copying the content of the temporary variable to the wallet_bal variable 
			 * and updating the wallet_bal variable.*/
			wallet_bal+=temp_bal;
			/*!!!Pay-Attention!!!
			 * Updating the transaction history for Wallet payments.
			 * The temp_bal is of float type and is converted to String type.			
			*/
			m2.push("Rs."+Float.toString(temp_bal)+" added successfully. ");//(Class Mon_Hist)
			System.out.println("\nDo you want to add more money?(Y/N)");
			choice=sc.next();
		}while(choice.equals("Y")||choice.equals("y"));	
			//Printing the receipt if needed.
			System.out.println("\nDo you want the receipt?(Y/N)");
			choice=sc.next();
			if(choice.equals("Y")||choice.equals("y"))
			{
				System.out.println("\t\t::RECEIPT::");
				//Displaying the current total Wallet-Balance.
				System.out.println("Curent total Wallet-Balance : Rs."+wallet_bal+"/-");
				System.out.println("Last Transaction :");
				//Displaying the last Wallet transaction.
				m2.display_last();//(Class Mon_Hist)
			}
	}	
	void bank_stat()//Print Bank-Statement.
	{		
		System.out.println("1.Bank-Statement");
		System.out.println("2.Wallet Statement");		
		System.out.println("\nEnter your choice(1,2) :");
		ch=sc.nextInt();
		try//For any out of bounds exception.
		{
			if(ch==1)								
				//displaying the Bank transaction history.
				m1.display();//(Class Mon_Hist)				
			else if(ch==2) 			
				//displaying the Wallet transaction history.
				m2.display();//(Class Mon_Hist)			
			else
				System.out.println("\nInvalid-Choice.");
		}catch(ArrayIndexOutOfBoundsException e)
		{
				//System.out.println("\nOut of balance!");
				//System.out.println(e);
		}
	}
	void check_bal()//Get current Total Balance and Last Transaction.
	{		
		System.out.println("1.Bank-Balance.");
		System.out.println("2.Wallet-Balance.");
		System.out.println("\nEnter your choice(1,2) :");
		ch=sc.nextInt();
		try//For any out of bounds exception. 
		{
			if(ch==1)//Condition for Bank Account(Direct & UPI payments).
			{										
					System.out.println("\nCurent total Bank-Balance : Rs."+main_bal+"/-");
					System.out.println("Last Transaction :");
					//Displaying the last Bank transaction.
					m1.display_last();//(Class Mon_Hist)												
			}		
			else if(ch==2)//Condition for Wallet Account(Wallet payments).
			{	
				System.out.println("\nCurrent total Wallet-Balance : Rs."+wallet_bal+"/-");
				System.out.println("Last Transaction :");				
				//Displaying the last Wallet transaction.
				m2.display_last();//(Class Mon_Hist)
			}
			else
				System.out.println("\nInvalid-Choice.");
		}catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("\nOut of balance!");
			/*Executes only once when you try to print the transaction history
			 *  even before you have added anything in the Account.
			*/ 
		}
	}
	void send_money()//To send money from Bank/Wallet Account.
	{	
		do 
		{	temp_bal=0;flag=0;//resetting temporary balance variable & flag variable.
			System.out.println("1.Send money directly through bank.");
			System.out.println("2.Send money through Online-wallet.");
			System.out.println("3.Send money through UPI.");
			System.out.println("\nEnter your choice(1,2,3) :");
			ch=sc.nextInt();				
			if(ch==1||ch==3)//Condition for only Direct/UPI payments.
			{	
				System.out.println("\nEnter the amount to send : ");
				temp_bal=sc.nextFloat();
				if(main_bal-temp_bal>=0)
				{
					main_bal-=temp_bal;//Updating the Bank-Balance
					if(ch==3)//Condition for only UPI payments.
					{		
						//Transaction history being updated.
						m1.push("Rs."+Float.toString(temp_bal)+" sent successfully through UPI. ");//Pay-Attention!!!
						System.out.println("\nTransaction Successful!");
					}
					else//Condition for only Direct payments.
					{
						//Transaction history being updated.
						m1.push("Rs."+Float.toString(temp_bal)+" sent successfully. ");//Pay-Attention!!!
						System.out.println("\nTransaction Successful!");
					}	
				}
				else//Transaction Failure condition.
				{
					System.out.println("\nTransaction Unsuccessful!");
					System.out.println("Please add money,Out of balance!");
					flag=1;					
					m1.push("Rs."+Float.toString(temp_bal)+" transaction failed.");//Pay-Attention!!!			
					break;
				}							
			}
			else if(ch==2)//Condition for Wallet payments.			
			{
				System.out.println("\nEnter the amount to send : ");
				temp_bal=sc.nextFloat();
				if(wallet_bal-temp_bal>=0)
				{
					wallet_bal-=temp_bal;//Updating the Wallet-Balance.
					//Transaction history being updated.
					m2.push("Rs."+Float.toString(temp_bal)+" sent successfully. ");//Pay-Attention!!!
					System.out.println("\nTransaction Successful!");
				} 
				else//Transaction Failure condition.
				{
					System.out.println("\nTransaction Unsuccessful!");
					System.out.println("Please add money,Out of balance!");
					flag=1;
					m2.push("Rs."+Float.toString(temp_bal)+" transaction failed.");//Pay-Attention!!!
				}				
			}
			else
			{
				System.out.println("\nInvalid-Choice.");
				flag=1;
				break;
			}
			if(flag==1)//Condition for coming out of do-while loop.(Transaction Failure condition.)
				break;
			System.out.println("\nDo you want to send more money?(Y/N)");
			choice=sc.next();
		}while(choice.equals("Y")||choice.equals("y"));
		flag=0;//resetting flag variable.
	}
}
