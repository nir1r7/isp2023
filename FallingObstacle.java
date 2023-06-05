import java.awt.*;

public class FallingObstacle extends Obstacle {
    int dy;
    
    public FallingObstacle(int x, int y, int w, int h, int dy) {
        super(x, y, w, h);
        this.dy = dy;
    }

    public void display(Graphics g){

        g.setColor(Color.BLACK);

        g.drawRect(x, y, w, h);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getW(){
        return w;
    }

    public int getH(){
        return h;
    }

    public void setX(int n){
        x = n;
    }

    public void setY(int n){
        y = n;
    }

}
