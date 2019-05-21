
public class Quiz {
	enum Color { RED(255,0,0),BLUE(0,0,255),YELLOW(255,255,0),BLACK(0,0,0);
		private int r,g,b;
		private Color(int r, int g, int b)
		{
			this.r = r;
			this.g = g;
			this.b = b;
		}
		public int getR()
		{
			return this.r;
		}
		public int getG()
		{
			return this.g;
		}
		public int getB()
		{
			return this.b;
		}
	}
	public static void main(String[] args)
	{
		Color paint = Color.YELLOW;
		System.out.println(paint.getR() + paint.getG() + paint.getB());
	}
}