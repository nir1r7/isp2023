import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main implements MouseListener, MouseMotionListener {
    Drawing draw;
    
    int state = 0;

    boolean l2 = false;
    boolean l3 = false;

    public Main() {
        JFrame frame = new JFrame("Finals Frenzy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        draw = new Drawing();
        draw.addMouseListener(this);
        draw.addMouseMotionListener(this);
        frame.add(draw);

        frame.setSize(1920, 1080);
        frame.setVisible(true);
    }

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {
        state++;
        draw.repaint();
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    class Drawing extends JComponent{
        
        public Drawing(){

        }
        
        public void paint(Graphics g){
            if (state == 0){
                splashScreen(g);
            }
            else if (state == 1){
                enterName(g);
            }
            else if (state == 2){
                
            }
        }

        public void splashScreen(Graphics g){
            g.fillRect(0, 0, 100, 100);
        }

        public void enterName(Graphics g){
            g.drawString("TESTINGZ", 300,300);
        }
    }
}
