import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class IPFinder extends JFrame implements ActionListener {
	
	JLabel label;
	JTextField text;
	JButton btn;
	
	public IPFinder() {
		// TODO Auto-generated constructor stub
		this.setTitle("Ip Finder");
		
		label = new JLabel("Enter URL :");
		label.setBounds(50,70,150,20);;  
		
		text = new JTextField();
	    text.setBounds(50,100,200,20);  
		
	    btn = new JButton("Find IP Address");
	    btn.setBounds(50,150,80,30);
	    btn.addActionListener(this);
	    
		this.add(label);
		this.add(text);
		this.add(btn);
		this.setSize(300,300);
		this.setLayout(null);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String url = text.getText();
		try {
			InetAddress i = InetAddress.getByName(url);
			String ip = i.getHostAddress();
			JOptionPane.showMessageDialog(this, ip);
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, e2.toString());
		}
	}

}
