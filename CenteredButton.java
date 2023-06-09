import java.awt.*;

/**
 * Centered BUtton class for Finals Frenzy, creates buttons with centered text
 * Course: ICS4U0-1
 * @author Nirvan Rabbani, Sean Zhao
 */
public class CenteredButton extends Button {

    /**
     * Centered button constructor
     * @param text text of button
     * @param x x value of button
     * @param y y value of button
     * @param w width of button
     * @param h height of button
     */
    public CenteredButton(String text, int x, int y, int w, int h) {
        super(text, x, y, w, h);
    }

    /**
     * Displays the centered button
     * @param g graphics
     */
    public void display(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRoundRect(x, y, w, h, 10, 10);

        x += 30;
        y += 35;

        String[] words = txt.split(" ");
        String[] lines = { "", "", "", "" };

        int charCount = 0;
        int index = 0;

        g.setColor(Color.BLACK);
        g.setFont(Main.font);
        /** Displays text in lines, centered */
        for (int i = 0; i < words.length; i++) {
            if (charCount + words[i].length() > w / 10) {

                String whiteSpace = "";
                for (int j = 0; j < (w / 10 - charCount) / 2 + 1; i++) {
                    whiteSpace += ' ';
                }

                g.drawString(whiteSpace + lines[index], x, y);

                y += 35;
                h += 40;
                index++;
                charCount = 0;
            }

            lines[index] += words[i] + " ";
            charCount += words[i].length() + 1;
        }
        String whiteSpace = "";
        for (int j = 0; j < (w / 10 - charCount) / 2; j++) {
            whiteSpace += ' ';
        }

        g.drawString(whiteSpace + lines[index], x, y);

        x -= 10;
        y -= (index + 1) * 35;   
    }
}
