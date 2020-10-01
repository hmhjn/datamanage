 import java.util.*;
 class BinarySearch
{
 public static int binarySearch(int array[],int l,int r,int search)
{
if(r>l)
{
int mid;
mid=(l+r)/2;
 if(array[mid]==search)
 return mid;
else if(array[mid]<key)
 return binarySearch(array,mid+1,r,search);
else
return binarySearch(array,l,mid-1,search);
}
return -1;
}
/** Since it works by serching through the middle elemenet and process
according to whether the searching data is less or greater than it ,all this is
done above*/
public static void main(String [] args)
{
 Scannner in=new Scanner(System.in);
System.out.println(“Enter the no. of element in array”);
int k=in.nextInt();
int array[]=new int[k];
System.out.println(“Enter the data”);
for(int i=0;i<k;i++)
array[i]=in.nextInt();
System.out.println(“Enter the data that you want to find”);
int search=in.nextInt();
int score=binarySearch(array,0,n-1,search)
if(score==-1)
System.out.println(“Element not found”);
else
System.out.println(“Element found at place”+score);
}
}
