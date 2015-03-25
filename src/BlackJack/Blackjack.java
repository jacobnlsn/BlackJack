package BlackJack;

import java.util.*;

import javax.swing.ImageIcon;

public class Blackjack {
	public static void main(String args[]) {

		Table blackJackTable = new Table();
		blackJackTable.setVisible(true);
		blackJackTable.setTitle("Black Jack");

		int cardsPerHand = 2;
		int playerTotal;
		int dealerTotal;
		int endGame = -1;
		double wager = 2;
		double bankroll = 150;
		boolean gameLoop = false;
		boolean gameLoopReal = false;
		boolean playHand = false;
		boolean playDealer = false;
		List<Card> dealerHand = new ArrayList<Card>();
		List<Card> dealerFake = new ArrayList<Card>();
		List<Card> deck = Card.newDeck();
		Collections.shuffle(deck);
		Player p1 = new Player();
		String bankrollString;
		char moveChar;

		while (!gameLoop) {

			bankrollString = (Double.toString(bankroll) + "0");
			blackJackTable.bankRollAmount.setText(bankrollString);

			while (!gameLoopReal) {

				blackJackTable.playerCardOne.setIcon(null);
				blackJackTable.playerCardTwo.setIcon(null);
				blackJackTable.playerCardThree.setIcon(null);
				blackJackTable.palyerCardFour.setIcon(null);
				blackJackTable.playerCardFive.setIcon(null);
				blackJackTable.dealerCardOne.setIcon(null);
				blackJackTable.dealerCardTwo.setIcon(null);
				blackJackTable.dealerCardThree.setIcon(null);
				blackJackTable.dealerCardFour.setIcon(null);
				blackJackTable.dealerCardFive.setIcon(null);
				blackJackTable.confirm.setEnabled(true);
				blackJackTable.betBox.setEnabled(true);
				blackJackTable.hit.setEnabled(false);
				blackJackTable.stay.setEnabled(false);
				blackJackTable.doubleDown.setEnabled(false);

				boolean canWeGo = Table.getIfBet();

				while (bankroll >= 2 && playHand == false && canWeGo) {

					blackJackTable.confirm.setEnabled(false);
					blackJackTable.betBox.setEnabled(false);
					blackJackTable.hit.setEnabled(true);
					blackJackTable.stay.setEnabled(true);
					blackJackTable.doubleDown.setEnabled(true);

					dealerFake.clear();
					playDealer = false;
					p1 = new Player(bankroll, Card.deal(deck, cardsPerHand));
					wager = blackJackTable.getBet();
					p1.setWager(wager);

					dealerHand = Card.deal(deck, cardsPerHand);
					Card hiddenCard = new Card();
					for (int i = 0; i < dealerHand.size(); i++)
						dealerFake.add(dealerHand.get(i));
					dealerFake.remove(0);
					dealerFake.add(0, hiddenCard);

					blackJackTable.betLabel.setText("Your bet: " + wager + "0");

					blackJackTable.statusWindow.setText("Dealing..");

					java.net.URL pCard1URL = Blackjack.class.getResource(Card.getCardFile(p1.getHand().get(0)));
					ImageIcon pCard1 = new ImageIcon(pCard1URL);
					blackJackTable.playerCardOne.setIcon(pCard1);

					Player.stopTime(500);

					java.net.URL dCard1URL = Blackjack.class.getResource(Card.getCardFile(dealerFake.get(0)));
					ImageIcon dCard1 = new ImageIcon(dCard1URL);
					blackJackTable.dealerCardOne.setIcon(dCard1);

					Player.stopTime(500);

					java.net.URL pCard2URL = Blackjack.class.getResource(Card.getCardFile(p1.getHand().get(1)));
					ImageIcon pCard2 = new ImageIcon(pCard2URL);
					blackJackTable.playerCardTwo.setIcon(pCard2);

					Player.stopTime(500);

					java.net.URL dCard2URL = Blackjack.class.getResource(Card.getCardFile(dealerFake.get(1)));
					ImageIcon dCard2 = new ImageIcon(dCard2URL);
					blackJackTable.dealerCardTwo.setIcon(dCard2);

					blackJackTable.statusWindow.setText("*Stay, hit, or double down?");

					playerTotal = Card.getSum(p1.getHand());
					dealerTotal = Card.getSum(dealerHand);

					int skipMove = -1;
					if (playerTotal == 21) {
						if (dealerTotal != 21) {
							java.net.URL dCardRURL = Blackjack.class.getResource(Card.getCardFile(dealerHand.get(0)));
							ImageIcon dCardR = new ImageIcon(dCardRURL);
							blackJackTable.dealerCardOne.setIcon(dCardR);
							blackJackTable.statusWindow.setText("*Black Jack! You win the hand!");
							Player.stopTime(2000);
							bankroll += p1.blackjackPayout();
							bankrollString = (Double.toString(bankroll) + "0");
							blackJackTable.bankRollAmount.setText(bankrollString);
							skipMove = 1;
						} else {
							java.net.URL dCardRURL = Blackjack.class.getResource(Card.getCardFile(dealerHand.get(0)));
							ImageIcon dCardR = new ImageIcon(dCardRURL);
							blackJackTable.dealerCardOne.setIcon(dCardR);
							blackJackTable.statusWindow.setText("*Push!");
							Player.stopTime(2000);
							skipMove = 1;
						}
					}
					boolean canWeGo2;
					do {
						canWeGo2 = Table.getPlayerChoose();
						Player.stopTime(500);
					} while (!canWeGo2);

					if (skipMove == -1) {
						blackJackTable.statusWindow.setText("**Stay, hit, or double down?");
						int moveLoop = 1;
						int playerMove = -1;

						while (moveLoop == 1 && canWeGo) {
							blackJackTable.statusWindow.setText("***Stay, hit, or double down?");

							do {
								Player.stopTime(500);
								moveChar = Table.getMove();
							} while (moveChar == 'x');

							switch (moveChar) {
							case 's':
								blackJackTable.statusWindow.setText("*The player stays.");
								Player.stopTime(2000);
								playerMove = 0;
								moveLoop = -1;
								moveChar = 'x';
								Table.setMoveX();
								break;
							case 'h':
								p1.hit(Card.getCard(deck));

								List<Card> playersHand = p1.getHand();
								if (playersHand.size() == 3) {
									java.net.URL pCard3URL = Blackjack.class.getResource(Card.getCardFile(p1.getHand().get(2)));
									ImageIcon pCard3 = new ImageIcon(pCard3URL);
									blackJackTable.playerCardThree.setIcon(pCard3);
								}
								if (playersHand.size() == 4) {
									java.net.URL pCard4URL = Blackjack.class.getResource(Card.getCardFile(p1.getHand().get(3)));
									ImageIcon pCard4 = new ImageIcon(pCard4URL);
									blackJackTable.palyerCardFour.setIcon(pCard4);
								}
								if (playersHand.size() == 5) {
									java.net.URL pCard5URL = Blackjack.class.getResource(Card.getCardFile(p1.getHand().get(4)));
									ImageIcon pCard5 = new ImageIcon(pCard5URL);
									blackJackTable.playerCardFive.setIcon(pCard5);
								}

								Player.stopTime(2000);
								playerMove = 1;
								moveLoop = -1;
								moveChar = 'x';
								Table.setMoveX();
								break;
							case 'd':
								p1.doubleDown(Card.getCard(deck));
								java.net.URL pCard3URL = Blackjack.class.getResource(Card.getCardFile(p1.getHand().get(2)));
								ImageIcon pCard3 = new ImageIcon(pCard3URL);
								blackJackTable.playerCardThree.setIcon(pCard3);
								Player.stopTime(2000);
								playerMove = 2;
								moveLoop = -1;
								moveChar = 'x';
								Table.setMoveX();
								break;
							}
							if (playerMove == 1) {
								playerTotal = Card.getSum(p1.getHand());
								if (playerTotal > 21) {
									System.out.println("\nYour hand " + p1.getHand());
									System.out.println("Dealer's hand " + dealerHand);
								} else {
									System.out.println("\nYour hand " + p1.getHand());
									System.out.println("Dealer's hand " + dealerFake);
								}
								if (playerTotal > 21) {
									blackJackTable.statusWindow.setText("*Bust!");
									java.net.URL dCardRURL = Blackjack.class.getResource(Card.getCardFile(dealerHand.get(0)));
									ImageIcon dCardR = new ImageIcon(dCardRURL);
									blackJackTable.dealerCardOne.setIcon(dCardR);
									bankroll -= wager;
									bankrollString = (Double.toString(bankroll) + "0");
									blackJackTable.bankRollAmount.setText(bankrollString);
									playDealer = true;
									playerMove = -1;
									Player.stopTime(2000);
									break;
								} else if (playerTotal == 21) {
									java.net.URL dCardRURL = Blackjack.class.getResource(Card.getCardFile(dealerHand.get(0)));
									ImageIcon dCardR = new ImageIcon(dCardRURL);
									blackJackTable.dealerCardOne.setIcon(dCardR);
									blackJackTable.statusWindow.setText("*You win the hand!");
									bankroll += p1.payout();
									bankrollString = (Double.toString(bankroll) + "0");
									blackJackTable.bankRollAmount.setText(bankrollString);
									playDealer = true;
									playerMove = -1;
									Player.stopTime(2000);
								} else
									moveLoop = 1;
							}
						}// end of moveLoop
						while (!playDealer || playerMove != -1 && canWeGo) {
							if (playerMove == 2) {
								System.out.println("\nYour hand " + p1.getHand());
								System.out.println("Dealer's hand " + dealerHand);
								playerTotal = Card.getSum(p1.getHand());
								dealerTotal = Card.getSum(dealerHand);
								if (playerTotal > 21) {
									java.net.URL dCardRURL = Blackjack.class.getResource(Card.getCardFile(dealerHand.get(0)));
									ImageIcon dCardR = new ImageIcon(dCardRURL);
									blackJackTable.dealerCardOne.setIcon(dCardR);
									blackJackTable.statusWindow.setText("**Bust!");
									bankroll -= wager * 2;
									bankrollString = (Double.toString(bankroll) + "0");
									blackJackTable.bankRollAmount.setText(bankrollString);
									Player.stopTime(2000);
									break;
								} else if (playerTotal == 21) {
									java.net.URL dCardRURL = Blackjack.class.getResource(Card.getCardFile(dealerHand.get(0)));
									ImageIcon dCardR = new ImageIcon(dCardRURL);
									blackJackTable.dealerCardOne.setIcon(dCardR);
									blackJackTable.statusWindow.setText("**You win the hand!");
									bankroll += p1.payout();
									bankrollString = (Double.toString(bankroll) + "0");
									blackJackTable.bankRollAmount.setText(bankrollString);
									Player.stopTime(2000);
									break;
								} else {
									while (Card.getSum(dealerHand) < 17 && canWeGo) {
										java.net.URL dCardRURL = Blackjack.class.getResource(Card.getCardFile(dealerHand.get(0)));
										ImageIcon dCardR = new ImageIcon(dCardRURL);
										blackJackTable.dealerCardOne.setIcon(dCardR);
										Player.stopTime(2000);
										dealerHand.add(Card.getCard(deck));
										if (dealerHand.size() == 3) {

											java.net.URL dCard3URL = Blackjack.class.getResource(Card.getCardFile(dealerHand.get(2)));
											ImageIcon dCard3 = new ImageIcon(dCard3URL);
											blackJackTable.dealerCardThree.setIcon(dCard3);
											Player.stopTime(2000);
										}
										if (dealerHand.size() == 4) {

											java.net.URL dCard4URL = Blackjack.class.getResource(Card.getCardFile(dealerHand.get(3)));
											ImageIcon dCard4 = new ImageIcon(dCard4URL);
											blackJackTable.dealerCardFour.setIcon(dCard4);
											Player.stopTime(2000);
										}
										if (dealerHand.size() == 5) {

											java.net.URL dCard5URL = Blackjack.class.getResource(Card.getCardFile(dealerHand.get(4)));
											ImageIcon dCard5 = new ImageIcon(dCard5URL);
											blackJackTable.dealerCardFive.setIcon(dCard5);
											Player.stopTime(2000);
										}
									}
									System.out.println("\nDealer's hand " + dealerHand);
									playerTotal = Card.getSum(p1.getHand());
									dealerTotal = Card.getSum(dealerHand);
									if (dealerTotal > 21) {
										java.net.URL dCardRURL = Blackjack.class.getResource(Card.getCardFile(dealerHand.get(0)));
										ImageIcon dCardR = new ImageIcon(dCardRURL);
										blackJackTable.dealerCardOne.setIcon(dCardR);
										blackJackTable.statusWindow.setText("***The dealer busts.  You win the hand!");
										bankroll += p1.payout();
										bankrollString = (Double.toString(bankroll) + "0");
										blackJackTable.bankRollAmount.setText(bankrollString);
										playerMove = -1;
										playDealer = true;
										Player.stopTime(2000);
										break;
									} else if (playerTotal == dealerTotal) {
										java.net.URL dCardRURL = Blackjack.class.getResource(Card.getCardFile(dealerHand.get(0)));
										ImageIcon dCardR = new ImageIcon(dCardRURL);
										blackJackTable.dealerCardOne.setIcon(dCardR);
										blackJackTable.statusWindow.setText("***Push!");
										playerMove = -1;
										playDealer = true;
										Player.stopTime(2000);
										break;
									} else if (playerTotal > dealerTotal && playerTotal <= 21) {
										java.net.URL dCardRURL = Blackjack.class.getResource(Card.getCardFile(dealerHand.get(0)));
										ImageIcon dCardR = new ImageIcon(dCardRURL);
										blackJackTable.dealerCardOne.setIcon(dCardR);
										blackJackTable.statusWindow.setText("****You win the hand!");
										bankroll += p1.payout();
										bankrollString = (Double.toString(bankroll) + "0");
										blackJackTable.bankRollAmount.setText(bankrollString);
										playerMove = -1;
										playDealer = true;
										Player.stopTime(2000);
										break;
									} else {
										java.net.URL dCardRURL = Blackjack.class.getResource(Card.getCardFile(dealerHand.get(0)));
										ImageIcon dCardR = new ImageIcon(dCardRURL);
										blackJackTable.dealerCardOne.setIcon(dCardR);
										blackJackTable.statusWindow.setText("***The dealer wins the hand.");
										bankroll -= wager * 2;
										bankrollString = (Double.toString(bankroll) + "0");
										blackJackTable.bankRollAmount.setText(bankrollString);
										playerMove = -1;
										playDealer = true;
										Player.stopTime(2000);
										break;
									}
								}
							}// end of double down
							else {
								while (Card.getSum(dealerHand) < 17 && canWeGo) {
									java.net.URL dCardRURL = Blackjack.class.getResource(Card.getCardFile(dealerHand.get(0)));
									ImageIcon dCardR = new ImageIcon(dCardRURL);
									blackJackTable.dealerCardOne.setIcon(dCardR);
									Player.stopTime(2000);
									dealerHand.add(Card.getCard(deck));
									if (dealerHand.size() == 3) {

										java.net.URL dCard3URL = Blackjack.class.getResource(Card.getCardFile(dealerHand.get(2)));
										ImageIcon dCard3 = new ImageIcon(dCard3URL);
										blackJackTable.dealerCardThree.setIcon(dCard3);
										Player.stopTime(2000);
									}
									if (dealerHand.size() == 4) {

										java.net.URL dCard4URL = Blackjack.class.getResource(Card.getCardFile(dealerHand.get(3)));
										ImageIcon dCard4 = new ImageIcon(dCard4URL);
										blackJackTable.dealerCardFour.setIcon(dCard4);
										Player.stopTime(2000);
									}
									if (dealerHand.size() == 5) {

										java.net.URL dCard5URL = Blackjack.class.getResource(Card.getCardFile(dealerHand.get(4)));
										ImageIcon dCard5 = new ImageIcon(dCard5URL);
										blackJackTable.dealerCardFive.setIcon(dCard5);
										Player.stopTime(2000);
									}
								}

								System.out.println("\nDealer's hand " + dealerHand);
								playerTotal = Card.getSum(p1.getHand());
								dealerTotal = Card.getSum(dealerHand);
								if (dealerTotal > 21) {
									blackJackTable.statusWindow.setText("****The dealer busts.  You win the hand!");
									java.net.URL dCardRURL = Blackjack.class.getResource(Card.getCardFile(dealerHand.get(0)));
									ImageIcon dCardR = new ImageIcon(dCardRURL);
									blackJackTable.dealerCardOne.setIcon(dCardR);
									bankroll += p1.payout();
									bankrollString = (Double.toString(bankroll) + "0");
									blackJackTable.bankRollAmount.setText(bankrollString);
									Player.stopTime(2000);
									break;
								} else if (playerTotal == dealerTotal) {
									java.net.URL dCardRURL = Blackjack.class.getResource(Card.getCardFile(dealerHand.get(0)));
									ImageIcon dCardR = new ImageIcon(dCardRURL);
									blackJackTable.dealerCardOne.setIcon(dCardR);
									blackJackTable.statusWindow.setText("*****Push!");
									Player.stopTime(2000);
									break;
								} else if (playerTotal > dealerTotal && playerTotal <= 21) {
									java.net.URL dCardRURL = Blackjack.class.getResource(Card.getCardFile(dealerHand.get(0)));
									ImageIcon dCardR = new ImageIcon(dCardRURL);
									blackJackTable.dealerCardOne.setIcon(dCardR);
									blackJackTable.statusWindow.setText("*****You win the hand!");
									bankroll += p1.payout();
									bankrollString = (Double.toString(bankroll) + "0");
									blackJackTable.bankRollAmount.setText(bankrollString);
									Player.stopTime(2000);
									break;
								} else {
									java.net.URL dCardRURL = Blackjack.class.getResource(Card.getCardFile(dealerHand.get(0)));
									ImageIcon dCardR = new ImageIcon(dCardRURL);
									blackJackTable.dealerCardOne.setIcon(dCardR);
									blackJackTable.statusWindow.setText("******The dealer wins the hand.");
									bankroll -= wager;
									bankrollString = (Double.toString(bankroll) + "0");
									blackJackTable.bankRollAmount.setText(bankrollString);
									Player.stopTime(2000);
									break;

								}
							}
						}// end of playDealer loop
						break;
					}// end of skipMove

					if (bankroll <= 0) {
						blackJackTable.statusWindow.setText("*You have run out of money!");
						endGame = 1;
						Player.stopTime(2000);
						break;
					}
					while (canWeGo2) {
						Table.setIfBet(false);
						canWeGo = false;
					}
				}// end of playHand
				if (endGame == 1)
					break;
			}// end of gameLoopReal
		}// end of gameLoop
	}

}
