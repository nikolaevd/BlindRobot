
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
        
    public void makeMove(String course, Maze maze){
        switch (course) {
            case NORTH:
                System.out.println("");
                System.out.println("Пробуем пойти на север..");
                if(checkMove(curPositionByX, curPositionByY+1, maze)){
                    curPositionByY = curPositionByY+1;
                    printCurPosition();
                }
                break;
            case WEST:
                System.out.println("");
                System.out.println("Пробудем пойти на запад..");
                if(checkMove(curPositionByX-1, curPositionByY, maze)){
                    curPositionByX = curPositionByX-1;
                    printCurPosition();
                }
                break;
            case SOUTH:
                System.out.println("");
                System.out.println("Пробуем пойти на юг..");
                if(checkMove(curPositionByX, curPositionByY-1, maze)){
                    curPositionByY = curPositionByY-1;
                    printCurPosition();
                }
                break;
            case EAST:
                System.out.println("");
                System.out.println("Пробуем пойти на восток..");
                if(checkMove(curPositionByX+1, curPositionByY, maze)){
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
    
    public boolean getGameOver(){
        return gameOver;
    }
    
    public void printCurPosition(){
        System.out.print("Текущие координаты: ");
        System.out.println("x = " + curPositionByX + ", y = " + curPositionByY);
        System.out.println("");
    }
    
    private boolean checkMove(int x, int y, Maze maze){
        if(x >= 0 && x < maze.getWidth() && y >= 0 && y < maze.getHeigth() && maze.checkState(x, y).equals("EMPTY")){
            System.out.println("EMPTY");
            return true;
        }
        else{
            System.out.println("BLOCKED");
            printCurPosition();
            return false;
        }
    }
    
}
