
package blindrobot;

public class GameBust {
    
    public static void main(String[] args) {
        Maze m = new Maze(5, 5);
//        m.printMaze();
//        m.printVisitedCells();
        UserInput ui = new UserInput();
        BlindRobot br = new BlindRobot();
        
        while(!br.getGameOver()){
            br.makeMove(ui.makeUserInput(), m);
        }
    } 
}
