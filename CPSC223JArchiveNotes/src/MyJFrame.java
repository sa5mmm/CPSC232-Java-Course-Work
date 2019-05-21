/*
 * Goes with notes 0ct 23 2018
 * Border layouts!
 * Grid Layouts
 * */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJFrame extends JFrame implements ActionListener {
	
	//Don't do it this way, but it will help us keep track of what is happening!
	JButton nb = new JButton("North Button");
	JButton sb = new JButton("South Button");
	JButton eb = new JButton("East Button");
	JButton wb = new JButton("West Button");
	JButton cb = new JButton("Center Button");
	//BorderLayouts can only have 5 objects!
	//However we can get around this by making a panel!
	JPanel panel = new JPanel();//This is only a container!
	
	JPanel newPanel = new JPanel();
	
	
	
	JTextField field = new JTextField(12);
	public MyJFrame()
	{
		super("More Layouts");
		setSize(400,150);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(nb,BorderLayout.NORTH);
		add(eb,BorderLayout.EAST);
		add(sb,BorderLayout.SOUTH);
		add(panel,BorderLayout.WEST);
		add(newPanel,BorderLayout.CENTER);
		eb.addActionListener(this);//THis calls the dispose method!
		
		
		panel.setLayout(new FlowLayout());
		panel.add(field);
		
		field.setEditable(false);
		field.setText("This is a label");
		
		panel.add(new JButton("1"));
		panel.add(new JButton("2"));
		panel.add(new JButton("3"));
		panel.add(new JButton("4"));
		
		newPanel.setLayout(new GridLayout(2,2,5,5));
		newPanel.add(new JButton("1"));
		newPanel.add(new JButton("2"));
		newPanel.add(new JButton("3"));
		newPanel.add(new JButton("4"));
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		super.dispose();//Closes the application!
		// TODO Auto-generated method stub
		
	}
	
}
