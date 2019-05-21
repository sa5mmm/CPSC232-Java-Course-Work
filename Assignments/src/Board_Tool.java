/*
 * Tools for Game_Board Specifically for Tic-Tac-Toe
 * 
 * 
 * */
public class Board_Tool {
	public static void emptyBoard(Game_Board boardObj)
	{
		for(int i =0; i<3; i++)
		{
			for(int j =0; j<3; j++)
			{
				boardObj.setPiece(i, j, ' ');
			}
		}
	}
	public static String getPrintOut(Game_Board boardObj)
	{
		String board = "";
		for(int i = 0; i<3; i++)
		{
			String line = " ";
			for(int j = 0; j<3; j++)
			{
				line = line + boardObj.getPiece(i, j);
				if(j<2)
				{
					line = line + " | ";
				}
			}
			board = board + line + "\n";
			if(i<2)
			{
			board = board +"---|---|---\n";
			}
		}
		
		return board;
	}
	public static boolean valid(int row, int col, Game_Board boardObj)
	{

		if(boardObj.getPiece(row, col)== ' ')
		{
			return true;
		}
		return false;
	}
	//We are going to check for a win after every move,
	//and only check the row, columns and diagonals affected by move
	public static boolean checkForWin(int row, int col, Game_Board boardObj)
	{	
		char pieceCheck = boardObj.getPiece(row, col);
		
		//Check for horizontal win
		int numPieceInRow = 0;
		for(int colCheck = 0; colCheck < 3; colCheck++)
		{
			if(boardObj.getPiece(row, colCheck) == pieceCheck)
			{
				numPieceInRow++;
			}else//Once we find a piece in the row that doesn't match the current player we can stop, because the row needs to be filled to win!
			{
				break;
			}
		}
		if(numPieceInRow == 3)//If we find three pieces in the row then that player wins!
		{
			return true;
		}
		//Check for vertical win
		int numPieceInCol = 0;
		for(int rowCheck = 0; rowCheck < 3; rowCheck++)
		{
			if(boardObj.getPiece(rowCheck, col) == pieceCheck)
			{
				numPieceInCol++;
			}else//Once we find a piece in the row that doesn't match the current player we can stop, because the row needs to be filled to win!
			{
				break;
			}
		}
		if(numPieceInCol == 3)//If we find three pieces in the row then that player wins!
		{
			return true;
		}
		//We will max only need to check two diagonals!
		//Diagonals only need to be checked if piece is moved in any corner, or center!
		//Anything along top left to bottom diagonal is when row==col, we need to check that diagonal.
		
		// any of these locations are when row == col!
		// X| | 
		//  |X| 
		//  | |X
		//
		int numPieceInDiagLtR = 0;
		if(row == col)
		{
			for(int i = 0; i<3; i++)
			{
				if(boardObj.getPiece(i,i)==pieceCheck)
				{
					numPieceInDiagLtR++;
				}else
				{
					break;
				}
			}
		}
		if(numPieceInDiagLtR == 3)//If we find three pieces in the row then that player wins!
		{
			return true;
		}
		// We need to check this diagonal, when row == 2 and col == 0, row == col, or row == 0 and col == 2
		//  | |X
		//  |X| 
		// X| |
		int numPieceInDiagRtL =0;
		if((row == col) |(row == 2 & col == 0)|(row == 0 & col == 2))//Checking for second diagonal
		{
			int colCheck = 2;
			for(int rowCheck = 0; rowCheck< 3; rowCheck++)
			{
				if(boardObj.getPiece(rowCheck, colCheck)==pieceCheck)
				{
					numPieceInDiagRtL++;
				}else
				{
					break;
				}
			}
		}
		if(numPieceInDiagRtL==3)
		{
			return true;
		}
		
		return false;
	}
}
