/*
 * Notes October 9th
 * GUI STUFF
 * */
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Notes20181009Two {
	public static void main(String[] args)
	{
		final int FRAME_WIDTH = 640;
		final int FRAME_HEIGHT = 480;
		
		final String Title_Bar = "Taco Frames";
		
		JFrame frame = new JFrame(Title_Bar);
		
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);//Set the window size
		frame.setResizable(false);//User cannot resize our window
		frame.setLocationRelativeTo(null);//null sets to center of the screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//makes sure our program doesn't run in the background.
		frame.getContentPane().setBackground(Color.blue);
		frame.setVisible(true);
		
		JLabel greeting = new JLabel("Good day");
		greeting.setFont(new Font("Arial",Font.BOLD,100));
		frame.add(greeting);
		JLabel greeting2 = new JLabel("Good Night");
		greeting2.setFont(new Font("Arial",Font.ITALIC,100));
		frame.add(greeting2);
		
		frame.setLayout(new FlowLayout());
		frame.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		
	}

}
