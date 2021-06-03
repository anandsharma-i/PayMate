package pay_mate;

public class Mon_Hist//Class for storing the transaction history. 
{
		private String[] stck;//stack array.
		private int tos;//Top of stack variable(controlling-variable).
		int i=0;
		Mon_Hist(int size)//Initialization is done
		{
			stck=new String[size];
			tos=-1;
		}
		protected void push(String item)//For adding transaction statements in the stack.
		{
			//stack-overflow condition.
			if(tos==stck.length-1)//If Stack is full,increase size by double the old size.
			{
				String[] temp=new String[2*stck.length];//creating temporary stack array of double 
														//the old size.
				for(i=0;i<stck.length;i++)
				{
					temp[i]=stck[i];//Copying the original contents from original stack array 
					//to the temporary stack array.
				}
				stck=temp;//copying again from the temporary stack array to the original stack array.
				stck[++tos]=item;//Adding transaction statements to the stack.
			}		
			else//Normal condition.
			{
				stck[++tos]=item;//Adding transaction statements to the stack.			
			}
		}
		protected String pop()//For deleting transaction statements from the stack.
		{
			//stack underflow condition.
			if(tos<0)
			{
				System.out.println("\nStack is empty!");
				return " ";
			}
			else
			{
				return stck[tos--];//Deleting transaction statements from the stack array.
			}		
		}
		protected void display()//To display the complete transaction statements history.
		{
			for(i=0;stck[i]!=null;i++)
			{
				System.out.println((i+1)+". "+stck[i]);
			}
			if(i==0)
				System.out.println("\nNo transaction have been done so far.");
		}
		protected void display_last()//To display the last transaction statement.
		{
			System.out.println((tos+1)+". "+stck[tos]);
		}
}
