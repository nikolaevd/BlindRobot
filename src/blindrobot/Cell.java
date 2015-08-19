
package blindrobot;

public class Cell {
    
    private final int x;
    private final int y;
    private String blockedState;
    
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
    
    public void setBlockedState(String state) {
        this.blockedState = state;
    }
    
}
