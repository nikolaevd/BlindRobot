package pathtofile;

import java.io.*;

public class PathToFile {
    File f;
    String aim;
    String path;
    String[] strings;
    int size;
    int aimPosition;
    int[] numOfSpaces;
    
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
    
    public void findAimPosition(){
        for(int i = 0; i < strings.length; i++){
            if(strings[i].contains(aim)){
                String tmp = strings[i];
                aimPosition = i;
                break;
            }
        }
    }
    
    public void countSpaces(){
        numOfSpaces = new int[aimPosition+1];
        
        for(int i = 0; i <= aimPosition; i++){
            int j = 0;
            
            while(strings[i].charAt(j) == ' '){
                j++;
            }
            
            numOfSpaces[i] = j;
        }
    }
    
    public void buildPath(){
        int tmp = numOfSpaces[aimPosition];
        path = aim;
        
        for(int i = numOfSpaces.length - 2; i >= 0; i--){
            if(numOfSpaces[i] < numOfSpaces[i+1] && numOfSpaces[i] < tmp){
                
                path = strings[i] + "/" + path;
                tmp = numOfSpaces[i];
            }
        }
    }
    
    public void deleteSpaces(){
        path = path.replaceAll("[\\s]{1,}", "");
    }
   
    public static void main(String[] args) {
        PathToFile ptf = new PathToFile();       
        ptf.readFile();
        ptf.findAimPosition();
        ptf.countSpaces();
        ptf.buildPath();
        ptf.deleteSpaces();
        System.out.println("Построен путь к файлу [" + ptf.path + "]");
    }
    
}
