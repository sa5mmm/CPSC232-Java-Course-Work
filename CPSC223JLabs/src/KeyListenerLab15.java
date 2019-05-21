import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class KeyListenerLab15 extends JFrame implements KeyListener
{
	private final int ROWS = 8; 
	private final int COLS = 8; 
	private final int GAP = 2;
	private int x;
	private int y;
	private KittyCruiser kitty;
	private JPanel pane;
	private JPanel[][] panel;
	private Color[][] color;
	private Color blank;
	private Color drawn;
	private Color cursor;
	private JLabel position;
	public KeyListenerLab15()
	{
		super("Pixel Painter");
		kitty = new KittyCruiser(ROWS,COLS);
		pane = new JPanel(new GridLayout(ROWS,COLS,GAP,GAP));
		panel = new JPanel[ROWS][COLS];
		color = new Color[ROWS][COLS];
		blank = Color.white;
		drawn = Color.black;
		cursor = Color.yellow;
		position = new JLabel("X: " + kitty.getX() + " Y: " + kitty.getY());
		
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		add(pane,BorderLayout.CENTER);
		resetColors();
		addKeyListener(this);
		add(position,BorderLayout.NORTH);
		x = kitty.getX();
		y = kitty.getY();
		panel[x][y].setBackground(cursor);
	}
	public void resetColors()
	{
		for(x=0;x<ROWS;++x)
		{
			for(y=0;y<COLS;++y)
			{
				panel[x][y] = new JPanel();
				pane.add(panel[x][y]);
				color[x][y] = blank;
				panel[x][y].setBackground(color[x][y]);
			}
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		//Current position of cat
		x = kitty.getX();
		y = kitty.getY();
		
		if(keyCode == KeyEvent.VK_LEFT)
		{
			panel[x][y].setBackground(color[x][y]);//reset background color
			kitty.moveLeft();//move the cat!
		}else if(keyCode == KeyEvent.VK_RIGHT)
		{
			panel[x][y].setBackground(color[x][y]);//reset background color
			kitty.moveRight();
		}else if(keyCode == KeyEvent.VK_UP)
		{
			panel[x][y].setBackground(color[x][y]);//reset background color
			kitty.moveUp();
		}else if(keyCode == KeyEvent.VK_DOWN)
		{
			panel[x][y].setBackground(color[x][y]);//reset background color
			kitty.moveDown();
		}else if(keyCode == KeyEvent.VK_SPACE)
		{
			if(color[x][y]==blank)
			{
				color[x][y]=drawn;
			}else
			{
				color[x][y]=blank;
			}
		}
		//check current position of cat
		x = kitty.getX();
		y = kitty.getY();
		//place cursor where cat is.
		panel[x][y].setBackground(cursor);
		position.setText("X: " + x + " Y: " + y);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
