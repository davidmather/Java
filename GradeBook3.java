
public class GradeBook3 {
	private String courseName;
	//constructor initializes courseName with String argument
	public GradeBook3(String name )//constructor name is class name
	{
		courseName=name;//initializes courseName
	}//end constructor
	//method to set the course name
	public void setCourseName(String name)
	{
		courseName=name;//store the course name
	}//end method setCourseName
	//method to retrieve the course name
	public String getCourseName()
	{
		return courseName;
	}//end method get course name
	public void displayMessage()
	{
		//this statement calls getCourseName to get the
		//name of the course this GradeBook represents
		System.out.printf("Welcome to the grade book for\n%s!\n", getCourseName());
	}//end method displayMessage
}//end class GradeBook
