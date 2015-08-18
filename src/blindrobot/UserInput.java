
package blindrobot;

import java.util.Scanner;
import java.util.regex.Pattern;

class UserInput {
    
    private String input;

    public String makeUserInput() {
        Scanner s = new Scanner(System.in);      
        
        if(s.hasNext(Pattern.compile("^north$|^west$|^south$|^east$|^done$"))) {
            input = s.nextLine();
            return input;
        }
        else {
            return null;
        }
    }
    
}