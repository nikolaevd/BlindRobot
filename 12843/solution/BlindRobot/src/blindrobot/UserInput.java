
package blindrobot;

import java.util.Scanner;

class UserInput {
    
    private String input;

    public void makeUserInput(){
        Scanner s = new Scanner(System.in);
        
        if(s.hasNext()){
            // TO DO добавить проверку регулярными выражениями на соответсвие ввода существующим командам
            input = s.nextLine();   
        }
        else {
            // повторяем ввод
            makeUserInput();
        }
    }
    
    public String getUserInput(){
        return input;
    }
    
}