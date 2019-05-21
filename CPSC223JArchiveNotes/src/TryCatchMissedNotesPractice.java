import java.util.Scanner;

public class TryCatchMissedNotesPractice {
	public static void main(String[] args)
	{
		int x=0;
		Scanner input = new Scanner(System.in);
		try
		{
			System.out.print("Enter an integer >> " );
			x = input.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Exception occurred! Problem parsing to integer");
		}
		System.out.println("x is " + x);
		input.close();
	}
}