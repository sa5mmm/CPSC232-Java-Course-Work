import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.color.*;


public class JFramePimp extends JFrame implements ActionListener
{
	
	private Font arial;
	private Font lucida;
	private Font ink;
	private JMenuItem arialM;
	private JMenuItem lucidaM;
	private JMenuItem inkM;
	private JLabel homeText;
	private JLabel homeInstructions;
	private JTextField homeName;
	
	private JLabel congratsText;
	private JTextField congratsField;
	
	private JLabel birthdayText;
	private JTextField birthdayField;
	private String name;
	
	
	private CardLayout cardLayout = new CardLayout();
	
	private String[] brightColorNames;
	private Color[] brightColorCodes;
	private String[] darkColorNames;
	private Color[] darkColorCodes;

	private JMenuItem white;
	private JPanel homePane;
	private JPanel congratsPane;
	private JPanel birthdayPane;
	
	
	private JMenuBar mainBar;
	private JMenu file;
	private JMenu select;
	private JMenu colors;
	private JMenu font;
	
	private JMenuItem exit;
	private JMenuItem home;
	private JMenuItem congrats;
	private JMenuItem birthday;
	
	private JMenu bright;
	private JMenu dark;
	private JMenuItem[] brightColors;
	private JMenuItem[] darkColors;
	
	public JFramePimp()
	{
		super("Pimp my JFrame");
		setLayout(cardLayout);
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainBar = new JMenuBar();
		file = new JMenu("File");
		select = new JMenu("Select");
		colors = new JMenu("Colors");
		font = new JMenu("Font");
		arial = new Font("Arial", Font.PLAIN,25);
		lucida = new Font("Lucida Handwriting",Font.PLAIN,25);
		ink = new Font("Ink Free", Font.PLAIN,25);
		
		arialM = new JMenuItem("Arial");
		lucidaM = new JMenuItem("Lucida Handwriting");
		inkM = new JMenuItem("Ink Free");
		
		arialM.addActionListener(this);
		lucidaM.addActionListener(this);
		inkM.addActionListener(this);
		
		font.add(arialM);
		font.add(lucidaM);
		font.add(inkM);
		
		exit = new JMenuItem("Exit");
		home = new JMenuItem("Home");
		congrats = new JMenuItem("Congratulations Card");
		birthday = new JMenuItem("Birthday Card");
		
		bright = new JMenu("Bright");
		dark = new JMenu("Dark");
		
		setJMenuBar(mainBar);
		mainBar.add(file);
		mainBar.add(select);
		mainBar.add(colors);
		mainBar.add(font);
		file.add(exit);
		exit.addActionListener(this);
		select.add(home);
		select.add(congrats);
		select.add(birthday);
		colors.add(bright);
		colors.add(dark);
		
		home.addActionListener(this);
		congrats.addActionListener(this);
		birthday.addActionListener(this);
		
		brightColorNames = new String[] {"Yellow","Pink","Cyan","Green"};
		darkColorNames = new String[] {"Black","Blue","Gray"};
		brightColorCodes = new Color[] {Color.YELLOW,Color.PINK,Color.CYAN,Color.GREEN};
		darkColorCodes = new Color[] {Color.BLACK,Color.BLUE,Color.GRAY};
		brightColors = new JMenuItem[brightColorNames.length];
		darkColors = new JMenuItem[darkColorNames.length];
		white = new JMenuItem("White");
		white.addActionListener(this);
		for(int i = 0; i<brightColorNames.length;i++)
		{
			brightColors[i] = new JMenuItem(brightColorNames[i]);
			bright.add(brightColors[i]);
			brightColors[i].addActionListener(this);
		}
		for(int i = 0; i<darkColorNames.length;i++)
		{
			darkColors[i] = new JMenuItem(darkColorNames[i]);
			dark.add(darkColors[i]);
			darkColors[i].addActionListener(this);
		}
		colors.add(white);
		congratsPane = new JPanel();
		congratsPane.setLayout(new GridLayout(2,1,10,10));
		congratsText = new JLabel();
		congratsField=new JTextField("enter your message here");
		congratsPane.add(congratsText);
		congratsPane.add(congratsField);
		
		birthdayPane = new JPanel();
		birthdayPane.setLayout(new GridLayout(2,1,10,10));
		birthdayText = new JLabel();
		birthdayField = new JTextField("enter your message here");
		birthdayPane.add(birthdayText);
		birthdayPane.add(birthdayField);
		
		homePane = new JPanel();
		homePane.setLayout(new GridLayout(3,1,10,10));
		homeText = new JLabel("Card Desinger Application");
		homeText.setFont(arial);
		homeInstructions = new JLabel("Then Get Started By Making Selections From the Menu");
		homeName = new JTextField("\"Please Enter the Recipient's Name\"");
		homeName.setFont(arial);
		homePane.add(homeText);
		homePane.add(homeName);
		homePane.add(homeInstructions);
		
		add(homePane,"home");
		add(birthdayPane,"birthday");
		add(congratsPane,"congrats");
		
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		Container con = getContentPane();
		
		if(source == exit)
		{
			System.exit(0);
		}else if(source == home)
		{
			cardLayout.show(con, "home");
		}else if(source == congrats)
		{
			name = homeName.getText();
			congratsText.setText("Congratulations " + name);
			cardLayout.show(con, "congrats");
		}else if(source == birthday)
		{
			name = homeName.getText();
			birthdayText.setText("Happy Birthday " + name);
			cardLayout.show(con, "birthday");
		}else if(source == arialM)
		{
			congratsField.setFont(arial);
			birthdayField.setFont(arial);
			congratsText.setFont(arial);
			birthdayText.setFont(arial);
		}
		else if(source == lucidaM)
		{
			congratsField.setFont(lucida);
			birthdayField.setFont(lucida);
			congratsText.setFont(lucida);
			birthdayText.setFont(lucida);
		
		}else if(source == inkM)
		{
			congratsField.setFont(ink);
			birthdayField.setFont(ink);
			congratsText.setFont(ink);
			birthdayText.setFont(ink);
		
		}else if(source == white)
		{
			birthdayPane.setBackground(Color.WHITE);
			congratsPane.setBackground(Color.WHITE);
			homePane.setBackground(Color.WHITE);
		}else
			
			
			
			
		{
			
		for(int i =0; i<brightColors.length;i++)
		{
			if(source == brightColors[i])
			{
				birthdayPane.setBackground(brightColorCodes[i]);
				congratsPane.setBackground(brightColorCodes[i]);
				homePane.setBackground(brightColorCodes[i]);
			}
		}
		for(int i = 0; i<darkColors.length; i++)
		{
			if(source == darkColors[i])
			{
				homePane.setBackground(darkColorCodes[i]);
				congratsPane.setBackground(darkColorCodes[i]);
				birthdayPane.setBackground(darkColorCodes[i]);
			}
		}
		}
	}

}
