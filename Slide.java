import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Slide {
    String txt;
    
    public Slide(String text){
        txt = text;
    }

    public Slide(){
        txt = "";
    }

    public void display(Graphics g){
        Font f1 = new Font("Serif", Font.PLAIN, 25);
        g.setFont(f1);

        int y = 550;
        int x = 300;

        String[] words = txt.split(" ");
        String[] lines = {"", "", "", ""};

        int charCount = 0;
        int index = 0;

        g.setColor(Color.WHITE);
        g.fillRect(0, 500, 1400, 250);

        g.setColor(Color.BLACK);

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
            BufferedImage bot = ImageIO.read(new File("./static/img/pixelbot.png"));
            BufferedImage logo = ImageIO.read(new File("./static/img/Elevanslogo.png"));

            g.drawImage(bot, 50, 380, 190, 210, null);
            g.drawImage(logo, 1270, 20, 100, 100, null);

        } catch (Exception e) {}
    }
}