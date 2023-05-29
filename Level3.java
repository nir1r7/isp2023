import java.awt.*;
import java.awt.event.KeyAdapter;

public class Level3 extends KeyAdapter {

    int x = 700;
    int y = 350;
    int score = 0;
    public void level3(Graphics g) {
        g.fillRect(x, y, 20, 20);
    }

    public void updateX(int x) {
        this.x += x;
    }

    public void updateY(int y) {
        this.y += y;
    }
}
