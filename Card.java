
public class Card implements Comparable<Card>  {
	private String suit;
	private String name;
	private int value;
	public Card(String name, String suit, int value) {
		this.suit = suit;
		this.name = name;
		this.value = value;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSuit() {
		return this.suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public int getValue() {
		return this.value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int compareTo(Card e) {
		return Integer.compare(this.value,e.value);
	}
	public String toString() {
		return this.getName() + " of " + this.getSuit();
	}
}
