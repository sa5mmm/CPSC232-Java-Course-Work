/* Samantha M
 * Goes with notes20180913
 * CPSC 223J
 * */
public class Employee {
	
	//hiding data, only employee can see this attribute
	private int empNum;
	private String lastName;
	private double empSalary;
	
	public String getEmpLastName()
	{
		return this.lastName;
	}
	public void setEmpLastName(String namePar)
	{
		this.lastName=namePar;
	}
	public double getEmpSalary()
	{
		return this.empSalary;
	}
	public void setEmpSalary(double salaryPar)
	{
		empSalary = salaryPar;
	}
	public int getEmpNum()
	{
		return this.empNum; //return empNum;
	}
	
	public void setEmpNum(int numPar)
	{
		this.empNum = numPar;
		
	}
	
	public double yearlyBonus()
	{
		return empSalary * 0.05;
	}
	
	public double yearlyBonus(double percentPar)
	{
		return empSalary*percentPar;
	}

}
