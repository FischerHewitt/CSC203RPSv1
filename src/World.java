import static java.lang.Math.random;

/*
    Developers: Fischer Hewitt
    Date: 04/20/2026
    Project 2: RPSv1
    Description: Build a rock paper scissors game that has a world full of rock, paper, and scissors, then they move
    around randomly and the last object standing is the winner.
    world view print view with coordinate labels
   0 1 2 3 (x)
  +-+-+-+-+
0 | | | | |
  +-+-+-+-+
1 | | | | |
  +-+-+-+-+
2 | | | | |
  +-+-+-+-+
(y)
 */
class World{
    public int width;
    public int height;
    String[][] world;

    /*
    Creates the world as an Array<Array<String>> where its an Array[width[height]].
    each empty slot is represented as null (Java default)
    our coordinate system will be x in the horizantal direction (also the width), starting at 0
    and our y will be in the vertical direction(also known as the height) starting at 0.
    {{(0,0), (0,1), (0,2)}, {(1,0), (1,1), (2,1)}}
     */
    World(int width, int height, int numOfObjects){//width is the size of the outer list, height is the size of the inner list

        this.width = width;
        this.height = height;
        this.world = new String[width][height];

        initializeObjects(numOfObjects);

    }

    /*
    initializes each rock, paper, and scissors objects based on how many the user wanted
    Input: int number of objects
    Result: it returns none but the world array will be updated with the objects in the correct x and y coordinates
     */
    public void initializeObjects(int numOfObjects){
        for (int idx = 0; idx < numOfObjects; idx++) {
            initializeRock();
            initializePaper();
            initializeScissors();

        }
    }

    public void initializeRock(){
        int xRock = getRandomWidth(); //gives you a random int between 0 and width
        int yRock = getRandomHeight(); //gives you a random int between 0 and height
        Point rockPoint = findEmpty(xRock, yRock);

        world[xRock][yRock] = "R";
        new Rock(rockPoint, this.world);
    }

    public void initializePaper(){
        int xPaper = getRandomWidth(); //gives you a random int between 0 and width
        int yPaper = getRandomHeight(); //gives you a random int between 0 and height
        Point paperPoint = findEmpty(xPaper, yPaper);

        world[paperPoint.getX][paperPoint.getY] = "P";
        new Paper(paperPoint, this.world);
    }

    public void initializeScissors(){
        int xScissors = getRandomWidth(); //gives you a random int between 0 and width
        int yScissors = getRandomHeight(); //gives you a random int between 0 and height
        Point scissorsPoint = findEmpty(xScissors, yScissors);

        world[scissorsPoint.getX][scissorsPoint.getY] = "S";
        new Scissors(scissorsPoint, this.world);
    }

    public Point findEmpty(int x, int y){
        while (world[x][y] != null){
            int counter = 0;
            while (world[x][y] != null && counter < this.width){
                x = (x + 1) % this.width;
                counter++;
            }
            y = (y + 1) % this.height;
        }

        return new Point(x, y);
    }

    public int getRandomWidth(){
        return (int)(random() * this.width);
    }

    public int getRandomHeight(){
        return (int)(random() * this.height);
    }


    addEntity(){

    }

}
