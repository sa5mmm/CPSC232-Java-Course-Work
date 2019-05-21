
public enum Player {
	X('X'),O('O');
	private char piece;
	private int turns;
		Player(char charPar)
			{
				this.piece = charPar;
				this.turns = 0;
			}
		public void takeTurn()
		{
			this.turns++;
		}
		public int getTurns()
		{
			return this.turns;
		}
		public char getPiece()
		{
			return this.piece;
		}
};
