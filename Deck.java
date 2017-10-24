import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class Deck {
	private ArrayList<Card> deck;
	public Deck() {
		deck = new ArrayList<Card>();
		Card card1 = new Card("Ace", "Hearts", 1);
		this.deck.add(card1);
		Card card2 = new Card("Ace", "Diamonds", 1);
		this.deck.add(card2);
		Card card3 = new Card("Ace", "Clubs", 1);
		this.deck.add(card3);
		Card card4 = new Card("Ace", "Spades", 1);
		this.deck.add(card4);
		Card card5 = new Card("Two", "Hearts", 2);
		this.deck.add(card5);
		Card card6 = new Card("Two", "Diamonds", 2);
		this.deck.add(card6);
		Card card7 = new Card("Two", "Clubs", 2);
		this.deck.add(card7);
		Card card8 = new Card("Two", "Spades", 2);
		this.deck.add(card8);
		Card card9 = new Card("Three", "Hearts", 3);
		this.deck.add(card9);
		Card card10 = new Card("Three", "Diamonds", 3);
		this.deck.add(card10);
		Card card11 = new Card("Three", "Clubs", 3);
		this.deck.add(card11);
		Card card12 = new Card("Three", "Spades", 3);
		this.deck.add(card12);
		Card card13 = new Card("Four", "Hearts", 4);
		this.deck.add(card13);
		Card card14 = new Card("Four", "Diamonds", 4);
		this.deck.add(card14);
		Card card15 = new Card("Four", "Clubs", 4);
		this.deck.add(card15);
		Card card16 = new Card("Four", "Spades", 4);
		this.deck.add(card16);
		Card card17 = new Card("Five", "Hearts", 5);
		this.deck.add(card17);
		Card card18 = new Card("Five", "Diamonds", 5);
		this.deck.add(card18);
		Card card19= new Card("Five", "Clubs", 5);
		this.deck.add(card19);
		Card card20= new Card("Five", "Spades", 5);
		this.deck.add(card20);
		Card card21 = new Card("Six", "Hearts", 6);
		this.deck.add(card21);
		Card card22 = new Card("Six", "Diamonds", 6);
		this.deck.add(card22);
		Card card23 = new Card("Six", "Clubs", 6);
		this.deck.add(card23);
		Card card24 = new Card("Six", "Spades", 6);
		this.deck.add(card24);
		Card card25 = new Card("Seven", "Hearts", 7);
		this.deck.add(card25);
		Card card26 = new Card("Seven", "Diamonds", 7);
		this.deck.add(card26);
		Card card27 = new Card("Seven", "Clubs", 7);
		this.deck.add(card27);
		Card card28 = new Card("Seven", "Spades", 7);
		this.deck.add(card28);
		Card card29 = new Card("Eight", "Hearts", 8);
		this.deck.add(card29);
		Card card30 = new Card("Eight", "Diamonds", 8);
		this.deck.add(card30);
		Card card31 = new Card("Eight", "Clubs", 8);
		this.deck.add(card31);
		Card card32 = new Card("Eight", "Spades", 8);
		this.deck.add(card32);
		Card card34 = new Card("Nine", "Hearts", 9);
		this.deck.add(card34);
		Card card35 = new Card("Nine", "Diamonds", 9);
		this.deck.add(card35);
		Card card36 = new Card("Nine", "Clubs", 9);
		this.deck.add(card36);
		Card card37 = new Card("Nine", "Spades", 9);
		this.deck.add(card37);
		Card card38 = new Card("Ten", "Hearts", 10);
		this.deck.add(card38);
		Card card39 = new Card("Ten", "Diamonds", 10);
		this.deck.add(card39);
		Card card40 = new Card("Ten", "Clubs", 10);
		this.deck.add(card40);
		Card card41 = new Card("Ten", "Spades", 10);
		this.deck.add(card41);
		Card card42 = new Card("Jack", "Hearts", 11);
		this.deck.add(card42);
		Card card43 = new Card("Jack", "Diamonds", 11);
		this.deck.add(card43);
		Card card44 = new Card("Jack", "Clubs", 11);
		this.deck.add(card44);
		Card card45 = new Card("Jack", "Spades", 11);
		this.deck.add(card45);
		Card card46 = new Card("Queen", "Hearts", 12);
		this.deck.add(card46);
		Card card47 = new Card("Queen", "Diamonds", 12);
		this.deck.add(card47);
		Card card48 = new Card("Queen", "Clubs", 12);
		this.deck.add(card48);
		Card card49 = new Card("Queen", "Spades", 12);
		this.deck.add(card49);
		Card card50 = new Card("King", "Hearts", 13);
		this.deck.add(card50);
		Card card51 = new Card("King", "Diamonds", 13);
		this.deck.add(card51);
		Card card52 = new Card("King", "Clubs", 13);
		this.deck.add(card52);
		Card card33 = new Card("King", "Spades", 13);
		this.deck.add(card33);	
	}
	public void shuffleDeck() {
		Collections.shuffle(this.deck);
	}
	public ArrayList<Card> getDeck() {
		return this.deck;
	}
	public Card getCard(String name, String suit) {
		for(int i = 0; i < this.deck.size(); i++) {
			if((this.deck.get(i).getName() == name) && (this.deck.get(i).getSuit() == suit)) {
				return this.deck.get(i);
			}
		}
		return null;
	}
	public void deal(Player p) {
		p.addCardToHand(this.getDeck().get(0));
		p.addCardToHand(this.getDeck().get(1));
		this.getDeck().remove(0);
		this.getDeck().remove(0);
	}
	public void dealBoard(ArrayList<Card> board) {
		for(int i = 0; i < 5; i++) {
			board.add(this.deck.get(0));
			this.getDeck().remove(0);
		}	
	}
	public void printDeck() {
		for(int i = 0; i < this.deck.size(); i++) {
			System.out.println(this.deck.get(i).getName() + " of " + this.deck.get(i).getSuit());
		}
	}
}
