//GradeBook constructor used to specify the course name at the time each GradeBook object is created
public class GradeBookTest3 {
	//main method begins program execution
	public static void main(String[] args)
	{
		//Create GradeBook object
		GradeBook3 gradeBook1= new GradeBook3("Cs101 Introduction to Java Programming"); 
		GradeBook3 gradeBook2= new GradeBook3("Cs102 Data Structures in Java");
		//display initial value of courseName for each GradeBook
		System.out.printf("gradeBook1 course name is %s\n",gradeBook1.getCourseName());
		System.out.printf("gradeBook2 course name is %s\n",gradeBook1.getCourseName());
	}//end main
}//end class GradeBookTest
