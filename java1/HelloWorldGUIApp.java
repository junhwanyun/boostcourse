import javax.swing.*;   
import java.awt.Dimension;
import java.awt.Toolkit;

public class HelloWorldGUIApp{
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Hello World GUI");

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(new Dimension(777, 777));

                JLabel label = new JLabel("Hello World!", SwingConstants.CENTER);

                frame.getContentPane().add(label);

                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

                frame.setLocation(dim.width / 2 - 777 / 2, dim.height / 2 - 777 / 2);

                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}