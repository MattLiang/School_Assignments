package PokerGame;

public class Rank {
	
	public static enum Ranks {
		royalFlush,
		straightFlush,
		fourOfAKind,
		fullHouse,
		straight,
		flush,
		threeOfAKind,
		twoPair,
		pair,
		highCard
	};
	
	private int highestValue;
	private int secondaryValue; //in case of 2nd pair (full house, 2 pair)
	private Ranks rank;
	
	public Rank(int highestValue){
		this.highestValue = highestValue;
		rank = Ranks.highCard;
	}
	
	public int getHighestValue() {
		return highestValue;
	}
	
	public void setHighestValue(int highestValue) {
		this.highestValue = highestValue;
	}
	
	public Ranks getRank() {
		return rank;
	}
	
	
	//Rank is dependent on the detection of multiple
	public void setRank(int multiple, int value) {
		switch(multiple){
		case 2:
			//2nd pair detected, record that value
			if (rank == Ranks.pair){
				rank = Ranks.twoPair;
				secondaryValue = value;
			} 
			
			//Full House detected, highest value now is that triple
			else if (rank == Ranks.threeOfAKind) {
				rank = Ranks.fullHouse;
				secondaryValue = value;
				
			//Single pair detected, record that value
			} else if (rank == Ranks.highCard) {
				rank = Ranks.pair;
				highestValue = value;
			}
			break;
			
		case 3:
			//Full house detected, record that pair as secondary value
			if (rank == Ranks.pair){
				rank = Ranks.fullHouse;
				secondaryValue = highestValue;
				highestValue = value;
			} 
			
			//Triple detected, record that value
			else if(rank == Ranks.highCard) {
				rank = Ranks.threeOfAKind;
				highestValue = value;
			}
			break;
			
		case 4:
			rank = Ranks.fourOfAKind;
			highestValue = value;
			break;
			
		default:
		}
	}
	
	public void setStraight(){
		rank = Ranks.straight;
	}
	
	public void setFlush(){
		rank = Ranks.flush;
	}
	
	public void setStraightFlush(){
		rank = Ranks.straightFlush;
	}
	
	public int getSecondaryValue() {
		return secondaryValue;
	}

	public void setSecondaryValue(int secondaryValue) {
		this.secondaryValue = secondaryValue;
	}
}
