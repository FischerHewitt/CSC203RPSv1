// Random number generator

// Rock count

import java.util.ArrayList;
import java.util.Random;


public class Rock {
    public static int rockCount = 0;
    private Object[][] world;
    private Point position;

    // Increment rock count
    public Rock(Point position, Object[][] world) {
        this.position = position;
        this.world = world;
        rockCount++;
    }

    // Get current position
    public Point getEntityPosition() {
        return position;
    }

    // Set current position
    public void setEntityPosition(Point position) {
        this.position = position;
    }

    // Check neighbors
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


    // Move rock
    public void moveRock() {
        ArrayList<Point> neighbors = checkNeighbors();

        // Pick a random position from the list,
        Random rand = new Random();
        Point newPosition = neighbors.get(rand.nextInt(neighbors.size()));
        setEntityPosition(newPosition);
    }


    // Rock attack
    public void rockAttack() {
        ArrayList<Point> neighbors = checkNeighbors();
        for (Point p : neighbors) {
            if (world[p.getPointX()][p.getPointY()] instanceof Scissors) {
                world[p.getPointX()][p.getPointY()] = null;
                Scissors.scissorsCount--;
            }
        }
    }



}