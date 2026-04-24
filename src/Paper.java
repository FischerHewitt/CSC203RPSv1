/*
    Developers: Fischer Hewitt, Sameeka Molugu, Mason Brown
    Date: 04/20/2026
    Project 2: RPSv1
    Description: Build a rock paper scissors game that has a world full of rock, paper, and scissors, then they move
    around randomly and the last object standing is the winner.
    world view print view with coordinate labels
   0 1 2 3 (x)      ^ 0 1 2
  +-+-+-+-+           ^ ^ ^
0 | | | | |        0
  +-+-+-+-+           - - -
1 | | | | |        1
  +-+-+-+-+           - - -
2 | | | | |        2
  +-+-+-+-+           v v v
(y)                          v
 */

import java.util.ArrayList;
import java.util.Random;

public class Paper {

    static int paperCount = 0;
    private Object[][] world;
    private Point position;

    public Paper(Point position, Object[][] world){
        this.position = position;
        this.world = world;
        paperCount++;
    }

    public Point getEntityPosition() {
        return position;
    }

    public void setEntityPosition(Point position) {
        this.position = position;
    }

    public ArrayList<Point> checkNeighbors() {
        ArrayList<Point> neighbors = new ArrayList<>();

        // Check all positions around the rock
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                int newX = position.getPointX() + x;
                int newY = position.getPointY() + y;

                // Add to list if within bounds
                if ((newX < this.world.length) && (0 <= newX) && (newY < this.world[0].length) && (0 <= newY)) {
                    neighbors.add(new Point(newX, newY));
                }
            }
        }
        return neighbors;
    }


    public void movePaper(){
        ArrayList<Point> neighbors = checkNeighbors();

        // Pick a random position from the list,
        Random rand = new Random();
        Point newPosition = neighbors.get(rand.nextInt(neighbors.size()));
        setEntityPosition(newPosition);
    }

    public void paperAttack() {
        ArrayList<Point> neighbors = checkNeighbors();
        for (Point p : neighbors) {
            if(world[p.getPointX()][p.getPointY()] instanceof Rock){
                world[p.getPointX()][p.getPointY()] = null;
                Rock.rockCount--;
            }
        }
    }


}
