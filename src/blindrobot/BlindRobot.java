
package blindrobot;

public class BlindRobot {
    
    private final String NORTH = "north";
    private final String WEST = "west";
    private final String SOUTH = "south";
    private final String EAST  = "east";
    private final String DONE = "done";
    
    private int curPositionByX;
    private int curPositionByY;
    
    private boolean gameOver = false;
    
     
    public void makeMove(String course, Field f){
        switch (course) {
            case NORTH:
                System.out.println("Идем на Север!");
                if(this.checkMove(this.getCurPositionByX(), this.getCurPositionByY()+1, f)){
                    setCurPositionByY(this.getCurPositionByY()+1);
                }
                break;
            case WEST:
                System.out.println("Идем на Запад!");
                if(this.checkMove(this.getCurPositionByX()-1, this.getCurPositionByY(), f)){
                    setCurPositionByX(this.getCurPositionByX()-1);
                }
                break;
            case SOUTH:
                System.out.println("Идем на Юг!");
                if(this.checkMove(this.getCurPositionByX(), this.getCurPositionByY()-1, f)){
                    setCurPositionByY(this.getCurPositionByY()-1);
                }
                break;
            case EAST:
                System.out.println("Идем на Восток!");
                if(this.checkMove(this.getCurPositionByX()+1, this.getCurPositionByY(), f)){
                    setCurPositionByX(this.getCurPositionByX()+1);
                }
                break;
            case DONE:
                System.out.println("Завершаем работу!");
                this.setGameOver(true);
                break;
            default:
                System.out.println("Идем в закат!");
                this.setGameOver(true);
                break;
        }
    }
    
    public int getCurPositionByX(){
        return curPositionByX;
    }
    
    public int getCurPositionByY(){
        return curPositionByY;
    }
    
    public boolean getGameOver(){
        return gameOver;
    }
    
    public void setCurPositionByX(int x){
        curPositionByX = x;
    }
    
    public void setCurPositionByY(int y){
        curPositionByY = y;
    }
    
    public void setGameOver(boolean b){
        gameOver = true;
    }
    
    private boolean checkMove(int x, int y, Field f){
        if(x >= 0 && x < f.getSizeFieldByX() && y >= 0 && y < f.getSizeFieldByY() && f.checkState(x, y).equals("EMPTY")){
            System.out.println("Ура! Клетка в этом направлении свободна!");
//            System.out.println("Состояние ячейкий: " + f.checkState(x, y));
            return true;
        }
        else{
            System.out.println("Ой! Выполнить ход в данном направлении невозможно: ");
            System.out.println("Клетка заблокированна или мы уперлись в границу поля.");
            return false;
        }
    }
    
}
