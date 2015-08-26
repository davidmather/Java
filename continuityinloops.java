public class continuityinloops {
	public static void main(String[] arguments)
	{
		int index=0;
		while(index<=1000)
		{
			index=index+5;
			if (index==400)continue;
			System.out.println("the index is "+index);
			
		}
	}
}
