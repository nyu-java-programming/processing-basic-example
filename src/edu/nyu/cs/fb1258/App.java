package edu.nyu.cs.fb1258;

import java.util.ArrayList;

import processing.core.*;

/**
 * A simple example of using the Processing framework.
 */
public class App extends PApplet {

    // we will draw this many ellipses
    public static final int NUM_ELLIPSES = 50;

    // an arraylist to hold all the ellipses
    private ArrayList<Bubble> ellipses = new ArrayList<Bubble>();

    /**
     * Processing calls this method once when the program starts.
     * We use it to set the window width and height.
     */
    public void settings() {
        this.size(1200, 800); // open a window that is 600x400, diameter=100
    }

    /**
     * Processing calls this method once when the program starts.
     * We use it to imstantiate a bunch of objects that we will draw to the screen later.
     */
    public void setup() {
        // create a bunch of objects and add them to an arraylist
        for (int i=0; i<App.NUM_ELLIPSES; i++) {
            // generate random starting position
            int x = (int) (Math.random() * this.width);
            int y = (int) (Math.random() * this.height);
            Bubble e = new Bubble(this, x, y);
            ellipses.add(e); // add to arraylist
        }
    }

    /**
     * Processing automatically calls this every 1/60th of a second.
     * We use it to draw all the shapes the window at their appropriate locations.
     */
    public void draw() {
        // wipe out the background with a solid color
        background(221, 160, 247); // r, g, b values out of 0-255

        // call each of our ellipse's draw methods so they draw themselves to the window
        for (int i=0; i<this.ellipses.size(); i++) {
            Bubble e = this.ellipses.get(i);
            e.draw();
        }

        // draw a rectangle in a fuschia-ish hue at the position of the cursor
        this.fill(160, 247, 167); // r, g, b as values from 0-255
        this.rectMode(PApplet.CENTER); // the center of the rectangle will be at the position of the mouse
        this.rect(this.mouseX, this.mouseY, 50, 50); // x, y, width, height
    }

    /**
     * Automatically called whenever the user clicks the mouse.
     * Removes any ellipses that were clicked on.
     */
    public void mouseClicked() {
        // loop through each ellipse 
        for (int i=0; i<this.ellipses.size(); i++) {
            Bubble e = this.ellipses.get(i);
            // check whether the coordinates of the mouse click were inside the ellipse area
            if (e.contains(this.mouseX, this.mouseY)) {
                // if so, remove the ellipse from the arraylist.
                this.ellipses.remove(e);
            }
        }
    }

    public static void main(String[] args) {
        // Processing requires us to pass our full package + class name to its main method.
        PApplet.main("edu.nyu.cs.fb1258.App");
    }
}
