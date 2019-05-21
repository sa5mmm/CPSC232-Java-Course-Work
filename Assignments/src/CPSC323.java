/*import java.util.Scanner;

enum Terminals{A('a',0),PLUS('+',1),MINUS('-',2),TIMES('*',3),DIVIDE('/',4),LEFTPERN('(',5),RIGHTPERN(')',6),DOLLAR('$',7);
	private char sign;
	private int index;
	private Terminals(char s,int n)
	{
		sign = s;
		index = n;
	}
	public char getSign()
	{
		return sign;
	}
	public int getIndex()
	{
		return index;
	}
}
enum nonTerminals{E(0,'E'),Q(1,'Q'),T(2,'T'),R(3,'R'),F(4,'F');
	private int index;
	private char sign;
	private nonTerminals(int n,char s)
	{
		index = n;
		sign = s;
	}
	public char getSign()
	{
		return sign;
	}
	public int getIndex()
	{
		return index;
	}

}

public class CPSC323 {
	public static void main(String[] args)
	{
		final String[][] PPT = {{"TQ","","","","","","TQ","",""},
				{"","+TQ","-TQ","","",""," "," "},
				{"FR","","","","","FR","",""},
				{""," "," ","*FR","/FR",""," "," "},
				{"a","","","","","(E)","",""}};
		Scanner input = new Scanner(System.in);
		String phrase ="";
		System.out.println("Please enter a phrase: ");
		phrase = input.nextLine();
		MyStack stack = new MyStack(1000);
		stack.push('E');
		char myPhrase[] = phrase.toCharArray();
		int sizeString = myPhrase.length;
		int current = 0;
		char read = myPhrase[current];
		char state = stack.pop();
		String tableRead;
		int stateN,readN;
		stateN =0;
		readN = 0;
		while(read != '$')
		{
			if(read == state)
		{
			read = myPhrase[++current];
		}
	switch(state)
	{
	case 'E':
		stateN = nonTerminals.E.getIndex();
		break;
	case 'Q':
		stateN = nonTerminals.E.getIndex();
		break;
	case 'T':
		stateN = nonTerminals.E.getIndex();
		break;
	case 'R':
		stateN = nonTerminals.E.getIndex();
		break;
	case 'F':
		stateN = nonTerminals.E.getIndex();
		break;
	default:
		break;
	}
	
	switch(read)
	{
	case 'a':
		readN = Terminals.A.getIndex();
		break;
	case '+':
		readN = Terminals.PLUS.getIndex();
		break;
	case '-':
		readN = Terminals.MINUS.getIndex();
		break;
	case '*':
		readN = Terminals.TIMES.getIndex();
		break;
	case '/':
		readN = Terminals.DIVIDE.getIndex();
		break;
	case '(':
		readN = Terminals.LEFTPERN.getIndex();
		break;
	case ')':
		readN = Terminals.RIGHTPERN.getIndex();
		break;
	case '$':
		readN = Terminals.DOLLAR.getIndex();
		break;
	default:
		break;
	}
	
	tableRead = PPT[stateN][readN];
	try
	{
		for(int i = (tableRead.length()-1);i>-1;i++)
		{
			System.out.println(i);
			char spot = tableRead.charAt(i);
			stack.push(spot);
		}
	}catch(Exception e)
	{
		//nothing to push to stack!
	}
	
	
	}
	}
}
*/