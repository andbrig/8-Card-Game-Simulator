import java.util.ArrayList;

public class SampleGame {

	public static void main(String[] args) {
		double numTrials = 0;
		int numRoyalFlushes = 0;
		int numStraightFlushes = 0;
		int fourOfAKind = 0;
		int fullHouse = 0;
		int flush = 0;
		int straight = 0;
		int threeOfAKind = 0;
		int twoPair = 0;
		int onePair = 0;
		int highCard = 0;
		int handStrength = 0;
		// TODO Auto-generated method stub
		for(int i = 0; i < 10000000; i++) {
			numTrials++;
			Deck newDeck = new Deck();
			Player p = new Player("John");
			ArrayList<Card> board = new ArrayList<Card>();
			newDeck.shuffleDeck();
			newDeck.deal(p);
			newDeck.dealBoard(board);
			HandEvaluator evaluator = new HandEvaluator(p.getHand(), board);
			handStrength = evaluator.evaluateHand();
			if(handStrength == 1000) {
				numRoyalFlushes++;
			}
			else if(handStrength == 900) {
				numStraightFlushes++;
			}
			else if(handStrength == 800) {
				fourOfAKind++;
			}
			else if(handStrength == 700) {
				fullHouse++;
			}
			else if(handStrength == 600) {
				flush++;
			}
			else if(handStrength == 500) {
				straight++;
			}
			else if(handStrength == 400) {
				threeOfAKind++;
			}
			else if(handStrength == 300) {
				twoPair++;
			}
			else if(handStrength == 200) {
				onePair++;
			}
			else if(handStrength == 100) {
				highCard++;
			}
		}
		float royal = (float) (numRoyalFlushes/numTrials)*100;
		float straightFlush = (float) (numStraightFlushes/numTrials)*100;
		float fourOfAKindCount = (float) (fourOfAKind/numTrials)*100;
		float fullHouseCount = (float) (fullHouse/numTrials)*100;
		float flushCount = (float) (flush/numTrials)*100;
		float straightCount = (float) (straight/numTrials)*100;
		float threeOfAKindCount = (float) (threeOfAKind/numTrials)*100;
		float twoPairCount = (float) (twoPair/numTrials*1.0f)*100;
		float onePairCount = (float) (onePair/numTrials)*100;
		float highCardCount = (float) (highCard/numTrials)*100;
		System.out.println("Royal Flush % = " + royal);
		System.out.println("Straight Flush % = " + straightFlush);
		System.out.println("Four of A Kind % = " + fourOfAKindCount);
		System.out.println("Full House % = " + fullHouseCount);
		System.out.println("Flush % = " + flushCount);
		System.out.println("Straight % = " + straightCount);
		System.out.println("Three Of A Kind % = " + threeOfAKindCount);
		System.out.println("Two Pair % = " + twoPairCount);
		System.out.println("One Pair % = " + onePairCount);
		System.out.println("High Card Count % " + highCardCount);
	}

}
