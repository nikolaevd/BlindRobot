
package blindrobot;

public class BlindRobot {
    
    private final String NORTH = "north";
    private final String WEST = "west";
    private final String SOUTH = "south";
    private final String EAST  = "east";
    private final String DONE = "done";
     
    public void makeMove(String selectedCourse){
        if(selectedCourse.equals(NORTH)){
            System.out.println("Идем на Север!");
        }
        else if(selectedCourse.equals(WEST)){
            System.out.println("Идмем на Запад!");      
        }
        else if(selectedCourse.equals(SOUTH)){
            System.out.println("Идмем на Юг!");
        }
        else if(selectedCourse.equals(EAST)){
            System.out.println("Идмем на Восток!");
        }
        else if(selectedCourse.equals(DONE)){
            System.out.println("Завершаем работу!");
        }
        else{
            System.out.println("Идем в закат!");
        }
    }
    
}
