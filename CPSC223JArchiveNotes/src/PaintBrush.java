/*
 * Goes with Notes20181004
 * */


public class PaintBrush {
	private int brushWidth;
	//private enum Color{RED,BLUE,YELLOW,BLACK};//static and final
	Color01 paint;
	
	public PaintBrush()
	{
		this.brushWidth = 2;
		paint = Color01.BLUE;
	}
	
	public void display()
	{
		System.out.println(paint);
		System.out.println("COLOR HUES\n" + paint.getRed() + ", " + paint.getGreen() + ", " + paint.getBlue());
	}
	
	

}
