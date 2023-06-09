import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * Slide class for Finals Frenzy, creates a slide used in the game
 * Course: ICS4U0-1
 * @author Nirvan Rabbani, Sean Zhao
 */
public class Slide {
    String txt;

    /** Emotion of pixel in the slide */
    int emote;

    /** Background image */
    BufferedImage bg;
    boolean hasbg = false;

    boolean button;

    /**
     * Slide constructor
     * @param background background image
     * @param n emotion
     * @param text text on slide
     * @param b has button or not
     */
    public Slide (BufferedImage background, int n, String text, boolean b){
        txt = text;
        emote = n;
        bg = background;
        hasbg = true;
        button = b;
    }

    /**
     * Slide constructor
     * @param n emotion
     * @param b has button or not
     * @param text text on slide
     */
    public Slide (int n, boolean b, String text){
        txt = text;
        emote = n;
        button = b;
    }

    /**
     * Slide constructor
     * @param n emotion
     * @param text text on slide
     */
    public Slide(int n, String text){
        txt = text;
        emote = n;
    }
    
    /**
     * Slide constructor
     * @param text text on slide
     */
    public Slide(String text){
        txt = text;
        emote = 0;
    }

    /**
     * Slide constructor
     */
    public Slide(){
        txt = "";
    }

    /**
     * Displays the slide
     * @param g
     */
    public void display(Graphics g){
        g.setFont(Main.font);

        int y = 535;
        int x = 300;

        String[] words = txt.split(" ");
        String[] lines = {"", "", "", ""};

        int charCount = 0;
        int index = 0;

        /** Displays text background */
        g.setColor(Color.WHITE);
        g.fillRoundRect(0, 500, 1400, 250, 10, 10);

        g.setColor(Color.BLACK);

        /** Displays text */
        for (int i = 0; i < words.length; i++){
            if (charCount + words[i].length() > 90){
                g.drawString(lines[index], x, y);

                y += 35;
                index++;
                charCount = 0;
            }

            lines[index] += words[i] + " ";
            charCount += words[i].length() + 1;
        }
        g.drawString(lines[index], x, y);

        try {
            /** Draws the bot image */
            BufferedImage bot;
            switch (emote){
                case -1: 
                    bot = ImageIO.read(new File("./static/img/sadBot.png"));
                    break;
                case 1:
                    bot = ImageIO.read(new File("./static/img/happyBot.png"));
                    break;
                default:
                    bot = ImageIO.read(new File("./static/img/defaultBot.png"));
            }

            if (hasbg){
                g.drawImage(bg, 0, 0, 1400, 500, null);
            }

            /** Draws logo */
            BufferedImage logo = ImageIO.read(new File("./static/img/Elevanslogo.png"));
            g.drawImage(bot, 50, 380, 190, 210, null);
            g.drawImage(logo, 1270, 20, 100, 100, null);

            if (!button) {
                g.setFont(Font.createFont(Font.TRUETYPE_FONT, new File("./static/fonts/font.otf")).deriveFont(14f));
                g.drawString("Click to continue...", 625, 650);
            }
        } catch (Exception e) {}
    }
}