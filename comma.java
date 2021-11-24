import java.util.Scanner;

public class comma
{
	static String addcomas(String num)
	{
		int i,r;
		String n="";
		r = num.length()%3;
		for(i=num.length()-1;i>=0;i--)
		{
			if(i%3 == r && i>0)
				n = ","+num.charAt(i)+n;
			else
				n = num.charAt(i) + n;
		}

		return n;

	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		String str = sc.nextLine();
		System.out.println(addcomas(str));
	}
}
