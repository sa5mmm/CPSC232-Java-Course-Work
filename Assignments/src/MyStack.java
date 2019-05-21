public class MyStack {
	private int maxSize;
	private char[] stackArray;
	private int top;
	public MyStack(int s)
	{
		maxSize = s;
		stackArray = new char[maxSize];
		top = -1;
	}
	public void push(char j)
	{
		stackArray[++top] = j;
	}
	public char pop()
	{
		return stackArray[top--];
	}
	public char peek()
	{
		return stackArray[top];
	}
	public boolean isEmpty()
	{
		return (top == -1);
	}
	public boolean isFull()
	{
		return (top == maxSize -1);
	}
	public void display()
	{
		String theStack = "";
		for(int i = top; i>=0;i--)
		{
			theStack = theStack + stackArray[i];
		}
		System.out.println(theStack);
	}

}
