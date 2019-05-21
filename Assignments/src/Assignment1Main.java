import java.util.Scanner;

public class Assignment1Main {
	public static void main(String[] args)
	{
		Game_Board board = new Game_Board();
		
		board.display();
		Player[] players = {Player.X,Player.O};
		
		
		Scanner input = new Scanner(System.in);

		int row,col;
		int i = 0;
		boolean keepPlaying = true;
		while(keepPlaying)
		{
		
			System.out.println(players[i%2] + "'s turn Row:" );
			row = input.nextInt()-1;
			System.out.println("Col:" );
			col = input.nextInt()-1;
			while(board.move(row, col, players[i%2])==false)
			{
				System.out.println(players[i%2] + "'s turn Row:" );
				row = input.nextInt()-1;
				System.out.println("Col:" );
				col = input.nextInt()-1;
			}
			board.display();
			if(board.checkforWin())
			{
				System.out.println(players[i%2]+ " wins!");
				keepPlaying = false;
			}
			if(board.checkCatsGame())
			{
				System.out.println("It's a cats game!");
				keepPlaying = false;
			}
			i++;
		}
		
		input.close();
	}
}
