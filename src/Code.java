import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Code extends JFrame implements ActionListener {

	JTextField field;
	JTextArea area;
	JButton btn;
	JLabel label;
	
	
	public Code() {
		// TODO Auto-generated constructor stub
		this.setTitle("Source Code Generator");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		label = new JLabel("Enter URL");
		label.setBounds(50,50,50,20);
		
		field = new JTextField();
		field.setBounds(120,50,250,20);
		
		btn = new JButton("Get Code");
		btn.setBounds(120,100,130,30);
		btn.addActionListener(this);
		
		area = new JTextArea();
		area.setBounds(120,150,250,150);
		
		this.add(label);
		this.add(field);
		this.add(btn);
		this.add(area);
		
		
		this.setLayout(null);
		this.setSize(500,500);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s = field.getText();
		
		if(s==null) {
		}
		else  {
			try {
				URL u = new URL(s);
				URLConnection conn = u.openConnection();
				
				InputStream is = conn.getInputStream();
				int i;
				StringBuilder b = new StringBuilder();
				while((i=is.read())!=1) {
					b.append((char)i);
				}
				
				String src = b.toString();
				area.setText(src);
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2);
			}
		}
	}

}
