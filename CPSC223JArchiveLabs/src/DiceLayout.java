//For lab 11
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DiceLayout extends JFrame
implements ActionListener, ItemListener
{
	
	DiceGame game;
	
	
	JLabel welcomeTitle;
	JLabel cashTitle;
	JLabel betTitle;
	
	JButton d1;
	JButton d2;
	JButton d3;
	JButton rules;
	
	JButton cashExit;
	JButton rollDice;
	
	JLabel bottomLeft;
	JLabel bottomRight;
	
	JTextField cashOutput;
	JTextField betHolder;
	
	JComboBox betBox;
	
	JPanel west;
	JPanel east;
	JPanel south;
	JPanel north;
	JPanel center;
	

	public DiceLayout()
	{
		super("Casino Simulator");
		game = new DiceGame();
		setSize(500,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setResizable(false);
		
		north = new JPanel();
		south = new JPanel();
		east = new JPanel();
		west = new JPanel();
		center = new JPanel();
		
		welcomeTitle = new JLabel("Welcome To The High Rollers Game");
		welcomeTitle.setFont(new Font("Arial",Font.BOLD,26));
		
		Font buttonFont = new Font("Arial", Font.BOLD,16);
		
		cashExit = new JButton("Cash Out");
		rollDice = new JButton("Roll Dice");
		rules = new JButton("Rules");
		cashExit.setFont(buttonFont);
		rollDice.setFont(buttonFont);
		rules.setFont(new Font("Arial", Font.PLAIN,12));
		d1 = new JButton("D1");
		d2 = new JButton("D2");
		d3 = new JButton("D3");
		d1.setFont(buttonFont);
		d2.setFont(buttonFont);
		d3.setFont(buttonFont);
		
		cashTitle = new JLabel("Cash Available");
		betTitle = new JLabel ("Place Your Bet");
		Font labelFont = new Font("Arial", Font.BOLD,14);
		Font labelFont2 = new Font("Arial",Font.BOLD,16);
		cashTitle.setFont(labelFont2);
		betTitle.setFont(labelFont2);
		cashOutput = new JTextField();
		cashOutput.setEditable(false);
		cashOutput.setText("$1000");
		cashOutput.setFont(new Font("Arial",Font.ITALIC,16));
		String[] bets = {"Quick Bet","$100","$350","$500"};
		betBox = new JComboBox(bets);
		betBox.setFont(new Font("Arial",Font.BOLD,14));
		bottomLeft = new JLabel("");
		bottomRight = new JLabel("");
		bottomLeft.setFont(labelFont);
		bottomRight.setFont(labelFont);
		betHolder = new JTextField(20);
		betHolder.setEditable(true);
		betHolder.setFont(labelFont);
		
		east.setLayout(new GridLayout(2,1,10,10));
		west.setLayout(new GridLayout(2,1,10,10));
		south.setLayout(new GridLayout(1,3,5,5));
		south.add(bottomLeft);
		south.add(rollDice);
		south.add(bottomRight);
		west.add(cashTitle);
		west.add(cashOutput);
		east.add(cashExit);
		east.add(betBox);
		north.setLayout(new FlowLayout());
		north.add(welcomeTitle);
		center.add(d1);
		center.add(d2);
		center.add(d3);
		center.add(betTitle);
		center.add(betHolder);
		center.add(rules);
		add(north,BorderLayout.NORTH);
		add(south,BorderLayout.SOUTH);
		add(west,BorderLayout.WEST);
		add(east,BorderLayout.EAST);
		add(center,BorderLayout.CENTER);
		
		betBox.addItemListener(this);
		
		cashExit.addActionListener(this);
		rollDice.addActionListener(this);
		rules.addActionListener(this);
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getSource();
		
		if(source == betBox)
		{
			int positionOfSel = betBox.getSelectedIndex();
			if(positionOfSel==1)
			{
				betHolder.setText("100");
			}else if(positionOfSel==2)
			{
				betHolder.setText("350");
			}else if(positionOfSel == 3)
			{
				betHolder.setText("500");
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == rollDice)
		{
			int bet = 0;
			if(game.getCash()>0) {
			try
			{
				bet = Integer.parseInt(betHolder.getText());
				if(game.getCash()>=bet && bet > 0)//got enough cash!
				{
					game.rollDice();
					d1.setText(" " + game.getRoll(1) + " ");
					d2.setText(" " + game.getRoll(2) + " ");
					d3.setText(" " + game.getRoll(3) + " ");
					if(game.getMulti()==-1)//No matches
					{
						bottomLeft.setText("Loser");
						bottomRight.setText("");
					}else if(game.getMulti()==2)//a pair
					{
						bottomLeft.setText("WINNER");
						bottomRight.setText("You got a pair!");
					}else if(game.getMulti()==3)//all three
					{
						bottomLeft.setText("WINNER");
						bottomRight.setText("All three match!");
					}
					game.setCash(bet*game.getMulti());//changes the cash we have!
				}else//Not enough cash
				{
					bottomLeft.setText("Insufficient Funds!");
					bottomRight.setText("Try a smaller bet!");
				}
				cashOutput.setText("$ " + game.getCash());
				if(game.getCash()==0)
				{
					cashExit.setText("Exit");
					bottomLeft.setText("You lose!");
					bottomRight.setText("You Lose!");
				}
				
			}
			catch(NumberFormatException ei)
			{
				JOptionPane.showMessageDialog(null, "Cannot read input!\n"
						+"Try a quick bet!","Invalid Bet!",JOptionPane.WARNING_MESSAGE);
			}
			}
		} else if (source == cashExit)
		{
			super.dispose();
		} else if (source == rules)
		{
			JOptionPane.showMessageDialog(null, "Place a bet and Roll the dice\n"
					+ "Two dice match -> cash + betX2\nThree dice match ->"
					+" cash + betX3\nNo dice match -> cash - bet");
		}
		
	}
}
