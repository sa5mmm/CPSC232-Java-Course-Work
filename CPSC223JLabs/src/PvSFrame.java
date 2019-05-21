import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
public class PvSFrame extends JFrame implements KeyListener
{
	ImageIcon zomPic, peaPic, rocPic, sunPic;
	Image transformation;
	final String zomFile = "C:\\Users\\Sam M\\Desktop\\CPSC 223J\\Resources\\zombie.png";
	final String peaFile = "C:\\Users\\Sam M\\Desktop\\CPSC 223J\\Resources\\peaShooter.png";
	final String rocFile = "C:\\Users\\Sam M\\Desktop\\CPSC 223J\\Resources\\rock.png";
	final String sunFile = "C:\\Users\\Sam M\\Desktop\\CPSC 223J\\Resources\\sunflower.png";
	Color grass1 = Color.GREEN;
	Color grass2 = Color.GREEN.darker();
	Color cursorIndicator = Color.CYAN;
	final int SpriteSize = 75;
	final int GridSize = 8;
	final int Gap = 2;
	int x,y;
	Cursor cursor;
	int curPiece;
	JPanel lawn;
	JPanel[][] lawnSquares;//What you see (Holds pieces and colors)
	JLabel[][] piecesGrid;//holds all picture pieces
	Color[][] colorsGrid;//Holds colors for cursor indication
	int[][] piecesKeys;//Holds pieces for cursor indication
	int pieceID;
	int counter;
	public PvSFrame()
	{
		super("Plants VS Zombies - 1.0");
		setSize(800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		//Create cursor
		cursor = new Cursor(GridSize, GridSize);
		x = cursor.getX();
		y = cursor.getY();
		counter = 0;
		curPiece = (int)(Math.random()*3)+1;
		//Set pictures for Labels!
		zomPic = new ImageIcon(zomFile);
		transformation = zomPic.getImage().getScaledInstance(SpriteSize-25, SpriteSize,java.awt.Image.SCALE_SMOOTH);
		zomPic = new ImageIcon(transformation);
		peaPic = new ImageIcon(peaFile);
		transformation = peaPic.getImage().getScaledInstance(SpriteSize, SpriteSize,java.awt.Image.SCALE_SMOOTH);
		peaPic = new ImageIcon(transformation);
		rocPic = new ImageIcon(rocFile);
		transformation = rocPic.getImage().getScaledInstance(SpriteSize+25, SpriteSize+25,java.awt.Image.SCALE_SMOOTH);
		rocPic = new ImageIcon(transformation);
		sunPic = new ImageIcon(sunFile);
		transformation = sunPic.getImage().getScaledInstance(SpriteSize+25, SpriteSize+25,java.awt.Image.SCALE_SMOOTH);
		sunPic = new ImageIcon(transformation);
		//Create the lawn panel (Holds lawn squares!
		lawn = new JPanel(new GridLayout(GridSize,GridSize,Gap,Gap));
		initiateGrid();		
		//Put all the lawn squares onto the lawn!
		for(int row = 0; row < GridSize; row++)
		{
			for(int col = 0; col < GridSize; col++)
			{
				lawn.add(lawnSquares[row][col]);
			}
		}
		add(lawn,BorderLayout.CENTER);
		addKeyListener(this);
	}
	private void initiateGrid()
	{
		lawnSquares = new JPanel[GridSize][GridSize];
		piecesGrid = new JLabel[GridSize][GridSize];
		colorsGrid = new Color[GridSize][GridSize];
		piecesKeys= new int[GridSize][GridSize];
		for(int row = 0; row < GridSize; row++)
		{
			for(int col = 0; col < GridSize; col++)
			{
				lawnSquares[row][col] = new JPanel();//Create a panel!
				colorsGrid[row][col] = grass1;//Set the grass colors!
				piecesKeys[row][col] = 0;//Set all the pieces to null!
				piecesGrid[row][col] = new JLabel();//Creates the labels			
				lawnSquares[row][col].setBackground(colorsGrid[row][col]);//sets the color on lawn
				lawnSquares[row][col].add(piecesGrid[row][col]);//sets the piece on the lawn
			}
			Color temp = grass1;
			grass1 = grass2;
			grass2 = temp;
		}
		x = cursor.getX();
		y = cursor.getY();
		lawnSquares[x][y].setBackground(cursorIndicator);
		switch(curPiece)
		{
		case 0:
			break;
		case 1:
		piecesGrid[x][y].setIcon(rocPic);
		break;
		case 2:
		piecesGrid[x][y].setIcon(sunPic);
		break;
		case 3:
		piecesGrid[x][y].setIcon(peaPic);
		break;
		case 4:
		piecesGrid[x][y].setIcon(zomPic);
		break;
		default:
		break; 
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		x = cursor.getX();
		y = cursor.getY();
		lawnSquares[x][y].setBackground(colorsGrid[x][y]);//reset color
		switch(piecesKeys[x][y])//reset piece
		{
		case 0:
			piecesGrid[x][y].setIcon(null);
			break;
		case 1:
		piecesGrid[x][y].setIcon(rocPic);
		break;
		case 2:
		piecesGrid[x][y].setIcon(sunPic);
		break;
		case 3:
		piecesGrid[x][y].setIcon(peaPic);
		break;
		case 4:
		piecesGrid[x][y].setIcon(zomPic);
		break;
		default:
		break; 
		}
		if(keyCode == KeyEvent.VK_UP)
		{
			cursor.moveUp();
		}else if(keyCode == KeyEvent.VK_DOWN)
		{
			cursor.moveDown();
		}else if(keyCode == KeyEvent.VK_LEFT)
		{
			cursor.moveLeft();
		}else if(keyCode == KeyEvent.VK_RIGHT)
		{
			cursor.moveRight();
		}else if(keyCode == KeyEvent.VK_SPACE)
		{
			counter = (++counter)%4;
			piecesKeys[x][y] = curPiece;
			curPiece = (int)(Math.random()*3)+1;
			if(counter == 0)
			{
				int row, col;
				row = (int)(Math.random()*GridSize);
				col = (int)(Math.random()*2)+6;
				piecesKeys[row][col]=4;
				piecesGrid[row][col].setIcon(zomPic);
			}
		}
		x = cursor.getX();
		y = cursor.getY();
		lawnSquares[x][y].setBackground(cursorIndicator);
		switch(curPiece)
		{
		case 0:
			break;
		case 1:
		piecesGrid[x][y].setIcon(rocPic);
		break;
		case 2:
		piecesGrid[x][y].setIcon(sunPic);
		break;
		case 3:
		piecesGrid[x][y].setIcon(peaPic);
		break;
		case 4:
		piecesGrid[x][y].setIcon(zomPic);
		break;
		default:
		break; 
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {	
	}	
}