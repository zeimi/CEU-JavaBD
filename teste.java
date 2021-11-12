import javax.swing.*;

import java.awt.*;

class BackgroundImageJFrame extends JFrame
{

    JButton b1;
    JLabel l1;

    public BackgroundImageJFrame() {

        setSize(400,400);
        setVisible(true);

        setLayout(new BorderLayout());

        JLabel background = new JLabel(new ImageIcon("img/img1.png"));

        add(background);

        background.setLayout(new FlowLayout());

        l1=new JLabel("Here is a button");
        b1=new JButton("I am a button");

        background.add(l1);
        background.add(b1);
        pack();

        
        
    }

    public static void main(String args[]) 
    {
        new BackgroundImageJFrame();
    }
}
