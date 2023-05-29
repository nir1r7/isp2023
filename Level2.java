import java.awt.*;
import java.awt.event.KeyAdapter;

public class Level2 extends KeyAdapter {

    int x = 700;
    int y = 350;
    int score = 0;
    public void level2(Graphics g) {
        g.drawString("This is level 2, click again to go to level 3", 200, 200);
    }

}
