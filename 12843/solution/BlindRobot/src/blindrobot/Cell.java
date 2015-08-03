
package blindrobot;

public class Cell {
    
    private int x;
    private int y;
    
    private enum State {EMPTY, BLOCKED};
    private State installedState;
    
    public Cell(int x, int y){
        this.x = x;
        this.y = y;
        this.installedState = this.generateRandomState();
    }
    
    private State generateRandomState(){
        int num = (int) Math.random();
        if(num != 0){
            installedState = State.BLOCKED;
        }
        else{
            installedState = State.EMPTY;
        }
        return installedState;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public State getState(){
        return this.installedState;
    }
}
