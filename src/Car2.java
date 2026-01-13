import java.awt.*;

public class Car2 {
    public static String name;
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



    public Car2() {
        hitbox = new Rectangle(xpos, ypos, width, height);
        //convention for making a rectangle
    }


    public Car2(int xposInput, int yposInput, double dxInput, double dyInput, int widthInput, int heightInput) {
        xpos = xposInput;
        ypos = yposInput;
        dx = dxInput;
        dy = dyInput;
        width = widthInput;
        height = heightInput;

        hitbox = new Rectangle(xpos, ypos, width, height);
        //overloaded constructor... we have two constructors for Bowser. one does the same thing.
        //the second takes in a bunch of stuff. when you have a constructor and give it no input, it does
        //the first one. if you give context it bypasses the first and goes straight to the second one.
        //this is overloaded constructor
    }

    public void move() {

        if (xpos <= 900 && xpos>100 && ypos<200) {
            xpos = xpos - (int) dx;
          //  ypos = 150;
        }
        else if (xpos <= 900 && xpos>100 && ypos>400  ) {
            xpos = xpos + (int) dx;
        }

        if (xpos <=100 && ypos > 600  ) {
            xpos = xpos + (int) dx;
        }

         else if (xpos <= 100) {
            ypos = ypos + (int) dy;
        }


         if (xpos > 900) {
            xpos = xpos;
            ypos = ypos - (int) dy;

        }




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