/**
 * Names: Tyler Treat and Jacob Nelson
 * AP Computer Science
 * BlackJack
 * May 11, 2009
 * Card.java
 * Class for Card object.
 */
package BlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card {
	public enum Rank {
		TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
	}

	public enum Suit {
		CLUBS, DIAMONDS, HEARTS, SPADES
	}

	private final Rank rank;
	private final Suit suit;
	private static final List<Card> deck = new ArrayList<Card>();
	public static List<Card> hand = new ArrayList<Card>();

	Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public Card() {
		this.rank = null;
		this.suit = null;
	}

	static {
		for (Suit suit : Suit.values())
			for (Rank rank : Rank.values())
				deck.add(new Card(rank, suit));
		Collections.shuffle(deck);
	}

	public static List<Card> newDeck() {
		return new ArrayList<Card>(deck);
	}

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public String toString() {
		if (rank != null && suit != null)
			return rank + " of " + suit;
		else
			return "HIDDEN";
	}

	public static List<Card> deal(List<Card> deck, int n) {
		int deckSize = deck.size();
		List<Card> handView = deck.subList(deckSize - n, deckSize);
		hand = new ArrayList<Card>(handView);
		handView.clear();
		return hand;
	}

	public static Card getCard(List<Card> dk) {
		Card card = dk.get(dk.size() - 1);
		dk.remove(dk.size() - 1);
		return card;
	}

	public static int getValue(Card card, List<Card> hand) {
		if (card.getRank().equals(Rank.TWO))
			return 2;
		else if (card.getRank().equals(Rank.THREE))
			return 3;
		else if (card.getRank().equals(Rank.FOUR))
			return 4;
		else if (card.getRank().equals(Rank.FIVE))
			return 5;
		else if (card.getRank().equals(Rank.SIX))
			return 6;
		else if (card.getRank().equals(Rank.SEVEN))
			return 7;
		else if (card.getRank().equals(Rank.EIGHT))
			return 8;
		else if (card.getRank().equals(Rank.NINE))
			return 9;
		else if (card.getRank().equals(Rank.TEN))
			return 10;
		else if (card.getRank().equals(Rank.JACK))
			return 10;
		else if (card.getRank().equals(Rank.QUEEN))
			return 10;
		else if (card.getRank().equals(Rank.KING))
			return 10;
		else if (card.getRank().equals(Rank.ACE))
			return ace(card, hand);
		else
			return -1;
	}

	private static int ace(Card card, List<Card> hand) {
		int sum = 0;
		ArrayList<Card> tempHand = new ArrayList<Card>();
		for (int i = 0; i < hand.size(); i++)
			tempHand.add(hand.get(i));
		for (int i = 0; i < tempHand.size(); i++) {
			if (tempHand.get(i).getRank().equals(Rank.ACE))
				tempHand.remove(i);
		}
		for (int i = 0; i < tempHand.size(); i++)
			sum += getValue(tempHand.get(i), hand);

		if (sum + 11 <= 21)
			return 11;
		else if (sum + 11 > 21)
			return 1;
		else
			return 1;
	}

	public static int getSum(List<Card> hand) {
		int total = 0;
		for (int i = 0; i < hand.size(); i++) {
			total += getValue(hand.get(i), hand);
		}
		return total;
	}

	public static String getCardFile(Card card) {

		Suit suit = card.getSuit();
		Rank rank = card.getRank();
		String cardFile = rank + "of" + suit + ".gif";

		if (rank != null && suit != null)
			return cardFile.toLowerCase();
		else
			return "cardback.gif";

	}

}