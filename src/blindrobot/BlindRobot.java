
package blindrobot;

public class BlindRobot {
    
    private final String NORTH = "north";
    private final String WEST = "west";
    private final String SOUTH = "south";
    private final String EAST  = "east";
    private final String DONE = "done";
    
    private int curPositionByX = 1;
    private int curPositionByY = 1;
    
    private boolean isEndGame = false;
          
    public void makeMove(String course, Maze maze) {        
        switch (course) {
            case NORTH:
                if(checkMove(curPositionByY+1, curPositionByX, maze)) {
                    curPositionByY = curPositionByY+1;
                }
                break;
            case WEST:
                if(checkMove(curPositionByY, curPositionByX-1, maze)) {
                    curPositionByX = curPositionByX-1;
                }
                break;
            case SOUTH:
                if(checkMove(curPositionByY-1, curPositionByX, maze)) {
                    curPositionByY = curPositionByY-1;
                }
                break;
            case EAST:
                if(checkMove(curPositionByY, curPositionByX+1, maze)) {
                    curPositionByX = curPositionByX+1;   
                }
                break;
            case DONE:
                isEndGame = true;
                break;
            default:
                break;
        }
        
        maze.setUnvisitedState(curPositionByY, curPositionByX, false);
         
        int num = maze.getNumUnvisitedCells();
        if(num == 0) isEndGame = true;
        
        printCurPosition();
        printSumUnvisitedCells(num);   
    }
    
    public boolean getEndGameFlag() {
        return isEndGame;
    }
    
    private void printCurPosition() {
        System.out.print("Текущие координаты: ");
        System.out.println("x = " + curPositionByX + ", y = " + curPositionByY);
    }
    
    private void printSumUnvisitedCells(int num){
        System.out.println("Непосещенных клеток: " + num);
    }
    
    private boolean checkMove(int y, int x, Maze maze) {
        if(x >= 0 && x < maze.getWidth() && y >= 0 && y < maze.getHeigth() && maze.checkBlockedState(y, x).equals("EMPTY")) {
            System.out.println("EMPTY");
            return true;
        }
        else {
            System.out.println("BLOCKED");
            return false;
        }
    }
    
}
