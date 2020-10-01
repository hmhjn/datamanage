import java.io.*;
import java.util.*;
public class insertionsort
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the number of element you want to sort: ");
		int n = scan.nextInt();
		System.out.println("Enter the elements to sort ");
		int [] a;
		a = new int[n];
		int i = 0;
		for(i=0;i<n;i++)
		{
			a[i] = scan.nextInt();
		}
		System.out.println("Elements after insertion sort are ");
		int j = 0;
		for(i=1;i<n;i++)
		{		
			j = i-1;
			while(j>=0&&a[j]>a[j+1])
			{
				a[j]=a[j+1]+a[j];
				a[j+1]= a[j]-a[j+1];
				a[j]=a[j]-a[j+1];
				j--;			
			}
		}
		for(i=0;i<n;i++)
		{
			System.out.print(a[i]+" ");
		}
	}
}
		

	
