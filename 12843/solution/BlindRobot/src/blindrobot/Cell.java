
package blindrobot;

public class Cell {
    
    private final int x;
    private final int y;
    private String state;
    
    public Cell(int x, int y){
        this.x = x;
        this.y = y;
        this.state = this.generateRandomState();
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public String getState(){
        return this.state;
    }
    
    private String generateRandomState(){
        double num = Math.random();
        if(num >= 0.5) state = "BLOCKED";
        else state = "EMPTY";
        return state;
    }
    
}
