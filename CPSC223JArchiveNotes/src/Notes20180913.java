
public class Notes20180913 {
	public static void main(String[] args)
	{
		//displayAddress();
		//displayAddress2(91709);
		
		Employee clerk = new Employee();
		Employee driver = new Employee();
		
		clerk.setEmpNum(12345);
		driver.setEmpNum(12265);
		System.out.println("the clerk number is: " + clerk.getEmpNum());
		System.out.println("the driver number is: " + driver.getEmpNum());
		
		clerk.setEmpSalary(25000);
		driver.setEmpSalary(80000);
		
		System.out.println("the clerk salary is: " + clerk.getEmpSalary());
		System.out.println("the driver salary is: "+driver.getEmpSalary());
		
		System.out.println("the clerk bonus is: " + clerk.yearlyBonus());
		System.out.println("the driver bonus is: "+driver.yearlyBonus());
		
		
		System.out.println("the clerk bonus is: " + clerk.yearlyBonus(.10));
		System.out.println("the driver bonus is: "+driver.yearlyBonus(.06));
		
		
		Student timmy = new Student();
		
		timmy.setID(889365);
		timmy.setName("Timmy");
		
		System.out.println("Student with id, " + timmy.getID() + ", has name " + timmy.getName());
		
		
		
	}
	
	//public doesn't need to be instantiated to be used, and returns nothing
	public static void displayAddress()
	{
		System.out.println("XyZ company ");

	}
	public static void displayAddress2(int zip)
	{
		System.out.println("XyZ company " + zip);
	}

}
