import java.util.Scanner;

public class Assignment8 {
	public static void displayTokenString(char[] phrase, int current)
	{
		String tokens = "";
		for(int i = current; i < phrase.length; i++)
		{
			tokens = tokens + phrase[i] + " ";
		}
		System.out.println(tokens);
	}
	public static void main(String[] args)
	{
		boolean error = false;
		//Predictive Parsing Table
		int problemID = 1; //0 is for first problem 1 is for second problem!
		final String[][] PPT0 = {{"TQ","","","","","TQ","",""},
				{"","+TQ","-TQ","","",""," "," "},
				{"FR","","","","","FR","",""},
				{""," "," ","*FR","/FR",""," "," "},
				{"a","","","","","(E)","",""}};
		//i+-*/()$ETF
		
		
		
		
		String[][] PPT;
		//Initate our character stack
		MyStack stack = new MyStack(100);
		stack.push('$');
		char start=' ';
		if(problemID==0)
		{
			start = 'E';
			PPT = new String[5][8];
			PPT = PPT0;
		}else
		{
			PPT = new String[7][10];
			PPT = PPT1;
			start = 'S';
		}
		stack.push(start);//Start
		String[] exs = new String[] {"(a+a)*a$","a*(a/a)$","a(a+a)$","a=(a+a)*b$","a=a*(b-a)$","a=(a+a)b$"};
		Scanner input = new Scanner(System.in);
		String phrase;
		System.out.println("Please enter a phrase: ");
		phrase = exs[5];
		//phrase = input.nextLine();
		char[] tokens = phrase.toCharArray();
		int curToken =0;
		char a,x;
		a = tokens[curToken];
		x = stack.peek();
		while(!stack.isEmpty())
		{
			a = tokens[curToken];
			x = stack.peek();
			while(x==' ')
			{
				stack.pop();
				x = stack.peek();
			}
			if(PPTHelper.findNonTermIndex(x,problemID)==-1)
			{
				if(x==a)
				{
					stack.pop();
					if(++curToken!=phrase.length())
					{
						a = tokens[curToken];
					}
				}else
				{
					//System.out.println("ERROR with if x==a");
					error = true;
				}
			}else
			{
				if(PPT[PPTHelper.findNonTermIndex(x,problemID)][PPTHelper.findTermIndex(a,problemID)]!="")
				{
					stack.pop();
					char[] toPush = PPT[PPTHelper.findNonTermIndex(x,problemID)][PPTHelper.findTermIndex(a,problemID)].toCharArray();
					for(int i = (toPush.length-1);i>=0;i--)
					{
						stack.push(toPush[i]);
					}
				}else
				{
						//System.out.println("ERROR with IF PPT[x][a]!=\"\"");
						error = true;
				}
			}
			System.out.print("Stack >");
			stack.display();
			System.out.print("Tokens >");
			displayTokenString(tokens,curToken);
			if(error)
			{
				break;
			}
			//System.out.println(stack.isEmpty());
		}
		if(x=='$' && a == '$')
		{
			System.out.println(phrase + " is accepted!");
		}else
		{
			System.out.println(phrase + " is rejected!");
		}	
	}
}