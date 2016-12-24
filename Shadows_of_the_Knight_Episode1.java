//Shadows of the Knight - Episode 1
import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        HashMap<String, Integer> directions = new HashMap<String, Integer>();
        directions.put("U", 0);
        directions.put("UR", 1);
        directions.put("R", 2);
        directions.put("DR", 3);
        directions.put("D", 4);
        directions.put("DL", 5);
        directions.put("L", 6);
        directions.put("UL", 7);
        
        int nextX = 0;
        int nextY = 0;
        int coefX = 1; // is 1 if we should modify X, 0 else
        int coefY = 1;
        int stepN_1 = 0;
        int stepN_2 = 0;
        int granularity = 2; 
        
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int X0 = in.nextInt();
        int Y0 = in.nextInt();

        // game loop
        while (true) {
            coefX = 1;
            coefY = 1;
            String bombDir = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)
            int direction = directions.get(bombDir);
           
            System.err.println("Step N-2 : " + stepN_2 + " Step N-1 : " + stepN_1+ " direction : " + direction);
            if((stepN_2 == direction)&&(stepN_1 != direction)){
                granularity *= 2;
            }
            if((stepN_2 == direction)&&(stepN_1 == direction)){
                granularity = 2;
            }
            if((direction == 0)||(direction == 4)){
                coefX = 0;
            }
            if((direction == 2)||(direction == 6)){
                coefY = 0;
            }
            
            //move UP : 
            if((direction < 2)||(direction == 7)){
                nextY -= coefY*nextY/granularity ;
            }

            //move Down :
            if((direction > 2)&&(direction < 6)){
                nextY += coefY*(H - nextY)/granularity;
            }
            //move right
            if((direction < 4)&&(direction > 0)){
                nextX += coefX*(W - nextX)/granularity;
            }
            //move left
            if(direction > 4){
                nextX -= coefX*nextX/granularity;
            }
            stepN_2 = stepN_1;
            stepN_1 = direction;
            // the location of the next window Batman should jump to.
            System.out.println(nextX + " " + nextY);
        }
    }
}
