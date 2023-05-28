import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Puzzle extends JFrame implements ActionListener {

	Button btn1, btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
	
	
	public Puzzle() {
		// TODO Auto-generated constructor stub
		this.setTitle("Puzzle");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		btn1 = new Button("1");
		btn1.setBounds(50,100,40,40);
		
		btn2 = new Button("2");
		btn2.setBounds(100,100,40,40);
		
		btn3 = new Button("3");
		btn3.setBounds(150,100,40,40);
		
		btn4 = new Button("4");
		btn4.setBounds(50,150,40,40);
		
		btn5 = new Button("5");
		btn5.setBounds(100,150,40,40);
		
		btn6 = new Button("6");
		btn6.setBounds(150,150,40,40);
		
		btn7 = new Button("7");
		btn7.setBounds(50,200,40,40);

		btn8 = new Button("");
		btn8.setBounds(100,200,40,40);
		
		btn9 = new Button("8");
		btn9.setBounds(150,200,40,40);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(btn5);
		this.add(btn6);
		this.add(btn7);
		this.add(btn8);
		this.add(btn9);
		
		this.setSize(400,400);
		this.setLayout(null);
		this.setVisible(true);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn1) {
			String s = btn1.getLabel();
			if(btn2.getLabel().equals("")) {
				btn2.setLabel(s);
				btn1.setLabel("");
			}
			if(btn4.getLabel().equals("")) {
				btn4.setLabel(s);
				btn1.setLabel("");
			}
		}
		
		if(e.getSource()==btn2) {
			String s = btn2.getLabel();
			if(btn1.getLabel().equals("")) {
				btn1.setLabel(s);
				btn2.setLabel("");
			}
			if(btn3.getLabel().equals("")) {
				btn3.setLabel(s);
				btn2.setLabel("");
			}
			if(btn5.getLabel().equals("")) {
				btn5.setLabel(s);
				btn2.setLabel("");
			}
		}
		
		if(e.getSource()==btn3) {
			String s = btn3.getLabel();
			if(btn2.getLabel().equals("")) {
				btn2.setLabel(s);
				btn3.setLabel("");
			}
			if(btn6.getLabel().equals("")) {
				btn6.setLabel(s);
				btn1.setLabel("");
			}
		}
		
		if(e.getSource()==btn4) {
			String s = btn4.getLabel();
			if(btn1.getLabel().equals("")) {
				btn1.setLabel(s);
				btn4.setLabel("");
			}
			if(btn7.getLabel().equals("")) {
				btn7.setLabel(s);
				btn4.setLabel("");
			}
			if(btn5.getLabel().equals("")) {
				btn5.setLabel(s);
				btn4.setLabel("");
			}
		}
		
		if(e.getSource()==btn5) {
			String s = btn5.getLabel();
			if(btn2.getLabel().equals("")) {
				btn2.setLabel(s);
				btn5.setLabel("");
			}
			if(btn4.getLabel().equals("")) {
				btn4.setLabel(s);
				btn5.setLabel("");
			}
			if(btn8.getLabel().equals("")) {
				btn8.setLabel(s);
				btn5.setLabel("");
			}
			if(btn6.getLabel().equals("")) {
				btn6.setLabel(s);
				btn5.setLabel("");
			}
		}
		
		if(e.getSource()==btn6) {
			String s = btn6.getLabel();
			if(btn3.getLabel().equals("")) {
				btn3.setLabel(s);
				btn6.setLabel("");
			}
			if(btn5.getLabel().equals("")) {
				btn5.setLabel(s);
				btn6.setLabel("");
			}
			if(btn9.getLabel().equals("")) {
				btn9.setLabel(s);
				btn6.setLabel("");
			}
		}
		
		if(e.getSource()==btn7) {
			String s = btn7.getLabel();
			if(btn4.getLabel().equals("")) {
				btn4.setLabel(s);
				btn7.setLabel("");
			}
			if(btn8.getLabel().equals("")) {
				btn8.setLabel(s);
				btn7.setLabel("");
			}
			
		}
		
		if(e.getSource()==btn8) {
			String s = btn8.getLabel();
			if(btn5.getLabel().equals("")) {
				btn5.setLabel(s);
				btn8.setLabel("");
			}
			if(btn7.getLabel().equals("")) {
				btn7.setLabel(s);
				btn8.setLabel("");
			}
			if(btn9.getLabel().equals("")) {
				btn9.setLabel(s);
				btn8.setLabel("");
			}
		}
		
		if(e.getSource()==btn9) {
			String s = btn9.getLabel();
			if(btn6.getLabel().equals("")) {
				btn6.setLabel(s);
				btn9.setLabel("");
			}
			if(btn8.getLabel().equals("")) {
				btn8.setLabel(s);
				btn9.setLabel("");
			}
		}
		
		if(btn1.getLabel().equals("1") && btn2.getLabel().equals("2") && btn3.getLabel().equals("3") && btn4.getLabel().equals("4") && btn5.getLabel().equals("5") && btn6.getLabel().equals("6") && btn7.getLabel().equals("7") && btn8.getLabel().equals("8") && btn9.getLabel().equals("")) {
			JOptionPane.showMessageDialog(this, "Congrats! You won");
		}
		
		
		
	}
	
	}