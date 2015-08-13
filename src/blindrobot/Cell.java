
package blindrobot;

public class Cell {
    private final int x;
    private final int y;
    private boolean isVisited; 
    private String state;
    
    public Cell(int x, int y, String state){
        this.x = x;
        this.y = y;
        this.state = state;
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
    
    public boolean getIsVisited(){
        return isVisited;
    }
    
    public void setState(String state){
        this.state = state;
    }
    
    public void setIsVisited(boolean isVisited){
        this.isVisited = isVisited;
    }
    
}
