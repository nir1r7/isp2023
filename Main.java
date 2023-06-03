import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main implements MouseListener, MouseMotionListener, KeyListener {
    JFrame frame;
    Drawing draw;
    Level1 l1 = new Level1();
    Level2 l2 = new Level2();
    Level3 l3 = new Level3();
    SplashScreen s = new SplashScreen();
    MainMenu m = new MainMenu();


    int width = 1400;
    int height = 700;

    int state = 0;

    String name;

    public Main() {
        frame = new JFrame("Finals Frenzy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        draw = new Drawing();
        draw.addMouseListener(this);
        draw.addMouseMotionListener(this);
        draw.addKeyListener(this);
        draw.setFocusable(true);

        frame.add(draw);

        frame.setSize(width, height);
        frame.setVisible(true);
    }

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {
        if (state == 0 && e.getX() >= 580 && e.getX() <= 780 && e.getY() >= 500 && e.getY() <= 550) {
            state = 2;
        } else if (state == 2 && e.getX() >= 512 && e.getX() <= 812 && e.getY() >= 200 && e.getY() <= 250) {
            state = 3;
        } else if (state == 3) {

            // only the slides with buttons
            switch(l1.getSlideNum()){
                case 0:
                    if (l1.y0.isClicked(e.getX(), e.getY())){
                        l1.setSlide(1);
                    }
                    if (l1.n0.isClicked(e.getX(), e.getY())){
                        l1.setSlide(2);
                    }
                    break;
                case 1:
                case 2:
                    l1.setSlide(3);
                    break;
                case 3:
                    if (l1.y1.isClicked(e.getX(), e.getY())){
                        l1.setSlide(4);
                    }
                    if (l1.n1.isClicked(e.getX(), e.getY())){
                        l1.setSlide(5);
                    }
                    break;
                case 4:
                case 5:
                    l1.setSlide(6);
                case 6:
                    if (l1.y1.isClicked(e.getX(), e.getY())){
                        l1.setSlide(7);
                    }
                    if (l1.n1.isClicked(e.getX(), e.getY())){
                        l1.setSlide(8);
                    }
                    break;
                case 7:
                case 8:
                    state = 2;
                    m.l2 = true;
            }
            
            
        } else if (state == 4){
            state++;
        } else if (state == 5){

        }
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

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) l3.setLeft(false);
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) l3.setRight(false);
        if (e.getKeyCode() == KeyEvent.VK_UP) l3.setUp(false);
        if (e.getKeyCode() == KeyEvent.VK_DOWN) l3.setDown(false);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) l3.setLeft(true);
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) l3.setRight(true);
        if (e.getKeyCode() == KeyEvent.VK_UP) l3.setUp(true);
        if (e.getKeyCode() == KeyEvent.VK_DOWN) l3.setDown(true);
    }

    public void updateState() {
        state++;
    }

    class Drawing extends JComponent {

        public Drawing() {

        }

        public void paint(Graphics g) {
            switch(state){
                case 0:
                    s.splashScreen(g);
                    break;
                case 1:
                    enterName();
                    break;
                case 2:
                    m.mainMenu(g);
                    break;
                case 3:
                    l1.level1(g);
                    repaint();
                    break;
                case 4:
                    l2.level2(g);
                    repaint();
                    break;
                case 5:
                    l3.level3(g);
                    repaint();
                    break;
                case 6:
                case 7:
            }
        }

        public void enterName() {
            name = (JOptionPane.showInputDialog(this, "Enter your name: ")); //TODO errortrap input

            frame.setSize(width, height + 1);

            state++;

            frame.setSize(width, height);
        }
    }
}