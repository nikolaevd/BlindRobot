
package blindrobot;

import java.util.Scanner;

class UserInput {
    
    private String input;

    public void makeUserInput(){
        Scanner s = new Scanner(System.in);
        
        if(s.hasNext("done")){
            // TO DO добавить проверку каждой вводимой команды
            input = s.nextLine();
            System.out.println("Отлично!");
        }
        else {
            // повторяем ввод
            System.out.println("Вы ввели неверную команду. Повторите ввод.");
            this.makeUserInput();
        }
    }
    
    public String getUserInput(){
        return input;
    }
    
}