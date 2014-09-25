package PokerGame;
import java.util.ArrayList;

public class Hand {
	private static final int HIGHEST_CARD_INDEX = 0;
	private static final int highAceStraightOffset = 13;	//Difference between high ace(14) and low ace(1)
	public static final int HAND_SIZE = 5;
	
	/**
	 * Assumming hand is already sorted
	 * @param Hand
	 * @return the highest value of the straight. -1 if not a straight
	 */
	private static boolean isStraight(ArrayList<Card> hand){
		//Ace high straight
		int highestValue = hand.get(HIGHEST_CARD_INDEX).getValue();
		
		for (int count=1;count<HAND_SIZE;count++){
			//Assuming ace is high
			if (highestValue-count != hand.get(count).getValue()){
				//Check if ace is highest card
				if (highestValue!=Card.MAX_VALUE){
					return false;
				}
				
				//If ace is high hard, check if straight is ace low straight (14,5,4,3,2)
				if (highestValue-highAceStraightOffset-HAND_SIZE-count != hand.get(count).getValue()){
					return false;
				}
			}
		}
		
		return true;
	}
	
	/**
	 * Assuming hand is already sorted
	 * Returns whether all the suits in the hand are the same
	 * @param Hand
	 * @return 
	 */
	private static boolean isFlush(ArrayList<Card> hand){
		Card.Suit suit = hand.get(0).getSuit();
		for (Card card : hand){
			if (card.getSuit() != suit){
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Sort hand from highest to lowest
	 * @param Hand
	 */
	private static void sortHand(ArrayList<Card> hand){
		
		//broken
		Card temp;
		for (int i=0; i<HAND_SIZE;i++){
			for (int j=1;j<i;j++){
				if (hand.get(j-1).getValue()<hand.get(j).getValue()){
					temp = hand.get(j);
					hand.set(j, hand.get(j-1));
					hand.set(j-1, temp);
				}
			}
		}
		
		System.out.print("\tSorted Hand: ");
		printHand(hand);
	}
	
	/**
	 * Assuming hand is already sorted
	 * @param Hand
	 * @return
	 */
	private static Rank getHighestMultipleRank(ArrayList<Card> hand){
		Rank rank = new Rank(hand.get(HIGHEST_CARD_INDEX).getValue());
		int count = 1;
		int current_value = 0;
		
		for (Card card : hand){
			if (current_value != card.getValue()){
				rank.setRank(count);
				current_value = card.getValue();
				count = 1;
			} else {
				count++;
			}
		}
		
		return rank;
	}
	
	public static Rank getRank(ArrayList<Card> hand){
		if (hand.size() != HAND_SIZE){
			//error, hand size is invalid
		}
		
		Rank rank = new Rank(hand.get(HIGHEST_CARD_INDEX).getValue());
		boolean straight = false;
		boolean flush = false;
		
		sortHand(hand);
		
		straight = isStraight(hand);
		flush = isFlush(hand);
		
		//Royal Flush
		if (straight && flush){
			rank.setStraightFlush();
		} 
		//Straight
		else if (straight && !flush){
			rank.setStraight();
		}
		//Flush
		else if (!straight && flush){
			rank.setFlush();
		} 
		else {
			rank = getHighestMultipleRank(hand);
		}
		
		return rank;
	}
	
	public static void printHand(ArrayList<Card> hand){
		String returnStr = "Hand: ";
		for (Card card : hand){
			returnStr += card.print() + " ";
		}
		
		System.out.println(returnStr);
	}
}
