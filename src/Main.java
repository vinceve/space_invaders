import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import shapes.Square;


public class Main {

    private Square square;

    public Main() {
        try {
            DisplayMode mode = new DisplayMode(800, 600);
            Display.setDisplayMode(mode);
            Display.setFullscreen(mode.isFullscreenCapable());
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }

        setupOpenGl();
        square = new Square(50);
        square.draw();

        while (!Display.isCloseRequested()) {
            pollInput();
            square.draw();
            Display.update();
        }

        Display.destroy();
    }

    public void pollInput() {

        while (Keyboard.next()) {
            switch (Keyboard.getEventKey()) {
                case Keyboard.KEY_Z:
                    System.out.println("Z key pressed");
                    square.moveUp();
                break;
                case Keyboard.KEY_S:
                    System.out.println("S key pressed");
                    square.moveDown();
                break;
                case Keyboard.KEY_Q:
                    System.out.println("Q key pressed");
                    square.moveLeft();
                break;
                case Keyboard.KEY_D:
                    System.out.println("D key pressed");
                    square.moveRight();
                break;
            }
        }

    }

    public void setupOpenGl() {
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, 800, 0, 600, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
    }

    public static void main(String[] args) {
        new Main();
    }

}


