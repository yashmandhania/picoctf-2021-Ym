import java.util.Scanner;
import java.util.*;


public class comma{
   //method to add commas to the input string
   static String addcommas(String num){
         int i,r;
         String n="";
         //assigning r the remainder when length is divided by 3
	 r = num.length()%3;
	 for(i=num.length()-1;i>=0;i--){
	    //if the the index of the string gives the same remainder with 3 as r,we put comma.
	    if(i%3 == r && i>0){
	       n = ","+num.charAt(i)+n;
	    }
	    else{
	       n = num.charAt(i) + n;
	    }
	 }
	 return n;
	}
	public static void main(String args[]){
	   System.out.println("YASH MANDHANIA REG NO.200905392");
	   System.out.println();
	   Scanner sc = new Scanner(System.in);
	   System.out.println("Enter integer");
	   String str = sc.nextLine();
	   System.out.println("String with commas is :");
	   System.out.println(addcommas(str));
	
	}	        
}

