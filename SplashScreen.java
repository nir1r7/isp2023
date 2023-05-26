import java.awt.*;

public class SplashScreen {
    public void splashScreen(Graphics g) {
        Font f1 = new Font("Serif", Font.PLAIN, 18);
        g.setFont(f1);
        g.setColor(Color.BLACK);

        g.drawString("Elevens Labs presents:", 600, 180);

        Font f2 = new Font("Serif", Font.BOLD, 100);
        g.setFont(f2);
        g.setColor(Color.RED);

        g.drawString("Finals Frenzy", 380, 300);

        Font f3 = new Font("Serif", Font.PLAIN, 30);
        g.setFont(f3);
        g.setColor(Color.BLACK);

        g.drawRect(580, 500, 200, 50);
        g.drawString("Continue", 620, 535);
    }
}
