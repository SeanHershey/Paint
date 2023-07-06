import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame implements ActionListener
{
    public static Color color;
    public static String shape = "Rectangle";
    public static Boolean undo = false;
    public static Boolean erase = false;

    public static void main(String[] args) throws Exception
    {
        App win = new App();
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(800,600);
        win.setVisible(true);
        
    }

    public App() 
    {
        super("Paint App");

        // Tool Bar (south)
        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.GRAY);
        JButton b1 = new JButton("Undo");
        JButton b2 = new JButton("Erase");
        southPanel.add(b1);
        southPanel.add(b2);

        // Pallete (west)
        JPanel westPanel = new JPanel();
        westPanel.setBackground(Color.GRAY);
        String[] colors = {"Black", "Red", "Green", "Blue"};
        JComboBox<String> list = new JComboBox<>(colors);
        JRadioButton rectangle = new JRadioButton("Rectangle");
        JRadioButton circle = new JRadioButton("Circle");
        JRadioButton arc = new JRadioButton("Arc");
        rectangle.setSelected(true);
        rectangle.setBackground(Color.GRAY);
        circle.setBackground(Color.GRAY);
        arc.setBackground(Color.GRAY);
        ButtonGroup group = new ButtonGroup();
        group.add(rectangle);
        group.add(circle);
        group.add(arc);
        GridLayout grid = new GridLayout(15, 1);
        westPanel.setLayout(grid);
        westPanel.add(list);
        westPanel.add(rectangle);
        westPanel.add(circle);
        westPanel.add(arc);

        // Canvas
        JPanel centerPanel = new DrawArea();
        centerPanel.setBackground(Color.GRAY);

        // Add Panels  
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        add(southPanel, BorderLayout.SOUTH);
        add(westPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);

        // Listeners
        list.addActionListener(this);
        rectangle.addActionListener(this);
        circle.addActionListener(this);
        arc.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("Undo"))
        {
            undo = true;
        }
        else if (e.getActionCommand().equals("Erase"))
        {
            erase = true;
        }
        else if (e.getActionCommand().equals("Rectangle"))
        {
            shape = "Rectangle";
        }
        else if (e.getActionCommand().equals("Circle"))
        {
            shape = "Circle";
        }
        else if (e.getActionCommand().equals("Arc"))
        {
            shape = "Arc";
        }
        else if (e.getActionCommand().equals("comboBoxChanged"))
        {
            JComboBox tmp = (JComboBox) e.getSource();
            switch ((String) tmp.getSelectedItem()) 
            {
                case "Black":
                    color = Color.BLACK;
                    break;
                case "Green":
                    color = Color.GREEN;
                    break;
                case "Blue":
                    color = Color.BLUE;
                    break;
                case "Red":
                    color = Color.RED;
                    break;
                default:
                    break;
            }

        }
    }
}