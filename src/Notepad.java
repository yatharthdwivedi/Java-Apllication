import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

public class Notepad extends JFrame implements ActionListener{
	
	JTextArea area;
	
	
 public Notepad() {
	// TODO Auto-generated constructor stub
	 this.setTitle("Notepad");
	 
	 try {
		UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		MetalLookAndFeel.setCurrentTheme(new OceanTheme());
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
			| UnsupportedLookAndFeelException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 area = new JTextArea();
	 
	 JMenuBar mb = new JMenuBar();
	 
	 JMenu m1 = new JMenu("File");
	 
	 JMenuItem i1 = new JMenuItem("New");
	 JMenuItem i2 = new JMenuItem("Open");
	 JMenuItem i3 = new JMenuItem("Save");
	 JMenuItem i4 = new JMenuItem("Print");
	 
	 i1.addActionListener(this);
	 i2.addActionListener(this);
	 i3.addActionListener(this);
	 i4.addActionListener(this);

	 m1.add(i1);
	 m1.add(i2);
	 m1.add(i3);
	 m1.add(i4);
	 
	 JMenu m2 = new JMenu("Edit");
	 
	 JMenuItem i5 = new JMenuItem("Cut");
	 JMenuItem i6 = new JMenuItem("Copy");
	 JMenuItem i7 = new JMenuItem("Paste");
	 
	 i5.addActionListener(this);
	 i6.addActionListener(this);
	 i7.addActionListener(this);
	 
	 m2.add(i5);
	 m2.add(i6);
	 m2.add(i7);
	 
	 JMenuItem c = new JMenuItem("Close");
	 
	 c.addActionListener(this);
	 
	 mb.add(m1);
     mb.add(m2);
     mb.add(c);
	 this.setJMenuBar(mb);
	 this.add(area);
	 this.setSize(500,500);
	 this.setVisible(true);
	 
	 
	 
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	String s = e.getActionCommand();
	if(s.equals("Cut")) {
		area.cut();
	}
	 else if (s.equals("Copy")) {
         area.copy();
     }
     else if (s.equals("Paste")) {
         area.paste();
     }
     else if (s.equals("Save")) {
    	 JFileChooser f = new JFileChooser("f:");
    	 int r = f.showSaveDialog(null);
    	 
    	 if(r == JFileChooser.APPROVE_OPTION) {
    		 File fi = new File(f.getSelectedFile().getAbsolutePath());
    		 
    		 try {
				FileWriter wr = new FileWriter(fi,false);
				
				BufferedWriter b = new BufferedWriter(wr);
				
				b.write(area.getText());
				
				b.flush();
				b.close();
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(f, e2.getMessage());
			}
    		 
    	 }
    	 else  {
    		 JOptionPane.showMessageDialog(f, "Cancelled");
    	 }
     }
     else if(s.equals("Open")) {
    	 JFileChooser f = new JFileChooser("f:");
    	 
    	 int r = f.showOpenDialog(null);
    	 
    	 if(r == JFileChooser.APPROVE_OPTION) {
    		 File fi = new File(f.getSelectedFile().getAbsolutePath());
    		 
    		 try {
				String s1 = " ", s2=" ";
				
				FileReader fr = new FileReader(fi);
				
				BufferedReader br = new BufferedReader(fr);
				
				s2 = br.readLine();
				
				while((s1 = br.readLine())!=null) {
					s2 = s2 + "\n" + s1;
				}
					
				area.setText(s2);
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(f, e2.getMessage());
			}
    		 
    	 }
    	 else
             JOptionPane.showMessageDialog(f, "the user cancelled the operation");
     }
     else if (s.equals("New")) {
         area.setText("");
     }
//     else if (s.equals("close")) {
//         f.setVisible(false);
//     }
}
}
