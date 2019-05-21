public class PPTHelper {
	public static int findTermIndex(char par,int ID)
	{
		int value=-1;
		if(ID==0)
		{
		switch(par)
		{
		case '$':
			value++;
		case ')':
			value++;
		case '(':
			value++;
		case '/':
			value++;
		case '*':
			value++;
		case '-':
			value++;
		case '+':
			value++;
		case 'a':
			value++;
		}
		}else if(ID ==1)
		{
			switch(par)
			{
			case '$':
				value++;
			case ')':
				value++;
			case '(':
				value++;
			case '/':
				value++;
			case '*':
				value++;
			case '-':
				value++;
			case '+':
				value++;
			case '=':
				value++;
			case 'b':
				value++;
			case 'a':
				value++;
			}
		}
		return value;
	}
	
	public static int findNonTermIndex(char par,int ID)
	{
		int value = -1;
		if(ID==0)
		{
			switch(par)
			{
			case 'F':
				value++;
			case 'R':
				value++;
			case 'T':
				value++;
			case 'Q':
				value++;
			case 'E':
				value++;
			}
		}else if(ID ==1)
		{
			switch(par)
			{
			case 'F':
				value++;
			case 'R':
				value++;
			case 'T':
				value++;
			case 'Q':
				value++;
			case 'E':
				value++;
			case 'V':
				value++;
			case 'S':
				value++;
			}
		}
		return value;
	}
}