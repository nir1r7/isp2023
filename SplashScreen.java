import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * Splash screen class for Finals Frenzy, displays the splash screen
 * Course: ICS4U0-1
 * @author Nirvan Rabbani, Sean Zhao
 */
public class SplashScreen {
    /** Continue button */
    CenteredButton cont;
    CenteredButton exit;

    /**
     * Displays the splash screen
     * @param g graphics
     */
    public void splashScreen(Graphics g) {
        BufferedImage bg;
        BufferedImage logo;
        try {
            bg = ImageIO.read(new File("./static/img/mainbackground.png"));
            logo = ImageIO.read(new File("./static/img/logo.png"));
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("./static/fonts/font.otf")).deriveFont(20f);

            g.drawImage(bg, 0, 0, 1400, 700, null);
            g.setFont(font);
            g.setColor(Color.WHITE);
            g.drawString("Elevens Labs presents:", 580, 180);

            g.drawImage(logo, 75, 100, 1250, 500, null);

            Font f3 = new Font("Serif", Font.PLAIN, 27);
            g.setFont(f3);
            g.setColor(Color.BLACK);

            cont = new CenteredButton("Continue", 600, 475, 200, 50);
            cont.display(g);

            exit = new CenteredButton("Exit", 600, 550, 200, 50);
            exit.display(g);
        } catch (Exception e){}
    }
}
