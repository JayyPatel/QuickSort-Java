import java.time.Duration;
import java.util.Random;

public class Quicksort {    
	 private static int chooseRandom (int [] a, int left, int right) {
	        
	    	Random random = new Random();
	        int index;        
	        index = (random.nextInt() % a.length);
	        
	        while ((index > right) || (index < left))
	             index = (random.nextInt() % a.length); 
	        
	        return 
	        		(index > 0) ? (index) : (-index);            
	    }
    
    

    public static void referenceSwap( int [ ] a, int index1, int index2 ) {
        int temp = a[ index1 ];
        a[ index1 ] = a[ index2 ];
        a[ index2 ] = temp;
    }

    
    int median3( int [ ] a, int left, int right ) {
        int center = ( left + right ) / 2;
        
        // swap left and center
        if( a[ center ] < ( a[ left ] ) )
        	referenceSwap( a, left, center );
        
        // swap left and right
        if( a[ right ]< ( a[ left ] ))
        	referenceSwap( a, left, right );
        
        //swap center and right
        if( a[ right ] < ( a[ center ] ) )
        	referenceSwap( a, center, right );

            // Place pivot at position right - 1
        referenceSwap( a, center, right);
        return a[ right ];
    }
    
    void insertionSort( int [ ] a, int left, int right ){
        for( int q = left + 1; q <= right; q++ ) {
            int temp = a[ q ];
            int j;

            for( j = q; j > left && temp < ( a[ j - 1 ] ); j-- )
                a[ j ] = a[ j - 1 ];
            a[ j ] = temp;
        }
    }

    private static final int CUTOFF = 3;
    void quicksort_case_1( int [ ] a, int left, int right ){
        if( left + CUTOFF <= right ) {
            int pivot;
            int pivotIndex;
            pivotIndex = left;
            pivot = a[pivotIndex];
            referenceSwap( a, pivotIndex, right );
            
            // Begin partitioning
            int m = left, n = right - 1;
            for( ; ; ) {
                while( a[ m++ ] < ( pivot ));
                while(( a[ n-- ] > ( pivot )) && (n >= left));
                m--;
                n++;
                if( m < n )
                	referenceSwap( a, m, n );
                else
                    break;
            }
            
         // Restoring pivot
            referenceSwap( a, m, right);  
            
         // Sorting small elements
            quicksort_case_1( a, left, m - 1);    
            
         // Sorting large elements
            quicksort_case_1( a, m + 1, right);  
        }
        
        else  
        	//insertion sort on the subarray
            insertionSort( a, left, right );
    }
    
    void quicksort_case_2( int [ ] a, int left, int right ){
        if( left + CUTOFF <= right ) {
            int pivot;
            int pivotIndex;
            pivotIndex = chooseRandom(a, left, right);
            pivot = a[pivotIndex];
            referenceSwap( a, pivotIndex, right );
            
            // Begin partitioning
            int i = left, j = right - 1;
            for( ; ; ) {
                while( a[ i++ ] < ( pivot ));
                while(( a[ j-- ] > ( pivot )) && (j >= left));
                i--;
                j++;
                if( i < j )
                	referenceSwap( a, i, j );
                else
                    break;
                
            }
         // Restoring pivot
            referenceSwap( a, i, right);   
            
         // Sorting small elements
            quicksort_case_2( a, left, i - 1);   
            
           // Sorting large elements
            quicksort_case_2( a, i + 1, right);   
        }
        else  
        	// Do an insertion sort on the subarray
            insertionSort( a, left, right );
    }
    
    void quicksort_case_3( int [ ] a, int left, int right ){
        if( left + CUTOFF <= right ){
            int pivot;        
            int number1 = chooseRandom(a, left, right);
            int number2 = chooseRandom(a, left, right);
            int number3 = chooseRandom(a, left, right);
            
            if( a[ number2 ] < ( a[ number1 ] ) ) {
            	referenceSwap( a, number1, number2 );
            }
            
            if( a[ number3 ]< ( a[ number1 ] )) {
            	referenceSwap( a, number1, number3 );
            }
            
            if( a[ number3 ] < ( a[ number2 ] ) )
            	referenceSwap( a, number2, number3 );
            referenceSwap( a, number2, right );
            pivot = a[right];
            
            
            // Begin partitioning
            int i = left, j = right - 1;
            for( ; ; ) {
                while( a[ i++ ] < ( pivot ));
                while(( a[ j-- ] > ( pivot )) && (j >= left));
                i--;
                j++;
                if( i < j )
                	referenceSwap( a, i, j );
                else
                    break;
            }
         // Restoring pivot
            referenceSwap( a, i, right);
            
         // Sorting small elements
            quicksort_case_3( a, left, i - 1); 
            
         // Sorting large elements
            quicksort_case_3( a, i + 1, right);   
        }
        else  
        	
        	// insertion sort on the subarray
            insertionSort( a, left, right );
    }
    
    void quicksort_case_4( int [ ] a, int left, int right ) {
        if( left + CUTOFF <= right ) {
            int pivot;        
            pivot = median3(a,left, right);
            
            // Partitioning
            int i = left, j = right - 1;
            for( ; ; ) {
                while( a[ i++ ] < ( pivot ));
                while(( a[ j-- ] > ( pivot )) && (j >= left));
                i--;
                j++;
                if( i < j )
                	referenceSwap( a, i, j );
                else
                    break;
            }
            
         // Restoring pivot
            referenceSwap( a, i, right);   
            
         // Sorting small elements
            quicksort_case_4( a, left, i - 1);    
            
         // Sorting large elements
            quicksort_case_4( a, i + 1, right);   
        }
        else  
        	
        	// insertion sort on the subarray
            insertionSort( a, left, right );
    }

    

}
