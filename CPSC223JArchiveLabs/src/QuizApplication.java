import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class QuizApplication extends JFrame
implements ActionListener,ItemListener {
	
	final int FRAMEWIDTH = 450;
	final int FRAMEHEIGHT = 400;
	
	JLabel title;
	JLabel question1;
	JLabel question2;
	JLabel question3;
	JLabel question4;
	
	JCheckBox answer1a;
	JCheckBox answer1b;
	JCheckBox answer1c;
	JCheckBox answer1d;
	
	ButtonGroup answer1;
	
	JCheckBox answer2a;
	JCheckBox answer2b;
	JCheckBox answer2c;
	JCheckBox answer2d;
	ButtonGroup answer2;
	
	JComboBox answer3;
	String[] answer3Array = {"T/F","True","False"};
	
	JCheckBox answer4a;
	JCheckBox answer4b;
	JCheckBox answer4c;
	JCheckBox answer4d;
	ButtonGroup answer4;
	
	JButton submit;
	JLabel scoreLabel;
	boolean[] answersRight;
	
	public QuizApplication()
	{
		super("JAVA QUIZ");
		setSize(FRAMEWIDTH,FRAMEHEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		answersRight = new boolean[] {false,false,false,false};
		title = new JLabel("223J Quiz Application");
		question1 = new JLabel("1) A variable can be referenced from its ");
		question2 = new JLabel("2) Methods referenced with individual objects are ");
		question3 = new JLabel("3) Most Class Data Fields are Private ");
		question4 = new JLabel("4) Java classes are stored in a folder or ");
		
		answer1a = new JCheckBox("Range",false);
		answer1b = new JCheckBox("Space",false);
		answer1c = new JCheckBox("Domain",false);
		answer1d = new JCheckBox("Scope",false);
		
		answer1 = new ButtonGroup();
		answer1.add(answer1a);
		answer1.add(answer1b);
		answer1.add(answer1c);
		answer1.add(answer1d);
		
		
		answer2a = new JCheckBox("Private",false);
		answer2b = new JCheckBox("Public",false);
		answer2c = new JCheckBox("Static",false);
		answer2d = new JCheckBox("NonStatic",false);
		answer2 = new ButtonGroup();
		answer2.add(answer2a);
		answer2.add(answer2b);
		answer2.add(answer2c);
		answer2.add(answer2d);
		
		answer3 = new JComboBox(answer3Array);
		
		answer4a = new JCheckBox("Packet",false);
		answer4b = new JCheckBox("Package",false);
		answer4c = new JCheckBox("Bundle",false);
		answer4d = new JCheckBox("Gaggle",false);
		answer4 = new ButtonGroup();
		answer4.add(answer4a);
		answer4.add(answer4b);
		answer4.add(answer4c);
		answer4.add(answer4d);
		
		submit = new JButton("Submit");
		scoreLabel = new JLabel("Score: /20");
		
		answer1a.addItemListener(this);
		answer1b.addItemListener(this);
		answer1c.addItemListener(this);
		answer1d.addItemListener(this);
		
		answer2a.addItemListener(this);
		answer2b.addItemListener(this);
		answer2c.addItemListener(this);
		answer2d.addItemListener(this);
		
		answer3.addItemListener(this);
		
		answer4a.addItemListener(this);
		answer4b.addItemListener(this);
		answer4c.addItemListener(this);
		answer4d.addItemListener(this);
		
		submit.addActionListener(this);
		
		title.setFont(new Font("Arial",Font.BOLD,30));
		question1.setFont(new Font("Arial",Font.ITALIC,20));
		question2.setFont(new Font("Arial",Font.ITALIC,18));
		question3.setFont(new Font("Arial",Font.ITALIC,18));
		question4.setFont(new Font("Arial",Font.ITALIC,22));
		
		submit.setFont(new Font("Arial",Font.BOLD,18));
		scoreLabel.setFont(new Font("Arial",Font.BOLD,30));
		
		answer1a.setFont(new Font("Courier New",Font.PLAIN,16));
		answer1b.setFont(new Font("Courier New",Font.PLAIN,16));
		answer1c.setFont(new Font("Courier New",Font.PLAIN,16));
		answer1d.setFont(new Font("Courier New",Font.PLAIN,16));
		
		answer2a.setFont(new Font("Courier New",Font.PLAIN,16));
		answer2b.setFont(new Font("Courier New",Font.PLAIN,16));
		answer2c.setFont(new Font("Courier New",Font.PLAIN,16));
		answer2d.setFont(new Font("Courier New",Font.PLAIN,16));
		
		answer3.setFont(new Font("Courier New",Font.PLAIN,16));
		
		answer4a.setFont(new Font("Courier New",Font.PLAIN,16));
		answer4b.setFont(new Font("Courier New",Font.PLAIN,16));
		answer4c.setFont(new Font("Courier New",Font.PLAIN,16));
		answer4d.setFont(new Font("Courier New",Font.PLAIN,16));
		
		setLayout(new FlowLayout());
		add(title);
		
		add(question1);
		add(answer1a);
		add(answer1b);
		add(answer1c);
		add(answer1d);
		
		add(question2);
		add(answer2a);
		add(answer2b);
		add(answer2c);
		add(answer2d);
		
		add(question3);
		add(answer3);
		
		add(question4);
		add(answer4a);
		add(answer4b);
		add(answer4c);
		add(answer4d);
		
		add(submit);
		add(scoreLabel);
		
		
	}
	
	
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object source1 = e.getItem();
		int select = e.getStateChange();
		Object source2 = e.getSource();
		
		if(source1 == answer1a)
		{
			if(select == ItemEvent.SELECTED)
			{
				answersRight[0]=false;
				//if correct answer add 5 to score else do nothing!
			}else if(select == ItemEvent.DESELECTED)
			{
				//if correct answer subtract 5 from score else do nothing!
			}
		}else if(source1 == answer1b)
		{
			if(select == ItemEvent.SELECTED)
			{
				answersRight[0]=false;
				//if correct answer add 5 to score else do nothing!
			}else if(select == ItemEvent.DESELECTED)
			{
				//if correct answer subtract 5 from score else do nothing!
			}
		}else if(source1 == answer1c)
		{
			if(select == ItemEvent.SELECTED)
			{
				answersRight[0]=false;
				//if correct answer add 5 to score else do nothing!
			}else if(select == ItemEvent.DESELECTED)
			{
				//if correct answer subtract 5 from score else do nothing!
			}
		}else  if(source1 == answer1d)
		{
			if(select == ItemEvent.SELECTED)
			{
				answersRight[0]=true;
				//if correct answer add 5 to score else do nothing!
			}else if(select == ItemEvent.DESELECTED)
			{
				answersRight[0]=false;
				//if correct answer subtract 5 from score else do nothing!
			}
		}else if(source1 == answer2a)
		{
			if(select == ItemEvent.SELECTED)
			{
				answersRight[1]=false;
				//if correct answer add 5 to score else do nothing!
			}else if(select == ItemEvent.DESELECTED)
			{
				//if correct answer subtract 5 from score else do nothing!
			}
		}else if(source1 == answer2b)
		{
			if(select == ItemEvent.SELECTED)
			{
				answersRight[1]=false;
				//if correct answer add 5 to score else do nothing!
			}else if(select == ItemEvent.DESELECTED)
			{
				//if correct answer subtract 5 from score else do nothing!
			}
		}else if(source1 == answer2c)
		{
			if(select == ItemEvent.SELECTED)
			{
				answersRight[1]=false;
				//if correct answer add 5 to score else do nothing!
			}else if(select == ItemEvent.DESELECTED)
			{
				//if correct answer subtract 5 from score else do nothing!
			}
		}else  if(source1 == answer2d)
		{
			if(select == ItemEvent.SELECTED)
			{
				answersRight[1]=true;
				
				//if correct answer add 5 to score else do nothing!
			}else if(select == ItemEvent.DESELECTED)
			{
				answersRight[1]=false;
				//if correct answer subtract 5 from score else do nothing!
			}
		}else if(source1 == answer4a)
		{
			if(select == ItemEvent.SELECTED)
			{
				answersRight[3]=false;
				//if correct answer add 5 to score else do nothing!
			}else if(select == ItemEvent.DESELECTED)
			{
				//if correct answer subtract 5 from score else do nothing!
			}
		}else if(source1 == answer4b)
		{
			if(select == ItemEvent.SELECTED)
			{
				answersRight[3]=true;
				//if correct answer add 5 to score else do nothing!
			}else if(select == ItemEvent.DESELECTED)
			{
				answersRight[3]=false;
				//if correct answer subtract 5 from score else do nothing!
			}
		}else if(source1 == answer4c)
		{
			if(select == ItemEvent.SELECTED)
			{
				answersRight[3]=false;
				//if correct answer add 5 to score else do nothing!
			}else if(select == ItemEvent.DESELECTED)
			{
				//if correct answer subtract 5 from score else do nothing!
			}
		}else  if(source1 == answer4d)
		{
			if(select == ItemEvent.SELECTED)
			{
				answersRight[3]=false;
				//if correct answer add 5 to score else do nothing!
			}else if(select == ItemEvent.DESELECTED)
			{
				//if correct answer subtract 5 from score else do nothing!
			}
		}
		
		if(source2 == answer3)//combo box!
		{
			if(select == ItemEvent.SELECTED)
			{
				int positionOfSelection = answer3.getSelectedIndex();
				if(positionOfSelection==1)//true
				{
					answersRight[2]=true;
				}else if(positionOfSelection==2)//false
				{
					answersRight[2]=false;
				}
			}
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int score=0;
		for(int i=0;i<4;i++)
		{
			if(answersRight[i]==true)
			{
				score +=5;
			}
		}
		scoreLabel.setText("Score : " + score + "/20");
		
	}

}
