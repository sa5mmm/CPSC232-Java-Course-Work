import java.util.Scanner;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Lab8 {
	public static void main(String[] args)
	{
		String[] instructions = {"Please enter your Company Name", 
				"Please enter your Message",
				"Please enter your Contact info"};
		String[] companyDetails = new String[3];
		Scanner input = new Scanner(System.in);
		/*
		String[] info = {"The Ghost Realtor", 
		"We only sell apparition free homes!", 
		"Sue Stanford (555) 714-8050"};
		*/
		for(int i = 0; i<3; i++)
		{
			System.out.println(instructions[i]);
			String text = input.nextLine();
				//companyDetails[i] = info[i];
				companyDetails[i] = text;
		}
		
		JFrame frame = new JFrame("Bill Board");
		frame.setSize(900, 400);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel comName = new JLabel(companyDetails[0]);
		JLabel comMess = new JLabel(companyDetails[1]);
		JLabel comCont = new JLabel(companyDetails[2]);
		
		comName.setFont(new Font("Arial",Font.BOLD, 90));
		comMess.setFont(new Font("Arial",Font.BOLD, 50));
		comCont.setFont(new Font("Arial", Font.ITALIC, 50));
		
		frame.add(comName);
		frame.add(comMess);
		frame.add(comCont);
		
		frame.setLayout(new FlowLayout(FlowLayout.LEFT));
		input.close();
	}
}
