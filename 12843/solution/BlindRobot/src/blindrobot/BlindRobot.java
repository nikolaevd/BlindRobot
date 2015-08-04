
package blindrobot;

public class BlindRobot {
    
    private final String NORTH = "north";
    private final String WEST = "west";
    private final String SOUTH = "south";
    private final String EAST  = "east";
    private final String DONE = "done";
    
    private int curPositionByX;
    private int curPositionByY;
     
    public void makeMove(String course, Field f){
        if(course.equals(NORTH)){
            System.out.println("Идем на Север!");
            this.checkMove(this.getCurPositionByX(), this.getCurPositionByY()+1, f);        
        }
        else if(course.equals(WEST)){
            System.out.println("Идем на Запад!");
            this.checkMove(this.getCurPositionByX()-1, this.getCurPositionByY(), f);    
        }
        else if(course.equals(SOUTH)){
            System.out.println("Идем на Юг!");
            this.checkMove(this.getCurPositionByX(), this.getCurPositionByY()-1, f);    
        }
        else if(course.equals(EAST)){
            System.out.println("Идем на Восток!");
            this.checkMove(this.getCurPositionByX()+1, this.getCurPositionByY(), f);    
        }
        else if(course.equals(DONE)){
            System.out.println("Завершаем работу!");
        }
        else{
            System.out.println("Идем в закат!");
        }
    }
    
    public int getCurPositionByX(){
        return curPositionByX;
    }
    
    public int getCurPositionByY(){
        return curPositionByY;
    }
    
    private void checkMove(int x, int y, Field f){
        if(x >= 0 && x < f.getSizeFieldByX() && y >= 0 && y < f.getSizeFieldByY()){
            System.out.println("Сделан ход в границах поля.");
            // TODO выполнить проверку ячейки
        }
        else{
            System.out.println("Выполнить ход невозможно: вы выходите за границы поля.");
            System.out.println("Повторите ход.");
            // TODO предложить сделать ход повторно
        }
    }
    
}
