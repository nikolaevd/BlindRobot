
package blindrobot;

public class GameBust {
    
    public static void main(String[] args) {
        Field f = new Field(3, 5);
        f.buildField();
        
        BlindRobot br = new BlindRobot();
        UserInput ui = new UserInput();
        
        while(!br.getGameOver()){
            br.makeMove(ui.makeUserInput(), f);
            System.out.println("");
        }
    }
    
}
