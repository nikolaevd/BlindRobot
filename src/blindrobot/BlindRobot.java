
package blindrobot;

public class BlindRobot {
    
    private final String NORTH = "north";
    private final String WEST = "west";
    private final String SOUTH = "south";
    private final String EAST  = "east";
    private final String DONE = "done";
    
    private int curPositionByX = 1;
    private int curPositionByY = 1;
    
    private boolean gameOver = false;
        
    public void makeMove(String course, Maze maze) {
        switch (course) {
            case NORTH:
                if(checkMove(curPositionByY+1, curPositionByX, maze)) {
                    curPositionByY = curPositionByY+1;
                    printCurPosition();
                }
                break;
            case WEST:
                if(checkMove(curPositionByY, curPositionByX-1, maze)) {
                    curPositionByX = curPositionByX-1;
                    printCurPosition();
                }
                break;
            case SOUTH:
                if(checkMove(curPositionByY-1, curPositionByX, maze)) {
                    curPositionByY = curPositionByY-1;
                    printCurPosition();
                }
                break;
            case EAST:
                if(checkMove(curPositionByY, curPositionByX+1, maze)) {
                    curPositionByX = curPositionByX+1;
                    printCurPosition();
                }
                break;
            case DONE:
                System.out.println("");
                System.out.println("Идем в закат..");
                gameOver = true;
                break;
            default:
                gameOver = true;
        }
    }
    
    public boolean getGameOver() {
        return gameOver;
    }
    
    public void printCurPosition() {
        System.out.print("Текущие координаты: ");
        System.out.println("x = " + curPositionByX + ", y = " + curPositionByY);
    }
    
    private boolean checkMove(int y, int x, Maze maze) {
        if(x >= 0 && x < maze.getWidth() && y >= 0 && y < maze.getHeigth() && maze.checkState(y, x).equals("EMPTY")) {
            System.out.println("EMPTY");
            return true;
        }
        else {
            System.out.println("BLOCKED");
            printCurPosition();
            return false;
        }
    }
    
}
