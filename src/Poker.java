import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;

public class Poker implements Comparable<Poker>{

	private final Classification handClassication;
	private final HandAnalyzer handAnalyzer;
	
	private static final int POKER_HAND_SIZE = 5;
	
	enum Classification {
		HIGH_CARD(1) {
			@Override
			int tieBreaker(final Poker hand, final Poker otherHand) {
				return HandUtils.compareHighCardHands(hand, otherHand);
			}
		}
	}

	static class HandAnalyzer {
		final SortedSet<Card> cards;
		final Map<Card.Rank, List<Card>> rankGroup;
		final Map<Card.Suit, List<Card>> suitGroup;
		final int quadCount;
		final int setCount;
		final int pairCount;
	}
	
	PokerHand(final Builder builder) {
		this.handAnalyzer = new HandAnalyzer(builder.cards);
		this.handClassication = classifyHand();
	}
	
	@Override
	public int compareTo(Poker o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	static class Builder {
		
		private SortedSet<Card> cards;
		
		public Builder() {
			this.cards = new TreeSet<>();
		}
		
		
		
		public Builder addCard(final Optional<Card> card) {
			this.cards.add(card.orElseThrow(IllegalStateException::new));
			return this;
		}
		
		public Poker build() {
			if (this.cards.size() != POKER_HAND_SIZE) {
				throw new RuntimeException("invalid hand size" + this.cards.toString());
			}
			return new PokerHand(this);
		}
	}
}
