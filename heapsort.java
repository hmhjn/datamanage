//max heap: insertion, deletion and heapsort
import java.util.*;

public class Heap {
    int arr[];
    int last_ind, size;
    
    Heap(int size)
    {
        arr=new int[size];
        last_ind=-1;
        this.size=size;
    }

    public void heapifyUp()
    {
        int temp, check=last_ind;
        while((check!=0)&&(arr[check]>arr[(check-1)/2]))
        {
            if(arr[check]>arr[(check-1)/2])
            {
                //swap
                temp=arr[check];
                arr[check]=arr[(check-1)/2];
                arr[(check-1)/2]=temp;

                check=(check-1)/2;
            }
        }
    }

    public void heapifyDown()
    {
        int temp, check=0;
        while((check!=last_ind)&&((arr[check]<arr[2*check+1])||(arr[check]<arr[2*check+2]))&&(last_ind>2*check))
        {
            if((arr[check]<arr[2*check+1])||(arr[check]<arr[2*check+2]))
            {
                if(arr[2*check+1]>arr[2*check+2])
                {
                    //swap
                    temp=arr[check];
                    arr[check]=arr[2*check+1];
                    arr[2*check+1]=temp;

                    check=2*check+1;
                }
                else
                {
                    //swap
                    temp=arr[check];
                    arr[check]=arr[2*check+2];
                    arr[2*check+2]=temp;

                    check=2*check+2;
                }
            }
        }
    }

    void insertion(int data)
    {

        if(last_ind<size-1)
        {
            last_ind++;
            arr[last_ind]=data;
            heapifyUp();
        }
        // else
        // {
        //     n=2*n;
        //     puts("SIZE INCREASED.");
        //     printf("Size of array: %d\n", n);
        //     arr=realloc(arr, 2*sizeof(arr));
        //     last_ind++;
        //     arr[last_ind]=data;
        //     heapifyUp();
        // }
    }

    void deletion()
    {
        if(last_ind>=0)
        {
            arr[0]=arr[last_ind];
            last_ind--;
            heapifyDown();
        }
        // else
        // {
        //     printf("Heap is empty.\n");
        // }
    }

    void heapsort()
    {
        int p[]=new int[last_ind+1];
        int i=0,j;
        long start2=System.nanoTime();
        while(last_ind>=0)
        {
            p[i++]=arr[0];
            arr[0]=arr[last_ind];
            heapifyDown();
            last_ind--;
        }
        long end2=System.nanoTime();
        long duration2=end2-start2;

        System.out.println("time duration "+duration2);
    }

    void display()
    {
        int i;
        System.out.print("Heap: ");
        for(i=0; i<=last_ind; i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand=new Random();
        try 
        {
            int n=2000, op, data;
            boolean exit=true;
            Heap obj = new Heap(n);
            while(exit==true)
            {
                System.out.println("Menu:\n1. Insertion\n2. Deletion\n3. Heap Print\n4. HeapSort\n5. Exit\nEnter Option: ");
                op=sc.nextInt();
                switch(op)
                {
                    case 1:
                        long start=System.nanoTime();
                        for(int i=0;i<2000;i++)
                        {
                         int temp=rand.nextInt(2000);
                         obj.insertion(temp);
                         temp=0;
                        }
                        long end=System.nanoTime();
                        long duration=end-start;
                        System.out.println("Time duration "+duration/1000);
                        break;
                    case 2:
                        long start1=System.nanoTime();
                        obj.deletion();
                        long end1=System.nanoTime();
                        long duration1=end1-start1;
                        System.out.println("Time duration "+duration1);
                        break;
                    case 3:
                        obj.display();
                        break;
                    case 4:
                        obj.heapsort();
                        break;
                    case 5:
                        exit=false;
                        break;
                    default:
                    System.out.println("Wrong choice");
                }
            }
        } 
        catch (Exception e) {
            sc.close();
        }
    }
}