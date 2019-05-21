/*
 * Goes with Notes20180925
 * 
 * */
public class Student02 {
	private int stuNum;
	private double gpa;
	//shared variable!
	private static int count = 0;
	
	
	//Examples of overloaded functions.
	//Student timmy = new Student();
	/*public Student()
	{
		this.stuNum = 999;
		this.gpa = 0.0;
	}*/
	public Student02()
	{
		this(999,0.0);
	}
	//Student timmy = new Student(ID);
	public Student02(int stuNum)
	{
		this(stuNum,0.0);
		//this.stuNum = stuNum;
		//this.gpa = 0.0;
	}
	//Student timmy = new Student(gpa);
	public Student02(double gpa)
	{
		this(999,gpa);
		//this.stuNum = 999;
		//this.gpa = gpa;
	}
	//Student timmy = new Student(ID,gpa);
	public Student02(int stuNum, double gpa)
	{
		this.stuNum = stuNum;
		this.gpa = gpa;
		count = count + 1;
	}
	public void showStudent()
	{
		System.out.println("GPA: " + this.gpa + " StuNum: " + this.stuNum);
	}
	public static int getCount()
	{
		return count;
	}

}
