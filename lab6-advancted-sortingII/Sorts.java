import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

	/**
	 * Implementation of various sorting algorithms 
	 * that includes a framework for testing with various input array sizes and over
	 * multiple runs
	 * 
	 */

public class Sorts {

private static Random r = new Random(System.currentTimeMillis());
public static void main(String args[]) { 
	
		
		Random r = new Random();
	
		int[] arr = new int[10];
		for(int i=0; i<10; i++) {
			arr[i] = r.nextInt(10);
		}
		
  	  int[] a = {0, 2, 2, 4, 0, 4, 5, 9, 1};  
		  Sorts s = new Sorts(); 

		  
	     int n = arr.length;
//	     s.quickSort(arr, 0, n-1);
	     
//	     s.selectionSort(arr);
//		  s.insertionSort(arr);
		  s.mergeSort(arr);
//		  s.shuffle(arr); 
//	     s.mergeSortEnhanced(arr);
//	      s.quickSort(arr, 0, n-1);
//	      s.enhancedQuickSort(arr, 0, n-1); 
//		  
	         
		  System.out.print("Sorted array: "); 
		  s.printArray(arr); 
		  long startTime = System.nanoTime();
		  long elapsedTime = System.nanoTime() - startTime;
		  System.out.print("time:" + elapsedTime); 

	
	

		}
		
