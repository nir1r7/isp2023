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
    private boolean l2 = false;
    private boolean l3 = false;

    /** Level Buttons */
    private CenteredButton level1Button;
    private CenteredButton level2Button;
    private CenteredButton level3Button;

    /**
     * Displays the main menu
     * @param g
     */
    public void mainMenu(Graphics g) {
        try {
            /** Draws background */
            BufferedImage bg = ImageIO.read(new File("./static/img/mainbackground.png"));
            g.drawImage(bg, 0, 0, 1400, 700, null);
            BufferedImage back = ImageIO.read(new File("./static/img/backarrow.png"));
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

        try{
            BufferedImage locked = ImageIO.read(new File("./static/img/locked.png"));
            BufferedImage unlocked = ImageIO.read(new File("./static/img/unlocked.png"));

            g.drawImage(unlocked, 790, 205, 33, 42, null);

            if (!l2) g.drawImage(locked, 790, 285, 33, 42, null);
            else g.drawImage(unlocked, 790, 285, 33, 42, null);

            if (!l3) g.drawImage(locked, 790, 365, 33, 42, null);
            else g.drawImage(unlocked, 790, 365, 33, 42, null);
        } catch (Exception e){}
    }

    /**
     * gets the boolean l2 to see if level 2 is locked
     * @return l2
     */
    public boolean isLevel2Locked(){
        return l2;
    }

    /**
     * gets the boolean l3 to see if level 3 is locked
     * @return
     */
    public boolean isLevel3Locked(){
        return l3;
    }

    /**
     * sets the boolean l2 to b
     * @param b
     */
    public void setLevel2Locked(boolean b){
        l2 = b;
    }

    /**
     * sets teh boolean l3 to b
     * @param b
     */
    public void setLevel3Locked(boolean b){
        l3 = b;
    }

    /**
     * gets the button for the level corresponding to n
     * @param n
     * @return level1Button || level2Buton || level3Button
     */
    public Button getLevelButton(int n){
        if (n == 1) return level1Button;
        if (n == 2) return level2Button;
        return level3Button;
    }
}
