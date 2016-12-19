import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();
        String answer = "";
        String bitList = "";
        
        for(int i = 0; i < MESSAGE.length(); i++){
            String text = new BigInteger(MESSAGE.substring(i, i+1).getBytes()).toString(2);
            int zeroNb = 7 - text.length();
            for(int j = 0; j < zeroNb; j++){
                bitList +=  "0";
            }
            bitList += text;
        }
        System.err.println("BitList = " + bitList);
        
        answer =  bitList.charAt(0) == '1'? "0 0": "00 0";
        for (int i = 1; i < bitList.length(); i++ ){
            if(bitList.charAt(i) != bitList.charAt(i-1)){
                answer +=  bitList.charAt(i) == '1'? " 0 0": " 00 0";
            }
            else answer += "0";
        }

        System.out.println(answer);
    }
}
