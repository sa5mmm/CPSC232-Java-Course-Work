/* Samantha Montoya
 * Notes Sep 20 2018
 * Goes with Notes20180920
 * */
public class GradeTool {
	public static void average(Student01 stu)
	{
		double avg = (stu.getTest1()+stu.getTest2()+stu.getTest3())/3.0;
		System.out.println(avg);
	}
	public static void score(Student01 stu)
	{
		double avg = (stu.getTest1()+stu.getTest2()+stu.getTest3())/3.0;
		stu.setGrade(avg);
	}

}
