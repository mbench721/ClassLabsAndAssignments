package CarStuff;
import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class Explosion extends Actor {
   
 	private GreenfootImage image;
	private int x;
	private int y;
	public int w;
	private int h;
	
	public Explosion() {
		
		image = new GreenfootImage("Images/explosion.png");
		image.scale(image.getWidth() - 150, image.getHeight() - 150);
		w = 0;
	}
	public void act(){
	
		if( w < 3){
			try {
				
				Thread.sleep(50);
				image.scale(image.getWidth() +25, image.getHeight() + 25);
				setImage(image); 
					 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		if(w == 3){
			getWorld().removeObject(this);
		}
		w++;	
			
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getW(){
		return w;
	}
	public int getH(){
		return h;
	}
}
