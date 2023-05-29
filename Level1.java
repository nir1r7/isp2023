import java.awt.*;
import java.awt.event.MouseAdapter;

public class Level1 extends MouseAdapter {
    int slideNum = 0;
    int width = 1400;
    int height = 700;

    public void level1introduction(Graphics g) {
        Font f1 = new Font("Serif", Font.PLAIN, 25);
        g.setFont(f1);

        Slide s = new Slide("Hello player, my name is Pixel! I will be helping over the coming weeks to make sure " + 
        "you succeed on your exams! First things first, have you been using your time efficiently?");
        s.display(g);

        int y = 250;

        Button b1 = new Button("Yes!", 950, y, 300, 50);
        Button b2 = new Button("Not really...", 950, y + 150, 300, 50);

        b1.display(g);
        b2.display(g);
    }

    public void level1dialog(Graphics g) {
        Font f1 = new Font("Serif", Font.PLAIN, 25);
        g.setFont(f1);

        Slide s = new Slide("Text goes here:");
        s.display(g);

        int y = 250;

        Button b1 = new Button("Organised and free of distractions!", 950, y, 300, 50);
        Button b2 = new Button("Messy and full of distractions :(", 950, y + 150, 300, 50);

        b1.display(g);
        b2.display(g);
    }

    public void level1(Graphics g) {
        switch (slideNum) {
            case 0:
                level1introduction(g);
                break;
            case 1:
                level1dialog(g);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }

    public void updateSlide() {
        slideNum++;
    }

    public int getSlideNum(){
        return slideNum;
    }
}
