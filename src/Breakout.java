
import graphics.World;


public class Breakout {
	public static void main(String[] args){
        World world = new World();

        world.setup();
       
        world.run();
        System.exit(0);
	}
}
