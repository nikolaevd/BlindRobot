
package blindrobot;

import java.util.ArrayList;

public class GameBust {
    public static void main(String[] args) {
        GameHelper gh = new GameHelper();
        gh.startGame();
        
        BlindRobot br = new BlindRobot();
        br.makeMove("done");
    }
}
