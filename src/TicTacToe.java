import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TicTacToe extends JFrame implements ActionListener {
	
	JPanel panel1 ;
	JPanel panel2 ;
	JLabel label;
	JButton[] btn = new JButton[9];
	 Random random = new Random();
	int flag =0;
	boolean p1_ch;
	
	
	public TicTacToe() {
		// TODO Auto-generated constructor stub
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Tic Tac Toe");
		this.setSize(800,800);
		this.getContentPane().setBackground(new Color(50,50,50));
		this.setLayout(new BorderLayout());
		
		label = new JLabel();
		label.setBackground(new Color(120,20,120));
		label.setForeground(new Color(25,255,0));
		label.setFont(new Font("Ink Tree", Font.BOLD, 75));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setText("Tic Tac Toe");
		label.setOpaque(true);
		
		panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		panel1.setBounds(0,0,800,100);
		
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(3,3));
		panel2.setBackground(new Color(150,150,150));
		
		for(int i =0; i<9; i++ ) {
			btn[i] = new JButton();
			panel2.add(btn[i]);
			btn[i].setFont(new Font("Ink Tree", Font.BOLD, 75));
			btn[i].setFocusable(false);
			btn[i].addActionListener(this);
		}
		
		panel1.add(label);
		
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2);
		this.setVisible(true);
		
		startGame();
	}

	public void startGame() {
		try {
			label.setText("Loading ...");
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		int ch = random.nextInt(100);
		
		if(ch%2==0) {
			p1_ch = true;
			label.setText("X Turn");
		}
		else  {
			p1_ch = false;
			label.setText("O Turn");
		}
	}
	
	public void gameOver(String s) {
		flag =0;
		Object[] opt = {"Restart", "Exit" };
		int n = JOptionPane.showOptionDialog(this, "Game Over\n " + s, "Game Over", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opt, opt[0]);
		if(n==0) {
			this.dispose();
			new TicTacToe();
		}
		else {
			this.dispose();
		}
	}
	
	public void matchCheck() {
		if((btn[0].getText() == "X") && (btn[1].getText()=="X") && (btn[2].getText()=="X")) {
			xWins(0,1,2);
		}
		else if ((btn[0].getText()=="X") && (btn[4].getText()=="X") && (btn[8].getText()=="X")) {
			xWins(0,4,8);
		}
		else if ((btn[0].getText()=="X") && (btn[3].getText()=="X") && (btn[6].getText()=="X")) {
			xWins(0,3,6);
		}
		else if ((btn[1].getText()=="X") && (btn[4].getText()=="X") && (btn[7].getText()=="X")) {
			xWins(1,4,7);
		}
		else if ((btn[2].getText()=="X") && (btn[4].getText()=="X") && (btn[6].getText()=="X")) {
			xWins(2,4,6);
		}
		else if ((btn[2].getText()=="X") && (btn[5].getText()=="X") && (btn[8].getText()=="X")) {
			xWins(2,5,8);
		}
		else if ((btn[3].getText()=="X") && (btn[4].getText()=="X") && (btn[5].getText()=="X")) {
			xWins(3,4,5);
		}
		else if ((btn[6].getText()=="X") && (btn[7].getText()=="X") && (btn[8].getText()=="X")) {
			xWins(6,7,8);
		}
		else if ((btn[0].getText()=="O") && (btn[1].getText()=="O") && (btn[2].getText()=="O")) {
			oWins(0,1,2);
		}
		else if ((btn[0].getText()=="O") && (btn[3].getText()=="O") && (btn[6].getText()=="O")) {
			oWins(0,3,6);
		}
		else if ((btn[0].getText()=="O") && (btn[4].getText()=="O") && (btn[8].getText()== "O")) {
			oWins(0,4,8);
		}
		else if ((btn[1].getText()=="O") && (btn[4].getText()=="O") && (btn[7].getText()=="O")) {
			oWins(1,4,7);
		}
		else if ((btn[2].getText() == "O") && (btn[4].getText() == "O") && (btn[6].getText() == "O")) {
            oWins(2, 4, 6);
        }
		else if ((btn[2].getText() == "O") && (btn[5].getText() == "O") && (btn[8].getText() == "O")) {
            oWins(2, 5, 8);
        }
        else if ((btn[3].getText() == "O") && (btn[4].getText() == "O") && (btn[5].getText() == "O")) {
            oWins(3, 4, 5);
        } 
        else if ((btn[6].getText() == "O") && (btn[7].getText() == "O") && (btn[8].getText() == "O")) {
            oWins(6, 7, 8);
        }
		else if (flag==9) {
			label.setText("MAtch Tie");
			gameOver("Match Tie");
		}
	}
	
	public void xWins(int x, int y, int z) {
		btn[x].setBackground(Color.RED);
		btn[y].setBackground(Color.RED);
		btn[z].setBackground(Color.RED);
		
		for(int i=0;i<9;i++) {
			btn[i].setEnabled(false);
		}
		
		label.setText("X Wins");
		gameOver("X Wins");
	}
	
	public void oWins(int x, int y, int z) {
		btn[x].setBackground(Color.RED);
		btn[y].setBackground(Color.RED);
		btn[z].setBackground(Color.RED);
		
		for(int i=0;i<9;i++) {
			btn[i].setEnabled(false);
		}
		
		label.setText("O Wins");
		gameOver("O Wins");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i =0;i<9;i++) {
			if(e.getSource()==btn[i]) {
				if(p1_ch) {
					if(btn[i].getText()=="") {
						btn[i].setBackground(new Color(255,0,0));
						btn[i].setText("X");
						p1_ch = false;
						label.setText("O Turn");
						flag++;
						matchCheck();
					}
				}
				else {
					if(btn[i].getText()=="") {
						btn[i].setBackground(new Color(0,0,255));
						btn[i].setText("O");
						p1_ch = true;
						label.setText("X Turn");
						flag++;
						matchCheck();
					}
				}
			}
		}
	}

}
