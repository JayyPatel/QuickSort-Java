import java.io.File;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import java.util.*;
import java.time.Duration;

public class main {
    public static void main(String[] args) {
        try{
            
                PrintWriter output1 = new PrintWriter(new File("unsorted.txt"));
                Scanner in = new Scanner (System.in);
                
                // prompt user to enter array size
                System.out.print ("Enter the size of the array: ");
                
                // get the array size
                int size = in.nextInt();
                int[] array = new int [size];
                Random random = new Random();
                
               
                for (int i = 0; i < size; ++i) {
                	// get number from array
                     int number = random.nextInt();
                     array[i] = number;
                }
                
                
                for (int i = 0; i < size; ++i){
                    output1.print(array[i]);
                    output1.print('\n');
                }
                
                output1.close();
                Quicksort q = new Quicksort();
                
                //Choose the first element as the pivot
                long startTime = System.nanoTime();
                // implement case 1
                q.quicksort_case_1( array, 0, array.length - 1);
                long finishTime = System.nanoTime();
                System.out.println("The elapsed time for case 1 is " + (finishTime - startTime) + " ns");                
                
                //Read the unsorted array from the unsorted.txt and sort it using case 2:
                Scanner input1 = new Scanner (new File ("unsorted.txt"));
                int i = 0;
                while (input1.hasNextLine())
                {
                    String st  = input1.nextLine();
                    int num = Integer.parseInt(st);
                    array[i++] = num;
                }
                // Randomly choose the pivot element
                
             // start the time count in nano second
                startTime = System.nanoTime();
                q.quicksort_case_2( array, 0, array.length - 1);
             // end the time count
                finishTime = System.nanoTime();
                System.out.println("The elapsed time for case 2 is " + (finishTime - startTime) + " ns");
                input1.close();                
                
                Scanner input2 = new Scanner (new File ("unsorted.txt"));
                i = 0;
                while (input2.hasNextLine())
                {
                    String str  = input2.nextLine();
                    int num = Integer.parseInt(str);
                    array[i++] = num;
                }
                //Choose the median of three randomly chosen elements as the pivot
                // start time
                startTime = System.nanoTime();//
                q.quicksort_case_3( array, 0, array.length - 1);
                // end time
                finishTime = System.nanoTime();
                
                System.out.println("The elapsed time for case 3 is " + (finishTime - startTime) + " ns");
                input2.close();
                
                Scanner input3 = new Scanner (new File ("unsorted.txt"));
                i = 0;
                while (input3.hasNextLine())
                {
                    String str  = input3.nextLine();
                    int num = Integer.parseInt(str);
                    array[i++] = num;
                }
                
                // Median of first, center and last element
                //start time
                startTime = System.nanoTime();
                q.quicksort_case_4( array, 0, array.length - 1);
                //end time
                finishTime = System.nanoTime();
                
                System.out.println("The elapsed time for case 4 is " + 
                		(finishTime - startTime) + " ns");
                input3.close();
                
                // output the sorted array file
                PrintWriter output2 = new PrintWriter(new File("sorted.txt"));
                for (i = 0; i < size; ++i)
                {
                    output2.print(array[i]);
                    output2.print('\n');
                }
                output2.close();              
            }
        catch (Exception e)
        {
            System.out.println ("\nError! Try again.");
        }
       
       
    }
}