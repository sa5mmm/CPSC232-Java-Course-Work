/*
	 * Goes with Notes20181004
	 * */
public enum Color01 {
	
		
		RED(255,0,0),BLUE(0,0,255),YELLOW(255,255,0),BLACK(0,0,0);
		
		private int red;
		private int green;
		private int blue;
		
		private Color01(int r, int g, int b)
		{
			red = r;
			green = g;
			blue = b;
		}
		public int getRed()
		{
			return red;
		}
		public int getBlue()
		{
			return blue;
		}
		public int getGreen()
		{
			return green;
		}
}

