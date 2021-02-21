package com.company;
// Julio Costa Beyeler 21312 CA1 Temperature
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Convert {

    public static void main(String[] args)
    {
            ConvertTemp app = new ConvertTemp();
    }

}

class ConvertTemp extends JFrame implements ActionListener
{
    // Global Variables
    JTextField t1;
    JButton b;
    JLabel l1, l2;
    JRadioButton c, f;
    JPanel p1,p2;
    // Decimal value convert object
    private static DecimalFormat df1 = new DecimalFormat("#.##");

    public ConvertTemp()
    {
        // Background and button colours
        Color c1 = new Color(222, 126, 24);
        Color c2 = new Color(24, 113, 222);
        // Colour panel for JLabel
        p1 = new JPanel(new GridBagLayout());
        // GridBag layout to organize items
        p2 = new JPanel(new GridBagLayout());
        p1.setBackground(c2);
        p2.setBackground(c1);
        p1.setSize(400,50);

        // Program name label
        l1 = new JLabel("Temperature Conversion");
        l1.setForeground(Color.WHITE);

        // Celsius radio button
        c = new JRadioButton("Celsius");
        c.setBackground(c1);
        c.setForeground(Color.WHITE);

        // Fahrenheit radio button
        f = new JRadioButton("Fahrenheit");
        f.setBackground(c1);
        f.setForeground(Color.WHITE);

        // TextField to enter value for conversion
        t1 = new JTextField(20);
        t1.setBackground(c2);
        t1.setForeground(Color.WHITE);

        // JLabel where result will show
        l2 = new JLabel("0");
        l2.setForeground(Color.WHITE);

        // Button to execute conversion
        b = new JButton("Conversion");
        b.setBackground(c2);
        b.setForeground(Color.WHITE);

        // Adding radio buttons to group so that only one can be selected at a time
        ButtonGroup bg = new ButtonGroup();
        bg.add(c);
        bg.add(f);

        GridBagConstraints g = new GridBagConstraints();

        // GridBag object to organize items inside Panel
        g.insets = new Insets(10,10,10,10);
        g.gridx = 0;
        g.gridy = 1;
        p1.add(l1, g);
        add(p1);

        p2.add(p1);

        g.gridx = 0;
        g.gridy = 1;
        p2.add(c, g);

        g.gridx = 1;
        g.gridy = 1;
        p2.add(f, g);

        g.gridx = 0;
        g.gridy = 3;
        p2.add(t1, g);

        g.gridx = 0;
        g.gridy = 4;
        p2.add(l2, g);

        g.gridx = 0;
        g.gridy = 5;
        p2.add(b, g);
        add(p2);

        b.addActionListener(this);

        // JFrame properties
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(350, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(c1);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // Variable for the temperature the user types
        double temp = Integer.parseInt(t1.getText());

        if(c.isSelected()) // Radio Button
        {
            // If celsius is selected will convert to Celsius
            double result = (temp - 32) * (5.0/9.0);
            l2.setText("" + df1.format(result));
        }

        if(f.isSelected()) // Radio Button
        {
            // If fahrenheit is select will convert to Fahrenheit
            double result = (temp * (9.0/5.0)) + 32;
            l2.setText("" + df1.format(result));
        }
    }
}