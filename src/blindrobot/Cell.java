
package blindrobot;

public class Cell {
    
    private final int x;
    private final int y;
    
    private String blockedState;
    private boolean isUnvisited;
    
    public Cell(int x, int y, String blockedState, boolean isUnvisited) {
        this.x = x;
        this.y = y;
        this.blockedState = blockedState;
        this.isUnvisited = isUnvisited;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public String getBlockedState() {
        return blockedState;
    }
    
    public void setBlockedState(String state) {
        this.blockedState = state;
    }
    
    public boolean getUnvisitedState() {
        return isUnvisited;
    }
    
    public void setUnvisitedState(boolean state) {
        isUnvisited = state;
    }
    
}
