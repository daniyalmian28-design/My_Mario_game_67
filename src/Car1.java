import java.awt.*;

public class Car1 {
    String name;
    Image aliveimage;
    Image deadimage;
    int xpos;
    int ypos;
    int speed;
    double dx;
    double dy;
    int width;
    int height;
    Rectangle hitbox;
    boolean isalive = true;
    boolean up = false;
    boolean down = false;
    boolean left = false;
    boolean right = false;

    public Car1() {
        hitbox = new Rectangle(xpos, ypos, width, height);
        //convention for making a rectangle
    }

    public Car1(int xposInput, int yposInput, double dxInput, double dyInput, int widthInput, int heightInput) {
        xpos = xposInput;
        ypos = yposInput;
        dx = dxInput;
        dy = dyInput;
        width = widthInput;
        height = heightInput;

        hitbox = new Rectangle(xpos, ypos, width, height);

    }

    public void move(){
     //   xpos = xpos + (int)dx;
       // ypos = ypos + (int) dy;
        if (up){
            ypos = ypos-(int)dy;
        }

        if (down){
            ypos = ypos + (int)dy;
        }

        if (left){
            xpos = xpos + (int)dx;
        }

        if (right){
            xpos = xpos - (int)dx;
        }

        if (xpos >= 1000){
            dx = -dx;
          //  xpos=0;
        }
        else if (xpos <= 0) {
            dx = -dx;
          //  xpos = 1000;
        }
        if (ypos >= 700){
           dy = -dy;
            //ypos=0;
        }
        else if (ypos <= 0){
           dy = -dy;
            //ypos=700;
        }
      //  System.out.println(xpos);
        hitbox = new Rectangle(xpos, ypos, width, height);
    }

    /*public void move(char key) {
        if (key == 'w') {//move forward
            ypos = ypos + speed;
        } else if (key == 's') {//move backwards
            ypos = ypos - speed;
        } else if (key == 'd') {//move right
            xpos = xpos + speed;
        } else if (key == 'a') {//move left
            xpos = xpos - speed;
        }*/
    public static void main(String[] args) {

    }

}

