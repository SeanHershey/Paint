import java.awt.*;

public interface MyShape {
    public void setX(int xPos);

    public int getX();

    public void setY(int yPos);

    public int getY();

    public int getWidth();

    public int getHeight();

    public Color getColor();

    public void paint(Graphics g);
}
