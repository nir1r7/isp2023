import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * Splash screen class for Finals Frenzy, displays the splash screen
 * Course: ICS4U0-1
 * @author Nirvan Rabbani, Sean Zhao
 */
public class Credits {
    public void credits(Graphics g) {
        BufferedImage bg;
        try {
            bg = ImageIO.read(new File("./static/img/mainbackground.png"));
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("./static/fonts/font.otf")).deriveFont(50f);

            g.drawImage(bg, 0, 0, 1400, 700, null);
            g.setFont(font);
            g.setColor(Color.WHITE);
            g.drawString("Credits", 580, 180);
        } catch (Exception e){}
    }
}
