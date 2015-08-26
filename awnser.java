
public class awnser {
	public static void main(String[] arguments)
	{
		int awnser=15;
		int correctawnser=13;
		int score=5;
		if(awnser==correctawnser)
		{
			score+=10;
			System.out.println("Thats right you get 10 points");
			
		}
		else
		{
			score-=10;
			System.out.println("Sorry thats wrong you lose 5 points");
			
		}
	}
}
