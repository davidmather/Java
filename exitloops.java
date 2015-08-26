
public class exitloops {
	public static void main(String[] args)
	{
		int index=0;
		while(index<=1000)
		{
			index=index+5;
			System.out.print(index+"  "+(index+5)+"  "+(index+5)+"\n");
			if(index==400){
				break;
				
			}
			
		}
		
	}
}
