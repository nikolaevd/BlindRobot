
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
        
        maze.setUnvisitedState(curPositionByY, curPositionByX, false);
        
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
        printCurPosition();
        int sumUnvisitedCells = maze.getSumUnvisitedCells();
        System.out.println("Число непосещенных ячеек = " + sumUnvisitedCells);
        if(sumUnvisitedCells == 0) isEndGame = true;
    }
    
    public boolean getEndGameFlag() {
        return isEndGame;
    }
    
    private void printCurPosition() {
        System.out.print("Текущие координаты: ");
        System.out.println("x = " + curPositionByX + ", y = " + curPositionByY);
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
