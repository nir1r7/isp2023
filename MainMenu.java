import java.awt.*;

public class MainMenu {
    boolean l2 = false;
    boolean l3 = false;
    public void mainMenu(Graphics g) {
        Font f1 = new Font("Serif", Font.BOLD, 45);
        g.setFont(f1);
        g.setColor(Color.BLACK);

        g.drawString("Main Menu", 555, 120);

        Font f2 = new Font("Serif", Font.PLAIN, 30);
        g.setFont(f2);
        g.setColor(Color.BLACK);

        for (int i = 0; i < 3; i++) {
            g.drawRect(512, 200 + i * 80, 300, 50);
            g.drawString("Level " + (i + 1), 620, 235 + i * 80);
        }

        int x = 780;
        int y = 295;
        if (!l2) {
            g.drawLine(x, y, x + 20, y + 20);
            g.drawLine(x, y + 20, x + 20, y);
        }
        if (!l3) {
            g.drawLine(x, y + 80, x + 20, y + 100);
            g.drawLine(x, y + 100, x + 20, y + 80);
        }
    }
}
