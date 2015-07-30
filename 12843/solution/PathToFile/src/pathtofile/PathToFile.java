
package pathtofile;

import java.io.*;

public class PathToFile {
    File f;
    int size;
    String aim;
    
    public PathToFile() {
        f = new File("src\\resources\\test.txt");
    }
    
    public PathToFile(String fileName) {
        f = new File(fileName);
    }
    
    public void readFile(){
        try{
            FileReader fr = new FileReader(f);
            BufferedReader reader = new BufferedReader(fr);
            String line = null;
            
            while((line = reader.readLine()) != null){
                
            }
            
            reader.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public String findPath(String[] strings){
        
        return "вот ваш путь!";
    }
   
    public static void main(String[] args) {
        PathToFile ptf = new PathToFile("src\\resources\\test.txt");        
        
    }
    
}
