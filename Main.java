import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;

/**
 * Main class for Finals Frenzy
 * Course: ICS4U0-1
 * @author Nirvan Rabbani, Sean Zhao
 */
public class Main implements MouseListener, MouseMotionListener, KeyListener {
    /** Frame */
    private JFrame frame;
    /** Drawing */
    private Drawing draw;
    /** Instance variables for levels and screens */
    private Level1 l1 = new Level1();
    private Level2 l2 = new Level2();
    private Level3 l3 = new Level3();
    private SplashScreen s = new SplashScreen();
    private MainMenu m = new MainMenu();

    /** Font used in game */
    private static Font font;

    /** Variables for the width and height of the screen */
    private int width = 1400;
    private int height = 700;

    /** Variable for game state */
    private int state = 0;

    /** Name of player */
    private static String name = null;

    /**
     * Constructor for main, initializes the frame
     */
    public Main() {
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("./static/fonts/font.otf")).deriveFont(18f);
        } catch (Exception e) {
            e.printStackTrace();
        }
        frame = new JFrame("Finals Frenzy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        draw = new Drawing();
        draw.addMouseListener(this);
        draw.addMouseMotionListener(this);
        draw.addKeyListener(this);
        draw.setFocusable(true);

        frame.add(draw);

        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void mouseDragged(MouseEvent e) {}

    public void mouseMoved(MouseEvent e) {}

    /**
     * Mouse clicked, handles mouse click events for entire game
     * @param e mouse event
     */
    public void mouseClicked(MouseEvent e) {
        /** x and y values of mouse click */
        int x = e.getX();
        int y = e.getY();

        /** handles mouse clicks for each game state */
        if (state == 0) {
            if (s.getContinueButton().isClicked(x, y)) {
                if (name != null) state = 2;
                else state = 1;
            } else if (s.getExitButton().isClicked(x, y)) {
                frame.dispose();
            }
        } else if (state == 2) {
            if (x >= 25 && x <= 129 && y >= 25 && y <= 89) {
                state = 0;
            }
            if (m.getLevelButton(1).isClicked(x, y)){
                state = 3;
            }
            else if (m.getLevelButton(2).isClicked(x, y) && m.isLevel2Locked()){
                state = 4;
                l2.load();
            }
            else if (m.getLevelButton(3).isClicked(x, y) && m.isLevel3Locked()){
                state = 5;
                l3.load();
            }
        } else if (state == 3) {
            switch(l1.getSlideNum()){
                case 0:
                    if (l1.y0.isClicked(x, y)){
                        l1.setSlide(1);
                    }
                    if (l1.n0.isClicked(x, y)){
                        l1.setSlide(2);
                    }
                    break;
                case 1:
                case 2:
                    l1.setSlide(3);
                    break;
                case 3:
                    if (l1.y1.isClicked(x, y)){
                        l1.setSlide(4);
                    }
                    if (l1.n1.isClicked(x, y)){
                        l1.setSlide(5);
                    }
                    break;
                case 4:
                case 5:
                    l1.setSlide(6);
                    break;
                case 6:
                    if (l1.y1.isClicked(x, y)){
                        l1.setSlide(7);
                    }
                    if (l1.n1.isClicked(x, y)){
                        l1.setSlide(8);
                    }
                    break;
                case 7:
                case 8:
                    state = 2;
                    m.setLevel2Locked(true);
                    l1.setSlide(0);
            }            
        } else if (state == 4){
            switch(l2.getSlideNum()) {
                case 0:
                    l2.setSlide(1);
                    break;
                case 1:
                    l2.setSlide(2);
                    break;
                case 2:
                    int sum = 0;
                    for (int n : l2.getScores()) sum += n;
                    if (sum == 6){ 
                        l2.setSlide(3);
                    }

                    if (l2.getPause()){
                        l2.getPlayer2().setMoving(true);
                        l2.load();
                        l2.setResponseCounter(0);
                        l2.setPause(false);
                        l2.setCollidedObstacleIndex(-1);
                    } else{
                        if (l2.y0 != null && l2.y0.isClicked(x, y) && l2.getCollidedObstacleIndex() == 0) l2.setResponseCounter(1);
                        else if (l2.n0 != null && l2.n0.isClicked(x, y) && l2.getCollidedObstacleIndex() == 0) l2.setResponseCounter(-1);
                        else if (l2.y1 != null && l2.y1.isClicked(x, y) && l2.getCollidedObstacleIndex() == 1) l2.setResponseCounter(2);
                        else if (l2.n1 != null && l2.n1.isClicked(x, y) && l2.getCollidedObstacleIndex() == 1) l2.setResponseCounter(-2);
                        else if (l2.y2 != null && l2.y2.isClicked(x, y) && l2.getCollidedObstacleIndex() == 2) l2.setResponseCounter(3);
                        else if (l2.n2 != null && l2.n2.isClicked(x, y) && l2.getCollidedObstacleIndex() == 2) l2.setResponseCounter(-3);
                        else if (l2.y3 != null && l2.y3.isClicked(x, y) && l2.getCollidedObstacleIndex() == 3) l2.setResponseCounter(4);
                        else if (l2.n3 != null && l2.n3.isClicked(x, y) && l2.getCollidedObstacleIndex() == 3) l2.setResponseCounter(-4);
                        else if (l2.y4 != null && l2.y4.isClicked(x, y) && l2.getCollidedObstacleIndex() == 4) l2.setResponseCounter(5);
                        else if (l2.n4 != null && l2.n4.isClicked(x, y) && l2.getCollidedObstacleIndex() == 4) l2.setResponseCounter(-5);
                        else if (l2.y5 != null && l2.y5.isClicked(x, y) && l2.getCollidedObstacleIndex() == 5) l2.setResponseCounter(6);
                        else if (l2.n5 != null && l2.n5.isClicked(x, y) && l2.getCollidedObstacleIndex() == 5) l2.setResponseCounter(-6);
                    }
                    break;
                
                case 3:
                    state = 2;
                    m.setLevel3Locked(true);
                    l2.setSlide(0);
                    break;
                }
        } else if (state == 5){
            switch(l3.getSlideNum()) {
                case 0:
                    l3.setSlide(1);
                    break;
                case 1:
                    l3.setSlide(2);
                    break;
                case 3:
                    state = 2;
                    l3.setSlide(0);
                    break;
                case 4:
                    if (l3.getYButton().isClicked(x, y)) {
                        l3.load();
                        l3.setSlide(2);
                    }
                    if (l3.getNButton().isClicked(x, y)) {
                        state = 2;
                        l3.setSlide(0);
                    }
                    break;
            }
        }
        draw.repaint();
    }

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void keyTyped(KeyEvent e) {}

    /** 
     * Handles key release
     * @param e key event
     */
    public void keyReleased(KeyEvent e) {
        if (state == 4){
            if (e.getKeyCode() == KeyEvent.VK_LEFT) l2.setLeft(false);
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) l2.setRight(false);
            if (e.getKeyCode() == KeyEvent.VK_UP) l2.setUp(false);
            if (e.getKeyCode() == KeyEvent.VK_DOWN) l2.setDown(false);
        } else if (state == 5){
            if (e.getKeyCode() == KeyEvent.VK_LEFT) l3.setLeft(false);
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) l3.setRight(false);
            if (e.getKeyCode() == KeyEvent.VK_UP) l3.setUp(false);
            if (e.getKeyCode() == KeyEvent.VK_DOWN) l3.setDown(false);
        }
    }

    /**
     * Handles key press
     * @param e key event
     */
    public void keyPressed(KeyEvent e) {
        if (state == 4){
            if (e.getKeyCode() == KeyEvent.VK_LEFT) l2.setLeft(true);
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) l2.setRight(true);
            if (e.getKeyCode() == KeyEvent.VK_UP) l2.setUp(true);
            if (e.getKeyCode() == KeyEvent.VK_DOWN) l2.setDown(true);
        } else if (state == 5){
            if (e.getKeyCode() == KeyEvent.VK_LEFT) l3.setLeft(true);
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) l3.setRight(true);
            if (e.getKeyCode() == KeyEvent.VK_UP) l3.setUp(true);
            if (e.getKeyCode() == KeyEvent.VK_DOWN) l3.setDown(true);
        }
    }

    class Drawing extends JComponent {
        /**
         * Paints each portion of the game depending on the state
         * @param g graphics
         */
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
            }
        }

        /**
         * Input dialog for entering player name
         */
        public void enterName() {
            while ((name = (JOptionPane.showInputDialog(this, "Enter your name: "))).length() > 80 || name.length() < 1) {
                JOptionPane.showMessageDialog(this, "Sorry, please enter a valid name.");
            }

            frame.setSize(width, height + 1);

            state++;

            frame.setSize(width, height);
        }
    }

    /**
     * Gets the main font of the game
     * @return font
     */
    public static Font getMainFont(){
        return font;
    }

    /**
     * Gets the name of the user
     * @return name
     */
    public static String getName(){
        return name;
    }
}