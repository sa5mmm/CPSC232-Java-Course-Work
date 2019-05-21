import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class JFrameComponents extends JFrame implements ActionListener
{
	private final int FrameWidth = 400;
	private final int FrameHeight = 200;
	JLabel header;
	JLabel body;
	JLabel body2;
	JButton button;
	JTextField textField;
	public JFrameComponents()
	{
		super("Temperature Converter");
		setSize(FrameWidth,FrameHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		header = new JLabel("Enter Degrees F* to recieve Degrees C*");
		body = new JLabel("Enter Fahrenheit: ");
		button = new JButton("Click to continue");
		textField = new JTextField(5);
		body2 = new JLabel("");
		
		header.setFont(new Font("Arial",Font.BOLD,20));
		body.setFont(new Font("Arial", Font.PLAIN,18));
		button.setFont(new Font("Arial", Font.PLAIN,14));
		textField.setFont(new Font("Arial",Font.ITALIC,14));
		body2.setFont(new Font("Arial",Font.BOLD,14));
		setLayout(new FlowLayout());
		add(header);
		add(body);
		add(textField);
		add(button);
		add(body2);
		button.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String text = textField.getText();
		double temp = Double.parseDouble(text);
		int c = (int)((temp -32) * 5/9.0);
		body2.setText("Degrees Celsius " + c + "*");
	}
}
