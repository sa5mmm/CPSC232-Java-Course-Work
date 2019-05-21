public class GameBoard {
	protected char[][] board;
	private changeBoard protector;
	private Player winner;
	GameBoard()
	{
		protector = new changeBoard();
		board = new char[3][3];
		BoardTools.emptyBoard(this);
	}
	public void dispose()
	{
		BoardTools.emptyBoard(this);
		protector.resetCats();
	}
	public boolean isCats()
	{
		if(protector.maybeCats())
		{
			if(!BoardTools.checkForWin(this))//if there aren't any wins, then it's cats game!
			{
				return true;
			}
		}
		return false;
	}
	public boolean move(int row, int col, Player player)
	{
		if(BoardTools.checkValid(row, col, this))
		{
			protector.setPiece(row, col, player.getSymbol());
			return true;
		}
		return false;
	}
	public char getValue(int row, int col)
	{
		return board[row][col];
	}
	public void displayBoard()
	{
		System.out.println(BoardTools.printBoard(this));
	}
	public boolean isThereWin()
	{
		if(BoardTools.checkForWin(this))
		{
			return true;
		}
		return false;
	}
	public Player getWinner()
	{
		return winner;
	}
	protected void setWinner(Player playerPar)
	{
		winner = playerPar;
	}
	private class changeBoard
	{
		private int piecesPlaced;
		public changeBoard()
		{
			piecesPlaced =0;
		}
		public void setPiece(int row, int col, char charPar)
		{
			board[row][col] = charPar;
			piecesPlaced++;
		}
		public boolean maybeCats()
		{
			if(piecesPlaced == 9)
			{
				return true;
			}
			return false;
		}
		public void resetCats()
		{
			piecesPlaced = 0;
		}
	}
}
