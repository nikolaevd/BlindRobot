
package pathtofile;

import java.io.*;

public class PathToFile {
    File f;
    String aim;
    int size;
    String[] strings;
    
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
            
            aim = reader.readLine();
            size = Integer.parseInt(reader.readLine());
    
            String line = null;
            int i = 0;
            strings = new String[size + 2];
    
            while((line = reader.readLine()) != null){
                strings[i] = line;
                i++;
            }
            
            reader.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public String findPath(){
        for(int i = 0; i < strings.length; i++){
            if(strings[i].equals(aim)){
                return strings[i];
            }
        }
        return "вот ваш путь!";
    }
    
    public void print(){
        System.out.println("!" + strings[8] + "!");
        if(strings[8].contains(aim)){
            System.out.println("Да, блядь!");
        }
        
    }
   
    public static void main(String[] args) {
        PathToFile ptf = new PathToFile();        
        ptf.readFile();
        //System.out.println(ptf.findPath());
        ptf.print();
    }
    
}
