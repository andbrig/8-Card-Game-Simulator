import java.util.ArrayList;
public class Player {
	private ArrayList<Card> hand;
	private String name;
	public Player(String name) {
		this.name = name;
		this.hand = new ArrayList<Card>();
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void addCardToHand(Card cardToAdd) {
		this.hand.add(cardToAdd);
	}
	public ArrayList<Card> getHand() {
		return this.hand;
	}
	public void revealHand() {
		System.out.println("PLAYERS HAND: ");
		for(int i = 0; i < this.hand.size(); i++) {
			System.out.println(this.hand.get(i).getName() + " of " + this.getHand().get(i).getSuit());
		}
	}
}
