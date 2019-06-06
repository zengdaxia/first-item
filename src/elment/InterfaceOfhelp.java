package elment;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class InterfaceOfhelp extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image image = new ImageIcon("src/background.jpg").getImage();
	JButton button3 = new JButton(new ImageIcon("src/next.png"));
	GameFrame gf;
	Font font = new Font("ËÎÌו",Font.BOLD,54);
	public InterfaceOfhelp(GameFrame gf){
		this.setLayout(null);
		this.gf = gf;
		this.button3.setBounds(700, 500, 150, 60);
		this.button3.setFont(font);
		
		button3.setOpaque(false);
		button3.setContentAreaFilled(false);
		button3.setMargin(new Insets(0, 0, 0, 0));
		button3.setFocusPainted(false);
		button3.setBorderPainted(false);
		button3.setBorder(null);
		this.button3.addActionListener(this);
		
		this.add(button3);
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(image, 0, 0,this.getWidth(),this.getHeight(),this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		gf.interfaceofbegin.setVisible(true);
		gf.interfaceofhelp.setVisible(false);
		gf.validate();
		
	}

}
