
package blindrobot;

import java.util.Scanner;
import java.util.regex.Pattern;

class UserInput {
    
    private String input;

    public String makeUserInput(){
        Scanner s = new Scanner(System.in);
        System.out.println("Введите команду [north|west|south|east|done]: ");
        
        if(s.hasNext(Pattern.compile("^north$|^west$|^south$|^east$|^done$"))){
            input = s.nextLine();
            return input;
        }
        else {
            System.out.println("Вы ввели неверную команду. Повторите ввод: ");
            this.makeUserInput();
        }
        
        return null;
    }
    
}