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

    String name;

    int x = 700; int y = 350;
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
        if (state == 0 && e.getX() >= 580 && e.getX() <= 780 && e.getY() >= 500 && e.getY() <= 550){
            state++;
        }

        else if(state == 2 && e.getX() >= 512 && e.getX() <= 812 && e.getY() >= 200 && e.getY() <= 250){
            state++;
        }
        else if (state == 3){
            if ((e.getX() >= 250 && e.getX() <= 1 && e.getY() >= 1 && e.getY() <= 1) ||
                (e.getX() >= 250 && e.getX() <= 550 && e.getY() >= 250 && e.getY() <= 300)){
                state++;
            }
        }
        else if (state == 4){

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
        System.out.println(keyCode);
    }

    public void keyReleased(KeyEvent e) {

    }


    class Drawing extends JComponent{
        
        public Drawing(){

        }

        public void paint(Graphics g){
            switch(state){
                case 0: splashScreen(g); break;
                case 1: enterName(); break;
                case 2: mainMenu(g); break;
                case 3: level1introduction(g); break;
                case 4: break;
                case 5: break;
                case 6: break;
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

        public void enterName(){
            name = (JOptionPane.showInputDialog(this, "Enter your name: ")); // make sure to error trap

            frame.setSize(width, height+1);
          
            state++;

            frame.setSize(width, height);
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
          
        public void level1introduction(Graphics g){
            Font f1 = new Font("Serif", Font.PLAIN, 25);
            draw.setFont(f1);

            int y = 250;

            g.drawString("Hello " + name + ", my name is Pixel! I will be helping over the coming weeks to make sure", 300, height - 150);
            g.drawString("you succeed on your exams! First things first, have you been using your time efficiently?", 300, height - 115);

            g.drawRect(width - 450, y, 300, 50);
            g.drawRect(width - 450, y + 150, 300, 50);

            g.drawString("Yes!", width - 440, y + 35);
            g.drawString("Not really...", width - 440, y + 185);
        }

        public void level1YesNo(int stateNum, boolean ans){
            switch(stateNum){
                case 4:
                    if (ans){

                    }
                    else{

                    }
                    break;
                case 5:
            }
        }
    }
}
