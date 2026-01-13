//vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DON'T CHANGE! vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
// Graphics Libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.security.Key;

//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
public class BasicGameApp implements Runnable, KeyListener {

    //Sets the width and height of the program window
    final int WIDTH = 1000;
    final int HEIGHT = 700;


    Car1 Car1 = new Car1();
    Car2 Car2 = new Car2();
    Image background;


    // Initialize your variables and construct your program objects here.
    public BasicGameApp() { // BasicGameApp constructor
        setUpGraphics();
        Car2 = new  Car2(750,150,3,3,30,30);
        Car2.name = "Car2 Car2";
        Car2.aliveimage = Toolkit.getDefaultToolkit().getImage("Car2.png");


        //variable and objects
        //create (construct) the objects needed for the game
        Car1 = new Car1(750,50,3,3,30,30);
        Car1.name = "Car1 Car1";
        Car1.aliveimage = Toolkit.getDefaultToolkit().getImage("Car1.png");

        background=Toolkit.getDefaultToolkit().getImage("nascartrack.jpg");


    }
    // end BasicGameApp constructor

    public void checkCollision(){
        if (Car1.hitbox.intersects(Car2.hitbox)){
            Car1.isalive=false;
        }

        if (Car1.xpos == 1){
            Car1.isalive=false;
        }
        if (Car1.xpos == 1000){
            Car1.isalive=false;
        }

        if (Car1.ypos == 0){
            Car1.isalive=false;
        }

        if (Car1.ypos == 700){
            Car1.isalive=false;
        }
        }

    public void moveThings() {
        //call the move() code for each object  -
        Car1.move();
        Car2.move();
    }


    //Paints things on the screen using bufferStrategy
    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);

        //draw the images
        // Signature: drawImage(Image img, int x, int y, int width, int height, ImageObserver observer)
        g.drawImage(background,0,0,1000,700,null);
        g.drawImage(Car1.aliveimage,Car1.xpos,Car1.ypos, Car1.width, Car1.height, null);
        if (Car1.isalive == false){
            Car1.aliveimage = Toolkit.getDefaultToolkit().getImage("fire.png");;
            Car1.dx = 0;
            Car1.dy = 0;
        }

        g.drawImage(Car2.aliveimage,Car2.xpos,Car2.ypos, Car2.width, Car2.height, null);



        // Keep the code below at the end of render()
        g.dispose();
        bufferStrategy.show();
    }














    //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
//vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv DON'T CHANGE! vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;
    public BufferStrategy bufferStrategy;

    // PSVM: This is the code that runs first and automatically
    public static void main(String[] args) {
        BasicGameApp ex = new BasicGameApp();   //creates a new instance of the game
        new Thread(ex).start();                 //creates a threads & starts up the code in the run( ) method
    }

    // main thread
    // this is the code that plays the game after you set things up
    public void run() {
        //for the moment we will loop things forever.
        while (true) {
            moveThings();  //move all the game objects
            checkCollision();
            render();  // paint the graphics
            pause(10); // sleep for 10 ms
        }
    }

    //Pauses or sleeps the computer for the amount specified in milliseconds
    public void pause(int time ) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }

    private Image getImage(String filename){
        return Toolkit.getDefaultToolkit().getImage(filename);
    }

    //Graphics setup method
    private void setUpGraphics() {
        frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);


        canvas.addKeyListener(this);
        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
       //System.out.println("DONE graphic setup");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //not gonna use ts
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        int key = e.getKeyCode();

        if (key == 65){//a is pressed
            Car1.right = true;

    }
        if (key==87){
           Car1.up = true;
        }

        if (key == 83){
            Car1.down = true;
        }

        if (key == 68){
            Car1.left = true;
        }



    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == 65){//a is pressed
            Car1.right = false;
        }
        if (key==87){
            Car1.up = false;
        }
        if (key == 83){
            Car1.down = false;
        }
        if (key == 68){
            Car1.left = false;
        }


    }
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
}




