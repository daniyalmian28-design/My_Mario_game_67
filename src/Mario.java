import java.awt.*;

public class Mario {
    String name;
    Image Image;
    int xpos;
    int ypos;
    int speed;
    double dx;
    double dy;
    int width;
    int height;
    Rectangle hitbox;

    public Mario() {
        hitbox = new Rectangle(xpos, ypos, width, height);
        //convention for making a rectangle
    }

    public Mario(int xposInput, int yposInput, double dxInput, double dyInput, int widthInput, int heightInput) {
        xpos = xposInput;
        ypos = yposInput;
        dx = dxInput;
        dy = dyInput;
        width = widthInput;
        height = heightInput;

        hitbox = new Rectangle(xpos, ypos, width, height);
        //overloaded constructor... we have two constructors for Mario. one does the same thing.
        //the second takes in a bunch of stuff. when you have a constructor and give it no input, it does
        //the first one. if you give context it bypasses the first and goes straight to the second one.
        //this is overloaded constructor
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

