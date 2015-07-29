
package pathtofile;

import java.io.*;
import java.util.ArrayList; 

public class PathToFile {
    ArrayList<String> str;
    String line;
    String line2;
    
    public void readFile(File f){
        try{
            FileReader fis = new FileReader(f);
            BufferedReader reader = new BufferedReader(fis);
            
            str = new ArrayList<>();
            
            while((line = reader.readLine()) != null){
                str.add(line);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void printStr(){
        line2 = str.get(4);
        System.out.println(line2);
    }
   
    public static void main(String[] args) {
        PathToFile ptf = new PathToFile();
        File f = new File("test.txt");
        ptf.readFile(f);
        ptf.printStr();
    }
    
}
