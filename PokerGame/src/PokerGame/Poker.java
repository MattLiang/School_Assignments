package PokerGame;

import java.util.ArrayList;

public class Poker {
	public Poker(){
		
	}

	
	public static void main (String[] args){
		
		ArrayList<Card> royalFlushLow = new ArrayList<Card>();
		royalFlushLow.add(new Card(Card.Suit.heart,2));
		royalFlushLow.add(new Card(Card.Suit.heart,4));
		royalFlushLow.add(new Card(Card.Suit.heart,3));
		royalFlushLow.add(new Card(Card.Suit.heart,14));
		royalFlushLow.add(new Card(Card.Suit.heart,5));
		
		ArrayList<Card> royalFlushHigh = new ArrayList<Card>();
		royalFlushHigh.add(new Card(Card.Suit.club,14));
		royalFlushHigh.add(new Card(Card.Suit.club,13));
		royalFlushHigh.add(new Card(Card.Suit.club,12));
		royalFlushHigh.add(new Card(Card.Suit.club,11));
		royalFlushHigh.add(new Card(Card.Suit.club,10));
		
		ArrayList<Card> flush = new ArrayList<Card>();
		flush.add(new Card(Card.Suit.heart,2));
		flush.add(new Card(Card.Suit.heart,5));
		flush.add(new Card(Card.Suit.heart,7));
		flush.add(new Card(Card.Suit.heart,10));
		flush.add(new Card(Card.Suit.heart,13));
		
		ArrayList<Card> straight = new ArrayList<Card>();
		straight.add(new Card(Card.Suit.heart,2));
		straight.add(new Card(Card.Suit.spade,3));
		straight.add(new Card(Card.Suit.diamond,4));
		straight.add(new Card(Card.Suit.diamond,5));
		straight.add(new Card(Card.Suit.club,6));
		
		ArrayList<Card> fullHouse = new ArrayList<Card>();
		fullHouse.add(new Card(Card.Suit.heart,2));
		fullHouse.add(new Card(Card.Suit.spade,2));
		fullHouse.add(new Card(Card.Suit.diamond,2));
		fullHouse.add(new Card(Card.Suit.diamond,3));
		fullHouse.add(new Card(Card.Suit.club,3));
		
		ArrayList<Card> twoPair = new ArrayList<Card>();
		twoPair.add(new Card(Card.Suit.heart,2));
		twoPair.add(new Card(Card.Suit.spade,2));
		twoPair.add(new Card(Card.Suit.diamond,7));
		twoPair.add(new Card(Card.Suit.diamond,3));
		twoPair.add(new Card(Card.Suit.club,3));
		
		ArrayList<Card> pair = new ArrayList<Card>();
		pair.add(new Card(Card.Suit.heart,2));
		pair.add(new Card(Card.Suit.spade,2));
		pair.add(new Card(Card.Suit.diamond,7));
		pair.add(new Card(Card.Suit.diamond,5));
		pair.add(new Card(Card.Suit.club,3));
		
		ArrayList<Card> threeOfAKind = new ArrayList<Card>();
		threeOfAKind.add(new Card(Card.Suit.heart,2));
		threeOfAKind.add(new Card(Card.Suit.spade,2));
		threeOfAKind.add(new Card(Card.Suit.diamond,2));
		threeOfAKind.add(new Card(Card.Suit.diamond,9));
		threeOfAKind.add(new Card(Card.Suit.club,3));
		
		ArrayList<Card> fourOfAKind = new ArrayList<Card>();
		fourOfAKind.add(new Card(Card.Suit.heart,2));
		fourOfAKind.add(new Card(Card.Suit.spade,2));
		fourOfAKind.add(new Card(Card.Suit.diamond,2));
		fourOfAKind.add(new Card(Card.Suit.diamond,3));
		fourOfAKind.add(new Card(Card.Suit.club,2));
		
		ArrayList<Card> highCard = new ArrayList<Card>();
		highCard.add(new Card(Card.Suit.heart,14));
		highCard.add(new Card(Card.Suit.spade,2));
		highCard.add(new Card(Card.Suit.diamond,10));
		highCard.add(new Card(Card.Suit.diamond,3));
		highCard.add(new Card(Card.Suit.club,5));
		
		
		Rank rank;
		
		Hand.printHand(royalFlushLow);
		rank = Hand.getRank(royalFlushLow);
		System.out.println("\tRank: "+rank.getRank().toString()+", High: "+rank.getHighestValue()+"\n");
		
		Hand.printHand(royalFlushHigh);
		rank = Hand.getRank(royalFlushHigh);
		System.out.println("\tRank: "+rank.getRank().toString()+", High: "+rank.getHighestValue()+"\n");
		
		Hand.printHand(flush);
		rank = Hand.getRank(flush);
		System.out.println("\tRank: "+rank.getRank().toString()+", High: "+rank.getHighestValue()+"\n");
		
		Hand.printHand(straight);
		rank = Hand.getRank(straight);
		System.out.println("\tRank: "+rank.getRank().toString()+", High: "+rank.getHighestValue()+"\n");
		
		Hand.printHand(fullHouse);
		rank = Hand.getRank(fullHouse);
		System.out.println("\tRank: "+rank.getRank().toString()+", High: "+rank.getHighestValue()+"\n");
		
		Hand.printHand(twoPair);
		rank = Hand.getRank(twoPair);
		System.out.println("\tRank: "+rank.getRank().toString()+", High: "+rank.getHighestValue()+"\n");
		
		Hand.printHand(pair);
		rank = Hand.getRank(pair);
		System.out.println("\tRank: "+rank.getRank().toString()+", High: "+rank.getHighestValue()+"\n");
		
		Hand.printHand(threeOfAKind);
		rank = Hand.getRank(threeOfAKind);
		System.out.println("\tRank: "+rank.getRank().toString()+", High: "+rank.getHighestValue()+"\n");
		
		Hand.printHand(fourOfAKind);
		rank = Hand.getRank(fourOfAKind);
		System.out.println("\tRank: "+rank.getRank().toString()+", High: "+rank.getHighestValue()+"\n");
		
		Hand.printHand(highCard);
		rank = Hand.getRank(highCard);
		System.out.println("\tRank: "+rank.getRank().toString()+", High: "+rank.getHighestValue()+"\n");
	}
	
}
