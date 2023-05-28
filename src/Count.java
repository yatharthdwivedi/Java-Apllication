import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Count extends JFrame implements ActionListener {

	JLabel l1,l2;
	JTextArea text;
	JButton btn, pad, t;
	
	public Count() {
		// TODO Auto-generated constructor stub
		this.setTitle("Word Count");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		l1 = new JLabel("Characters =>");
		l1.setBounds(60,50,100,20);
		
		l2 = new JLabel("Words => ");
		l2.setBounds(60,80,100,20);
		
		text = new JTextArea();
		text.setBounds(60,110,300,200);
		
		btn = new JButton("Click");
		btn.setBounds(60,320,80,30);
		btn.addActionListener(this);
		
		pad = new JButton("Pad Colour");
		pad.setBounds(140,320,110,30);
		pad.addActionListener(this);
		
		t = new JButton("Text Colour");
		t.setBounds(260,320,110,30);
		t.addActionListener(this);
		
		this.add(l1);
		this.add(l2);
		this.add(btn);
		this.add(text);
		this.add(pad);
		this.add(t);
		
		this.setSize(400,400);
		this.setLayout(null);
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==btn) {
			String word = text.getText();
			l1.setText("Characters : " + word.length());
			String words[] = word.split("\\s");
			l2.setText("Words are : " + words.length);
		}
		else if (e.getSource()==pad) {
			Color c = JColorChooser.showDialog(this, "Choose Colour", Color.BLACK);
			text.setBackground(c);
		}
		else if (e.getSource()==t) {
			Color c = JColorChooser.showDialog(this, "Choose Colour", Color.BLACK);
			text.setForeground(c);
		}
		
	}

}
