// Java program for Naive Pattern Searching 

public class bruteForceSearch {
	
	public static int search(String txt, String pat) {
       int n = txt.length();
       int m = pat.length();

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (txt.charAt(i+j) != pat.charAt(j))
                    break;
            }
            if (j == m) 
            	System.out.println("pattern found at index " + i);
            	
            }
        
        return n;                          
    }
	
		
	
	public static void main(String[] args) 
	
	    { 
	        //alter to take text file in..
	        String txt = "ABABDABACDABABCABAB"; 
		    String pat = "ABABCABAB"; 
	    	
//	    	String txt = "ZAHARAVAZIRHELLOHFIEWKEJRNK";
//	    	String pat = "LO";
	        search(txt, pat); 
	    	
	    } 
	} 