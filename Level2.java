import java.awt.*;
import java.awt.event.KeyAdapter;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Level2 extends KeyAdapter {
    /** Player variable */
    Player p;

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

    /**
     * Displays level 2 based off of slide number
     * @param g graphics
     */
    public void level2(Graphics g) {
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
                        break;
                    case -1:
                        paused = true;
                        load();
                        n0Response(g);
                        break;
                    case 2:
                        paused = true;
                        load();
                        y1Response(g);
                        break;
                    case -2:
                        paused = true;
                        load();
                        n1Response(g);
                        break;
                    case 3:
                        paused = true;
                        load();
                        y2Response(g);
                        break;
                    case -3:
                        paused = true;
                        load();
                        n2Response(g);
                        break;
                    case 4:
                        paused = true;
                        load();
                        y3Response(g);
                        break;
                    case -4:
                        paused = true;
                        load();
                        n3Response(g);
                        break;
                    case 5:
                        paused = true;
                        load();
                        y4Response(g);
                        break;
                    case -5:
                    paused = true;
                        load();
                        n4Response(g);
                        break;
                    case 6:
                        paused = true;
                        load();
                        y5Response(g);
                        break;
                    case -6:
                        paused = true;
                        load();
                        n5Response(g);
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
        p = new Player(600, 300);
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
        walls.add(new Wall(500, 375, 275, 25));
        walls.add(new Wall(1262, 75, 25,225));
        walls.add(new Wall(850, 275, 412, 25));
        walls.add(new Wall(850, 275, 25, 300));
        walls.add(new Wall(950, 375, 450, 25));
        walls.add(new Wall(1262, 375, 25, 200));
        walls.add(new Wall(950, 500, 25, 175));
        walls.add(new Wall(950, 475, 225, 25));
        walls.add(new Wall(750, 475, 25, 200));
        walls.add(new Wall(375, 450, 100, 25));
        walls.add(new Wall(750, 275, 25, 100));
        walls.add(new Wall(225, 375, 175, 25));
        walls.add(new Wall(475, 375, 25, 200));
        walls.add(new Wall(375, 400, 25, 75));
        walls.add(new Wall(500, 550, 150, 25));
        walls.add(new Wall(75, 550, 325, 25));
        walls.add(new Wall(75, 375, 25, 175));
    }

    /**
     * Displays slide 0
     * @param g graphics
     */
    public void slide0(Graphics g) {
        Slide s = new Slide(0, "need to write this txt");
        s.display(g);
    }

    /**
     * Displays slide 1
     * @param g graphics
     */
    public void slide1(Graphics g) {
        Slide s = new Slide(0,"Control the player by using your arrow keys to move around the screen. Your goal is to go to all the stations in the maze and answer a series of questions.");
        s.display(g);
    }

    /** 
     * Displays slide 3
     * @param g graphics
     */
    public void slide3(Graphics g){
        Slide s = new Slide(0, "Congradulations! You have completed the final learning level of this game. Now it is time for you to play the real game");
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
                        p.updateX(-1);
                        break;
                    case 2:
                        p.updateY(-1);
                        break;
                    case 3:
                        p.updateX(1);
                        break;
                    case 4:
                        p.updateY(1);
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

        // displays the respective question according the obstacle that the player collided with
        int i = temp;
        collidedObstacleIndex = i;
        if (temp != -1 ){
            p.setMoving(false);

            switch(i){
                case 0:
                    Slide s0 = new Slide(1, true,  "Is Github a helpful resource in keeping an organized work enviornement?");
                    s0.display(g);

                    y0 = new Button("Yes 0", 950, 200, 300, 50);
                    n0 = new Button("No 0", 950, 350, 300, 50);

                    y0.display(g);
                    n0.display(g);

                    buttons.add(y0);
                    buttons.add(n0);

                    break;
                case 1:
                    Slide s1 = new Slide(1, true,  "Is brawl stars good?");
                    s1.display(g);

                    y1 = new Button("Yes 1", 950, 200, 300, 50);
                    n1 = new Button("No 1", 950, 350, 300, 50);

                    y1.display(g);
                    n1.display(g);

                    buttons.add(y1);
                    buttons.add(n1);

                    break;
                case 2:
                    Slide s2 = new Slide(1, true,  "It Instagram good?");
                    s2.display(g);

                    y2 = new Button("Yes 2", 950, 200, 300, 50);
                    n2 = new Button("No 2", 950, 350, 300, 50);

                    y2.display(g);
                    n2.display(g);

                    buttons.add(y2);
                    buttons.add(n2);
                    
                    break;
                case 3:
                    Slide s3 = new Slide(-1, true,  "Is google sheets good?");
                    s3.display(g);

                    y3 = new Button("Yes 3", 950, 200, 300, 50);
                    n3 = new Button("No 3", 950, 350, 300, 50);

                    y3.display(g);
                    n3.display(g);

                    buttons.add(y3);
                    buttons.add(n3);
                    
                    break;
                case 4:
                    Slide s4 = new Slide(-1, true,  "Is twitter good?");
                    s4.display(g);

                    y4 = new Button("Yes 4", 950, 200, 300, 50);
                    n4 = new Button("No 4", 950, 350, 300, 50);

                    y4.display(g);
                    n4.display(g);

                    buttons.add(y4);
                    buttons.add(n4);
                    
                    break;
                case 5:
                    Slide s5 = new Slide(-1, true,  "Is google docs good?");
                    s5.display(g);

                    y5 = new Button("Yes 5", 950, 200, 300, 50);
                    n5 = new Button("No 5", 950, 350, 300, 50);

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
        Slide s = new Slide(-1, "Incorrect. Github is an open  easy to use software that is very helpful for programmers. It allows programmers to easily organize their projects, keep track of code version, and collaborate with otjer developers. Revisite this checkpoint to answer correctly.");
        s.display(g);
    }

    /**
     * Displays the response for answer yes of slide 1
     * @param g graphics
     */
    public void y1Response(Graphics g){
        Slide s = new Slide(1,  "Correct, brawl stars is bad");
        s.display(g);

        scores[1] = 1;
    }

    /**
     * Displays the response for answer no of slide 1
     * @param g graphics
     */
    public void n1Response(Graphics g){
        Slide s = new Slide(-1, "Incorrect, brawl stars is bad, revisite");
        s.display(g);
    }


    /**
     * Displays the response for answer yes of slide 2
     * @param g graphics
     */
    public void y2Response(Graphics g){
        Slide s = new Slide(1, "Correct! Instagram is a distraction");
        s.display(g);
        
        scores[2] = 1;
    }

    /**
     * Displays the response for answer no of slide 2
     * @param g graphics
     */
    public void n2Response(Graphics g){
        Slide s = new Slide(-1, "Incorrect! Instagram is a distraction, revisite");
        s.display(g);
    }

    /**
     * Displays the response for answer yes of slide 3
     * @param g graphics
     */
    public void y3Response(Graphics g){
        Slide s = new Slide(1, "Correct! Using google sheets for schedules can help you manage your time properly and finish your assignements on time...");
        s.display(g);
        
        scores[3] = 1;
    }

    /**
     * Displays the response for answer no of slide 3
     * @param g graphics
     */
    public void n3Response(Graphics g){
        Slide s = new Slide(-1, "Incorrect! Using google sheets... revisite");
        s.display(g);
        
    }

    /**
     * Displays the response for answer yes of slide 4
     * @param g graphics
     */
    public void y4Response(Graphics g){
        Slide s = new Slide(1, "twitter is bad");
        s.display(g);

        scores[4] = 1;
    }

    /**
     * Displays the response for answer no of slide 4
     * @param g graphics
     */
    public void n4Response(Graphics g){
        Slide s = new Slide(-1, "twitter is correct");
        s.display(g);
    }

    /**
     * Displays the response for answer yes of slide 5
     * @param g graphics
     */
    public void y5Response(Graphics g){
        Slide s = new Slide(1, "correct, google docs is good");
        s.display(g);

        scores[5] = 1;
    }

    /**
     * displays the response for answer no of slide 5
     * @param g graphics
     */
    public void n5Response(Graphics g){
        Slide s = new Slide(-1, "incorrect, google docs is good, reviste");
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
