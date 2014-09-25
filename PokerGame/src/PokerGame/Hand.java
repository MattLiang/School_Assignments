package PokerGame;
import java.util.ArrayList;

public class Hand {
	private static final int HIGHEST_CARD_INDEX = 0;
	public static final int HAND_SIZE = 5;
	
	/**
	 * Assumming hand is already sorted
	 * @param Hand
	 * @return the highest value of the straight. -1 if not a straight
	 */
	private static boolean isStraight(ArrayList<Card> hand){
		//Ace high straight
		int compareValue = hand.get(HIGHEST_CARD_INDEX).getValue();
		int nextCardValue;
		
		for (int count=1;count<HAND_SIZE;count++){
			//Assuming ace is high
			nextCardValue = hand.get(count).getValue();
			if (compareValue-nextCardValue!=1){
				return false;
			}
			compareValue = nextCardValue;
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
		for (int i=0; i<HAND_SIZE-1;i++){
			for (int j=0;j<HAND_SIZE-i-1;j++){
				if (hand.get(j).getValue()<hand.get(j+1).getValue()){
					temp = hand.get(j);
					hand.set(j, hand.get(j+1));
					hand.set(j+1, temp);
				}
			}
		}
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
				rank.setRank(count,current_value);
				current_value = card.getValue();
				count = 1;
			} else {
				count++;
			}
		}
		rank.setRank(count,current_value);
		
		return rank;
	}
	
	private static boolean isAceLowStraight(ArrayList<Card> hand){
		ArrayList<Card> tempHand=new ArrayList<Card>(hand);
		boolean straight;
		
		//Check for ace low straight
		Card card = tempHand.get(HIGHEST_CARD_INDEX);
		card.setValue(Card.MIN_VALUE);
		tempHand.set(HIGHEST_CARD_INDEX, card);
		sortHand(tempHand);
		
		straight=isStraight(tempHand);
		if (straight) {
			hand = tempHand;
		} else {
			//revert changes
			card.setValue(Card.MAX_VALUE);
			hand.set(HIGHEST_CARD_INDEX, card);
			sortHand(hand);
		}
		
		return straight;
	}
	
	public static Rank getRank(ArrayList<Card> hand){
		if (hand.size() != HAND_SIZE){
			//error, hand size is invalid
		}
		
		sortHand(hand);
		Rank rank = new Rank(hand.get(HIGHEST_CARD_INDEX).getValue());
		boolean straight = false;
		boolean flush = false;
		
		straight = isStraight(hand);
		
		if (!straight && hand.get(HIGHEST_CARD_INDEX).getValue()==Card.MAX_VALUE){
			straight = isAceLowStraight(hand);
			if (straight) {
				rank = new Rank(hand.get(HIGHEST_CARD_INDEX).getValue());
			}
		}

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
