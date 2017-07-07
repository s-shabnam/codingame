import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        int result = 0;  
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        int [] cubes = new int [N+1];
        
        for (int i = 0; i < N; i++){
            cubes[i] = (int)Math.pow((double) (i+1),3);
            System.err.println("N = " + (i + 1)+ " cubes = " + cubes[i]);
        }            
        if (N == 1){
            result = 1;
        }else if (N == 2){
            result = cubes[N - 1];
        }
        if (N > 2){
            result = Math.abs(cubes[N - 1] - cubes[N - 3] );
        }    
        
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(result);
    }
}
