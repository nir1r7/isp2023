import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main implements MouseListener, MouseMotionListener, KeyListener {
    JFrame frame;
    Drawing draw;

    int width = 1400;
    int height = 700;
    
    int state = 0;

    boolean l2 = false;
    boolean l3 = false;

    public Main() {
        frame = new JFrame("Finals Frenzy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        draw = new Drawing();
        draw.addMouseListener(this);
        draw.addMouseMotionListener(this);
        frame.add(draw);

        frame.setSize(width, height);
        frame.setVisible(true);
    }

    public void mouseDragged(MouseEvent e) {
        
    }

    public void mouseMoved(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {
        if (state == 0 && e.getX() >= 580 && e.getX() <= 780 && e.getY() >= 500 && e.getY() <= 550){
            state++;
        }
        else if (true){}

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

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

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
                state++; // temporary
            }
            else if (state == 2){
                mainMenu(g);
            }
        }

        public void splashScreen(Graphics g){
            Font f1 = new Font("Serif", Font.PLAIN,  18);
            g.setFont(f1);
            g.setColor(Color.BLACK);

            g.drawString("Elevens Labs presents:", 600, 180);

            Font f2 = new Font("Serif", Font.BOLD,  100);
            g.setFont(f2);
            g.setColor(Color.RED);

            g.drawString("Finals Frenzy", 380, 300);

            Font f3 = new Font("Serif", Font.PLAIN,  30);
            g.setFont(f3);
            g.setColor(Color.BLACK);

            g.drawRect(580, 500, 200, 50);
            g.drawString("Continue", 620, 535);        
        }

        public void enterName(Graphics g){
            g.drawString("TESTINGZ", 300,300);

            // Not possible (at least i dont think so)
        }

        public void mainMenu(Graphics g){
            Font f1 = new Font("Serif", Font.BOLD,  45);
            g.setFont(f1);
            g.setColor(Color.BLACK);

            g.drawString("Main Menu", 555, 120);

            Font f2 = new Font("Serif", Font.PLAIN,  30);
            g.setFont(f2);
            g.setColor(Color.BLACK);
            
            for (int i = 0; i < 3; i++){
                g.drawRect(512, 200 + i*80,  300,50);
                g.drawString("Level " + (i + 1), 620, 235 + i*80);
            }

            int x = 780;
            int y = 295;
            if (!l2){
                g.drawLine(x,y, x + 20,y + 20);
                g.drawLine(x,y + 20, x + 20,y);
            }
            if (!l3){
                g.drawLine(x,y + 80, x + 20,y + 100);
                g.drawLine(x,y + 100, x + 20,y + 80);
            }
        }
    }
}
