import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Stack;


public class DrawArea extends JPanel implements MouseListener, MouseMotionListener, ActionListener
{
    int x1, y1, x2, y2;
    Stack<MyShape> s = new Stack<MyShape>();
    boolean modify = false;

    public void startTimer()
    {
        Timer timer = new Timer(100, this);
        timer.start();
    }

    public DrawArea()
    {
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void paintComponent (Graphics g)
    {
        startTimer();

        super.paintComponent(g);
        super.setBackground(Color.WHITE);
        if (modify)
        {
            modify = false;
        }
        else
        {
            if (App.shape.equals("Rectangle"))
            {
                s.push(new Rectangle(x1, y1, x2-x1, y2-y1, App.color));
            }
            else if (App.shape.equals("Circle"))
            {
                s.push(new Circle(x1, y1, (x2-x1), (y2-y1), App.color));
            }
            else if (App.shape.equals("Arc"))
            {
                s.push(new Arc(x1, y1, x2-x1, y2-y1, App.color));
            }
        }

        for (MyShape shape : s)
        {
            g.setColor(shape.getColor());
            shape.paint(g);
        }
    }

    public void mousePressed(MouseEvent e)
    {
        x1 = e.getX();
        y1 = e.getY();
    }

    public void mouseReleased(MouseEvent e)
    {
        x2 = e.getX();
        y2 = e.getY();
        repaint();
    }

    public void mouseDragged(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseMoved(MouseEvent e) { }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (App.undo)
        {
            if (!s.empty())
            {
                s.pop();
            }
            App.undo = false;
            modify = true;
            repaint();
        }

        if (App.erase)
        {
            s.clear();
            App.erase = false;
            modify = true;
            repaint();
        }

    }
}
