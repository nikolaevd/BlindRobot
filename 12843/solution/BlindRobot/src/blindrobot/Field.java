
package blindrobot;

import java.util.ArrayList;

public class Field {
    
    private ArrayList<Cell> field;
    private int sizeFieldByX;
    private int sizeFieldByY;
    
    public Field(int sizeFieldByX, int sizeFieldByY){
        this.sizeFieldByX = sizeFieldByX;
        this.sizeFieldByY = sizeFieldByY;
    }
    
    public int getSizeFieldByX(){
        return sizeFieldByX;
    }
    
    public int getSizeFieldByY(){
        return sizeFieldByY;
    }
        
    public void buildField(){
        this.initialzeField();
        this.printCells();
    }
    
    private void initialzeField(){
        field = new ArrayList<Cell>();
        
        for(int i = 0; i < this.sizeFieldByX; i++){
            for(int j = 0; j < this.sizeFieldByY; j++){
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
