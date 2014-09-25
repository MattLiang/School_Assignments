package PokerGame;

import java.util.ArrayList;

public class Poker {
	public Poker(){
		
	}
	
	public void play(){
		
	}
	
	public static void main (String[] args){
	
		//Hearts
		Card heart2 = new Card(Card.Suit.heart,2);
		Card heart3 = new Card(Card.Suit.heart,3);
		Card heart4 = new Card(Card.Suit.heart,4);
		Card heart5 = new Card(Card.Suit.heart,5);
		Card heart6 = new Card(Card.Suit.heart,6);
		Card heart7 = new Card(Card.Suit.heart,7);
		Card heart8 = new Card(Card.Suit.heart,8);
		Card heart9 = new Card(Card.Suit.heart,9);
		Card heart10 = new Card(Card.Suit.heart,10);
		Card heartJ = new Card(Card.Suit.heart,11);
		Card heartQ = new Card(Card.Suit.heart,12);
		Card heartK = new Card(Card.Suit.heart,13);
		Card heartA = new Card(Card.Suit.heart,14);
		
		//Spades
		Card spade2 = new Card(Card.Suit.spade,2);
		Card spade3 = new Card(Card.Suit.spade,3);
		Card spade4 = new Card(Card.Suit.spade,4);
		Card spade5 = new Card(Card.Suit.spade,5);
		Card spade6 = new Card(Card.Suit.spade,6);
		Card spade7 = new Card(Card.Suit.spade,7);
		Card spade8 = new Card(Card.Suit.spade,8);
		Card spade9 = new Card(Card.Suit.spade,9);
		Card spade10 = new Card(Card.Suit.spade,10);
		Card spadeJ = new Card(Card.Suit.spade,11);
		Card spadeQ = new Card(Card.Suit.spade,12);
		Card spadeK = new Card(Card.Suit.spade,13);
		Card spadeA = new Card(Card.Suit.spade,14);
		
		//Clubs
		Card club2 = new Card(Card.Suit.club,2);
		Card club3 = new Card(Card.Suit.club,3);
		Card club4 = new Card(Card.Suit.club,4);
		Card club5 = new Card(Card.Suit.club,5);
		Card club6 = new Card(Card.Suit.club,6);
		Card club7 = new Card(Card.Suit.club,7);
		Card club8 = new Card(Card.Suit.club,8);
		Card club9 = new Card(Card.Suit.club,9);
		Card club10 = new Card(Card.Suit.club,10);
		Card clubJ = new Card(Card.Suit.club,11);
		Card clubQ = new Card(Card.Suit.club,12);
		Card clubK = new Card(Card.Suit.club,13);
		Card clubA = new Card(Card.Suit.club,14);
		
		//Diamonds
		Card diamond2 = new Card(Card.Suit.diamond,2);
		Card diamond3 = new Card(Card.Suit.diamond,3);
		Card diamond4 = new Card(Card.Suit.diamond,4);
		Card diamond5 = new Card(Card.Suit.diamond,5);
		Card diamond6 = new Card(Card.Suit.diamond,6);
		Card diamond7 = new Card(Card.Suit.diamond,7);
		Card diamond8 = new Card(Card.Suit.diamond,8);
		Card diamond9 = new Card(Card.Suit.diamond,9);
		Card diamond10 = new Card(Card.Suit.diamond,10);
		Card diamondJ = new Card(Card.Suit.diamond,11);
		Card diamondQ = new Card(Card.Suit.diamond,12);
		Card diamondK = new Card(Card.Suit.diamond,13);
		Card diamondA = new Card(Card.Suit.diamond,14);
		
		ArrayList<Card> royalFlushLow = new ArrayList<Card>();
		royalFlushLow.add(heart2);
		royalFlushLow.add(heart4);
		royalFlushLow.add(heart3);
		royalFlushLow.add(heartA);
		royalFlushLow.add(heart5);
		
		ArrayList<Card> royalFlushHigh = new ArrayList<Card>();
		royalFlushHigh.add(heartA);
		royalFlushHigh.add(heartK);
		royalFlushHigh.add(heartQ);
		royalFlushHigh.add(heartJ);
		royalFlushHigh.add(heart10);
		
		ArrayList<Card> flush = new ArrayList<Card>();
		flush.add(heart2);
		flush.add(heart5);
		flush.add(heart7);
		flush.add(heart10);
		flush.add(heartK);
		
		ArrayList<Card> straight = new ArrayList<Card>();
		straight.add(heart2);
		straight.add(spade3);
		straight.add(diamond4);
		straight.add(diamond5);
		straight.add(club6);
		
		ArrayList<Card> fullHouse = new ArrayList<Card>();
		fullHouse.add(heart2);
		fullHouse.add(spade2);
		fullHouse.add(diamond2);
		fullHouse.add(diamond3);
		fullHouse.add(club3);
		
		ArrayList<Card> twoPair = new ArrayList<Card>();
		twoPair.add(heart2);
		twoPair.add(spade2);
		twoPair.add(diamond7);
		twoPair.add(diamond3);
		twoPair.add(club3);
		
		ArrayList<Card> pair = new ArrayList<Card>();
		pair.add(heart2);
		pair.add(spade2);
		pair.add(diamond7);
		pair.add(diamond5);
		pair.add(club3);
		
		ArrayList<Card> threeOfAKind = new ArrayList<Card>();
		threeOfAKind.add(heart2);
		threeOfAKind.add(spade2);
		threeOfAKind.add(diamond2);
		threeOfAKind.add(diamond9);
		threeOfAKind.add(club3);
		
		ArrayList<Card> fourOfAKind = new ArrayList<Card>();
		fourOfAKind.add(heart2);
		fourOfAKind.add(spade2);
		fourOfAKind.add(diamond2);
		fourOfAKind.add(diamond3);
		fourOfAKind.add(club2);
		
		ArrayList<Card> highCard = new ArrayList<Card>();
		highCard.add(heartA);
		highCard.add(spade2);
		highCard.add(diamond10);
		highCard.add(diamond3);
		highCard.add(club2);
		
		
		Rank rank;
		
		Hand.printHand(royalFlushLow);
		rank = Hand.getRank(royalFlushLow);
		System.out.println("Rank: "+rank.getRank().toString()+", High: "+rank.getHighestValue());
		
		Hand.printHand(royalFlushHigh);
		rank = Hand.getRank(royalFlushHigh);
		System.out.println("Rank: "+rank.getRank().toString()+", High: "+rank.getHighestValue());
		
		Hand.printHand(flush);
		Hand.printHand(straight);
		Hand.printHand(fullHouse);
		Hand.printHand(twoPair);
		Hand.printHand(pair);
		Hand.printHand(threeOfAKind);
		Hand.printHand(fourOfAKind);
		Hand.printHand(highCard);
		
		
		
	}
	
	//how to handle ties of ranks
	
}
