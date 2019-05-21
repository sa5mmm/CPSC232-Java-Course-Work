import java.util.Scanner;

public class MainSequence {
	public static void main(String[] args)
	{
		System.out.println("#--- Tic-Tac-Toe ---#\n");
		GameBoard game = new GameBoard();
		Player[] players = new Player[] {Player.X, Player.O};
		Scanner input = new Scanner(System.in);
		int row, col, playerTurn;
		playerTurn = 0;
		while( game.isThereWin()==false & game.isCats() == false)
		{
			game.displayBoard();
			boolean isValid=false;
			while(isValid == false)
			{
				System.out.println("Player " + players[playerTurn] + "'s turn");
				System.out.println("Chose a row (1-3): ");
				row = input.nextInt();
				System.out.println("Chose a col (1-3): ");
				col = input.nextInt();
				isValid = game.move(row-1, col-1, players[playerTurn]);
			}
			playerTurn = (playerTurn + 1) % 2;
		}
		game.displayBoard();
		input.close();
		if(game.isCats())
		{
			System.out.println("Cat's Game!");
		}
	}

}
