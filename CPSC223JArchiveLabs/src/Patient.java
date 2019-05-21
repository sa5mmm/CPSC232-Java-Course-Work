/*
 * Goes with lab 7
 * */
enum BloodType{O,A,B,AB};
enum RhFactor{
			POSITIVE('+'),NEGATIVE('-');
			private char sign;
			private RhFactor(char s)
			{
				sign = s;
			}
			public char getRh()
			{
				return sign;
			}
};
public class Patient {
	private int ID_number,age;
	BloodData bloodData;
	
	Patient()
	{
		this.age = 0;
		this.ID_number = 0;
		bloodData = new BloodData();
	}
	Patient(int ID_number, int age, RhFactor rhFactor, BloodType bloodType)
	{
		this.age = age;
		bloodData = new BloodData(rhFactor, bloodType);
		this.ID_number = ID_number;
	}
	
	public int getID()
	{
		return this.ID_number;
	}
	public int getAge()
	{
		return this.age;
	}
	public void displayBlood()
	{
		System.out.println("Blood Type: " + bloodData.getType() + bloodData.getRH());
	}
	
	private class BloodData
	{
		private BloodType bloodType; 
		private RhFactor rhFactor;
		
		BloodData(RhFactor rhFactor,BloodType bloodType)
		{
			this.bloodType = bloodType;
			this.rhFactor = rhFactor;
		}
		BloodData()
		{
			this(RhFactor.POSITIVE,BloodType.O);
		}

		public BloodType getType()
		{
			return this.bloodType;
		}
		public char getRH()
		{
			return this.rhFactor.getRh();
		}
	}
}
