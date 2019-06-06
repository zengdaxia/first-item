package elment;
import java.awt.*;
import javax.swing.*;


public class GameFrame extends JFrame implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ImageIcon icon = new ImageIcon("../bin/img/girl.jpg");
	
	public InterfaceOfbegin interfaceofbegin;
	public InterfaceOfhelp interfaceofhelp; 
	public InterfaceOfinfo interfaceinfo; 
	public GamePanel gamepanel ;
	
	public static void main(String[] args){
		GameFrame gameframe = new GameFrame();
		gameframe.setWindow();
	}
	
	
	public GameFrame(){
		interfaceofhelp= new InterfaceOfhelp(this);
		interfaceinfo= new InterfaceOfinfo(this);
		//gamepanel = new GamePanel(this);
		interfaceofbegin = new InterfaceOfbegin(this);
		this.getContentPane().add(interfaceofbegin);
		StaticValue.init();
	}
	
	public void setWindow(){
		this.setTitle("KillBoss");
		this.setSize(900,600);
		this.setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()-900)/2,(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-600)/2);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}




}
