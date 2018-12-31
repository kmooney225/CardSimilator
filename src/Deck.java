import java.util.Collections;
import java.util.Optional;
import java.util.Stack;

public class Deck {
	
	private final Stack<Card> deckCards;
	
	private Deck(final boolean needShuffle) {
		this.deckCards = initDeck(needShuffle);
	}
	
	private Stack<Card> initDeck(boolean needShuffle) {
		
		final Stack<Card> deckCards = new Stack<>();
		for(final Card.Suit suit : Card.Suit.values()) {
			for(final Card.Rank rank : Card.Rank.values()) {
				deckCards.push(Card.getCard(rank, suit));
			}
		}
		
		if(needShuffle) {
			Collections.shuffle(deckCards);
		} else {
			Collections.sort(deckCards);
		}
		return deckCards;
	}
	
	public static Deck newShuffleSingleDeck() {
		return new Deck(true);
	}
	
	public static Deck newUnshuffleSingleDeck() {
		return new Deck(false);
	}
	
	public int size() {
		return this.deckCards.size();
	}
	
	public Optional<Card> deal() {
		return this.deckCards.empty() ? Optional.empty() :
			Optional.of(this.deckCards.pop());
	}
}
