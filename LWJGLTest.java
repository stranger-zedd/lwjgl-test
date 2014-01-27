import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;


public class LWJGLTest {
	
	
	static float x = 100;
	static float y = 100;
	
	public static void main(String [] args) {
	
		try {
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.create();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		// Set up OpenGL
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 800, 0, 600, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		
		while(!Display.isCloseRequested()) {
			pollInput();
			
			// Clears the screen and the depth buffer
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			
			//Set the colour of the quad (RGBA)
			GL11.glColor3f(0.5f, 0.5f, 1.0f);
			
			// Render the quad
			GL11.glBegin(GL11.GL_QUADS);
			
			GL11.glVertex2f(x, y);
			GL11.glVertex2f(x + 200, y);
			GL11.glVertex2f(x + 200, y + 200);
			GL11.glVertex2f(x, y + 200);
			
			GL11.glEnd();
			
			Display.update();
			
			// Cap to 60 FPS
			Display.sync(60);
		}
		
		Display.destroy();
		
	}
	
	/** Alters x and y based on keyboard input */
	public static void pollInput() {
		
		if(Keyboard.isKeyDown(Keyboard.KEY_UP))
			y += 10;
		
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT))
			x -= 10;
		
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
			x += 10;
		
		if(Keyboard.isKeyDown(Keyboard.KEY_DOWN))
			y -= 10;
	}
	
}
