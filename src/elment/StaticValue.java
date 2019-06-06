package elment;

import java.util.List;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class StaticValue {
	public static List<BufferedImage> allPlayerImage = new ArrayList<BufferedImage>();
	
	public static List<BufferedImage> allFlyImage = new ArrayList<BufferedImage>();
	public static List<BufferedImage> allLandImage = new ArrayList<BufferedImage>();
	public static List<BufferedImage> allTreeImage = new ArrayList<BufferedImage>();
	
	public static List<BufferedImage> allStrenImage = new ArrayList<BufferedImage>();
	public static List<BufferedImage> allClsImage = new ArrayList<BufferedImage>();
	public static String imagePath =System.getProperty("user.dir")+ "./src/";
	public static boolean flag = false;
	public static int counter = 0;
	
	public static void init(){
		for(int i = 1;i <= 9;i++){
			try{
				allPlayerImage.add(ImageIO.read(new File(imagePath+i+".png")));
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
		for(int i = 26;i <= 29;i++){
			try {
				allFlyImage.add(ImageIO.read(new File(imagePath+i+".png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(int i = 22;i <= 25;i++){
			try {
				allLandImage.add(ImageIO.read(new File(imagePath+i+".png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(int i = 18;i <= 21;i++){
			try {
				allTreeImage.add(ImageIO.read(new File(imagePath+i+".png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(int i = 14;i <= 17;i++){
			try {
				allStrenImage.add(ImageIO.read(new File(imagePath+i+".png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(int i = 10;i <= 13;i++){
			try {
				allClsImage.add(ImageIO.read(new File(imagePath+i+".png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
				
	}
}
