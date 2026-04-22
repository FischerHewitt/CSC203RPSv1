// Documentation
// Rock.java
// Purpose: this class represents a rock entity that moves around the world

// Rock() -> Rock
// Purpose: this constructor initializes a rock object with a position and world
// Examples: Rock(new Point(3,4), world) -> new Rock at position (3,4)

// getEntityPosition() -> Point
// Purpose: this function returns the current position of the rock
// Examples: getEntityPosition() -> Point(3,4)

// setEntityPosition() -> void
// Purpose: this function sets the rock to a new position
// Examples: setEntityPosition(new Point(5,6)) -> rock is now at (5,6)

//totalRock() -> int
//Purpose: this function calculates the total number of rocks
//Examples: totalRock() -> 5

// checkNeighbors() -> ArrayList
// Purpose: this function checks all neighboring cells around the rock and returns a list of valid positions
// Examples: checkNeighbors() -> [(2,2), (2,3), (3,2)]

//moveRock() -> void
//Purpose: this function moves the rock in a direction (N, E, S, W)
//Examples: moveRock() -> rock moves from Point(1, 1) to Point(2, 2)

//rockAttack() -> void
//Purpose: this function attacks an object if it is on either side of it
//Examples: rockAttack() -> removes adjacent paper if it is next to rock


public class Rock {
    // Current rock position
    // Random number generator

    // Rock count
    private static int rockCount = 0;

    // Increment rock count
    public Rock(Point position, World){
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


    public ArrayList<Point> checkNeighbors(){
        ArrayList<Point> neighbors = new ArrayList<>();

        // Check all positions around the rock
        for(int x = -1; x <= 1; x++){
            for(int y = -1; y <= 1; y++){
                int newX = position.x + x;
                int newY = position.y + y;

                // Add to list if within bounds
                if(world.isInBounds(newX, newY)){
                    neighbors.add(new Point(newX, newY));
                }
            }
        }
        return neighbors;
    }


    // Move rock
    public void moveRock(){
        ArrayList<Point> neighbors = checkNeighbors();

        // Pick a random position from the list
        Random rand = new Random();
        Point newPosition = neighbors.get(rand.nextInt(neighbors.size()));

        setEntityPosition(newPosition);
    }


    // Rock attack
    public void rockAttack() {
        ArrayList<Point> neighbors = checkNeighbors();
        for (Point p : neighbors) {
            if(world.getEntity(p.intx, p.y).toString().equals("S")){
                world.removeEntity(p.x, p.y);
            }
        }
    }
}