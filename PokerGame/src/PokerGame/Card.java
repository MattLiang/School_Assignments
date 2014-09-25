package PokerGame;

public class Card {
	public static enum Suit {heart,diamond,club,spade};
	public static final int MAX_VALUE = 14; //14 is ace high
	public static final int MIN_VALUE = 2;

	private Suit suit;
	private int value;
	
	public Card(Suit suit, int value){
		this.suit = suit;
		this.value = value;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public String print(){
		return value+suit.toString().substring(0, 1).toUpperCase();
	}
}
