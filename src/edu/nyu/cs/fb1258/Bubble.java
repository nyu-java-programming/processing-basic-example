package edu.nyu.cs.fb1258;

public class Bubble {

    private int x;
    private int y;
    private static final int MAX_SPEED = 5;
    private int speedX;
    private int speedY;
    private int r;
    private int g;
    private int b;
    private App app;
    private int width;
    private int height;

    public Bubble(App app, int x, int y) {
        this.app = app;
        this.r = (int) (Math.random() * 255);
        this.g = (int) (Math.random() * 255);
        this.b = (int) (Math.random() * 255);
        this.x = x;
        this.y = y;
        this.speedX = (int) ((Math.random() * Bubble.MAX_SPEED) + 1)*2 - Bubble.MAX_SPEED;
        this.speedY = (int) ((Math.random() * Bubble.MAX_SPEED) + 1)*2 - Bubble.MAX_SPEED;
        this.width = 100;
        this.height = 100;
    }

    public void draw() {
        // draw the ellipse in bluish hue
        app.fill(this.r, this.g, this.b);
        app.ellipseMode(App.CENTER);
        app.ellipse(this.x, this.y, this.width, this.height); // draw an ellipse at x=250, y=150
        this.setX(this.x+speedX);
        this.setY(this.y+speedY);
    }

    public void setX(int newX) {
        if (newX >= app.width || newX <= 0) {
            this.speedX = -this.speedX;
        }
        else {
            this.x = newX;
        }
    }

    public void setY(int newY) {
        if (newY >= app.height || newY <= 0) {
            this.speedY = -this.speedY;
        }
        else {
            this.y = newY;
        }
    }    

    public boolean contains(int x, int y) {
        // assume the mouse position is not within the boundaries of this ellipse
        boolean xCollision = false;
        boolean yCollision = false;

        // get the right, left, and top, bottom coordinates of this ellipse
        int l = this.x - this.width/2;
        int r = l + this.width;
        int b = this.y - this.height/2;
        int t = b + this.height;

        // debugging...
        // this.app.rectMode(App.CORNER);
        // this.app.rect(l, t, r-l, b-t);

        // check whether the mouseX coordinate is within the horizontal boundaries of this ellipse
        if (x > l && x < r ) {
            xCollision = true;
        }
        // check whether the mouseY coordinate is within the vertical boundaries of this ellipse
        if (y > b && y < t ) {
            yCollision = true;
        }
        // return whether both the mouse is within both the horizontal and vertical boundaries of this ellipse
        // System.out.printf("%s,%s\n", xCollision, yCollision);
        return xCollision && yCollision; 
    }
    
}
