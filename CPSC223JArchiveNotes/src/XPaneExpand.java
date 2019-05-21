/*
 * Notes from 10 25 where I missed most of them.
 * Notes20181025
 * */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class XPaneExpand extends JFrame implements ActionListener {
	private JButton next = new JButton("Next");
	private JButton next2 = new JButton("Exit");
	
	private JPanel buttonsPane1 = new JPanel();
	private JPanel buttonsPane2 = new JPanel();
	
	
	CardLayout cardLayout = new CardLayout();
	
	public XPaneExpand()
	{
		super("Card Layout");
		setLayout(cardLayout);
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buttonsPane1.setLayout(new FlowLayout());
		buttonsPane1.add(new JButton("1"));
		buttonsPane1.add(new JButton("2"));
		buttonsPane1.add(new JButton("3"));
		buttonsPane1.add(next);
		next.addActionListener(this);
		add(buttonsPane1, "Panel1");
		
		buttonsPane2.setLayout(new GridLayout(2,2));
		buttonsPane2.add(new JButton("4"));
		buttonsPane2.add(new JButton("5"));
		buttonsPane2.add(new JButton("6"));
		buttonsPane2.add(next2);
		next2.addActionListener(this);
		add(buttonsPane2,"Panel2");	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == next)
		{
			cardLayout.show(getContentPane(), "Panel2");
		}else if(source == next2)
		{
			cardLayout.show(getContentPane(), "Panel1");
		}
		
	}
}
