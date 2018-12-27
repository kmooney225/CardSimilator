import Card.CardValue;
import Card.Suit;

public class Deck {
	
	private int deckSize;
	private String deckType;

	public Deck (int deckSize, String deckType) {
		this.deckSize = deckSize;
		this.deckType = deckType;
		
	}
	
	public int getDeckSize() {
		return deckSize;
	}
	
	public String getDeckType() {
		return deckType;
	}
	
	public void setDeckSize() {
		if (deckType == "Normal")
		{
			deckSize = 52;
		}
		else if (deckType == "Jokers")
		{
			deckSize = 54;
		}
		
		else 
		{ 
			deckSize = 0;
		}
	}
}
