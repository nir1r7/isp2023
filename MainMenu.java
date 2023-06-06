import java.awt.*;

public class MainMenu {
    boolean l2 = true;
    boolean l3 = false;

    CenteredButton level1Button;
    CenteredButton level2Button;
    CenteredButton level3Button;

    public void mainMenu(Graphics g) {
        Font f1 = new Font("Serif", Font.BOLD, 45);
        g.setFont(f1);
        g.setColor(Color.BLACK);

        g.drawString("Main Menu", 555, 120);

        Font f2 = new Font("Serif", Font.PLAIN, 30);
        g.setFont(f2);
        g.setColor(Color.BLACK);

        level1Button = new CenteredButton("Level 1", 512, 200, 300, 50);
        level2Button = new CenteredButton("Level 2", 512, 280, 300, 50);
        level3Button = new CenteredButton("Level 3", 512, 360, 300, 50);

        level1Button.display(g);
        level2Button.display(g);
        level3Button.display(g);

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
