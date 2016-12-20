import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        //initialisation of variables
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of cards for player 1
        String[] warCards ;
        List<String> refWarCards = new ArrayList<String>();
        List<String> tmpWarCards = new ArrayList<String>();
        Queue playerN = new LinkedList();
        Queue playerM = new LinkedList();
        int round = 0;
        int winnerNumner = 0;
        
        //creation of the list of all cards
        Map<String, Integer> refCards = new HashMap<String, Integer>();
         for (int i = 0; i < 8; i++) {
            refCards.put(Integer.toString(i+2), i);
        }
        refCards.put("1", 8); // for card 10
        refCards.put("J", 9);
        refCards.put("Q", 10);
        refCards.put("K", 11);
        refCards.put("A", 12);
        
        //first plaer's (1) cards
        for (int i = 0; i < n; i++) {
            String cardp1 = in.next(); // the n cards of player 1
            playerN.add(cardp1.substring(0, 1));
            System.err.println("Player 1 cards : " + cardp1 + " ");
        }
         System.err.println("------------------");
         
        //second plaer's (2) cards
        int m = in.nextInt(); // the number of cards for player 2
        for (int i = 0; i < m; i++) {
            String cardp2 = in.next(); // the m cards of player 2
            playerM.add(cardp2.substring(0, 1));
            System.err.println("Player 2 cards : " + cardp2 + " ");
        }
        System.err.println("------------------");
        
        while((playerN.size() > 0) && (playerM.size() > 0)){
            String cardpN = playerN.remove().toString();
            String cardpM = playerM.remove().toString();
            Queue winner = playerN;
            winnerNumner = 0;
            warCards = new String[8];
            tmpWarCards= new ArrayList<String>();
            
            int indexN = refCards.get(cardpN);
            int indexM = refCards.get(cardpM);
            
            if(indexN != indexM){
                
                if(indexN < indexM){
                   winner =  playerM;
                   winnerNumner = 2;
                }else if (indexN > indexM){
                   winner =  playerN;
                   winnerNumner = 1; 
                }
                
                int longeur = refWarCards.size(); // number of war cards 
                if (longeur > 0){
                  for(int i = 0; i < longeur; i++){
                      if( i == longeur/2 - 1){
                          winner.add(cardpN);
                      }
                    winner.add(refWarCards.get(i));
                    }  
                }
                winner.add(cardpM);
                round++;
                refWarCards= new ArrayList<String>();
            }else{
                //war card of current round to save in array warCards
                warCards[0] = cardpN; 
                warCards[4] = cardpM; 
                for(int i = 1; i<4; i++) {
                   warCards[i] = playerN.remove().toString(); 
                   warCards[i+4] = playerM.remove().toString();
                }
                System.err.println("War Cards of current round : ");
                for(int i = 1; i<warCards.length; i++) {
                   System.err.println(warCards[i]);
                }
                // war  cards remaining of previous rounds
                // cards of first player
                if(refWarCards != null){
                      for (int k = 0; k < refWarCards.size(); k++){
                        if(k == refWarCards.size()/2){
                            for(int j = 0; j < warCards.length / 2; j++){
                                tmpWarCards.add(warCards[j]); // first half of war cards of current round corresponding to first player
                            }
                            }else{
                                tmpWarCards.add(refWarCards.get(k)); // war cards of previous rounds 
                            }
                           
                        } 
                        for(int j = warCards.length/2; j < warCards.length; j++){
                           tmpWarCards.add(warCards[j]);// second half of war cards of current round corresponding to second player
                       } 
                } else{
                    for(int j = 0; j < warCards.length; j++){
                        tmpWarCards.add(warCards[j]); // first half of war cards of current round corresponding to first player
                    }
                }
               refWarCards = tmpWarCards;
            }
        } if(winnerNumner > 0){
            System.out.println(winnerNumner + " " + round);
        }else{
            System.out.println("PAT");
        }
        
    }
}
