/*
 * Mostly Generic Game Board Class
 * (Size of game board would need to be modified for example chess)
 * (move method would need to be modified for example connect four)
 * */
public class Game_Board {
	private char[][] board;
	private int[] lastMove;
	private static int turns;
	
	Game_Board()
	{
		board = new char[3][3];
		Board_Tool.emptyBoard(this);
		lastMove = new int[2];
		turns = 0;
	}
	
	public boolean move(int row, int col,Player playerPar)
	{
		if(Board_Tool.valid(row, col, this))
		{
			setPiece(row, col,playerPar.getPiece());
			lastMove[0] = row;
			lastMove[1] = col;
			turns++;
			return true;
		}else
		{
			System.out.println("Move is not valid!");
			return false;
		}
	}
	public boolean checkforWin()
	{
		if(Board_Tool.checkForWin(lastMove[0], lastMove[1], this))
		{
			return true;
		}
		return false;
	}
	public boolean checkCatsGame()
	{
		if(turns >=9)
		{
			return true;
		}
		return false;
	}
	public void setPiece(int row, int col, char charPar)
	{
		board[row][col] = charPar;
	}
	public char getPiece(int row, int col)
	{
		return board[row][col];
	}
	public void display()
	{
		System.out.println(Board_Tool.getPrintOut(this));
	}
};

