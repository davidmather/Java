
import java.util.Scanner;
public class Comparison {
	public static void main(String[] args)
	{
		
		Scanner input=new Scanner(System.in);
		int number1;
		int number2;
		System.out.print("Enter the first integer: ");
		number1=input.nextInt();
		System.out.print("Enter the second integer: ");
		number2=input.nextInt();
		if(number1==number2)
		{
			System.out.printf("%d==%d\n", number1, number2);
		}
		if(number1!=number2)
		{
			System.out.printf("%d!=%d\n", number1, number2);
		}
		if(number1<number2)
		{
			System.out.printf("%d<%d\n", number1, number2);
		}
		if(number1>number2)
		{
			System.out.printf("%d>%d\n", number1, number2);
		}
		if(number1<=number2)
		{
			System.out.printf("%d<=%d\n", number1, number2);
		}
		if(number1>=number2)
		{
			System.out.printf("%d>=%d\n", number1, number2);
		}
	}//end method main
}//end class Comparison
