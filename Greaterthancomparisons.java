
public class Greaterthancomparisons {
	public static void main(String[] arguments)
	{
		int elephantWeight = 700;
		int elephantTotal = 13;
		int cleaningExpenses =200;
		if(elephantWeight>700)
		{
			System.out.println("Your elephants are too fat to tightrope");
			if(elephantTotal>12)
			{
				cleaningExpenses = cleaningExpenses + 150;
				System.out.println("Your cleaning bill was high this week it was €"+cleaningExpenses);
				elephantTotal = 0;
			}
		}
		if(elephantTotal>12)
		{
			cleaningExpenses = cleaningExpenses + 150;
			System.out.println("Your cleaning bill was high this week it was €"+cleaningExpenses);
		}
	}
}
