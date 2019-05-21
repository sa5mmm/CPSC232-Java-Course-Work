import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

public class Images extends JFrame {
	ImageIcon pic = new ImageIcon("C:\\Users\\Sam M\\Desktop\\cat.jpg");
	Image transformed;
	JLabel imageLabel = new JLabel();
	public Images()
	{
		transformed = pic.getImage().getScaledInstance(50,100,java.awt.Image.SCALE_SMOOTH);
		pic = new ImageIcon(transformed);
		imageLabel.setIcon(pic);
		
		add(imageLabel);
	}
	public static void main(String[] args)
	{
		Images frame = new Images();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
	}
}