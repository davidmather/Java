import java.util.Scanner;
public class GradeBookTest2 {
	public static void main(String[] args)
	{
		//create scanner to obtain input from command window
		Scanner input=new Scanner(System.in);
		//create a GradeBook2 object and assign it to my GradeBook2
		GradeBook2 myGradeBook2=new GradeBook2();
		//display initial value of courseName
		System.out.printf("Initial course name is: %s\n\n", myGradeBook2.getCourseName() );
		//prompt and read course name
		System.out.println("Please enter the course name:");
		String theName=input.nextLine();//read a line of text
		myGradeBook2.setCourseName(theName);//set the course name
		System.out.println();//outputs a blank line
		//display welcome message after specifying course name
		myGradeBook2.displayMessage();
	}//end main
}//end class GradeBookTest
