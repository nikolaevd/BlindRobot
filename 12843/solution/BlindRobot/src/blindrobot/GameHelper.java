
package blindrobot;

import java.util.ArrayList;

public class GameHelper {
    
    private ArrayList<Cell> field;
    
    public void startGame(){
        GameHelper gh = new GameHelper();
        gh.initialzeField(2, 5);
        gh.printCells();
    }
    
    private void initialzeField(int xSize, int ySize){
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
