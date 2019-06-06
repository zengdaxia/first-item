package elment;
import java.awt.*;
import java.awt.image.BufferedImage;


//角色类
public class Player implements Runnable {
	public GamePanel gamepanel;
	public int seconds = 0;
	//人物坐标
	public int hitType = 0;
	private int moving = 0;
	private int uptime = 5;
	private int x = 50;
	private int y = 380;
	private int width;
	private int height;
	private int Ymove;
	private BufferedImage showImage;
	
	//体力
	private int strength = 100;
	private int score;
	private Thread t = null;
	
	//检测是否贴地
	private boolean isGravity = false;
	
	//人物的各种状态
	public String Dir_Up = "up";
	public String Dir_Down = "down";
	private String status = "standing";
	private int moving2 = 5;
	
	
	public Player(GamePanel gamepanel){
	
		this.showImage=StaticValue.allPlayerImage.get(0);
		this.width = this.showImage.getWidth();
		this.height = this.showImage.getHeight();
		this.gamepanel = gamepanel;
	    t = new Thread(this);
		t.start();
		this.Gravity();

	}
	
	public void run(){
		
		while(!StaticValue.flag){
			int tmp = 0;
			
			if(isOnLand()){
				moving++;
				tmp+=moving;
				if(moving==4){
					moving=0;
				}
				
			}
			
			if(this.status.equals("creeping")){
				moving2 ++;
				tmp += moving2;
				if(moving2==8)
					moving2=5;
			
			}
			
			
			
			
			if(this.status.equals("jumping")){
				if(uptime!=0){
					uptime--;
				}else{
					this.down();
					if(this.y==380)
						Ymove=0;
				}
				if(isOnLand()){
					uptime=5;
				}
				y+=Ymove;
			}
			
			if((seconds%1000)==0)
				this.ChangeStr();
			
			this.seconds+=50;
			
			 this.showImage = StaticValue.allPlayerImage.get(tmp);
			
			try{
				Thread.sleep(50);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}

	}
	
	public void ChangeStr(){
		strength--;
	}
	
	public void jump(){
		Ymove = -30;
		
		this.status="jumping";
	}
	
	public void down(){
		Ymove = 30;
	}
	
	public void creep(){
		
		
			this.y =381;
		this.status="creeping";
	
}
	
	public void creepStop(){
		this.y=380;
			this.status= "standing";
	}
	
	public boolean hit(){
		Rectangle myrect = new Rectangle(this.x+20,this.y+10,this.width-21,this.height-10);
		if(this.status=="creeping"){
			myrect = new Rectangle(this.x+20,this.y+50,this.width-21,this.height-15);
		}
		Rectangle rect = null;
		if(gamepanel.itemList.size()!=0){
		for(int i =0;i < gamepanel.itemList.size();i++){
			Obstrcut item = gamepanel.itemList.get(i);
			switch(item.getType()){
			case 1:
				rect = new Rectangle(item.getX()+25,item.getY()+25,item.getWidth()-20,item.getHeight()-20);break;//猪
			case 2:
				rect = new Rectangle(item.getX()+28,item.getY()+25,39,50);break;
			case 3:
				rect = new Rectangle(item.getX()+29,item.getY()+30,60,80);break;//骷髅
			case 4:
				rect = new Rectangle(item.getX()+25,item.getY()+20,item.getWidth()-10,item.getHeight()-10);break;
			case 5:
				rect = new Rectangle(item.getX()+25,item.getY()+20,item.getWidth()-10,item.getHeight()-10);break;
			}
			if(myrect.intersects(rect)){
				this.hitType = item.getType();
				item.setAlive(false);
				return true;
			}
		}
		}
		return false;
	}
	
	
	public boolean isOnLand(){
		return this.y==380;
	}
	
	public void Gravity(){
		new Thread(){
			public void run(){
				while(true){
					try{
						sleep(10);
					}catch(InterruptedException e ){
						e.printStackTrace();
					}
					
					while(true){
						if(status.equals("jumping"))
							break;
						
						if(y>=200){
							setGravity(false);
						}
						else{
							setGravity(true);
							y+=Ymove;
						}
						
						try{
							sleep(10);
						}catch(InterruptedException e ){
							e.printStackTrace();
						}
					}
				}
			}
		}.start();
	}


	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}

	

	public String getStatus(){
		return status;
	}


	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	public int getHeight(){
		return height;
	}

	public boolean isGravity() {
		return isGravity;
	}

	public void setGravity(boolean isGravity) {
		this.isGravity = isGravity;
	}
	
	public int getScore(){
		score = 50*StaticValue.counter+10*((int)seconds/1000);
		
		return this.score;
	}

	public BufferedImage getShowImage() {
		// TODO Auto-generated method stub
		return showImage;
	}

	public int getHitType() {
		// TODO Auto-generated method stub
		return hitType;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
	
}
