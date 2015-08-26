

import java.util.Scanner;
 
class types
{
   public static void main(String args[])
   {
      String s;
      String character="";
    
	Scanner in = new Scanner(System.in);
    
      System.out.println("Enter a string");
      s = in.nextLine();
      System.out.println("You entered string "+s);
      String[] ary = s.split("");
      in.close();
       for(int i = 0; i < ary.length; i++)  {
    	     
    	     s=ary[i].toString();
    	  		if(
    	  		ary[i].equals("1")|
    	  		ary[i].equals("2")|
    	  		ary[i].equals("3")|
    	  		ary[i].equals("4")|
    	  		ary[i].equals("5")|
    	  		ary[i].equals("6")|
    	  		ary[i].equals("7")|
    	  		ary[i].equals("8")|
    	  		ary[i].equals("9")|
    	  		ary[i].equals("0")
    	  		)
    		   {
    		   System.out.println(ary[i]); //prints "name"
    		   character=character+ary[i];
    		   }

    	}
       System.out.println(character);

   }
}