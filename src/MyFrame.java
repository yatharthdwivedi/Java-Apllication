import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame implements ActionListener {
	
	private JButton calBtn, noteBtn, ipBtn, ticBtn, exitBtn, wordBtn, puzzBtn, examBtn, srcBtn;
	
	public MyFrame() {
		// TODO Auto-generated constructor stub
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Java Application");
		this.setSize(500,500);
		this.setLayout(new GridLayout(3,3));
		
		calBtn = new JButton("Calculator");
		calBtn.addActionListener(this);
		
		noteBtn = new JButton("Notepad");
		noteBtn.addActionListener(this);
		
		ipBtn = new JButton("Ip Finder");
		ipBtn.addActionListener(this);
		
		ticBtn = new JButton("Tic Tac Toe");
		ticBtn.addActionListener(this);
		
		exitBtn = new JButton("Exit");
		exitBtn.addActionListener(this);
		
		wordBtn = new JButton("Word Count");
		wordBtn.addActionListener(this);
		
		puzzBtn = new JButton("Puzzle");
		puzzBtn.addActionListener(this);
		
		examBtn = new JButton("Exam");
		examBtn.addActionListener(this);
		
		srcBtn = new JButton("Source Code");
		srcBtn.addActionListener(this);
		
		this.add(calBtn);
		this.add(noteBtn);
		this.add(ipBtn);
		this.add(ticBtn);
		this.add(wordBtn);
		this.add(puzzBtn);
		this.add(examBtn);
		this.add(srcBtn);
		this.add(exitBtn);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== calBtn) {
			Calculator c = new Calculator();
			c.setVisible(true);
		}
		
		else if(e.getSource()== noteBtn) {
			Notepad note = new Notepad();
			note.setVisible(true);
		}
		
		else if (e.getSource()== ipBtn) {
			IPFinder ip = new IPFinder();
			ip.setVisible(true);
		}
		
		else if (e.getSource()== ticBtn) {
			TicTacToe t = new TicTacToe();
			t.setVisible(true);
		}
		else if (e.getSource()== wordBtn) {
			Count c = new Count();
			c.setVisible(true);
		}
		else if (e.getSource() == puzzBtn) {
			Puzzle p = new Puzzle();
			p.setVisible(true);
		}
		else if (e.getSource() == examBtn) {
			Exam ex = new Exam();
			ex.setVisible(true);
		}
		else if (e.getSource() == srcBtn) {
			Code src = new Code();
			src.setVisible(true);
		}
		else if (e.getSource() == exitBtn) {
			this.dispose();
		}
		
	}

}