		//********print helper class*****
		// Prints the input array 
	    private static void printArray(int arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i]+" "); 
	        	System.out.println(); 
	    } 
	 


		//insert your MergeSort implementation here
	    
	    
	    public static void mergeSort(int[] arr) {

	        int n = arr.length;
	        int middle = n / 2;
	        int lSize = middle;
	        int rSize = n - middle;
	        int[] right = new int[rSize];
	        int[] left = new int[lSize];
	        
	        if(n < 2) {
	            return;
	        }

	            for(int i =0; i<middle; i++){
	                left[i] = arr[i];
	            }

	            //creating subarrays
	            for (int i = middle; i < n; i++) {
	                right[i - middle] = arr[i];
	            }

	            mergeSort(left);
	            mergeSort(right);
	            merge(left, right, arr);
	    } 
	    
	    public static void merge(int[] left, int[] right, int[] arr) {
	        int rSize = right.length;
	        int lSize = left.length;
	        int i = 0, j = 0, k = 0;
	        while (i < lSize && j < rSize) {
	            if (left[i] <= right[j]) {
	                arr[k] = left[i];
	                i++;
	                k++;
	            } else {
	                arr[k] = right[j];
	                k++;
	                j++;
	            }
	        }

	        while (i < lSize) {
	            arr[k] = left[i];
	            k++;
	            i++;
	        }
	        while (j < lSize) {
	            arr[k] = right[j];
	            k++;
	            j++;
	        }
	    }
	    
	    
	    public static void mergeSortEnhanced(int[] arr){
	        int n = arr.length;
	        int mid = n/2;
	        if (n <= 8){    
	            insertionSort(arr);
	            return;
	        }

	        int[] left = new int[mid];
	        int[] right = new int[n-mid];

	        for (int i=0;i<mid;i++){
	            left[i] = arr[i];
	        }

	        for (int i=mid;i<n;i++){
	            right[i-mid] = arr[i];
	        }
	        mergeSort(left);
	        mergeSort(right);

	        if (left[mid-1] <= right[0]){
	            for(int pos=0;pos<mid;pos++){
	                arr[pos] = left[pos];
	            }

	            for (int pos=mid;pos<n;pos++){
	                arr[pos] = right[pos-mid];
	            }
	        }else {
	            merge(left, right, arr);
	        }
	}
	  
	    public static void quickSort(int arr[], int low, int high) {

	        for (int i = low + 1; i <= high; i++) {
	            int key = arr[i];
	            int j = i;

	            while (j > low && arr[j-1] > key) {
	                arr[j] = arr[j - 1];
	                j--;
	            }
	            arr[j] = key;
	        }
	}

	    public static int partition(int arr[], int low, int high) {
			int pivot = arr[high];
			int i = (low-1);
			int temp;
			
			for(int j=low; j<= high-1; j++) {
				if(arr[j] < pivot) {
					i++;
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			temp = arr[i+1];
			arr[i+1] = arr[high];
			arr[high] = temp;
			return (i+1);
		}
	    
	    
	    public static void enhancedQuickSort(int[] arr, int low, int high){

	        if (high <= low+10){
	            //System.out.println("insertion used ");
	            quickSort(arr,low,high);
	            return;
	        }else {
	            int mid = (low + high)/2;
	            if (arr[mid] < arr[low]){partition(arr, low, mid);}
	            if (arr[high] < arr[low]){partition(arr, low, high);}
	            if (arr[high] < arr[mid]){partition(arr, mid, high);}

	            //now put the pivot at last position
	            partition(arr, mid, high-1);
	            int pivot = arr[high-1];

	            // Begin partitioning
	            int i, j;
	            for( i = low, j = high - 1; ; ) {
	                while( arr[++i]<pivot)
	                    ;
	                while( pivot < arr[--j])
	                    ;
	                if( i >= j )
	                    break;
	                partition( arr, i, j );
	            }

	            // Restore pivot
	            partition( arr, i, high - 1 );

	            enhancedQuickSort( arr, low, i - 1 );    // Sort small elements
	            enhancedQuickSort( arr, i + 1, high );   // Sort large elements
	        }
	}
	    
		// ***************************** Insertion Sorts *****************************



//		
//				public static void insertionSort(int[] arr) {
//					System.out.println("Insertion Sort"); 
//				  for (int i = 1; i < arr.length; i++) {
//					  int valueToSort = arr[i]; 
//					  int j = i;
//					  
//					  while (j > 0 && arr[j-1] > valueToSort) {
//						  arr[j] = arr[j-1]; 
//						  j--; 
//					  }
//					  arr[j] = valueToSort; 
//				  }
//            
//			    printArray(arr);
//			    
//				}
	    
	    public static void insertionSort(int arr[]) {
			
			for(int i=1; i<arr.length; i++) {
				int key = arr[i];
				int j = i-1;
				
				while(j >= 0 && arr[j] > key) {
					arr[j+1] = arr[j];
					j = j-1;
					arr[j+1] = key;
				}
			}
		}

		

		// ***************************** Selection Sort ****************************

//		public static void selectionSort(int[] nums) {
//			int minindex;
//			for (int i = 0; i < nums.length - 1; i++) {
//				minindex = i;
//				for (int j = i; j < nums.length; j++) {
//					if (nums[j] < nums[minindex]) {
//						minindex = j;
//					}
//				}
//				if (minindex != i) {
//					int tmp = nums[i];
//					nums[i] = nums[minindex];
//					nums[minindex] = tmp;
//				}
//			}
//		}
				
				
				public static void selectionSort(int arr[]) {
					int temp;
					int min_index;

					for (int i = 0; i < arr.length - 1; i++) {
						min_index = i;

						for (int j = i + 1; j < arr.length; j++) {
							if (arr[min_index] > arr[j])
								min_index = j;
						}

						temp = arr[i];
						arr[i] = arr[min_index];
						arr[min_index] = temp;
					}
				}

		// ***************************** Silly Sorts *****************************
				
		
		//*** the silliest sorts of them all
		public static void bogoSort(int[] nums) {
			while (!isSorted(nums)) {
				shuffle(nums);
			}
		}
		
       //******shuffle helper for bogoSort
		// Knuth Shuffle
//		private static void shuffle(int[] nums) { 
//			int n, tmp;
//			for (int i = nums.length - 1; i > 0; i--) {
//				n = r.nextInt(i + 1);
//				tmp = nums[i];
//				nums[i] = nums[n];
//				nums[n] = tmp;
//			}
//		}
		
		private static void shuffle(int[] nums) { 
			Random r = new Random(System.currentTimeMillis());
			int n, tmp;
			for (int i = nums.length - 1; i > 0; i--) {
				n = r.nextInt(i + 1);
				tmp = nums[i];
				nums[i] = nums[n];
				nums[n] = tmp;
			}
		}


		
		//**helper function to check if your array is sorted or not
		
		public static boolean isSorted(int[] arr) {
			
			for(int i=1; i<arr.length; i++) 
				if(arr[i] < arr[i-1])
					return false;
			
				return true;
			
		}
		
		
//		public static boolean isSorted(int[] nums) {
//			for (int i = 0; i < nums.length - 1; i++) {
//				if (nums[i] > nums[i + 1]) {
//					return false;
//				}
//			}
//			return true;
//		}
	

	}
