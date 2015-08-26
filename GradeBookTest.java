import java.util.Scanner;
public class GradeBookTest
{
	// main method begins program execution
	public static void main( String[] args )
	{
	// create Scanner to obtain input from command window	
		Scanner input= new Scanner(System.in);
	// create a GradeBook object and assign it to myGradeBook
		GradeBook myGradeBook = new GradeBook();
	//prompt for course name
		System.out.println("Please enter the course name");
		String nameOfCourse=input.nextLine();//read a line of text
		System.out.println();
	// call myGradeBook's displayMessage method
		myGradeBook.displayMessage(nameOfCourse);
	} // end main
} // end class GradeBookTest