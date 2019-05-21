import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TicTacToeFrame extends JFrame implements ActionListener
{
	private JMenuBar mainBar;
	private JMenu file;
	private JMenuItem exit;
	private JMenuItem clear;
	private int turn;
	private boolean stop;
	private int score[];
	private JPanel gameBoard;
	private JPanel[][] gameGrid;
	private JPanel[][] gameButtonGrid;
	private JPanel[][] gamePieceGrid;
	private JButton[][] gameButtons;
	private JLabel[][] gameLabels;
	private CardLayout[][] cardLayout;
	private Font pieceFont;
	private Font scoreFont;
	private Font titleFont;
	private JLabel topLabel;
	private JPanel sidePanel;
	private JTextArea sideScore;
	private JTextArea sideTurn;
	private JButton reset;
	private GameBoard game;
	private Player[] players;
	private String scoreMsg;
	
	public TicTacToeFrame()
	{
		super("Tic-Tac-Toe");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		mainBar = new JMenuBar();
		file = new JMenu("File");
		exit = new JMenuItem("Exit");
		clear = new JMenuItem("Clear Score");
		setJMenuBar(mainBar);
		mainBar.add(file);
		file.add(clear);
		file.add(exit);
		exit.addActionListener(this);
		
		pieceFont = new Font("Arial",Font.BOLD,36);
		scoreFont = new Font("Arial",Font.ITALIC,20);
		titleFont = new Font("Arial",Font.BOLD,40);
		
		players = new Player[] {Player.X,Player.O};
		turn = 0;
		stop = false;
		score = new int[] {0,0,0};
		
		//Visualization of Gameboard
		gameBoard = new JPanel();
		gameBoard.setLayout(new GridLayout(3,3,3,3));
		gameGrid = new JPanel[3][3];
		gameButtonGrid = new JPanel[3][3];
		gamePieceGrid = new JPanel[3][3];
		gameButtons = new JButton[3][3];
		gameLabels = new JLabel[3][3];
		cardLayout = new CardLayout[3][3];
		game = new GameBoard();
		
		
		topLabel = new JLabel("Tic-Tac-Toe", SwingConstants.CENTER);
		sidePanel = new JPanel();
		scoreMsg = "Score \n" +players[0].getSymbol()+": " + score[0] +"\n"+
				players[1].getSymbol() + ": " + score[1]
				+ "\nCats: " + score[2];
		sideScore = new JTextArea(scoreMsg);
		sideTurn = new JTextArea("X starts!");
		sideScore.setEditable(false);
		sideTurn.setEditable(false);
		sideScore.setFont(scoreFont);
		sideTurn.setFont(scoreFont);
		reset = new JButton("Reset Board");
		clear.addActionListener(this);
		topLabel.setFont(titleFont);
		sidePanel.setLayout(new GridLayout(3,1,3,3));
		sidePanel.add(sideScore);
		sidePanel.add(sideTurn);
		sidePanel.add(reset);
		add(sidePanel,BorderLayout.WEST);
		add(topLabel,BorderLayout.NORTH);
		reset.addActionListener(this);
		
		
		//Set up visualization
		for(int row = 0; row < 3; row++)
		{
			for(int col = 0; col < 3; col++)
			{
				cardLayout[row][col] = new CardLayout();
				gameGrid[row][col] = new JPanel();
				gameGrid[row][col].setLayout(cardLayout[row][col]);
				gameButtons[row][col] = new JButton();
				gameButtonGrid[row][col] = new JPanel();
				gameButtonGrid[row][col].setLayout(new GridLayout(1,1));
				gameButtonGrid[row][col].add(gameButtons[row][col]);
				gameLabels[row][col] = new JLabel("", SwingConstants.CENTER);
				gameLabels[row][col].setFont(pieceFont);
				gamePieceGrid[row][col] = new JPanel();
				gamePieceGrid[row][col].setLayout(new GridLayout(1,1));
				gamePieceGrid[row][col].add(gameLabels[row][col]);
				gamePieceGrid[row][col].setBackground(Color.WHITE);
				gameGrid[row][col].add(gameButtonGrid[row][col],"Button" + row + ", " + col);
				gameGrid[row][col].add(gamePieceGrid[row][col],"Piece" + row + ", " + col);
				gameBoard.add(gameGrid[row][col]);
				gameButtons[row][col].addActionListener(this);
			}
		}
		add(gameBoard,BorderLayout.CENTER);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == exit)
		{
			System.exit(0);
		}else 
		if(source == clear)
		{
			//Flip over the buttons
			for(int row=0;row<3;row++)
			{
				for(int col=0;col<3;col++)
				{
					cardLayout[row][col].show(gameGrid[row][col],"Button" + row + ", " + col);
				}
			}
			//clear board in GameBoard
			game.dispose();
			stop = false;
			for(int i =0; i<3;i++)
			{
				score[i]=0;
			}
		}else if(source == reset)
		{
			
			for(int row=0;row<3;row++)
			{
				for(int col=0;col<3;col++)
				{
					cardLayout[row][col].show(gameGrid[row][col],"Button" + row + ", " + col);
				}
			}
			game.dispose();
			stop = false;
		}else
		{
			if(stop == false)
			{
				for(int row = 0; row < 3; row++)
				{
					for(int col = 0; col < 3; col++)
					{
						if(source == gameButtons[row][col])
						{
							//switch from button to label!
							cardLayout[row][col].show(gameGrid[row][col],"Piece" + row + ", " + col );
							game.move(row, col, players[turn%2]);
							gameLabels[row][col].setText(""+game.getValue(row, col)+"");
							turn++;
							sideTurn.setText(players[turn%2].getSymbol()+"'s turn!");
						}
					}
				}
			}
		}
		String lastWin = "";
		if(game.isThereWin() & stop == false)
		{
			if(game.getWinner().getSymbol() == players[0].getSymbol())
			{
				score[0]++;
			}else
			{
				score[1]++;
			}
			lastWin = "Last Winner: " + game.getWinner().getSymbol();
			stop = true;
		}
		if(game.isCats()& stop == false)
		{
			score[2]++;
			lastWin = "Cat's Game!";
			stop = true;
		}
		scoreMsg = "Score \n" +players[0].getSymbol()+": " + score[0] +"\n"+ players[1].getSymbol() + ": " + score[1]
				+ "\nCats: " + score[2];
		sideTurn.setText(sideTurn.getText() + "\n" + lastWin);
		sideScore.setText(scoreMsg);
	}
}

