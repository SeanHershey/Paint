import java.awt.*;

class Circle implements MyShape
{
    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private Color color;

    public Circle(int x, int y, int w, int h, Color c)
    {
        this.xPos = x;
        this.yPos = y;
        this.width = w;
        this.height = h;
        this.color = c;
    }

    public void setX(int xPos)
    { 
        this.xPos = xPos;
    }

    public int getX()
    {
        return xPos;
    }

    public void setY(int yPos)
    {
        this.yPos = yPos;
    }

    public int getY()
    {
        return yPos;
    }

    public int getWidth()
    {
        return width;
    } 

    public int getHeight()
    {
        return height;
    }

    public Color getColor()
    {
        return color;
    }

    public void paint(Graphics g)
    {
        g.fillOval(xPos, yPos, Math.min(width,height), Math.min(width,height));
    }
}
