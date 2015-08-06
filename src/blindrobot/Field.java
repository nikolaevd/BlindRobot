
package blindrobot;

import java.util.ArrayList;

public class Field {
    
    private ArrayList<Cell> field;
    
    private final int sizeFieldByX;
    private final int sizeFieldByY;
    
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
    
    public String checkState(int x, int y){
        for(Cell c: field){
            if(c.getX() == x && c.getY() == y){
                return c.getState();
            }
        }
        return null;
    }
    
    public void buildField(){
        field = new ArrayList<>();
        
        for(int i = 0; i < this.sizeFieldByX; i++){
            for(int j = 0; j < this.sizeFieldByY; j++){
                field.add(new Cell(i, j));
            }
        }
    }
    
}
