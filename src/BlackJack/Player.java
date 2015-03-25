/**
 * Names: Tyler Treat and Jacob Nelson
 * AP Computer Science
 * BlackJack
 * May 12, 2009
 * Player.java
 * Class for Player object.
 */
package BlackJack;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private double bankroll;
	private double wager;
	public static List<Card> playerHand = new ArrayList<Card>();

	public Player() {
	}

	public Player(double bkroll, List<Card> hand) {
		bankroll = bkroll;
		playerHand = hand;
	}

	public double getBankroll() {
		return bankroll;
	}

	public List<Card> getHand() {
		return playerHand;
	}

	public void hit(Card card) {
		playerHand.add(card);
	}

	public void setWager(double bet) {
		wager = bet;
	}

	public void doubleDown(Card card) {
		wager = wager * 2;
		hit(card);
	}

	public double blackjackPayout() {
		double payout = 1.5 * wager; // 3:2 payout for natural BlackJack
		return payout;
	}

	public double payout() {
		double payout = 1.2 * wager; // 6:5 payout for everything else
		return payout;
	}

	public static void stopTime(int time) {
		try {
			Thread.sleep(time);
		} catch (Throwable t) {
			throw new OutOfMemoryError("An Error has occured");
		}
	}
}
