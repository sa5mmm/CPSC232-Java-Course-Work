import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MadLibsJFrame extends JFrame implements ActionListener
{
	JLabel welcome,welcome2;
	JLabel namePrompt, verbPrompt, nounPrompt, adjectivePrompt;
	JTextField name, verb, noun, adjective;
	
	JPanel prompts, result;
	JTextArea madlib;
	JButton next, prev, exit;
	CardLayout cardLayout = new CardLayout();
	
	String Noun, Name, Verb, Adjective;
	
	public MadLibsJFrame()
	{
		super("Card Layout");
		setLayout(cardLayout);
		setSize(625,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font welcomeFont = new Font("Arial", Font.BOLD,36);
		Font buttonFont = new Font("Arial", Font.BOLD,20);
		Font promptFont = new Font("Arial",Font.BOLD,14);
		Font textFont = new Font("Arial", Font.PLAIN,16);

		
		welcome = new JLabel("Welcome to Mad Libs");
		welcome2 = new JLabel("Welcome to Mad Libs");
		
		welcome.setFont(welcomeFont);
		welcome2.setFont(welcomeFont);
		
		namePrompt = new JLabel("Please Enter Your Name");
		verbPrompt = new JLabel("Please Enter A Verb ending in \"ing\"");
		nounPrompt = new JLabel("Please Enter A Plural Noun");
		adjectivePrompt = new JLabel("Please Enter An Adjective");
		
		namePrompt.setFont(promptFont);
		verbPrompt.setFont(promptFont);
		nounPrompt.setFont(promptFont);
		adjectivePrompt.setFont(promptFont);
		name = new JTextField(12);
		verb = new JTextField(12);
		noun = new JTextField(12);
		adjective = new JTextField(12);
		madlib = new JTextArea();
		name.setFont(textFont);
		verb.setFont(textFont);
		noun.setFont(textFont);
		adjective.setFont(textFont);
		madlib.setFont(new Font("Arial",Font.PLAIN,24));
		JPanel mainPrompts = new JPanel();
		mainPrompts.setLayout(new FlowLayout());
		mainPrompts.add(namePrompt);
		mainPrompts.add(name);
		mainPrompts.add(verbPrompt);
		mainPrompts.add(verb);
		mainPrompts.add(nounPrompt);
		mainPrompts.add(noun);
		mainPrompts.add(adjectivePrompt);
		mainPrompts.add(adjective);
		
		next = new JButton("Next");
		prev = new JButton("Prev");
		exit = new JButton("Exit");
		next.setFont(buttonFont);
		prev.setFont(buttonFont);
		exit.setFont(buttonFont);
		
		
		
		
		prompts = new JPanel();
		prompts.setLayout(new BorderLayout());
		prompts.add(welcome,BorderLayout.NORTH);
		prompts.add(mainPrompts,BorderLayout.CENTER);
		prompts.add(next,BorderLayout.EAST);
		next.addActionListener(this);
		add(prompts, "Prompts");
		
		
		result = new JPanel();
		result.setLayout(new BorderLayout());
		result.add(welcome2,BorderLayout.NORTH);
		result.add(prev, BorderLayout.WEST);
		result.add(exit, BorderLayout.EAST);
		result.add(madlib,BorderLayout.CENTER);
		prev.addActionListener(this);
		exit.addActionListener(this);
		add(result, "Result");
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == next)
		{
			
			Noun = noun.getText();
			Verb = verb.getText();
			Adjective = adjective.getText();
			Name = name.getText();
			madlib.setText(getLib());
			cardLayout.show(getContentPane(), "Result");
		}else if(source == prev)
		{
			cardLayout.show(getContentPane(), "Prompts");
		}else if(source == exit)
		{
			dispose();
		}
		
	}
	
	public String getLib()
	{
		String lib = "";
		int rand = (int)(Math.random()*2);
		if(rand == 0)
		{
			lib = "Hi there, all you " + Adjective + " little boys and girls!\n"
					+ "This is your old TV buddy, " + Name + "!\n"
					+ "With another " + Adjective + "-hour program of\n"
					+ Verb + " " + Noun + " for all of you!";
		}else
		{
			lib = "Driving a car can be fun...\n"
					+ "If you follow " + Name + "'s " + Adjective + " advice:\n"
					+ "Before " + Verb + ", always stick your " + Noun
					+ "\nout of the window.";
		}
		
		return lib;
	}
	
}
