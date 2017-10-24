import java.util.*;
public class HandEvaluator {
	ArrayList<Card> fullHand;
	int numHearts = 0;
	int numDiamonds = 0;
	int numClubs = 0;
	int numSpades= 0;
	int numAces = 0;
	int numTwos = 0;
	int numThrees = 0;
	int numFours = 0;
	int numFives = 0;
	int numSixes = 0;
	int numSevens = 0;
	int numEights = 0;
	int numNines = 0;
	int numTens = 0;
	int numJacks = 0;
	int numQueens = 0;
	int numKings = 0;
	public HandEvaluator(ArrayList<Card> hand, ArrayList<Card> board) {
		this.fullHand = new ArrayList<Card>();
		this.fullHand.addAll(hand);
		this.fullHand.addAll(board);
		Collections.sort(this.fullHand);
	}
	//Will return a number that corresponds to the best hand.. etc High Card
	public int evaluateHand() {
		stats();
		if(royalFlush()) {
			return 1000;
		}
		if(straightFlush()) {
			return 900;
		}
		if(fourOfAKind()) {
			return 800;
		}
		if(fullHouse()) {
			return 700;
		}
		if(flush() != -1) {
			return 600;
		}
		if(straight() > 0) {
			return 500;
		}
		if(threeOfAKind()) {
			return 400;
		}
		if(twoPair()) {
			return 300;
		}
		if(onePair()) {
			return 200;
		}
		else
			return 100;
	}
	public void stats() {
		
		//Counts number of each suit in players hand
		for(int i = 0; i < 7; i++) {
			if(this.fullHand.get(i).getSuit() == "Hearts") {
				numHearts++;
			}
			else if(this.fullHand.get(i).getSuit() == "Diamonds") {
				numDiamonds++;
			}
			else if(this.fullHand.get(i).getSuit() == "Clubs") {
				numClubs++;
			}
			else {
				numSpades++;
			}
			if(this.fullHand.get(i).getValue() == 1) {
				numAces++;
			}
			else if(this.fullHand.get(i).getValue() == 2) {
				numTwos++;
			}
			else if(this.fullHand.get(i).getValue() == 3) {
				numThrees++;
			}
			else if(this.fullHand.get(i).getValue() == 4) {
				numFours++;
			}
			else if(this.fullHand.get(i).getValue() == 5) {
				numFives++;
			}
			else if(this.fullHand.get(i).getValue() == 6) {
				numSixes++;
			}
			else if(this.fullHand.get(i).getValue() == 7) {
				numSevens++;
			}
			else if(this.fullHand.get(i).getValue() == 8) {
				numEights++;
			}
			else if(this.fullHand.get(i).getValue() == 9) {
				numNines++;
			}
			else if(this.fullHand.get(i).getValue() == 10) {
				numTens++;
			}
			else if(this.fullHand.get(i).getValue() == 11) {
				numJacks++;
			}
			else if(this.fullHand.get(i).getValue() == 12) {
				numQueens++;
			}
			else {
				numKings++;
			}
		}
	}
	public boolean royalFlush() {
		if(flush() != -1 && straight() != -1) {
			ArrayList<Card> tempList = getFlushCards();
			//Only continue if ace
			if(tempList.get(0).getValue() == 1) {
				if(tempList.get(1).getValue() == 10) {
					return true;
				}
			}
			return false;
		}
		return false;
	}
	//Helper method for Royal Flush method
	public ArrayList<Card> getFlushCards() {
		ArrayList<Card> flushCards = new ArrayList<Card>();
		String suit = "";
		if(numHearts > 4) {
			suit = "Hearts";
		}
		else if(numDiamonds > 4) {
			suit = "Diamonds";
		}
		else if(numClubs > 4) {
			suit = "Clubs";
		}
		else if(numSpades > 4) {
			suit = "Spades";
		}
		else {
			return null;
		}
		for(int i = 0; i < this.fullHand.size(); i++) {
			if(this.fullHand.get(i).getSuit() == suit) {
				flushCards.add(this.fullHand.get(i));
			}
		}
		if(flushCards.size() > 6) {
			//Avoids removing Ace, which is highest card in flush
			if(flushCards.get(0).getValue() == 1) {
				flushCards.remove(1);
				flushCards.remove(1);
			}
			else {
				flushCards.remove(0);
				flushCards.remove(0);
			}
		}
		if(flushCards.size() > 5) {
			//Avoids removing Ace
			if(flushCards.get(0).getValue() == 1){
				flushCards.remove(1);
			}
			else {
				flushCards.remove(0);
			}
		}
		return flushCards;
	}
	public boolean straightFlush() {
		if(getAllFlushCards() != null) {
			ArrayList<Card> tempFlushCards = getAllFlushCards();
			int straightFlushCounter = 0;
			for(int i = 0; i < tempFlushCards.size() -1; i++) {
				if(tempFlushCards.get(i).getValue() + 1 == tempFlushCards.get(i + 1).getValue()) {
					straightFlushCounter++;
					if(tempFlushCards.get(i + 1).getValue() == 13) {
						if(tempFlushCards.get(0).getValue() == 1) {
							straightFlushCounter++;
						}
					}
				}	
				else {
					straightFlushCounter = 0;
				}
				if(straightFlushCounter > 3) {
					return true;
				}
		}
		return false;
		}
		else {
			return false;
		}
	}
	public ArrayList<Card> getAllFlushCards() {
		ArrayList<Card> tempList = new ArrayList<Card>();
		String suitOfFlush = "";
		if(numHearts >= 5){
			suitOfFlush = "Hearts"; 
		}
		else if(numDiamonds >= 5) {
			suitOfFlush = "Diamonds";
		}
		else if(numClubs >= 5) {
			suitOfFlush = "Clubs";
		}
		else if(numSpades >= 5) {
			suitOfFlush = "Spades";
		}	
		else {
			return null;
		}
		for(int i = 0; i < this.fullHand.size(); i++) {
			if(this.fullHand.get(i).getSuit() == suitOfFlush) {
				tempList.add(this.fullHand.get(i));
			}
		}
		return tempList;
	}
	public boolean fourOfAKind() {
		if(numAces == 4|| numTwos == 4|| numThrees == 4|| numFours == 4 ||numFives == 4||numSixes == 4||numSevens == 4||numEights == 4 || numNines == 4||
				numTens == 4|| numJacks == 4 || numQueens == 4||numKings == 4) {
				return true;
			}
			return false;
	}
	public boolean fullHouse() {
		if(twoPair() == true && threeOfAKind() == true) {
			return true;
		}
		return false;
	}
	public int flush() {
		boolean aceHighFlush = false;
		//If player has five or more of any one suit, flush is true, else false
		String suitOfFlush = "";
		if(numHearts >= 5){
			suitOfFlush = "Hearts"; 
		}
		else if(numDiamonds >= 5) {
			suitOfFlush = "Diamonds";
		}
		else if(numClubs >= 5) {
			suitOfFlush = "Clubs";
		}
		else if(numSpades >= 5) {
			suitOfFlush = "Spades";
		}	
		else {
			return -1;
		}
		int tempValue = 0;
		for(int i = 0; i < this.fullHand.size(); i++) {
			if(this.fullHand.get(i).getSuit() == suitOfFlush) {
				tempValue = this.fullHand.get(i).getValue();
				if(tempValue == 1) {
					aceHighFlush = true;
				}
			}
			if(aceHighFlush == true) {
				tempValue = 1;
			}
		}
		return tempValue;
	}
	public int straight() {
		int topOfStraight = 0;
		int straightCounter = 0;
		boolean aceHigh = false;
		for(int i = 0; i < fullHand.size() - 1; i++) {
			//BUG FOUND NEVER ACTUALLY WORKS
			if((this.fullHand.get(i).getValue() + 1) == this.fullHand.get(i + 1).getValue()) {
				straightCounter++;
				//Covers special boundary case where its an ace high straight
				if(this.fullHand.get(i + 1).getValue() == 13 && straightCounter >= 3) {
					if(this.fullHand.get(0).getValue() == 1) {
						straightCounter++;
						topOfStraight = 1;
						aceHigh = true;
					}
				}
				if(straightCounter >= 4 && (aceHigh == false)) {
					topOfStraight = this.fullHand.get(i + 1).getValue();
				}
			}
			else if(this.fullHand.get(i).getValue() == this.fullHand.get(i+1).getValue()) {
				//Do Nothing for duplicate cards of differing suits
			}
			else {
				straightCounter = 0;
			}
		}
		if(topOfStraight != 0) {
			return topOfStraight;
		}
		return -1;
	}
	public boolean threeOfAKind() {
		if(numAces == 3| numTwos == 3|| numThrees == 3|| numFours == 3||numFives == 3||numSixes == 3||numSevens == 3||numEights == 3 || numNines == 3||
			numTens == 3|| numJacks == 3|| numQueens == 3||numKings == 3) {
			return true;
		}
		return false;
	}
	public boolean twoPair() {
		int pairCounter = 0;
		if(numAces >= 2) {
			pairCounter++;
		}
		if(numTwos >= 2) {
			pairCounter++;
		}
		if(numThrees >= 2) {
			pairCounter++;
		}
		if(numFours >= 2) {
			pairCounter++;
		}
		if(numFives >= 2) {
			pairCounter++;
		}
		if(numSixes >= 2) {
			pairCounter++;
		}
		if(numSevens >= 2) {
			pairCounter++;
		}
		if(numEights >= 2) {
			pairCounter++;
		}
		if(numNines >= 2) {
			pairCounter++;
		}
		if(numTens >= 2) {
			pairCounter++;
		}
		if(numJacks >= 2) {
			pairCounter++;
		}
		if(numQueens >= 2) {
			pairCounter++;
		}
		if(numKings >= 2) {
			pairCounter++;
		}
		if(pairCounter > 1) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean onePair() {
		if(numAces == 2) {
			return true;
		}
		else if(numTwos == 2) {
			return true;
		}
		else if(numThrees == 2) {
			return true;
		}
		else if(numFours == 2) {
			return true;
		}
		else if(numFives == 2) {
			return true;
		}
		else if(numSixes == 2) {
			return true;
		}
		else if(numSevens == 2) {
			return true;
		}
		else if(numEights == 2) {
			return true;
		}
		else if(numNines == 2) {
			return true;
		}
		else if(numTens == 2) {
			return true;
		}
		else if(numJacks == 2) {
			return true;
		}
		else if(numQueens == 2) {
			return true;
		}
		else if(numKings == 2) {
			return true;
		}
		return false;
	}
}
