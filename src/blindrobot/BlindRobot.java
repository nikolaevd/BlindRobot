
package blindrobot;

public class BlindRobot {
    
//    private final String NORTH = "north";
//    private final String WEST = "west";
//    private final String SOUTH = "south";
//    private final String EAST  = "east";
//    private final String DONE = "done";
//    
//    private int curPositionByX;
//    private int curPositionByY;
//    
//    private boolean gameOver = false;
//    
//     
//    public void makeMove(String course, Maze maze){
//        switch (course) {
//            case NORTH:
//                System.out.println("");
//                System.out.println("Пробуем пойти на север..");
//                if(checkMove(getCurPositionByX(), getCurPositionByY()+1, maze)){
//                    setCurPositionByY(getCurPositionByY()+1);
//                    printCurPosition();
//                }
//                break;
//            case WEST:
//                System.out.println("");
//                System.out.println("Пробудем пойти на запад..");
//                if(checkMove(getCurPositionByX()-1, getCurPositionByY(), maze)){
//                    setCurPositionByX(getCurPositionByX()-1);
//                    printCurPosition();
//                }
//                break;
//            case SOUTH:
//                System.out.println("");
//                System.out.println("Пробуем пойти на юг..");
//                if(checkMove(getCurPositionByX(), getCurPositionByY()-1, maze)){
//                    setCurPositionByY(getCurPositionByY()-1);
//                    printCurPosition();
//                }
//                break;
//            case EAST:
//                System.out.println("");
//                System.out.println("Пробуем пойти на восток..");
//                if(checkMove(getCurPositionByX()+1, getCurPositionByY(), maze)){
//                    setCurPositionByX(getCurPositionByX()+1);
//                    printCurPosition();
//                }
//                break;
//            case DONE:
//                System.out.println("");
//                System.out.println("Идем в закат..");
//                setGameOver(true);
//                break;
//            default:
//                setGameOver(true);
//        }
//    }
//    
//    public int getCurPositionByX(){
//        return curPositionByX;
//    }
//    
//    public int getCurPositionByY(){
//        return curPositionByY;
//    }
//    
//    public boolean getGameOver(){
//        return gameOver;
//    }
//    
//    public void setCurPositionByX(int x){
//        curPositionByX = x;
//    }
//    
//    public void setCurPositionByY(int y){
//        curPositionByY = y;
//    }
//    
//    public void setGameOver(boolean b){
//        gameOver = true;
//    }
//    
//    public void printCurPosition(){
//        System.out.print("Текущие координаты: ");
//        System.out.println("x = " + getCurPositionByX() + ", y = " + getCurPositionByY());
//        System.out.println("");
//    }
//    
//    private boolean checkMove(int x, int y, Maze maze){
//        if(x >= 0 && x < maze.getSizeFieldByX() && y >= 0 && y < maze.getSizeFieldByY() && maze.checkState(x, y).equals("EMPTY")){
//            System.out.println("EMPTY");
//            return true;
//        }
//        else{
//            System.out.println("BLOCKED");
//            printCurPosition();
//            return false;
//        }
//    }
    
}
