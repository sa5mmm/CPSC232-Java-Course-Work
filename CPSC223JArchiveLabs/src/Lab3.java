/*
 * Samantha M
 * Lab 3
 * Dice
 * */

import javax.swing.JOptionPane;

public class Lab3 {
	public static void main(String args[])
	{
		//constants
		final int STARTCASH = 100;
		final int DIE_SIZE=6;
		final int TWO_FACTOR = 2;
		final int THREE_FACTOR = 3;
		final String RULES = "2 matches - x"+TWO_FACTOR+" your bet\n3 matches - x"
							+THREE_FACTOR+" your bet\n0 matches - lose your bet!\n";
		//Utilities
		boolean play = true;
		int matches, selection;
		final String HEADER= "Royce Rolls";

		//Game pieces
		int[] dice = {1,2,3};
		int cash, bet;
		cash = STARTCASH;

		//Ask if user would like to play dice rolling game
		selection = JOptionPane.showConfirmDialog(null, "Do you want to play a dice game?\n",
				HEADER,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		play = (selection==JOptionPane.YES_OPTION);
		
		while (play)
		{
			bet = 0;
			while(bet>cash||bet==0)//Make sure that the player places a valid bet!
			{
				String stringBet = JOptionPane.showInputDialog(null,"Your cash: $" + cash + "\n"+
							RULES +"Enter the amount you want to bet!",HEADER + " - Place a Bet!",
							JOptionPane.PLAIN_MESSAGE);
				bet = Integer.parseInt(stringBet);
				bet = Math.abs(bet);
				
				if(bet>cash)
				{
					JOptionPane.showMessageDialog(null, "You don't have that much money to bet!\nTry again!",
							HEADER + " - Invalid Bet",JOptionPane.ERROR_MESSAGE);
				}
				if(bet==0)
				{
					JOptionPane.showMessageDialog(null, "You have to bet more than that!\nTry again!",
							HEADER + " - Invalid Bet",JOptionPane.WARNING_MESSAGE);
				}
			}
			
			//ROLL 3 dice
			String results = "";
			for (int i =0;i<dice.length;i++)
			{
				dice[i] = (int)(Math.random()*DIE_SIZE)+1;
				results = results + "Die " + (i+1) + ": " + dice[i] + "\n";
			}
			//Show Results
			JOptionPane.showMessageDialog(null, results, HEADER + " - Roll Results",
					JOptionPane.INFORMATION_MESSAGE);
			//How many matches does user have?
			matches = 1;
			if(dice[0]==dice[1]) {
				matches = matches+1;
			}
			else if(dice[0]==dice[2])
			{
				matches=matches+1;
			}
			if(dice[1]==dice[2])
			{
				matches = matches+1;
			}
			
			
			
			//Build the message to show user if they won!
			String message = "";
			int messageType = 2;//0=Error X 1=information i  2=warning ! 3 = ? 4 = not available
			if(matches==1)
			{
			messageType =0;
			message = "Better Luck next time!";
			results = " - Loser";
			cash = cash -bet;
			}else if(matches==2)
			{
				results = " - WINNER";
				message = message + "Two of your dice match!";
				cash = cash+bet*TWO_FACTOR;
			}else if(matches==3)
			{
				results = " - WINNER";
				message = message + "All three dice match!";
				cash = cash+bet*THREE_FACTOR;
			}
			
			String score = "Your Cash: " + cash;
			message = message + "\n" + score;
			JOptionPane.showMessageDialog(null, message,HEADER + results,messageType);
			String PlayAgain = "\n\nDo you want to play again?\n\n";
			
			if(cash ==0)
			{
				JOptionPane.showMessageDialog(null,"Sorry you ran out of money!",HEADER,JOptionPane.WARNING_MESSAGE);
				selection = JOptionPane.showConfirmDialog(null, "Do you want to start over and play again?" ,
						HEADER,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				play = (selection==JOptionPane.YES_OPTION);
				cash = STARTCASH;
				
			}else {
				selection = JOptionPane.showConfirmDialog(null, score + PlayAgain +RULES ,
						HEADER,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				play = (selection==JOptionPane.YES_OPTION);
			}
			
		}
		
	}

}
