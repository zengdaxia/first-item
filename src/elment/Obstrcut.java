package elment;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class Obstrcut implements Runnable{
	private int width;
	private int height;
	private int x;
	private int y;
	private int move = 0;
	private boolean isAlive = true;
	private int type;
	private Thread t = new Thread(this);
	
	private BufferedImage showImage;
	
	
	public Obstrcut(int x,int y,int type,GamePanel gp){
		this.x = x;
		this.y = y;
		this.type = type;
		if(type == 1){
			this.showImage = StaticValue.allFlyImage.get(0);
		}else if(type == 2){
			this.showImage = StaticValue.allLandImage.get(0);
		}else if(type == 3){
			this.showImage = StaticValue.allTreeImage.get(0);
		}else if(type == 4){
			this.showImage = StaticValue.allStrenImage.get(0);
		}else if(type == 5){
			this.showImage = StaticValue.allClsImage.get(0);
		}
		
		this.width = this.showImage.getWidth();
		this.height = this.showImage.getHeight();
		t.start();
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!StaticValue.flag){
			int tmp = 0;
			
			this.x -= 20;
			if(this.x==-100){
				this.x=900;
				StaticValue.counter++;
			}

			if(true){
				move++;
				tmp+=move;
				if(move==4){
					move=0;
				}
			}
		if(type==1)
			this.showImage = StaticValue.allFlyImage.get(tmp);
		else if (type==2)
			this.showImage = StaticValue.allLandImage.get(tmp);
		else if (type==3)
			this.showImage = StaticValue.allTreeImage.get(tmp);
		else if (type==4)
			this.showImage = StaticValue.allStrenImage.get(tmp);
		else if (type==5)
			this.showImage = StaticValue.allClsImage.get(tmp);
		
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}


	public void set(int x,int y,int type){
		this.x = x;
		this.y = y;
		this.type = type;
	}
	
	public Image getShowImage() {
		// TODO Auto-generated method stub
		return showImage;
	}


	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}
	
	public int getY(){
		return y;
	}


	public int getHeight() {
		return height;
	}


	public int getWidth() {
		return width;
	}
	public int getType(){
		return type;
	}


	public boolean isAlive() {
		return isAlive;
	}


	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	

}
