import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame implements ActionListener{

	JButton b10,b11,b12,b13,b14,b15;
	JButton b[] = new JButton[10];
	int i,r,n1,n2;
	JTextField field;
	char op;
	
	
	public Calculator() {
		// TODO Auto-generated constructor stub
		this.setTitle("Calculator");
		this.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4,4));
		
		for (int i = 0; i < 10; i++) {
			b[i] = new JButton(i+ "");
		    panel.add(b[i]);
		    b[i].addActionListener(this);
		}
		
		b10 = new JButton("+");
		panel.add(b10);
		b10.addActionListener(this);
		
		b11 = new JButton("-");
		panel.add(b11);
		b11.addActionListener(this);
		
		b12 = new JButton("*");
		panel.add(b12);
		b12.addActionListener(this);
		
		b13 = new JButton("/");
		panel.add(b13);
		b13.addActionListener(this);
		
		b14 = new JButton("=");
		panel.add(b14);
		b14.addActionListener(this);
		
		b15 = new JButton("C");
		panel.add(b15);
		b15.addActionListener(this);
		
		
		
		
		
		field = new JTextField(10);
		add(panel,BorderLayout.CENTER);
		this.add(field,BorderLayout.NORTH);
		
		
//		this.add(panel);
		this.setSize(500,500);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== b15) {
			r = n1 = n2 = 0;
			field.setText("");
		}
		else if(e.getSource() == b14) {
			n2 = Integer.parseInt(field.getText());
			eval();
			field.setText("" + r);
		}
		else {
			boolean opf = false;
			if(e.getSource()==b10) {
				op = '+';
				opf = true;
			}
			if(e.getSource()==b11) {
				op = '-';
				opf = true;
			}
			if(e.getSource()==b12) {
				op = '*';
				opf = true;
			}
			if(e.getSource()==b13) {
				op = '/';
				opf = true;
			}
			
			if(opf == false) {
				for (int i = 0; i < 10; i++) {
					if(e.getSource()== b[i]) {
						String s = field.getText();
						s+=i;
						field.setText(s);
					}
				}
			}
			else {
				n1 = Integer.parseInt(field.getText());
				field.setText("");
			}
		}
	}
	
	int eval()
	{
		switch(op)
		{
	 	case '+':   r=n1+n2;  break;
	 	case '-':    r=n1-n2;   break;
	 	case '*':    r=n1*n2; break;
	 	case '/':    r=n1/n2; break;
	 
		}
		return 0;
	}

}
