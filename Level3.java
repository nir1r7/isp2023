import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Level3 extends KeyAdapter {
    int x = 700;
    int y = 350;
    public void level3(Graphics g) {
        g.fillRect(x, y, 20, 20);
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
}
