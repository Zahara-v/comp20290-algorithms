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
	
		int[] arr = new int[100000];
		for(int i=0; i<100000; i++) {
			arr[i] = r.nextInt(100000);
		}
		
  	  int[] a = {0, 2, 2, 4, 0, 4, 5, 9, 1};  
		  Sorts s = new Sorts(); 

		  
	     int n = arr.length;
	     s.quickSort(arr, 0, n-1);
	     
//	     s.selectionSort(arr);
//		  s.insertionSort(arr);
//		  s.mergeSort(arr, arr.length);
//		  s.shuffle(arr); 
	     
	      
		  
	         
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
	    
	    public static void mergeSort(int[] a, int n) {
	    	
	    	if(n<2) {
	    		return;
	    	}
	    	
	    	int mid = n/2;
	    	int[] l = new int[mid]; 
	    	int[] r = new int[n-mid]; 
	    	
	    	for(int i=0; i<mid; i++) {
	    		l[i] = a[i];
	    	}
	    	for(int i=mid; i<n;i++) {
	    		r[i-mid] = a[i];
	    	}
	    	mergeSort(l,mid); 
	    	mergeSort(r, n-mid); 
	    	
	    	merge(a, l, r, mid, n-mid); 
	    }
	    
	    public static void merge(int[]a, int[]l, int[]r, int left, int right) {
	    	
	    	int i=0, j=0, k=0;
	    	
	    	while(i<left && j<right) {
	    		if(l[i] <= r[j]) {
	    			a[k++] = l[i++];
	    		}
	    		else {
	    			a[k++] = r[j++];
	    		}
	    	}
	    	
	    	while(i<left) {
	    		a[k++] = l[i++];
	    	}
	    	
	    	while(j<right) {
	    		a[k++] = r[j++]; 
	    	}
	    }
	   
	    public void quickSort(int arr[], int low, int high) {
			if(low<high) {
				int p = partition(arr, low, high);
				
				quickSort(arr, low, p-1);
				quickSort(arr, p+1, high);
			}
		}
	  

	    public int partition(int arr[], int low, int high) {
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
