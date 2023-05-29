import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main implements MouseListener, MouseMotionListener, KeyListener {
    JFrame frame;
    Drawing draw;
    Level1 l1 = new Level1();
    SplashScreen s = new SplashScreen();
    MainMenu m = new MainMenu();


    int width = 1400;
    int height = 700;

    int state = 0;


    String name;

    int x = 700;
    int y = 350;
    int score = 0;

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
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                y -= 10;
                System.out.println("UP");
                break;
            case KeyEvent.VK_DOWN:
                y += 10;
                System.out.println("DOWN");
                break;
            case KeyEvent.VK_LEFT:
                x -= 10;
                System.out.println("LEFT");
                break;
            case KeyEvent.VK_RIGHT:
                x += 10;
                System.out.println("RIGHT");
                break;
        }
    }

    public void keyReleased(KeyEvent e) {

    }


    class Drawing extends JComponent {

        public Drawing() {

        }

        public void paint(Graphics g) {
            if (state == 0) {
                s.splashScreen(g);
            } else if (state == 1) {
                enterName();
            } else if (state == 2) {
                m.mainMenu(g);
            } else if (state == 3) {
                l1.level1(g);
                repaint();
            }
        }



        public void enterName() {
            name = (JOptionPane.showInputDialog(this, "Enter your name: ")); // make sure to error trap

            frame.setSize(width, height + 1);

            state++;

            frame.setSize(width, height);
        }



        public void level3(Graphics g) {
            g.fillRect(x, y, 20, 20);
        }
    }
}