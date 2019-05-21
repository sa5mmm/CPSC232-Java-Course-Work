/*
 * Lab 6 goes with Notes 20180927
 * */
import javax.swing.JOptionPane;

public class Lab6 {
	public static void main(String[] args)
	{
		String players[] = {"Catcher","Outfielder","Shortsthop","Batter"};
		int id;
		double avg;
		String num;
		
		num = JOptionPane.showInputDialog(null,"What is the " + players[0] + "'s id?",
				players[0],JOptionPane.QUESTION_MESSAGE);
		id = Integer.parseInt(num);
		num = JOptionPane.showInputDialog(null,"What is the " + players[0] + "'s batting average?",
				players[0],JOptionPane.QUESTION_MESSAGE);
		avg = Double.parseDouble(num);
		Player Catcher = new Player(id,avg);
		displayPlayer(Catcher);
		
		num = JOptionPane.showInputDialog(null,"What is the " + players[2] + "'s id?",
				players[2],JOptionPane.QUESTION_MESSAGE);
		id = Integer.parseInt(num);
		num = JOptionPane.showInputDialog(null,"What is the " + players[2] + "'s batting average?",
				players[2],JOptionPane.QUESTION_MESSAGE);
		avg = Double.parseDouble(num);
		Player Shortstop = new Player(id,avg);
		displayPlayer(Shortstop);
		
		num = JOptionPane.showInputDialog(null,"What is the " + players[1] + "'s batting average?",
				players[1],JOptionPane.QUESTION_MESSAGE);
		avg = Double.parseDouble(num);
		Player Outfielder = new Player(avg);
		displayPlayer(Outfielder);
		
		num = JOptionPane.showInputDialog(null,"What is the " + players[3] + "'s id?",
				players[3],JOptionPane.QUESTION_MESSAGE);
		id = Integer.parseInt(num);
		Player Batter = new Player(id);
		displayPlayer(Batter);
		
		JOptionPane.showMessageDialog(null, "There are " + Batter.getCount() + 
				" players & the team's collective batting average is: " + Outfielder.getTeamAvg());
		
	}
	public static void displayPlayer(Player player)
	{
		JOptionPane.showMessageDialog(null, "Player # " + player.getID() + 
				" batting average is " + player.getAvg() + " There are " + player.getCount() + 
				" players on the team","Display Player", JOptionPane.INFORMATION_MESSAGE);
	}
}
