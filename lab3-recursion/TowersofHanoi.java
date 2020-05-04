class TowersofHanoi
{ 
   
    static void tower(int n, char from_rod, char to_rod, char aux_rod) 
    { 
        if (n == 1) //base case 
        { 
            System.out.println("Move disk 1 from " +  from_rod + " to " + to_rod); 
            return;  
        } 
        tower(n-1, from_rod, aux_rod, to_rod); 
        System.out.println("Move disk " + n + " from " +  from_rod + " to " + to_rod); 
        tower(n-1, aux_rod, to_rod, from_rod); 
    } 
      
   
    public static void main(String args[]) 
    { 
        int n = 4; 
        tower(n, 'A', 'C', 'B');  // A, B and C are names of rods 
    } 
} 