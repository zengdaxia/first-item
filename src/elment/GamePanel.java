package elment;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class GamePanel extends JPanel implements KeyListener,Runnable {
	/**
	 * 
	 */
	Image image = new ImageIcon("bin/image/01.jpeg").getImage();
	private static final long serialVersionUID = 1L;
	public GameFrame gf ;

	public Player player = new Player(this);
	public JLabel showInfo1 = new JLabel("分数:"+this.player.getScore());
	public JLabel showInfo2 = new JLabel("体力:"+this.player.getStrength());
	public Obstrcut one;
	public Obstrcut two;
	public Obstrcut three;
	public Obstrcut four;
	public Obstrcut five;
	public Vector<Obstrcut> itemList; 
	

	public GamePanel(GameFrame gf){
		
		this.setLayout(null);
		showInfo1.setVisible(true);
		showInfo1.setBounds(0, 0, 500, 40);
		showInfo1.setFont(new Font("草书",Font.BOLD,20));
		showInfo2.setVisible(true);
		showInfo2.setBounds(0, 40, 90, 40);
		showInfo2.setFont(new Font("草书",Font.BOLD,20));
		this.add(showInfo1);
		this.add(showInfo2);
		itemList = new Vector<Obstrcut>();
		this.addKeyListener(this);
		this.gf = gf;
		this.setFocusable(true);
		this.setOpaque(false);
		this.setLayout(null);
	    this.setSize(900,600);
	    StaticValue.init();
	    one = new Obstrcut(500,350,4,this);
	    two = new Obstrcut(900,360,5,this);
	    three = new Obstrcut(1400,380,3,this);
	    four = new Obstrcut(1100,380,2,this);
	    five = new Obstrcut(1700,340,1,this);
	    itemList.add(this.one);
	    itemList.add(two);
	    itemList.add(three);
	    itemList.add(four);
	    itemList.add(five);
	    
	    new Thread(this).start();
		this.repaint();
	}
	
	public void paintComponent(Graphics g){
		//BufferedImage image = new BufferedImage(900,600,BufferedImage.TYPE_3BYTE_BGR);
		g.drawImage(new ImageIcon("src/bj.png").getImage(),0,0,this.getWidth(),this.getHeight(),this);
		g.drawImage(image, 0, 0,this.getWidth(),this.getHeight(),this);
		
		//if(one.isAlive())
		g.drawImage(this.one.getShowImage(),this.one.getX(),this.one.getY(),this);
		
		//if(two.isAlive())
		g.drawImage(this.two.getShowImage(),this.two.getX(),this.two.getY(),this);
		
		g.drawImage(this.three.getShowImage(),this.three.getX(),this.three.getY(),this);
		g.drawImage(this.four.getShowImage(),this.four.getX(),this.four.getY(),this);
		g.drawImage(this.five.getShowImage(),this.five.getX(),this.five.getY(),this);
		g.drawImage(this.player.getShowImage(),this.player.getX(), this.player.getY(), this);
		//g.drawImage(image, 0, 0,this);
		
	}
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	
		if(e.getKeyCode()==38){
		
			this.player.jump();
			
		}
		else if (e.getKeyCode()==40){
		if(this.player.isOnLand())
			this.player.creep();

		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==40){
			if(this.player.getStatus().equals("creeping"))
			this.player.creepStop();
			
		}
		
	}

	@Override
	public void run(){
		// TODO Auto-generated method stub
		while(!StaticValue.flag){
			this.repaint();
			this.showInfo1.setText("分数:"+this.player.getScore());;
			this.showInfo2.setText("体力:"+this.player.getStrength());
			
			try{
				if(this.player.hit()&&(this.player.getHitType()==1||this.player.getHitType()==2||this.player.getHitType()==3)||this.player.getStrength()<1){
				
					int socre = this.player.getScore();
					if(JOptionPane.showConfirmDialog(this,"游戏结束!!! 您获得了"+ socre+"分!","Gameover",UNDEFINED_CONDITION )==0);
					{
						
						System.out.println(""+socre);
						File file = new File("score.dat");
						try{
									Scanner in = new Scanner(new FileReader(file));
									int x = Integer.parseInt(in.nextLine());
									
									if(x<socre){
										FileWriter fw = new FileWriter("score.dat");
										fw.write(""+socre);
										fw.close();
									}
									in.close();}
						catch(Exception e){
										e.printStackTrace();
									}
					
					}
						StaticValue.counter=0;
						this.player.setScore(0);
						gf.interfaceofbegin.setVisible(true);
						gf.gamepanel.setVisible(false);
						gf.validate();
						StaticValue.flag=true;
						
				}
				
				if(this.player.hit()&&this.player.getHitType()==4){
					this.player.setStrength(100);
					this.one.set((int)(Math.random()*500+900),(int)(Math.random()*40+340),4); 
				}
				
				if(this.player.hit()&&this.player.getHitType()==5){
					//remove();
					StaticValue.counter+=3;
					this.two.set((int)(Math.random()*500+1000),(int)(Math.random()*40+340),5);
					this.three.set((int)(Math.random()*500+1000),380,(int)(Math.random()*2+1));
					this.four.set((int)(Math.random()*500+1000),380,(int)(Math.random()*2+1)); 
					this.five.set((int)(Math.random()*500+1000),340,1); 
				}
				
				Thread.sleep(50);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}




}
