import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Level2 extends KeyAdapter {
    /** Player variable */
    Player2 p = new Player2(692,  430, 50, 50);


    /** ArrayLists for walls, obstacles and buttons */
    ArrayList<Wall> walls = new ArrayList<Wall>();
    ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
    ArrayList<Button> buttons = new ArrayList<Button>();

    int x = 700;
    int y = 350;

    /** Slide number and responses */
    private int slideNum = 0;
    private int responseCounter = 0;

    boolean paused = false;

    /** Index of obstacle on collision */
    int collidedObstacleIndex = -1;

    int scores[] = {0, 0, 0, 0, 0, 0};
    
    /** Buttons for slide */
    Button y0;
    Button n0;
    Button y1;
    Button n1;
    Button y2;
    Button n2;

    /** Buttons for slide */
    Button y3;
    Button n3;
    Button y4;
    Button n4;
    Button y5;
    Button n5;

    /** Background image */
    BufferedImage bg;

    /** Checkmark image */
    BufferedImage checkmark;

    /** Sprites for different directions */
    BufferedImage front;
    BufferedImage back;
    BufferedImage left;
    BufferedImage right;

    /**
     * Displays level 2 based off of slide number
     * @param g graphics
     */
    public void level2(Graphics g) {

        /** Load background image */
        g.drawImage(bg, 0, 0, 1400, 700, null);

        /** Loads level based off of the slide number */
        switch(slideNum) {
            case 0:
                slide0(g);
                break;
            case 1:
                slide1(g);
                break;
            case 2:
                maze(g);
                switch(responseCounter){
                    case 1:
                        paused = true;
                        load();
                        y0Response(g);
                        p.setX(165);
                        break;
                    case -1:
                        paused = true;
                        load();
                        n0Response(g);
                        p.setX(165);
                        break;
                    case 2:
                        paused = true;
                        load();
                        y1Response(g);
                        p.setX(565);
                        break;
                    case -2:
                        paused = true;
                        load();
                        n1Response(g);
                        p.setX(565);
                        break;
                    case 3:
                        paused = true;
                        load();
                        y2Response(g);
                        p.setY(570);
                        break;
                    case -3:
                        paused = true;
                        load();
                        n2Response(g);
                        p.setY(570);
                        break;
                    case 4:
                        paused = true;
                        load();
                        y3Response(g);
                        p.setY(430);
                        break;
                    case -4:
                        paused = true;
                        load();
                        n3Response(g);
                        p.setY(430);
                        break;
                    case 5:
                        paused = true;
                        load();
                        y4Response(g);
                        p.setY(70);
                        break;
                    case -5:
                        paused = true;
                        load();
                        n4Response(g);
                        p.setY(70);
                        break;
                    case 6:
                        paused = true;
                        load();
                        y5Response(g);
                        p.setY(470);
                        break;
                    case -6:
                        paused = true;
                        load();
                        n5Response(g);
                        p.setY(470);
                        break;
                }
                break;

            case 3:
                slide3(g);
                break;
        }
    }

    /**
     * Loads the level
     */
    public void load(){
        /** Resets the player and clears obstacles */
        obstacles.clear();
        walls.clear();

        p.setMoving(true);

        Obstacle g1;
        Obstacle g2;
        Obstacle g3;

        Obstacle b1;
        Obstacle b2;
        Obstacle b3;

        try{

            checkmark = ImageIO.read(new File("./static/img/checkmark.png"));
            bg = ImageIO.read(new File("./static/img/mazebg.png"));

            g1 = new Obstacle(117, 17, 40, 40, true, ImageIO.read(new File("./static/img/github.png")));
            g2 = new Obstacle(517, 417, 40, 40, true, ImageIO.read(new File("./static/img/brawlstars.png")));
            g3 = new Obstacle(993, 517, 40, 40, true, ImageIO.read(new File("./static/img/instagram.png")));

            b1 = new Obstacle(117, 493, 40, 40, true, ImageIO.read(new File("./static/img/googlesheets.png")));
            b2 = new Obstacle(1193, 17, 40, 40, true, ImageIO.read(new File("./static/img/twitter.png")));
            b3 = new Obstacle(1303, 417, 40, 40, true, ImageIO.read(new File("./static/img/googledocs.png")));
        } catch (Exception e){
            g1 = new Obstacle(117, 17, 40, 40, true);
            g2 = new Obstacle(517, 417, 40, 40, true);
            g3 = new Obstacle(1000, 517, 40, 40, true);

            b1 = new Obstacle(117, 493, 40, 40, true);
            b2 = new Obstacle(1193, 17, 40, 40, true);
            b3 = new Obstacle(1303, 417, 40, 40, true);
        }

        obstacles.add(g1);
        obstacles.add(g2);
        obstacles.add(g3);

        obstacles.add(b1);
        obstacles.add(b2);
        obstacles.add(b3);

        walls.add(new Wall(75, 0, 25, 275));
        walls.add(new Wall(175, 175, 1000, 25));
        walls.add(new Wall(75, 75, 1000, 25));
        walls.add(new Wall(1150, 0, 25, 200));
        walls.add(new Wall(75, 275, 600, 25));
        walls.add(new Wall(750, 275, 25, 100));
        walls.add(new Wall(475, 375, 300, 25));
        walls.add(new Wall(1262, 75, 25,200));
        walls.add(new Wall(850, 275, 437, 25));
        walls.add(new Wall(850, 275, 25, 300));
        walls.add(new Wall(950, 375, 450, 25));
        walls.add(new Wall(1262, 375, 25, 175));
        walls.add(new Wall(950, 500, 25, 200));
        walls.add(new Wall(950, 475, 225, 25));
        walls.add(new Wall(750, 475, 25, 200));
        walls.add(new Wall(375, 450, 125, 25));
        walls.add(new Wall(750, 275, 25, 100));
        walls.add(new Wall(225, 375, 175, 25));
        walls.add(new Wall(475, 400, 25, 150));
        walls.add(new Wall(375, 400, 25, 75));
        walls.add(new Wall(475, 550, 175, 25));
        walls.add(new Wall(75, 550, 325, 25));
        walls.add(new Wall(75, 375, 25, 175));
    }

    /**
     * Displays slide 0
     * @param g graphics
     */
    public void slide0(Graphics g) {
        Slide s = new Slide(0, "Now that you have learned the basic fundamentals of studying for your final exams. It is time for you to put your knowledge to the test!");
        s.display(g);
    }

    /**
     * Displays slide 1
     * @param g graphics
     */
    public void slide1(Graphics g) {
        Slide s = new Slide( 0,"Control the player by using the arrow keys on your keyboard to move around the maze. Your goal is to go to all the checkpoints and answer each question correctly. If you fail a checkpoint, you will be required to go back and try again. Get all of the questions correct to unlock level 3!");
        s.display(g);
    }

    /** 
     * Displays slide 3
     * @param g graphics
     */
    public void slide3(Graphics g){
        Slide s = new Slide(1, "Congradulations! You have completed the final learning level of this game. You have proven your knowledge very well. It is time for you to tackle level 3!");
        s.display(g);

        for (int i = 0; i < scores.length; i++){
            scores[i] = 0;
        }
    }

    /**
     * Displays the maze level
     * @param g graphics
     */
    public void maze(Graphics g) {
        // checks if the player is colliding with any walls
        for (Wall w : walls){
            w.display(g);
            if (p.collided(w) != 0) {
                switch (p.collided(w)){
                    case 1:
                        p.updateX(-2);
                        break;
                    case 2:
                        p.updateY(-2);
                        break;
                    case 3:
                        p.updateX(2);
                        break;
                    case 4:
                        p.updateY(2);
                        break;
                }
            }
        }

        // finds the position of the obstacle that the player collided with in the arraylist
        int temp = -1;
        for (int i = 0; i < obstacles.size(); i++){
            obstacles.get(i).display(g);
            if (p.collided(obstacles.get(i)) != 0){
                temp = i;
            }
        }

        g.setColor(Color.BLACK);
        p.display(g);

        if (scores[0] == 1) g.drawImage(checkmark, 117, 20, 40, 32, null);
        if (scores[1] == 1) g.drawImage(checkmark, 517, 420 , 40, 32, null);
        if (scores[2] == 1) g.drawImage(checkmark, 993, 520, 40, 32, null);
        if (scores[3] == 1) g.drawImage(checkmark, 117, 496, 40, 32, null);
        if (scores[4] == 1) g.drawImage(checkmark, 1193, 20, 40, 32, null);
        if (scores[5] == 1) g.drawImage(checkmark, 1303 , 420, 40, 32, null);

        // displays the respective question according the obstacle that the player collided with
        int i = temp;
        collidedObstacleIndex = i;
        if (temp != -1 ){
            p.setMoving(false);

            switch(i){
                case 0:
                    Slide s0 = new Slide(0, true,  "Is Github a helpful resource in keeping an organized work enviornement?");
                    s0.display(g);

                    y0 = new Button("Yes", 950, 200, 300, 50);
                    n0 = new Button("No", 950, 350, 300, 50);

                    y0.display(g);
                    n0.display(g);

                    buttons.add(y0);
                    buttons.add(n0);

                    break;
                case 1:
                    Slide s1 = new Slide(0, true,  "Would the video game Brawl Stars be useful for passing your final exams?");
                    s1.display(g);

                    y1 = new Button("Yes", 950, 200, 300, 50);
                    n1 = new Button("No", 950, 350, 300, 50);

                    y1.display(g);
                    n1.display(g);

                    buttons.add(y1);
                    buttons.add(n1);

                    break;
                case 2:
                    Slide s2 = new Slide(0, true,  "Is Instagram an app that allows studens to focus better?");
                    s2.display(g);

                    y2 = new Button("Yes", 950, 200, 300, 50);
                    n2 = new Button("No", 950, 350, 300, 50);

                    y2.display(g);
                    n2.display(g);

                    buttons.add(y2);
                    buttons.add(n2);
                    
                    break;
                case 3:
                    Slide s3 = new Slide(0, true,  "Is google sheets a helpful software?");
                    s3.display(g);

                    y3 = new Button("Yes", 950, 200, 300, 50);
                    n3 = new Button("No", 950, 350, 300, 50);

                    y3.display(g);
                    n3.display(g);

                    buttons.add(y3);
                    buttons.add(n3);
                    
                    break;
                case 4:
                    Slide s4 = new Slide(0, true,  "Does twitter aid students in search of academic success?");
                    s4.display(g);

                    y4 = new Button("Yes", 950, 200, 300, 50);
                    n4 = new Button("No", 950, 350, 300, 50);

                    y4.display(g);
                    n4.display(g);

                    buttons.add(y4);
                    buttons.add(n4);
                    
                    break;
                case 5:
                    Slide s5 = new Slide(0, true,  "Is google docs a studying related application?");
                    s5.display(g);

                    y5 = new Button("Yes", 950, 200, 300, 50);
                    n5 = new Button("No", 950, 350, 300, 50);

                    y5.display(g);
                    n5.display(g);

                    buttons.add(y5);
                    buttons.add(n5);
                    
                    break;
            }
        }
    }

    /**
     * Displays the response for answer yes of slide 0
     * @param g graphics
     */
    public void y0Response(Graphics g){
        Slide s = new Slide(1,  "Correct! Github is an open source easy to use software that is very helpful. It allows programmers to easily organize their projects, keep track of code versions, and collaborate with other developers. I am glad to see that you're on the right track!");
        s.display(g);

        scores[0] = 1;
    }

    /**
     * Displays the response for answer no of slide 0
     * @param g graphics
     */
    public void n0Response(Graphics g){
        Slide s = new Slide(-1, "Incorrect, Github is an open  easy to use software that is very helpful for programmers. It allows programmers to easily organize their projects, keep track of code version, and collaborate with other developers. Revisite this checkpoint to answer correctly.");
        s.display(g);
    }

    /**
     * Displays the response for answer yes of slide 1
     * @param g graphics
     */
    public void y1Response(Graphics g){
        Slide s = new Slide(-1,  "Incorrect, Brawl Stars is a third person shooter animated video game. There is no scientific research that suggests that Brawl Stars will help students pass their exams. I hope this is not your main strategy in passing. Please revisite this checkpoint to answer correctly.");
        s.display(g);
    }

    /**
     * Displays the response for answer no of slide 1
     * @param g graphics
     */
    public void n1Response(Graphics g){
        Slide s = new Slide(1, "Correct! Brawl Stars is not an educational video game. Brawl Stars is a distraction and can prevent you from being on schedule for studying for your final exams. It is good to see that you are making the right choices for your education.");
        s.display(g);

        scores[1] = 1;
    }


    /**
     * Displays the response for answer yes of slide 2
     * @param g graphics
     */
    public void y2Response(Graphics g){
        Slide s = new Slide(-1, "Incorrect, Instagram is a social media platform whose main purpose is entertainement. Although it can be used in an educational way, studies show that excessive usage of Instagram leads to procrastination. It is recommended you limit your usage of Instagram. Please revisite this checkpoint.");
        s.display(g);
    }

    /**
     * Displays the response for answer no of slide 2
     * @param g graphics
     */
    public void n2Response(Graphics g){
        Slide s = new Slide(1, "Correct! Instagram is a not an app that will help you focus. In fact, it is the opposite, Instagram's goal is to keep you on the app as long as possible. Its excessive usage leads to procrastination. Way to stay to focused on studies!");
        s.display(g);

        scores[2] = 1;
    }

    /**
     * Displays the response for answer yes of slide 3
     * @param g graphics
     */
    public void y3Response(Graphics g){
        Slide s = new Slide(1, "Correct! Google sheets is a very useful software. The spreadsheet application allows students to create schedules and plans for studying for their final exams. This allows them to manage their time properly and put their plans into action. I hope you start using google sheets! ");
        s.display(g);
        
        scores[3] = 1;
    }

    /**
     * Displays the response for answer no of slide 3
     * @param g graphics
     */
    public void n3Response(Graphics g){
        Slide s = new Slide(-1, "Incorrect, google sheets is in fact a useful software. The google application is a spreadsheat that allows students to do many things. They can make schedules/plans and track the amount of time they spend on certain tasks. Make sure to reviste this checkpoint to answer correctly.");
        s.display(g);
    }

    /**
     * Displays the response for answer yes of slide 4
     * @param g graphics
     */
    public void y4Response(Graphics g){
        Slide s = new Slide(-1, "Incorrect, twitter does aid students in search of academic success. Although there are many educational aspects to twitter, then end product of its usage is not intended to help students. Come back to this checkpoint to answer the question correctly");
        s.display(g);
    }

    /**
     * Displays the response for answer no of slide 4
     * @param g graphics
     */
    public void n4Response(Graphics g){
        Slide s = new Slide(1, "Correct! Twitter has no direct benefits to students. There are potentially some educational aspects to twitter, notwithstanding, it is more of a distraction than anything else. Make sure to continue avoiding distractions just like twitter!");
        s.display(g);

        scores[4] = 1;
    }

    /**
     * Displays the response for answer yes of slide 5
     * @param g graphics
     */
    public void y5Response(Graphics g){
        Slide s = new Slide(1, "Correct! Google docs is a very useful google application. It may be used to organize/take notes from students' classes. Moreover, the application allows students to access their documents directly from the browser from any computer.");
        s.display(g);

        scores[5] = 1;
    }

    /**
     * displays the response for answer no of slide 5
     * @param g graphics
     */
    public void n5Response(Graphics g){
        Slide s = new Slide(-1, "Incorrect, google docs is in fact a helpful application for students. Its ease of access to documents and offline edit access allows students to take notes from anywhere. Consider using google docs as a way to study and take notes for your courses. Revisite this checkpoint.");
        s.display(g);
    }

    /**
     * sets the player movement to left
     * @param left boolean left
     */
    public void setLeft(boolean left) {
        p.left = left;
    }

    /** 
     * sets the player movement to right 
     * @param right boolean right
     */
    public void setRight(boolean right) {
        p.right = right;
    }

    /**
     * sets the player movement to up
     * @param up boolean up
     */
    public void setUp(boolean up) {
        p.up = up;
    }

    /**
     * sets the player movement to down
     * @param down boolean down
     */
    public void setDown(boolean down) {
        p.down = down;
    }

    /**
     * sets the slideNum
     * @param n slide number
     */
    public void setSlide(int n) {
        slideNum = n;
    }

    /**
     * gets the slideNum variable
     * @return slideNum
     */
    public int getSlideNum() {
        return slideNum;
    }

    /**
     * sets the responseCounter
     * @param n number of responses
     */
    public void setResponseCounter(int n){
        responseCounter = n;
    }

    /**
     * gets the responseCoutner
     * @return responseCoutner
     */
    public int getResponseCounter(){
        return responseCounter;
    }

    /**
     * gets the paused variable
     * @return paused
     */
    public boolean getPause(){
        return paused;
    }

    /**
     * sets the paused variable
     * @param b boolean paused
     */
    public void setPause(boolean b){
        paused = b;
    }

    /**
     * sets the collidedObstacleIndex
     * @param n index
     */
    public void setCollidedObstacleIndex(int n){
        collidedObstacleIndex = n;
    }

    /**
     * Gets the index of the collided obstacle in the arraylist
     * @return collidedObstacleIndex
     */
    public int getCollidedObstacleIndex(){
        return collidedObstacleIndex;
    }
}
