package pathtofile;

import java.io.*;

public class PathToFile {
    private final File f;
    private String desiredFile;
    private String pathToDesiredFile;
    private String[] contentsOfFile;
    private int numOfStrings;
    private int indexOfDesiredFile;
    private int[] numOfSpaces;
    
    public PathToFile() {
        f = new File("src\\resources\\test.txt");
    }
    
    public PathToFile(String fileName) {
        f = new File(fileName);
    }
    
    public static void main(String[] args) {
        PathToFile ptf = new PathToFile();       
        ptf.putFileToArray();
        ptf.findIdexOfDesiredFile();
        ptf.countSpaces();
        ptf.buildPath();
        ptf.deleteSpaces();
        
        System.out.print("Построен путь к файлу '" + ptf.desiredFile + "': ");
        System.out.println("[" + ptf.pathToDesiredFile + "]");
    }
    
    private void putFileToArray(){
        try{
            FileReader fr = new FileReader(f);
            BufferedReader reader = new BufferedReader(fr);
            
            desiredFile = reader.readLine();
            numOfStrings = Integer.parseInt(reader.readLine());
    
            String line = null;
            int i = 0;
            contentsOfFile = new String[numOfStrings + 2];
    
            while((line = reader.readLine()) != null){
                contentsOfFile[i] = line;
                i++;
            }
            
            reader.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    private void findIdexOfDesiredFile(){
        for(int i = 0; i < contentsOfFile.length; i++){
            if(contentsOfFile[i].contains(desiredFile)){
                String tmp = contentsOfFile[i];
                indexOfDesiredFile = i;
                break;
            }
        }
    }
    
    private void countSpaces(){
        numOfSpaces = new int[indexOfDesiredFile+1];
        
        for(int i = 0; i <= indexOfDesiredFile; i++){
            int j = 0;
            
            while(contentsOfFile[i].charAt(j) == ' '){
                j++;
            }
            
            numOfSpaces[i] = j;
        }
    }
    
    private void buildPath(){
        int tmp = numOfSpaces[indexOfDesiredFile];
        pathToDesiredFile = desiredFile;
        
        for(int i = numOfSpaces.length - 2; i >= 0; i--){
            if(numOfSpaces[i] < numOfSpaces[i+1] && numOfSpaces[i] < tmp){
                
                pathToDesiredFile = contentsOfFile[i] + "/" + pathToDesiredFile;
                tmp = numOfSpaces[i];
            }
        }
    }
    
    private void deleteSpaces(){
        pathToDesiredFile = pathToDesiredFile.replaceAll("[\\s]{1,}", "");
    }
}
