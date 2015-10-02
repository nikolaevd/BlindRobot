
package blindrobot;

public class GameBust {
    
    public static void main(String[] args) {
        Maze m = new Maze(11, 15);
//        m.printMaze();
       
        UserInput ui = new UserInput();
        BlindRobot br = new BlindRobot();
        
        while(!br.getEndGameFlag()) {
            System.out.println("");
            System.out.println("Введите команду [north|west|south|east|done]: ");  
            String input = ui.makeUserInput();            
            if(input != null) {
                br.makeMove(input, m);
            }
            else {
                System.out.println("Команда не распознана, повторите ввод.");
            }
        }
        System.out.println("Игра завершена.");
    } 
    
}
