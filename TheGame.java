
public class TheGame {
	public static void main(String[] arguments)
	{
		int total=0;
		int score=7;
		if(score==7)
		{
			System.out.println("You Score a touchdown");
			
		}
		if(score==3)
		{
			System.out.println("You score a fieldgoal");
		}
		total=total+score;
		System.out.println("Total Score "+ total);
	}
}
