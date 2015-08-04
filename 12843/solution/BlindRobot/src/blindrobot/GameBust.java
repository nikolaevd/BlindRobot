
package blindrobot;

import java.util.ArrayList;

public class GameBust {
    public static void main(String[] args) {
        Field f = new Field(3, 5);
        f.buildField();
        
        BlindRobot br = new BlindRobot();
        br.makeMove("east", f);
    }
}
