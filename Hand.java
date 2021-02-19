// 13707293
// robertjohnhill1@gmail.com

import java.io.*;
import java.util.*;


 class Card {
     int num;
     int suit;
     String card_num_str;
     String card_suit_str;

     Card(int n, int s){
         int x = n;
         this.num = n;
         this.suit = s;
         this.card_num_str = "" + n;
         this.card_suit_str = "";
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
        //allocating numbers and names to cards
        for (Card c : cards){
            if (c.num == 1){
                c.card_num_str = "Ace";
            }
            if (c.num == 13){
                c.card_num_str = "King";
            }
            if (c.num == 12){
                c.card_num_str = "Queen";
            }
            if (c.num == 11){
                c.card_num_str = "Jack";
            }
        }

        //allocating suits to cards
        for (Card c : cards){
            if(c.suit == 0){
                c.card_suit_str = "Clubs";
            }
            if(c.suit == 1){
                c.card_suit_str = "Diamonds";
            }
            if(c.suit == 2){
                c.card_suit_str = "Hearts";
            }
            if(c.suit == 3){
                c.card_suit_str = "Spades";
            }
        }

        String ret_str = "";
        Boolean ifFirst = true;

        for (Card c : cards){
            if (ifFirst == true){
                ret_str +=c.card_num_str + " of " + c.card_suit_str;
                ifFirst = false;
            }
            else{
                ret_str +=  ", " + c.card_num_str + " of " + c.card_suit_str;
            }
        }
        return ret_str;
    }


    public String status() // return "straight flush", "straight", "flush", or "none"
    {
        ArrayList<Integer> straight_check = new ArrayList<Integer>();
        ArrayList<Integer> flush_check = new ArrayList<Integer>();

        ArrayList<Integer> ace_low_straight = new ArrayList<Integer>();
        ace_low_straight.add(1);
        ace_low_straight.add(10);
        ace_low_straight.add(11);
        ace_low_straight.add(12);
        ace_low_straight.add(13);



        Boolean straight = false;
        Boolean flush = false;

        for (Card c : cards){
            straight_check.add(c.num);
            flush_check.add(c.suit);
        }
        Collections.sort(straight_check);
        Collections.sort(flush_check);

        //checks if flush
        if (flush_check.get(0) == flush_check.get(4)){
            flush = true;
        }
        //checks if straight
        if (ace_low_straight.equals(straight_check)){
            straight = true;
        }
        else {
        for (int i= 4; i >= 1; i--){
            if(straight_check.get(i) - straight_check.get(i-1) == 1){
                straight = true;
            }
            else{
                straight = false;
                break;
            }
        }
    }






        //return string concatenation
        String end_string = "none";

        if (flush == true & straight == true){
            end_string = "straight flush";
        }
        else if (flush == true){
            end_string = "flush";
        }
        else if (straight == true){
            end_string = "straight";
        }


        return( end_string );
    }



    public static void main(String[] args) {
        // sample testing code
        Hand h = new Hand( "1 1 2 1 3 1 4 1 5 1" );
        System.out.println( h.toString() );
        System.out.println( h.status() );
    }
    
}

