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
            state++;
        } else if (state == 2 && e.getX() >= 512 && e.getX() <= 812 && e.getY() >= 200 && e.getY() <= 250) {
            state++;
        } else if (state == 3) {
            l1.updateSlide();
            //state++;
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

    public void keyPressed(KeyEvent e) {
        if (state == 5) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_UP:
                    l3.updateY(-10);
                    System.out.println("UP");
                    break;
                case KeyEvent.VK_DOWN:
                    l3.updateY(10);
                    System.out.println("DOWN");
                    break;
                case KeyEvent.VK_LEFT:
                    l3.updateX(-10);
                    System.out.println("LEFT");
                    break;
                case KeyEvent.VK_RIGHT:
                    l3.updateX(10);
                    System.out.println("RIGHT");
                    break;
            }
        }
    }

    public void keyReleased(KeyEvent e) {

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