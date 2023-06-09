import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * Main menu class for Finals Frenzy, displays the main menu
 * Course: ICS4U0-1
 * @author Nirvan Rabbani, Sean Zhao
 */
public class MainMenu {
    /** booleans for locking level 2 and level 3 */
    boolean l2 = false;
    boolean l3 = false;

    /** Buttons */
    CenteredButton level1Button;
    CenteredButton level2Button;
    CenteredButton level3Button;

    /**
     * Displays the main menu
     * @param g
     */
    public void mainMenu(Graphics g) {
        try {
            /** Draws background */
            BufferedImage bg = ImageIO.read(new File("./static/img/mainbackground.png"));
            g.drawImage(bg, 0, 0, 1400, 700, null);
            BufferedImage back = ImageIO.read(new File("./static/img/back.png"));
            g.drawImage(back, 25, 25, 104, 64, null);
            Font larger = Font.createFont(Font.TRUETYPE_FONT, new File("./static/fonts/stress.ttf")).deriveFont(50f);
            g.setFont(larger);
        } catch (Exception e) {}
        g.setColor(Color.WHITE);

        g.drawString("Main Menu", 590, 120);

        /** Creates buttons */
        level1Button = new CenteredButton("Level 1", 550, 200, 300, 50);
        level2Button = new CenteredButton("Level 2", 550, 280, 300, 50);
        level3Button = new CenteredButton("Level 3", 550, 360, 300, 50);

        level1Button.display(g);
        level2Button.display(g);
        level3Button.display(g);

        /** Draws 'x's indicating locked */
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
