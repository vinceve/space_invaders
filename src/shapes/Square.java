package shapes;

import org.lwjgl.opengl.GL11;

/**
 * Our X & Y start at the bottom left corner.
 */
public class Square {

    private float x;
    private float y;
    private float size;

    public Square(float size) {
        this.size = size;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public void moveUp() {
        setY(getY()+10);
    }

    public void moveDown() {
        setY(getY()-10);
    }

    public void moveLeft() {
        setX(getX()-10);
    }

    public void moveRight() {
        setX(getX()+10);
    }

    public void draw() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

        GL11.glColor3f(1f,0f,0f);
        GL11.glBegin(GL11.GL_QUADS);

        // bottom left point
        GL11.glVertex2f(getX(),getY());

        // bottom right point
        GL11.glVertex2f(getX() + getSize(),getY());

        // top right point
        GL11.glVertex2f(getX() + getSize(),getY() + getSize());

        // top left point
        GL11.glVertex2f(getX(), getY()+getSize());
        GL11.glEnd();
    }
}
