//Notes20181106

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JDemoKeyFrame extends JFrame
implements KeyListener
{
	private Font programFont = new Font("Arial",Font.PLAIN,20);
	private JLabel prompt = new JLabel("Type keys below");
	private JTextField textField = new JTextField(10);
	private JLabel output = new JLabel();
	
	public JDemoKeyFrame()
	{
		super("Key Demo");
		setSize(400,400);
		setLayout(new BorderLayout());
		prompt.setFont(programFont);
		textField.setFont(programFont);
		output.setFont(programFont);
		add(prompt,BorderLayout.NORTH);
		add(textField,BorderLayout.CENTER);
		add(output,BorderLayout.SOUTH);
		
		textField.addKeyListener(this);
		addKeyListener(this);
		
		
	}
	
	
	@Override // ONLY work for character keys
	public void keyTyped(KeyEvent e) {
		char key = e.getKeyChar();
		output.setText("The key " + key + " was pressed.");
	}

	@Override // Virtual key codes
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_UP)
		{
			output.setText("You pressed up!");
		}else if(keyCode == KeyEvent.VK_DOWN)
		{
			output.setText("You pressed down!");
		}else if(keyCode == KeyEvent.VK_LEFT)
		{
			output.setText("You pressed left!");
		}else if(keyCode == KeyEvent.VK_RIGHT)
		{
			output.setText("You pressed right!");
		}else if(keyCode == KeyEvent.VK_SPACE)
		{
			output.setText("You pressed space!");
		}
		
		//VK_SPACE VR_ENTER VK_DOWN ETC
	}

	@Override // Virtual key codes
	public void keyReleased(KeyEvent e) {
		
	}

}
