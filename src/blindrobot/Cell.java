
package blindrobot;

public class Cell {
    private final int x;
    private final int y;
    private String blockedState;
    private boolean isVisited; 
    
    public Cell(int x, int y, String blockedState) {
        this.x = x;
        this.y = y;
        this.blockedState = blockedState;
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
    
    public boolean getVisitedState() {
        return isVisited;
    }
    
    public void setBlockedState(String state) {
        this.blockedState = state;
    }
    
    public void setVisitedState(boolean isVisited) {
        this.isVisited = isVisited;
    }
    
}
