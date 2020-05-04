
public class FibonacciSequence{
	
	public static int fibonacci(int n){
	if(n == 0){ //base case 
		return 0;
	}
	if(n == 1 || n == 2){
			return 1;
		}
	return fibonacci(n-2) + fibonacci(n-1);
	}
	
	
    public static void main(String args[]) {
	int number = 48;
	System.out.print("Fibonacci Series of "+number+" numbers: ");
	for(int i = 0; i < number; i++){
			System.out.print(fibonacci(i) +" ");
		}
	
	System.out.println(System.nanoTime());
	}
}