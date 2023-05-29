import java.awt.*;
import java.awt.event.MouseAdapter;

public class Level1 extends MouseAdapter {
    int slideNum = 0;
    int width = 1400;
    int height = 700;
    public void level1introduction(Graphics g) {
        Font f1 = new Font("Serif", Font.PLAIN, 25);
        g.setFont(f1);

        int y = 250;

        g.drawString("Hello player, my name is Pixel! I will be helping over the coming weeks to make sure", 300, height - 150);
        g.drawString("you succeed on your exams! First things first, have you been using your time efficiently?", 300, height - 115);

        g.drawRect(width - 450, y, 300, 50);
        g.drawRect(width - 450, y + 150, 300, 50);

        g.drawString("Yes!", width - 440, y + 35);
        g.drawString("Not really...", width - 440, y + 185);
    }

    public void level1dialog(Graphics g) {
        Font f1 = new Font("Serif", Font.PLAIN, 25);
        g.setFont(f1);

        int y = 250;

        g.drawString("New Slide", 300, height - 150);
        g.drawString("you succeed on your exams! First things first, have you been using your time efficiently?", 300, height - 115);

        g.drawRect(width - 450, y, 300, 50);
        g.drawRect(width - 450, y + 150, 300, 50);
    }

    public void level1(Graphics g) {
        switch (slideNum) {
            case 0:
                level1introduction(g);
                break;
            case 1:
                level1dialog(g);
                break;
        }
    }

    public void updateSlide() {
        slideNum++;
    }
}
