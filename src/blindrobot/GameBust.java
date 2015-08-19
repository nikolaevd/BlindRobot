
package blindrobot;

public class GameBust {
    
    public static void main(String[] args) {
        Maze m = new Maze(11, 15);
//        m.printMaze();
       
        UserInput ui = new UserInput();
        BlindRobot br = new BlindRobot();
        
        while(!br.getGameOver()) {
            System.out.println("");
            System.out.println("Введите команду [north|west|south|east|done]: ");  
            String tmp = ui.makeUserInput();            
            if(tmp != null) {
                br.makeMove(tmp, m);
            }
            else {
                System.out.println("Неверная команда, повторите ввод.");
            }
        }     
    } 
}
