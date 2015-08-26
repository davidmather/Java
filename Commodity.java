
public class Commodity {
	public static void main(String[] args)
	{
		String shop = "Buy";
		int balance = 550;
		int quantity = 42;
		switch(shop)
		{
			case "BUY":
				quantity+=5;
				balance-=20;
				break;
			case "SELL":
				quantity -=5;
				balance +=15;
		}
		System.out.println("Balance: "+ balance + "\n"+"Quantity: "+quantity);
	}
}
