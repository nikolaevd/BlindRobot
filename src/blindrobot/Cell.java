
package blindrobot;

public class Cell {
    
    private final int x;
    private final int y;
    private String state;
    
    public Cell(int x, int y){
        this.x = x;
        this.y = y;
        state = generateRandomState();
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public String getState(){
        return state;
    }
    
    private String generateRandomState(){
        double num = Math.random();
        if(num >= 0.6) state = "BLOCKED";
        else state = "EMPTY";
        return state;
    }
    
}
