import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    
    public static int getLiveNeighbors(int[][] cells, int w, int h, int height, int width){
       int NbLivesCells = 0;
      
       
       if(h-1 >= 0){
           //diogonal -1; -1
           if(w-1 >= 0){
              if(cells[h-1][w-1] == 1) {
                    NbLivesCells++;
              }
            } 
            // -1; 0
            if(cells[h-1][w] == 1) {
                NbLivesCells++;
            }
            // -1; +1
            if(w + 1 < width){
                if(cells[h-1][w+1] == 1) {
                    NbLivesCells++;
                }
            } 
       } 
       
       if(h + 1 < height){
           //diogonal +1; -1
           if(w-1 >= 0){
              if(cells[h+1][w-1] == 1) {
                    NbLivesCells++;
              }
            } 
            // +1; 0
            if(cells[h+1][w] == 1) {
                NbLivesCells++;
            }
            // +1; +1
            if(w + 1 < width){
                if(cells[h+1][w+1] == 1) {
                    NbLivesCells++;
                }
            } 
       } 
        //0; -1
            if(w-1 >= 0){
              if(cells[h][w-1] == 1) {
                    NbLivesCells++;
              }
            } 
           
            // 0; +1
            if(w + 1 < width){
                if(cells[h][w+1] == 1) {
                    NbLivesCells++;
                }
            } 
       
       
        return NbLivesCells;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt();
        int height = in.nextInt();
        int[][] cells = new int[height][width];
        int[][] cells_V2 = new int[height][width];
        for (int i = 0; i < height; i++) {
            String line = in.next();
            for (int j = 0; j < width; j++){
                cells[i][j] = Character.getNumericValue((line.charAt(j)));
            }
        }
        // compute next state
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++){
                
                int N = getLiveNeighbors(cells, j, i, height, width);
                
                if((N < 2)&&(cells[i][j] == 1)){
                    cells_V2[i][j] = 0; //case 1
                }
                else if((N <= 3) && (N >= 2) && (cells[i][j] == 1)){
                    cells_V2[i][j] = 1; //case 2
                }
                else if((N > 3) &&(cells[i][j] == 1)){
                       cells_V2[i][j] = 0; //case 3
                }
                else if((N == 3) &&(cells[i][j] == 0)){
                       cells_V2[i][j] = 1; //case 4
                } else{
                    cells_V2[i][j] = 0;
                }
                
            }
            
        }
        StringBuilder answer = new StringBuilder();
          for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++){
                answer.append(cells_V2[i][j]);
            }
            answer.append("\n");
        }
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(answer);
    }
}
