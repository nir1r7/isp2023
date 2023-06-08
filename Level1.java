import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Level1 extends MouseAdapter {
    private int slideNum;
    int width = 1400;
    int height = 700;

    Button y0;
    Button n0;
    Button y1;
    Button n1;
    Button y2;
    Button n2;
    Button y3;
    Button n3;

    public Level1(){
        slideNum = 0;
    }

    public void slide0(Graphics g) {
        Font f1 = new Font("Serif", Font.PLAIN, 25);
        g.setFont(f1);

        try {
            BufferedImage bg = ImageIO.read(new File("./static/img/mainbackground.png"));
            Slide s = new Slide(bg, 0, "Hello " + Main.name + ", my name is Pixel! I will be helping over the coming weeks to make sure you succeed on your exams! First things first, have you been using your time efficiently? Click the answer on the right side of the screen.", true);
            s.display(g);
        } catch (Exception e) {
            // TODO: handle exception
        }

        int y = 200;

        y0 = new Button("Yes!", 950, y, 300, 50);
        n0 = new Button("Not really...", 950, y + 150, 300, 50);

        y0.display(g);
        n0.display(g);
    }

    public void slide1(Graphics g) {
        Font f1 = new Font("Serif", Font.PLAIN, 25);
        g.setFont(f1);

        try{
            BufferedImage bg = ImageIO.read(new File("./static/img/defaultDesk.png"));

            Slide s = new Slide(bg, 0, "One of the most important things that people ignore when studying is the study environment. Having a clean and organised study environment can improve your focus. Minimizing any distractions can help you use your study time more efficiently. How does your study environment look like?", true);
            s.display(g);
        } catch (Exception e){
            Slide s = new Slide(0, "One of the most important things that people ignore when studying is the study environment. Having a clean and organised study environment can improve your focus. Minimizing any distractions can help you use your study time more efficiently. How does your study environment look like?");
            s.display(g);
        }

        int y = 200;

        y1 = new Button("Organised and free of distractions!", 1000, y, 300, 50);
        n1 = new Button("Messy and full of distractions :(", 1000, y + 150, 300, 50);

        y1.display(g);
        n1.display(g);
    }

    public void slide2(Graphics g) {
        Font f1 = new Font("Serif", Font.PLAIN, 25);
        g.setFont(f1);

        try{
            BufferedImage bg = ImageIO.read(new File("./static/img/defaultSchedule.png"));

            Slide s = new Slide(bg, 0, "Another important study tip to get ready for you exams is to study on a schedule. Studying at the same time every day helps build a habit of studying faster. By sticking to a schedule, studying will become easier, almost like second nature. Do you currently have a study schedule?", true);
            s.display(g);
        } catch (Exception e){
            Slide s = new Slide(0, "Another important study tip to get ready for you exams is to study on a schedule. Studying at the same time every day helps build a habit of studying faster. By sticking to a schedule, studying will become easier, almost like second nature. Do you currently have a study schedule?");
            s.display(g);
        }

        int y = 200;

        y2 = new Button("Yes! Of Course!", 950, y, 300, 50);
        n2 = new Button("Not yet…", 950, y + 150, 300, 50);

        y2.display(g);
        n2.display(g);
    }

    public void y0Response(Graphics g){
        try{
            BufferedImage bg = ImageIO.read(new File("./static/img/goodTimeManagement.png"));
            
            Slide s = new Slide(bg, 1, "That’s great! Keep up the good work. Make sure you always start your work early, not leaving things to the last minute. This ensures that you have time to finish all assignments and projects, as well as study for exams.", false);
            s.display(g);
        } catch (Exception e){
            Slide s = new Slide(1, "That’s great! Keep up the good work. Make sure you always start your work early, not leaving things to the last minute. This ensures that you have time to finish all assignments and projects, as well as study for exams.");
            s.display(g);
        }
    }

    public void n0Response(Graphics g){
        try{
            BufferedImage bg = ImageIO.read(new File("./static/img/badTimeManagement.png"));

            Slide s = new Slide(bg, -1, "It is important to use your time wisely to make sure that everything that needs to be done is completed. Make sure to give yourself enough time to finish all assignments and projects, as well as study for exams. Trust me, I know this sucks for a lot of people. Push through! You can do it!", false);
            s.display(g);
        } catch (Exception e){
            Slide s = new Slide(-1, "It is important to use your time wisely to make sure that everything that needs to be done is completed. Make sure to give yourself enough time to finish all assignments and projects, as well as study for exams. Trust me, I know this sucks for a lot of people. Push through! You can do it!");
            s.display(g);
        }
    }

    public void y1Response(Graphics g){
        try{
            BufferedImage bg = ImageIO.read(new File("./static/img/organizedDesk.png"));

            Slide s = new Slide(bg, 1, "That’s great to hear! You’re already on track to doing spectacularly on your exams!", false);
            s.display(g);
        } catch (Exception e){
            Slide s = new Slide(1, "That’s great to hear! You’re already on track to doing spectacularly on your exams!");
            s.display(g);
        }
    }

    public void n1Response(Graphics g){
        try{
            BufferedImage bg = ImageIO.read(new File("./static/img/unorganizedDesk.png"));

            Slide s = new Slide(bg, -1, "That’s alright. While the task may seem daunting, organising your study environment is something that you only need to do once! Just take some time out of your day to clean up the space around you. You only need to do this once!", false);
            s.display(g);
        } catch (Exception e){
            Slide s = new Slide(-1, "That’s alright. While the task may seem daunting, organising your study environment is something that you only need to do once! Just take some time out of your day to clean up the space around you. You only need to do this once!");
            s.display(g);
        }
    }

    public void y2Response(Graphics g){
        try{
            BufferedImage bg = ImageIO.read(new File("./static/img/successfulSchedule.png"));

            Slide s = new Slide(bg, 1, "That’s great! Having a consistent study schedule makes it a lot easier to study effectively. Make sure to try not to miss too many days at once, as missing many days can break the schedule.", false);
            s.display(g);
        } catch (Exception e){
            Slide s = new Slide(1, "That’s great! Having a consistent study schedule makes it a lot easier to study effectively. Make sure to try not to miss too many days at once, as missing many days can break the schedule.");
            s.display(g);
        }
    }

    public void n2Response(Graphics g){
        try{
            BufferedImage bg = ImageIO.read(new File("./static/img/unsuccessfulSchedule.png"));

            Slide s = new Slide(bg, -1, "Sticking to a schedule is very important to create good study habits. Sticking to a schedule will prevent situations where you are cramming last minute. While cramming may sometimes seem to work, you can be more prone to making mistakes on the test day.", false);
            s.display(g);
        } catch (Exception e){
            Slide s = new Slide(-1, "Sticking to a schedule is very important to create good study habits. Sticking to a schedule will prevent situations where you are cramming last minute. While cramming may sometimes seem to work, you can be more prone to making mistakes on the test day.");
            s.display(g);
        }
    }

    public void level1(Graphics g) {
        switch (slideNum) {
            case 0:
                slide0(g);
                break;
            case 1:
                y0Response(g);
                break;
            case 2:
                n0Response(g);
                break;
            case 3:
                slide1(g);
                break;
            case 4:
                y1Response(g);
                break;
            case 5:
                n1Response(g);
                break;
            case 6:
                slide2(g);
                break;
            case 7:
                y2Response(g);
                break;
            case 8:
                n2Response(g);
                break;
        }
    }

    public void setSlide(int n) {
        slideNum = n;
    }

    public int getSlideNum(){
        return slideNum;
    }
}
