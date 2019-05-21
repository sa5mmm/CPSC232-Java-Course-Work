public class BoardTools{
	public static boolean checkValid(int row, int col, GameBoard board)
	{
		if(board.getValue(row,col) == ' ')
		{
			return true;
		}
		return false;
	}
	public static void emptyBoard(GameBoard board)
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				board.board[i][j] = ' ';
			}
		}
	}
	public int boardToInt(GameBoard board)
	{
		int number =0;
		int place = 0;
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				char thisChar = board.getValue(i,j);
				switch(thisChar)
				{
				case 'X':
					number = number + 2*3^place;
				case 'O':
					number = number + 1*3^place;
				case ' ':
					number = number + 0*3^place;
				}
				
			}
		}
		return number;
	}
	public static String printBoard(GameBoard board)
	{
		String display = "";
		for(int row=0; row<3;row++)
		{
			for(int col=0;col<3;col++)
			{
				display = display + " " + board.getValue(row, col) + " ";
				if(col != 2)
				{
					display = display + "|";
				}
			}
			if(row !=2)
			{
			display = display + "\n---|---|---\n";
			}
		}
		display = display + "\n";
		return display;
	}
	public static boolean checkForWin(GameBoard board)
	{
		//check for horizontal wins
		int numX, numO;
		numX = 0;
		numO = 0;
		for(int row = 0; row<3; row++)
		{
			numX=0;
			numO=0;
			for(int col = 0; col<3;col++)
			{
				if(board.getValue(row, col) == ' ')//no win on this one!
				{
					break;
				}else if(board.getValue(row, col)==Player.X.getSymbol())
				{
					numX++;
				}else
				{
					numO++;
				}
				
			}
			if(numX == 3)
			{
				board.setWinner(Player.X);
				return true;
				
			}else if(numO==3)
			{
				board.setWinner(Player.O);
				return true;
			}
		}
		for(int col = 0; col<3; col++)
		{
			numX=0;
			numO=0;
			for(int row = 0; row<3;row++)
			{
				if(board.getValue(row, col) == ' ')//no win on this one!
				{
					break;
				}else if(board.getValue(row, col)==Player.X.getSymbol())
				{
					numX++;
				}else
				{
					numO++;
				}
				
			}
			if(numX == 3)
			{
				board.setWinner(Player.X);
				return true;
				
			}else if(numO==3)
			{
				board.setWinner(Player.O);
				return true;
			}
		}
		
		//Check diagonal!
		numX=0;
		numO=0;
		for(int col = 0; col < 3; col++)
		{
			
			int row = 0;
			row = col;
			if(board.getValue(row, col)==' ')
			{
				break;
			}
			else if(board.getValue(row, col)==Player.X.getSymbol())
			{
				numX++;
			}else
			{
				numO++;
			}
			if(numX == 3)
			{
				board.setWinner(Player.X);
				return true;
				
			}else if(numO==3)
			{
				board.setWinner(Player.O);
				return true;
			}
		}
		numX=0;
		numO=0;
		for(int col = 0; col < 3; col++)
		{
			int row = 0;
			row = 2 - col;
			if(board.getValue(row, col)==' ')
			{
				break;
			}
			else if(board.getValue(row, col)==Player.X.getSymbol())
			{
				numX++;
			}else
			{
				numO++;
			}
			if(numX == 3)
			{
				board.setWinner(Player.X);
				return true;
				
			}else if(numO==3)
			{
				board.setWinner(Player.O);
				return true;
			}
		}
		return false;
	}
}
