package elment;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.*;

public class InterfaceOfinfo extends JPanel implements ActionListener,Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel maxScore = new JLabel("最高分:");
	JLabel info = new JLabel("开发信息：");
	JButton huan = new JButton(new ImageIcon("src/next.png"));
	JLabel Score = new JLabel();//随时更新的数据   分数
	JLabel note = new JLabel();//开发信息
	GameFrame gf;
	Thread t = null;
	Font font = new Font("宋体",Font.BOLD,54);
	
	public InterfaceOfinfo(GameFrame gf){
		
		this.setLayout(null);
		
		try {
			
			Scanner in = new Scanner(new FileReader(new File("score.dat")));
			Score.setText(in.nextLine());
			in.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Score.setBounds(300, 10, 300, 100);
		Score.setFont(font);
		
		this.maxScore.setBounds(0, 10,300,100);
		this.info.setBounds(0,80,300,300);
		this.huan.setBounds(700, 500, 150, 60);
		huan.setOpaque(false);
		huan.setContentAreaFilled(false);
		huan.setMargin(new Insets(0, 0, 0, 0));
		huan.setFocusPainted(false);
		huan.setBorderPainted(false);
		huan.setBorder(null);
		this.maxScore.setFont(font);
		this.info.setFont(font);
		this.huan.setFont(font);
		this.gf = gf;
		
		this.huan.addActionListener(this);
		
		this.add(maxScore);
		this.add(info);
		this.add(huan);
		this.add(Score);
		t = new Thread(this);
		t.start();
		
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(new ImageIcon("src/background.jpg").getImage(), 0, 0,this.getWidth(),this.getHeight(),this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		gf.interfaceofbegin.setVisible(true);
		gf.interfaceinfo.setVisible(false);
		gf.validate();
		
	}
	
	public void run() {
		if (StaticValue.flag) {
			
		while(true){
			
			repaint();
			Scanner in;
			try {
				in = new Scanner(new FileReader(new File("score.dat")));
				Score.setText(in.nextLine());
				in.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			try{
				Thread.sleep(50);
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		}
	}


}
