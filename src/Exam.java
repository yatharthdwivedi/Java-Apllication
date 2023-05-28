import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Exam extends JFrame implements ActionListener{
	
	
	JLabel label;
	JRadioButton r[] = new JRadioButton[5];
	JButton btn1,btn2;
	ButtonGroup btng;
	int m[] =  new int[10];
	int count = 0, curr = 0,x=1,y=1,n =0;
	
	public Exam() {
		// TODO Auto-generated constructor stub
		this.setTitle("Exam");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		label = new JLabel();
		label.setBounds(30,40,450,20);
		
		btng = new ButtonGroup();
		
		for(int i=0;i<5;i++) {
			r[i] = new JRadioButton();
			this.add(r[i]);
			btng.add(r[i]);
		}
		r[0].setBounds(50,80,100,20);
		r[1].setBounds(50,80,100,20);
		r[2].setBounds(50,110,100,20);
		r[3].setBounds(50,140,100,20);
//		r[0].setBounds(50,170,100,20);
		
		btn1 = new JButton("Next");
		btn2 = new JButton("Bookmark");
		
		btn1.setBounds(100,240,100,30);
		btn2.setBounds(270,240,100,30);  
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		
		
		this.add(label);
		this.add(btn1);
		this.add(btn2);
		
		set();
		
		this.setSize(500,500);
		this.setLayout(null);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()== btn1) {
			if(check()) {
				count++;
				
			}
			curr++;
			set();
			if(curr==9) {
				btn1.setEnabled(false);
				btn2.setText("Result");
			}
		}
		
		if(e.getSource()==btn2) {
			JButton b = new JButton("Bookmark " + x);
			b.setBounds(480,20+30*x,100,30);  
			this.add(b);
			m[x] = curr;
			x++;
			curr++;
			set();
			if(curr == 9) {
				btn2.setText("Result");
			}
			setVisible(false);
			setVisible(true);
		}
		
		for(int i=0,y=1;i<x;i++,y++) {
			
			if(e.getActionCommand().equals("Bookmark" +y)) {
				if(check()) {
					count++;
				}
			n = curr;
			curr = m[y];
			set();
			((JButton)e.getSource()).setEnabled(false);
			curr = n;
			
			}
		}
		
		if(e.getActionCommand().equals("Result")) {
			  if(check())  
	                count=count+1;  
	            curr++;  
	            System.out.println("correct ans="+count);  
	            JOptionPane.showMessageDialog(this,"correct ans="+count);  
	            System.exit(0);  
		}
		
	}
	
	
	public void set() {
		
		r[4].setSelected(true);
		if(curr == 0) {
			label.setText("Que1: Which one among these is not a primitive datatype?");
			r[0].setText("INTEGER");
			r[1].setText("char");
			r[2].setText("long");
			r[3].setText("bool");
		}
		
		if(curr == 1) {
			label.setText("Que2: Which class is available to all the class automatically?");
			r[0].setText("Swing");
			r[1].setText("HttpServlet");
			r[2].setText("Object");
			r[3].setText("Collection");
		}
		
		if(curr == 2) {
			label.setText("Que3: Which package is directly available to our class without importing it?");
			r[0].setText("Swing");
			r[1].setText("Applet");
			r[2].setText("Net");
			r[3].setText("Lang");
		}
		
		if(curr == 3) {
			label.setText("Que4: String class is defined in which package?");
			r[0].setText("Awt");
			r[1].setText("Applet");
			r[2].setText("Swing");
			r[3].setText("Lang");
		}
		
		if(curr == 4) {
			label.setText("Que5: Who will win the IPL 2023?");
			r[0].setText("CSK");
			r[1].setText("GT");
			r[2].setText("LSG");
			r[3].setText("MI");
		}
		
		if(curr == 5) {
			label.setText("Que6: Who will win the Purple Cap");
			r[0].setText("Shami");
			r[1].setText("Rashid");
			r[2].setText("Mohit");
			r[3].setText("Tushar");
		}
		
		if(curr == 6) {
			label.setText("Que7: Who will be the MOM in final");
			r[0].setText("Ruturaj");
			r[1].setText("Gill");
			r[2].setText("Rashid");
			r[3].setText("Dhoni");
		}
		
		if(curr == 7) {
			label.setText("Que8: Who will be the MOS of Ashes 2023");
			r[0].setText("Steven Smith");
			r[1].setText("Marnus");
			r[2].setText("Stokes");
			r[3].setText("Root");
		}
		
		if(curr == 8) {
			label.setText("Que9: Who will be the highest wicket taker in Ashes 2023");
			r[0].setText("James Anderson");
			r[1].setText("Broad");
			r[2].setText("Hazelwood");
			r[3].setText("Pat Cummins");
		}
		
		if(curr == 9) {
			label.setText("Que10: Who will win the World Cup 2023");
			r[0].setText("Austrailia");
			r[1].setText("India");
			r[2].setText("England");
			r[3].setText("Sri Lanka");
		}
		
		label.setBounds(30,40,450,20);
		
		for(int i=0,j=0;i<=90;i+=30,j++) {
			r[j].setBounds(50,80+i,200,20);
		}
	}
	
	boolean check() {
	
		if(curr==0)  
            return(r[1].isSelected());  
        if(curr==1)  
            return(r[2].isSelected());  
        if(curr==2)  
            return(r[3].isSelected());  
        if(curr==3)  
            return(r[0].isSelected());  
        if(curr==4)  
            return(r[2].isSelected());  
        if(curr==5)  
            return(r[2].isSelected());  
        if(curr==6)  
            return(r[1].isSelected());  
        if(curr==7)  
            return(r[3].isSelected());  
        if(curr==8)  
            return(r[1].isSelected());  
        if(curr==9)  
            return(r[2].isSelected());  
        return false;  
	}

}
