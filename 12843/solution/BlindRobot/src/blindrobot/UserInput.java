
package blindrobot;

import java.util.Scanner;
import java.util.regex.Pattern;

class UserInput {
    
    private String input;

    public void makeUserInput(){
        Scanner s = new Scanner(System.in);
        System.out.println("Введите команду [north|west|south|east|done]: ");
        
        if(s.hasNext(Pattern.compile("^north$|^west$|^south$|^east$|^done$"))){
            input = s.nextLine();
            System.out.println("Команда принята.");
        }
        else {
            System.out.println("Вы ввели неверную команду. Повторите ввод: ");
            this.makeUserInput();
        }
    }
    
    public String getUserInput(){
        return input;
    }
    
}