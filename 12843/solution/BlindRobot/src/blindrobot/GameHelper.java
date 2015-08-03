
package blindrobot;

import java.util.ArrayList;

public class GameHelper {
    
    private ArrayList<Cell> field;
    
    public void startGame(){
        this.initialzeField(2, 5);
        this.printCells();
    }
    
    private void initialzeField(int xSize, int ySize){
        field = new ArrayList<Cell>();
        
        for(int i = 0; i < xSize; i++){
            for(int j = 0; j < ySize; j++){
                field.add(new Cell(i, j));
            }
        }
    }
    
    private void printCells(){
        for(Cell c: field){
            System.out.println("x = " + c.getX());
            System.out.println("y = " + c.getY());
            System.out.println("state = " + c.getState());
        }
    }
    
}
