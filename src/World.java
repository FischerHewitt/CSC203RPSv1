import static java.lang.Math.random;

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
class World{
    public int width;
    public int height;
    Object[][] world;

    /*
    Creates the world as an Array<Array<String>> where its an Array[width[height]].
    each empty slot is represented as null (Java default)
    our coordinate system will be x in the horizantal direction (also the width), starting at 0
    and our y will be in the vertical direction(also known as the height) starting at 0.
    {{(0,0), (0,1), (0,2)}, {(1,0), (1,1), (2,1)}}
     */
    World(int width, int height){//width is the size of the outer list, height is the size of the inner list

        this.width = width;
        this.height = height;
        this.world = new Object[width][height];

        // sets the list = to null
        for (int idxW = 0; idxW < this.width; idxW++){
            for (int idxH = 0; idxH < this.height; idxH++){
                this.world[idxW][idxH] = null;
            }
        }
    }

    /*
    initializes each rock, paper, and scissors objects based on how many the user wanted
    Input: int number of objects
    Result: it returns none but the world array will be updated with the objects in the correct x and y coordinates
     */
    public void initializeObjects(int numOfObjects){
        for (int idx = 0; idx < numOfObjects; idx++) {
            addEntity();

        }
    }
    /*
    adds an entity (rock, paper, and scissors) in the world.
    Input:null
    output:null
    */
    public void addEntity(){
        addRock();// adds a rock to the world
        addPaper();// adds a paper to the world
        addScissors();// adds scissors to the world
    }

    /*
    this initializes a Rock Object and add it to our world array.
    Input: null
    output: null
    Result: After finding an empty spot using the findEmpty,
    it creates a new rock object with the coordinates it is at in the list
     */
    public void addRock(){
        int xRock = getRandomWidth(); //gets the x coordinate of the rock by generating a random int between 0 and width
        int yRock = getRandomHeight(); //gets the y coordinate of the rock by generating a random int between 0 and height
        Point rockPoint = findEmpty(xRock, yRock);  //finds an empty coordinate in the world array

        this.world[rockPoint.getPointX()][rockPoint.getPointY()] = new Rock(rockPoint, this.world);
        //this is a comment
    }

    /*
    this initializes a Paper Object and add it to our world array.
    Input: null
    output: null
    Result: After finding an empty spot using the findEmpty,
    it creates a new paper object with the coordinates it is at in the list
     */

    public void addPaper(){
        int xPaper = getRandomWidth(); //gets the x coordinate of the paper by generating a random int between 0 and width
        int yPaper = getRandomHeight(); //gets the y coordinate of the paper by generating a random int between 0 and height
        Point paperPoint = findEmpty(xPaper, yPaper);  //finds an empty coordinate in the world array

        //new Paper(paperPoint, this.world);
    }

    /*
    this initializes a Scissors Object and add it to our world array.
    Input: null
    output: null
    Result: After finding an empty spot using the findEmpty,
    it creates a new scissors object with the coordinates it is at in the list
     */
    public void addScissors(){
        int xScissors = getRandomWidth(); //gets the x coordinate of the scissors by generating a random int between 0 and width
        int yScissors = getRandomHeight(); //gets the y coordinate of the scissors by generating a random int between 0 and height
        Point scissorsPoint = findEmpty(xScissors, yScissors); //finds an empty coordinate in the world array

        //new Scissors(scissorsPoint, this.world);
    }

    /*
    finds an empty spot in the array initializing all the objects to make sure they have a place
    (we check to make sure all objects will fit in dimensions in gameplay)
    input: int x, int y
    result: Point(x,y). Returns a point that is a valid empty spot.
     */
    public Point findEmpty(int x, int y){
        while (world[x][y] != null){ //if the current spot is not empty go check all the x's for each height.
            int counter = 0;
            while ((world[x][y] != null) && (counter < this.width)){
                x = (x + 1) % this.width; // makes sure it stays within the boundaries
                counter++; // lets us check the height and not iterate for infinity
            }
            if (world[x][y] == null){ // check to see if it is null space or if we need to increase the height by 1
                break;
            }
            y = (y + 1) % this.height;
        }

        return new Point(x, y);
    }

    /*
    gets a random value between 0 and the width
    input: null
    output: int of a random value
     */
    public int getRandomWidth(){
        return (int)(random() * this.width);
    }

    /*
    gets a random value between 0 and the height
    input: null
    output: int of a random value
     */
    public int getRandomHeight(){
        return (int)(random() * this.height);
    }


    public void playRound(){

        for (int idxHeight = 0; idxHeight < this.height; idxHeight++){
            for (int idxWidth = 0; idxWidth < this.width; idxWidth++) { // has to print at each width first before the height
                if (world[idxWidth][idxHeight] instanceof Rock) { // checks if it is a rock
                    ((Rock) world[idxWidth][idxHeight]).rockAttack();
                } else if (world[idxWidth][idxHeight] instanceof Paper) { // checks if it is a paper
                    ((Paper) world[idxWidth][idxHeight]).paperAttack();
                } else if (world[idxWidth][idxHeight] instanceof Scissors) { // checks if is it a scissors
                    ((Scissors) world[idxWidth][idxHeight]).scissorsAttack();
                }
            }
        }

        if ((Rock.rockCount == 0 && Paper.paperCount == 0) | (Paper.paperCount == 0 && Scissors.scissorsCount == 0) | (Scissors.scissorsCount == 0 && Rock.rockCount == 0)){
            return;
        }

        for (int idxHeight = 0; idxHeight < this.height; idxHeight++){
            for (int idxWidth = 0; idxWidth < this.width; idxWidth++) { // has to print at each width first before the height
                if (world[idxWidth][idxHeight] instanceof Rock) { // checks if it is a rock
                    ((Rock) world[idxWidth][idxHeight]).moveRock();
                } else if (world[idxWidth][idxHeight] instanceof Paper) { // checks if it is a paper
                    ((Paper) world[idxWidth][idxHeight]).movePaper();
                } else if (world[idxWidth][idxHeight] instanceof Scissors) { // checks if is it a scissors
                    ((Scissors) world[idxWidth][idxHeight]).moveScissors();
                }
            }
        }


    }

    /*
    Purpose: prints the world with the Rock, Paper, and Scissors objects in it
    input: null
    output: null
     */
    public void printWorld(){
        System.out.println("World:");
        // prints the top +-+-+-+
        for (int idxLine = 0; idxLine < this.width; idxLine++){
           System.out.print("+-") ; //prints the top +-+-+-
        }
        System.out.print("+\n"); // adds the last + to the top line


        // prints the rest of the world
        for (int idxHeight = 0; idxHeight < this.height; idxHeight++){
            for (int idxWidth = 0; idxWidth < this.width; idxWidth++) { // has to print at each width first before the height
                if (world[idxWidth][idxHeight] instanceof Rock) { // checks if it is a rock
                    System.out.print("|R");
                } else if (world[idxWidth][idxHeight] instanceof Paper) { // checks if it is a paper
                    System.out.print("|P");
                } else if (world[idxWidth][idxHeight] instanceof Scissors) { // checks if is it a scissors
                    System.out.print("|S");
                } else {
                    System.out.print("| ");
                }
            }

            System.out.print("|\n"); // prints the last | on the line

            // prints the bottom line
            for (int idxLine = 0; idxLine < this.width; idxLine++){
                System.out.print("+-") ; //prints the top +-+-+-
            }
            System.out.print("+\n"); // adds the last + to the top line
        }
    }


}
