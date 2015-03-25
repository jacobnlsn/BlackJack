/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Table.java
 *
 * Created on May 11, 2009, 11:30:00 AM
 */

/**
 *
 * @author 09154453
 */

package BlackJack;

public class Table extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	javax.swing.JLabel bankRollAmount;
	private javax.swing.JLabel bankRollLabel;
	javax.swing.JTextField betBox;
	javax.swing.JLabel betLabel;
	javax.swing.JButton confirm;
	javax.swing.JLabel dealerCardFive;
	javax.swing.JLabel dealerCardFour;
	javax.swing.JLabel dealerCardOne;
	javax.swing.JLabel dealerCardThree;
	javax.swing.JLabel dealerCardTwo;
	private javax.swing.JLabel dealerLabel;
	javax.swing.JButton doubleDown;
	javax.swing.JButton hit;
	private javax.swing.JPanel mainWindow;
	javax.swing.JLabel palyerCardFour;
	javax.swing.JLabel playerCardFive;
	javax.swing.JLabel playerCardOne;
	javax.swing.JLabel playerCardThree;
	javax.swing.JLabel playerCardTwo;
	private javax.swing.JLabel playerLabel;
	javax.swing.JLabel statusWindow;
	javax.swing.JButton stay;

	/** Creates new form Table */
	public Table() {
		initComponents();
	}

	private void initComponents() {

		mainWindow = new javax.swing.JPanel();
		betLabel = new javax.swing.JLabel();
		betBox = new javax.swing.JTextField();
		confirm = new javax.swing.JButton();
		hit = new javax.swing.JButton();
		stay = new javax.swing.JButton();
		doubleDown = new javax.swing.JButton();
		statusWindow = new javax.swing.JLabel();
		dealerLabel = new javax.swing.JLabel();
		playerLabel = new javax.swing.JLabel();
		bankRollLabel = new javax.swing.JLabel();
		bankRollAmount = new javax.swing.JLabel();
		playerCardOne = new javax.swing.JLabel();
		playerCardTwo = new javax.swing.JLabel();
		playerCardThree = new javax.swing.JLabel();
		palyerCardFour = new javax.swing.JLabel();
		playerCardFive = new javax.swing.JLabel();
		dealerCardOne = new javax.swing.JLabel();
		dealerCardTwo = new javax.swing.JLabel();
		dealerCardThree = new javax.swing.JLabel();
		dealerCardFour = new javax.swing.JLabel();
		dealerCardFive = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(0, 102, 0));
		setResizable(false);

		mainWindow.setBackground(new java.awt.Color(0, 102, 0));
		mainWindow.setPreferredSize(new java.awt.Dimension(419, 436));

		betLabel.setForeground(new java.awt.Color(255, 255, 255));
		betLabel.setText("Bet Goes Below");

		betBox.setText("BET");
		betBox.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				betBoxActionPerformed(evt);
			}
		});

		confirm.setText("Confirm");
		confirm.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				confirmActionPerformed(evt);
			}
		});

		hit.setText("Hit");
		hit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				hitActionPerformed(evt);
			}
		});

		stay.setText("Stay");
		stay.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				stayActionPerformed(evt);
			}
		});

		doubleDown.setText("Double Down");
		doubleDown.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				doubleDownActionPerformed(evt);
			}
		});

		statusWindow.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		statusWindow.setForeground(new java.awt.Color(255, 255, 255));
		statusWindow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		statusWindow.setText("PLEASE ENTER YOUR BET!");

		dealerLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
		dealerLabel.setForeground(new java.awt.Color(255, 255, 255));
		dealerLabel.setText("Dealer");

		playerLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
		playerLabel.setForeground(new java.awt.Color(255, 255, 255));
		playerLabel.setText("Player");

		bankRollLabel.setForeground(new java.awt.Color(255, 255, 255));
		bankRollLabel.setText("Player's Bank Roll:");

		bankRollAmount.setForeground(new java.awt.Color(255, 255, 255));
		bankRollAmount.setText("$");

		javax.swing.GroupLayout mainWindowLayout = new javax.swing.GroupLayout(mainWindow);
		mainWindow.setLayout(mainWindowLayout);
		mainWindowLayout
				.setHorizontalGroup(mainWindowLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								mainWindowLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												mainWindowLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(statusWindow,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE, 374,
																Short.MAX_VALUE)
														.addComponent(dealerLabel,
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																mainWindowLayout
																		.createSequentialGroup()
																		.addComponent(playerCardOne)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(playerCardTwo)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(playerCardThree)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(palyerCardFour)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(playerCardFive))
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																mainWindowLayout
																		.createSequentialGroup()
																		.addComponent(dealerCardOne)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(dealerCardTwo)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(dealerCardThree)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(dealerCardFour)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(dealerCardFive))
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																mainWindowLayout
																		.createSequentialGroup()
																		.addComponent(hit)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(stay)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(doubleDown)
																		.addGap(17, 17, 17)
																		.addGroup(
																				mainWindowLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(betLabel)
																						.addGroup(
																								mainWindowLayout
																										.createSequentialGroup()
																										.addComponent(
																												betBox,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												65,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												confirm))))
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																mainWindowLayout
																		.createSequentialGroup()
																		.addComponent(playerLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(bankRollLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(bankRollAmount,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				178, Short.MAX_VALUE)))
										.addContainerGap()));
		mainWindowLayout.setVerticalGroup(mainWindowLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				mainWindowLayout.createSequentialGroup().addContainerGap().addComponent(dealerLabel).addPreferredGap(
						javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
						mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
								dealerCardOne).addComponent(dealerCardTwo).addComponent(dealerCardThree).addComponent(
								dealerCardFour).addComponent(dealerCardFive)).addGap(18, 18, 18).addComponent(
						statusWindow, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE).addGap(18, 18, 18)
						.addGroup(
								mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(playerCardOne).addComponent(playerCardTwo).addComponent(
												playerCardThree).addComponent(palyerCardFour).addComponent(
												playerCardFive)).addPreferredGap(
								javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
								mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(
												mainWindowLayout.createSequentialGroup().addGroup(
														mainWindowLayout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(bankRollLabel).addComponent(
																		bankRollAmount)).addPreferredGap(
														javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(betLabel).addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED))
										.addComponent(playerLabel)).addGap(7, 7, 7).addGroup(
								mainWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(
												mainWindowLayout.createParallelGroup(
														javax.swing.GroupLayout.Alignment.BASELINE).addComponent(hit)
														.addComponent(stay).addComponent(doubleDown)).addGroup(
												mainWindowLayout.createParallelGroup(
														javax.swing.GroupLayout.Alignment.BASELINE).addComponent(
														confirm).addComponent(betBox,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))).addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				mainWindow, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				mainWindow, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 482,
				Short.MAX_VALUE));

		pack();
	}// </editor-fold>

	public static char move;
	public static boolean playerChoose = false;

	private void doubleDownActionPerformed(java.awt.event.ActionEvent evt) {
		move = 'd';
		playerChoose = true;

	}

	private void hitActionPerformed(java.awt.event.ActionEvent evt) {
		move = 'h';
		playerChoose = true;
	}

	private void stayActionPerformed(java.awt.event.ActionEvent evt) {
		move = 's';
		playerChoose = true;
	}

	public double theirBetDouble = 5;
	public static boolean bet = false;

	public void confirmActionPerformed(java.awt.event.ActionEvent evt) {
		String theirBet = betBox.getText();
		theirBetDouble = Double.valueOf(theirBet.trim()).doubleValue();
		bet = true;

	}

	private void betBoxActionPerformed(java.awt.event.ActionEvent evt) {
		confirmActionPerformed(evt);
	}

	public static boolean getIfBet() {
		return bet;
	}

	public static void setIfBet(boolean Boolean) {
		bet = Boolean;
	}

	public Double getBet() {
		return theirBetDouble;
	}

	public static char getMove() {
		return move;
	}
	
	public static void setMoveX() {
		move = 'x';
	}

	public static boolean getPlayerChoose() {
		return playerChoose;
	}

	public static void setPlayerChoose(boolean Boolean) {
		playerChoose = Boolean;
	}

}
