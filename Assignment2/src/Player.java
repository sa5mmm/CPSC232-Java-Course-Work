public enum Player {X('X'),O('O');
	private char symbol;
	Player(char symbol)
	{
		this.symbol = symbol;
	}
	char getSymbol()
	{
		return symbol;
	}
}
