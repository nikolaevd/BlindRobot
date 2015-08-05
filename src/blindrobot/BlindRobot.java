
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
        switch (course) {
            case NORTH:
                System.out.println("Идем на Север!");
                this.checkMove(this.getCurPositionByX(), this.getCurPositionByY()+1, f);
                break;
            case WEST:
                System.out.println("Идем на Запад!");
                this.checkMove(this.getCurPositionByX()-1, this.getCurPositionByY(), f);
                break;
            case SOUTH:
                System.out.println("Идем на Юг!");
                this.checkMove(this.getCurPositionByX(), this.getCurPositionByY()-1, f);
                break;
            case EAST:
                System.out.println("Идем на Восток!");
                this.checkMove(this.getCurPositionByX()+1, this.getCurPositionByY(), f);
                break;
            case DONE:
                System.out.println("Завершаем работу!");
                break;
            default:
                System.out.println("Идем в закат!");
                break;
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
            System.out.println("Выполнен ход в границах поля.");
            System.out.println("Состояние ячейкий: " + f.checkState(x, y));
            // TODO реализовать ветвление в зависимости от состояния ячейки
            // EMPTY - делается ход
            // BLOCKED - выполнение хода невозможно, повторите ввод
        }
        else{
            System.out.println("Ход невозможен: вы выходите за границу поля.");
            System.out.println("Повторите ход.");
            // TODO реализовать цикл для повторного ввода
        }
    }
    
}
