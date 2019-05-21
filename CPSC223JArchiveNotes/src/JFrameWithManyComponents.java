//Notes20181011

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class JFrameWithManyComponents  extends JFrame 
			implements ActionListener
	{
	final int Framewidth = 300;
	final int Frameheight = 150;
	JLabel heading;
	JLabel namePrompt;
	JTextField nameField;
	JButton button;
	public JFrameWithManyComponents()
	{
		super("This frame has many components");//must be first
		heading = new JLabel("This frame has many components");
		namePrompt = new JLabel("Enter name");
		nameField = new JTextField(12);
		button = new JButton("Click to continue");
		setSize(Framewidth,Frameheight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		add(heading);
		add(namePrompt);
		add(nameField);
		add(button);
		button.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String name = nameField.getText();
		heading.setText("Hello " + name);
	}
}

