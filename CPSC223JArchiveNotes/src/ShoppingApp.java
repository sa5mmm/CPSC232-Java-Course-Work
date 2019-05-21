import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/* for Notes 2018 10 18
 * check boxes have a selection state and deselection state
 * page 766 -> java swing package.
 * 
 * combo boxes need to be in an array!
 * */
public class ShoppingApp extends JFrame implements ActionListener, ItemListener /* new for check boxes!*/ {
	final int FRAME_HEIGHT = 130;
	final int FRAME_WIDTH = 350;
	//for check box
	JLabel label;
	JCheckBox coffee;
	JCheckBox cola;
	JCheckBox milk;
	JCheckBox water;
	
	int cost = 0;
	
	JButton button;
	
	ButtonGroup aGroup = new ButtonGroup();//now all the buttons will be mutually exclusive!
	
	String[] comboArray = {"Pick an option", "Regular", "Large"};
	JComboBox comboSize;
	
	
	public ShoppingApp()
	{
		super("Shopping Application");
		
		label = new JLabel("What do you want to drink?");
		//for check box
		coffee = new JCheckBox("Coffee $5", false);
		cola = new JCheckBox("Cola $2", false);
		milk = new JCheckBox("Milk $3", false);
		water = new JCheckBox("Water $1", false);
		button = new JButton("Checkout");
		
		comboSize = new JComboBox(comboArray);
		
		aGroup.add(coffee);
		aGroup.add(cola);
		aGroup.add(milk);
		aGroup.add(water);
		
		
		//page 766 what element uses which listener!
		coffee.addItemListener(this);
		cola.addItemListener(this);
		milk.addItemListener(this);
		water.addItemListener(this);
		button.addActionListener(this);
		comboSize.addItemListener(this);
		
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		add(label);
		add(comboSize);
		add(coffee);
		add(cola);
		add(milk);
		add(water);
		add(button);
		
		
		
	}
	@Override
	public void itemStateChanged(ItemEvent ie) {
		// TODO Auto-generated method stub
		Object source = ie.getItem();
		int select = ie.getStateChange();
		if(source == coffee)
		{
			if(select == ItemEvent.SELECTED)
			{
				//statements if coffee is checked!
				cost = cost + 5;
			}else
			{
				//statements if coffee is unchecked.
				cost = cost - 5;
			}
		}else
		if(source == cola)
		{
			if(select == ItemEvent.SELECTED)
			{
				//statements if coffee is checked!
				cost = cost + 2;
			}else
			{
				//statements if coffee is unchecked.
				cost = cost - 2;
			}
		}else
			if(source == milk)
			{
				if(select == ItemEvent.SELECTED)
				{
					//statements if coffee is checked!
					cost = cost + 3;
				}else
				{
					//statements if coffee is unchecked.
					cost = cost - 3;
				}
			}else
				if(source == water)
				{
					if(select == ItemEvent.SELECTED)
					{
						//statements if coffee is checked!
						cost = cost + 1;
					}else
					{
						//statements if coffee is unchecked.
						cost = cost - 1;
					}
				}
		
		//for combo boxes
		Object source1 = ie.getSource();
		if(source1 == comboSize)
		{
			if(select == ItemEvent.SELECTED)
			{
				int positionOfSelection = comboSize.getSelectedIndex();
				if(positionOfSelection == 1)
				{
					cost = cost + 1;
				}else
					if(positionOfSelection== 2)
					{
						cost = cost + 2;
					}
			}else 
				if(select == ItemEvent.DESELECTED)
				{
					int positionOfSelection = comboSize.getSelectedIndex();
					if(positionOfSelection == 1)
					{
						cost = cost - 1;
					}else
						if(positionOfSelection== 2)
						{
							cost = cost - 2;
						}
				}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		label.setText("Total cost = " + cost);
	}
	
}
