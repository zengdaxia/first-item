package elment;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;



public class InterfaceOfbegin extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public GameFrame gf;
	JButton button1 ;
	JButton button2 ;
	JButton button3 ;
		
	Image image = new ImageIcon("src/background.jpg").getImage();
	Font f = new Font("≤› È",Font.BOLD,36);
	public InterfaceOfbegin(GameFrame gf){
		
		this.gf = gf;
		button1 = new JButton(new ImageIcon("src/start.png"));
		button1.setOpaque(false);
		button1.setContentAreaFilled(false);
		button1.setMargin(new Insets(0, 0, 0, 0));
		button1.setFocusPainted(false);
		button1.setBorderPainted(false);
		button1.setBorder(null);
		button2 = new JButton(new ImageIcon("src/help.png"));
		button2.setOpaque(false);
		button2.setContentAreaFilled(false);
		button2.setMargin(new Insets(0, 0, 0, 0));
		button2.setFocusPainted(false);
		button2.setBorderPainted(false);
		button2.setBorder(null);
		button3 = new JButton(new ImageIcon("src/info.png"));
		button3.setOpaque(false);
		button3.setContentAreaFilled(false);
		button3.setMargin(new Insets(0, 0, 0, 0));
		button3.setFocusPainted(false);
		button3.setBorderPainted(false);
		button3.setBorder(null);
		
		button1.addActionListener(new button1Listener());
		button2.addActionListener(new button2Listener());
		button3.addActionListener(new button3Listener());
		

		this.setOpaque(false);
	    this.setSize(900,600);
		
		this.gf.getContentPane().add(this);
		this.setLayout(null);
		button1.setBounds(350, 160, 200, 80);
		button2.setBounds(350, 260,200 ,80);
		button3.setBounds(350,360, 200,80);
		
		button1.setFont(f);
		button2.setFont(f);
		button3.setFont(f);
	
		this.add(button1);
		this.add(button2);
		this.add(button3);
	
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(image, 0, 0,this.getWidth(),this.getHeight(),this);
	}
	
	class button1Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			StaticValue.flag = false;
			gf.gamepanel = new GamePanel(gf);
			gf.getContentPane().add(gf.gamepanel);
			gf.interfaceofbegin.setVisible(false);
			gf.gamepanel.setVisible(true);
			gf.validate();
		}
		
	}
	
	class button2Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gf.getContentPane().add(gf.interfaceofhelp);
			gf.interfaceofhelp.setVisible(true);
			gf.interfaceofbegin.setVisible(false);
			gf.validate();
		}
		
	}
	
	class button3Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gf.getContentPane().add(gf.interfaceinfo);
			gf.interfaceofbegin.setVisible(false);
			gf.interfaceinfo.setVisible(true);
			gf.validate();
		}
		
	}

}
