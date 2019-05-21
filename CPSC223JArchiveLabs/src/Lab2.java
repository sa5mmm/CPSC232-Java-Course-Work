/*
 * Samantha M
 * Lab 2
 * MadLibs and Taxable Income
 */
import javax.swing.JOptionPane;
public class Lab2
{
	public static void main(String[] args)
	{
		//Mad Libs
		//Hold the requirements for the MadLib, and then hold the responses to those requirements
		final String[] needsArray = {"noun","another noun","adjective","past-tense verbe"};
		String[] holderArray=new String[needsArray.length];
		int index =0;
		while (index < needsArray.length)//Ask and get requirements for MadLibs
		{
			holderArray[index] = JOptionPane.showInputDialog(null,"Please enter a " + needsArray[index],
					"Mad Libs",JOptionPane.WARNING_MESSAGE);
			index=index+1;
		}
		//Construct MadLib
		String madLib = "Mary had a little " + holderArray[0] +
				"\nIts " + holderArray[1] + " was " + holderArray[2] + " as snow \n"+
				"And everywhere that Mary " + holderArray[3] + "\nThe " + holderArray[0] +
				" was sure to go";
		//Output MadLib
		JOptionPane.showMessageDialog(null,madLib,"Mad Libs",JOptionPane.INFORMATION_MESSAGE );
		//Taxable Income
		//Need to store the tax brackets and their rate, Was too lazy to solve for tax under and just saved that.
		final double[] incomeLowerBound = {0,9325,37950,91900,191650,416700,418400};
		final double[] rateTaxed = {.10,.15,.25,.28,.33,.35,.396};
		double[] addedTax = {0,932.5,5226.25,18713.75,46643.75,120910.25,121505.25};
		double userIncome,userIncomeTax;
		userIncomeTax =0;
		String userIncomeString;
		//Getting the user's income
		userIncomeString = JOptionPane.showInputDialog(null,"Please provide your taxable income:",
				"Taxable Income dialog 1", JOptionPane.INFORMATION_MESSAGE);
		userIncome = Double.parseDouble(userIncomeString);
		//Calculating the tax owed
		for(int i = 0;i<rateTaxed.length;i++)
		{
			if(userIncome>incomeLowerBound[i])
			{
				userIncomeTax = (userIncome-incomeLowerBound[i])*rateTaxed[i]+addedTax[i];
			}
		}
		//Output tax owed
		JOptionPane.showMessageDialog(null, "Your federal income tax is $" + userIncomeTax,
				"Taxable Income dialog 2", JOptionPane.WARNING_MESSAGE);
	}
}