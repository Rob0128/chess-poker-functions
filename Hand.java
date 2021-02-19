// 13707293
// robertjohnhill1@gmail.com

import java.io.*;
import java.util.*;


 class Card {
     int num;
     int suit;
     String card_num_str;

     Card(int n, int s){
         int x = n;
         this.num = n;
         this.suit = s;
         this.card_num_str = "" + n;
     }
 }

public class Hand
{
    Card[] cards;

    Hand( String str )
    {
        Scanner handScanner = new Scanner(str);
        this.cards = new Card[5];

        for (int i = 0; i <= 4; i++){
            cards[i] = new Card(handScanner.nextInt(), handScanner.nextInt());
        }

    }


    public String toString()
    {
        //allocating numbers and names to numbers
        for (Card c : cards){
            if (c.num == 1){
                c.card_num_str = "Ace";
            }
            if (c.num == 13){
                c.card_num_str = "King";
            }
            if (c.num == 1){
                c.card_num_str = "Ace";
            }
        }
        return "";
    }


    public String status() // return "straight flush", "straight", "flush", or "none"
    { 
        return( "none" );
    }



    public static void main(String[] args) {
        // sample testing code
        Hand h = new Hand( "1 1 2 1 3 1 4 1 5 1" );
        System.out.println( h.toString() );
        System.out.println( h.status() );
    }
    
}

